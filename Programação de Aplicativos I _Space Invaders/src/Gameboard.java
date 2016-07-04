import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;

public class Gameboard extends JPanel implements KeyListener
{
    Timer _timer = new Timer();
    Ebe Ets[][] = new Ebe[4][8];
    Ship Nightwatchman;
    Head painel;
    private int pixels;
    BufferedImage Start = null;
    BufferedImage End = null;
    Graphics2D l1 = null;
    int estado;
    boolean shootgun;
    int mira;
    int up;
    Shoot Tiro;
    int down;
    boolean kill[][] = new boolean [4][8];
    boolean points[][] = new boolean [4][8];
    int i,j,a;
    boolean resetar;
    int Deadend;
    
public Gameboard(Head h)
{ 
    this.addKeyListener(this);
    painel = h;
    for(i=0;i<=3;i++)
    {
        for(j=0;j<=7;j++)
        {
            Ets[i][j]= new Ebe();
        }
    }
    Nightwatchman = new Ship();
    pixels = 384;
    estado = 0;
    shootgun = false;
    mira = 0;
    up = 480;
    Tiro = new Shoot();
    down = 0;
    LoadImages();
    Deadend = 0;
    
    for(i=0;i<=3;i++)
    {
        for(j=0;j<=7;j++)
        {
            kill[i][j] = false;
        }
    }
    for(i=0;i<=3;i++)
    {
        for(j=0;j<=7;j++)
        {
            points[i][j]= false;
        }
    }
    resetar = false;
// Iniciar o timer para chamar repaint() a cada 250ms 
_timer.scheduleAtFixedRate(new TimerTask() {
public void run() {
repaint();
}
}, 0, 250);
}

public void paintComponent(Graphics g) 
{ 
    super.paintComponent(g);

  Graphics2D g1 = (Graphics2D)g;
  Graphics2D s1 = (Graphics2D)g;
  Graphics2D l1 = (Graphics2D)g;
  
  this.setFocusable(true);
  this.requestFocusInWindow();

  if (estado == 0) //Inicio do jogo
  {
        l1.drawImage(Start, 0, 0, this);
        Ets[0][1].draw(g1, 270+1*50, 215, new Color(0xFF0000));
        Ets[1][1].draw(g1, 270+1*50, 250, new Color(0x660033));
        Ets[2][1].draw(g1, 270+1*50, 285, new Color(0x009900));
        Ets[3][1].draw(g1, 270+1*50, 318, new Color(0xFFFF00));
  }

  if (estado == 1) //Jogando
  {
        for(j=0;j<=7;j++)
        {
            if(kill[0][j] == false)
            Ets[0][j].draw(g1, 210+j*50, down+15, new Color(0xFF0000));
            else
            {
                
            }
        }
        for(j=0;j<=7;j++)
        {   
            if(kill[1][j] == false)
            Ets[1][j].draw(g1, 210+j*50, down+65, new Color(0x660033));
            else
            {
                
            }
        }
        for(j=0;j<=7;j++)
        {
            if(kill[2][j] == false)
            Ets[2][j].draw(g1, 210+j*50, down+115, new Color(0x009900));
            else
            {
                
            }
        }
        for(j=0;j<=7;j++)
        {   
            if(kill[3][j] == false)
            Ets[3][j].draw(g1, 210+j*50, down+165, new Color(0xFFFF00));
            else
            {
                
            }
        }
    Nightwatchman.draw(s1, pixels, 485, new Color(0xFFFF00));
  
    l1.setColor(Color.green);
    l1.drawLine(50, 515, 732, 515);
    Colide(); //Verifica se os Ebes bateram no chão
    destroi();
        
    if(shootgun == true)
    {   
        Tiro.draw(l1, mira, up, new Color(0x009900));
        if(up >= 0)
        {
            up = up - 60;
        }
        else
        {
            shootgun = false;
            up = 480;
        }
    }
    if(Integer.valueOf(painel.getScorePoints().getText()) >= 100)
        down = down + 3;
    
    if (Integer.valueOf(painel.getScorePoints().getText()) >= 800)
        estado = 2;
    
    if (Integer.valueOf(painel.getLivesNumber().getText()) <= 0)
        estado = 2;
    
    reset();
  }

  if (estado == 2) //Game Over
  {
      l1.drawImage(End, 0, 0, this);
      painel.Reset.setText("AGAIN");
      reset();
  }

}

    public void keyTyped(KeyEvent e) 
    {
        if (e.getKeyChar() == 'd' && pixels <= 700)
        {
            pixels = pixels + 10;
            Nightwatchman.newx(pixels);
        }
        if (e.getKeyChar() == 'a' && pixels >= 50) //Keycode 37
        {
            pixels = pixels - 10;
            Nightwatchman.newx(pixels);
        }
        if (e.getKeyChar() == 'p')
        {
            estado = 1;
        }
        if (e.getKeyChar() == 'l') //Keycode 32
        {
            shootgun = true;
            mira = Nightwatchman.x();
         }
    }
    
    public void keyPressed(KeyEvent e) 
    {
        if (e.getKeyCode() == 39 && pixels <= 700)
        {
            pixels = pixels + 10;
            Nightwatchman.newx(pixels);
        }
        if (e.getKeyCode() == 37 && pixels >= 50)
        {
            pixels = pixels - 10;
            Nightwatchman.newx(pixels);
        }
        if (e.getKeyCode() == 32)
        {
            shootgun = true;
            mira = Nightwatchman.x();
         }
    }
    public void keyReleased(KeyEvent e) { }
    
    public void LoadImages()
    { 
        try
        {
            Start = ImageIO.read(new File("inicio.jpg"));
            End = ImageIO.read(new File("fim.jpg"));
        }
        catch (Exception e)
        {
            System.out.println("Imagens não foram encontradas!");
        }
    }
    
    public void Colide()
    {
        for(i=0;i<=3;i++)
        {
            for(j=0;j<=7;j++) //Implementar para pegar 1 por linha
            {
                if(Ets[i][j].y()+ 20 >= 500)
                {
                    down = 0;
                    a++;
                }
            }
        }
       if(a > 0)
       {
           String teste = painel.getLivesNumber().getText();
           int n = Integer.valueOf(teste);
           n = n-1;
           painel.setLivesNumber(n);
           a = 0;
       }
       //Testar o fim do jogo
    }
        public void destroi()
    {
        for(i=0;i<=3;i++)
        {
            for(j=0;j<=7;j++)
            {
                //melhor colisao if((Tiro.x() >= Ets[i][j].x() && Tiro.x()+4 <= Ets[i][j].x()+44) && (Tiro.y() <= Ets[i][j].y()+40) && Tiro.y() >= Ets[i][j].y())
                if(Tiro.x() >= Ets[i][j].x()-15 && Tiro.x()+4 <= Ets[i][j].x()+20 && (Tiro.y() <= Ets[i][j].y()+57 &&  Tiro.y() >= Ets[i][j].y()))
                {
                    kill[i][j] = true;
                    if(points [i][j] == false)
                    {
                    if(i == 3)
                    {
                        String teste2 = painel.getScorePoints().getText();
                        int m = Integer.valueOf(teste2);
                        painel.setScorePoints(m+10);
                        shootgun = false;
                        up = 480;
                    }
                    if(i == 2)
                    {
                        String teste2 = painel.getScorePoints().getText();
                        int m = Integer.valueOf(teste2);
                        painel.setScorePoints(m+20);
                        shootgun = false;
                        up = 480;                        
                    }
                    if(i == 1)
                    {
                        String teste2 = painel.getScorePoints().getText();
                        int m = Integer.valueOf(teste2);
                        painel.setScorePoints(m+30);
                        shootgun = false;
                        up = 480;
                    }
                    if(i == 0)
                    {
                        String teste2 = painel.getScorePoints().getText();
                        int m = Integer.valueOf(teste2);
                        painel.setScorePoints(m+40);
                        shootgun = false;
                        up = 480;
                    }
                    }
                    points[i][j] = true;
                }
            }
        }
    }
        
    public void reset() //Nunca receber true através do get mas a variável é alterada
    {
        if(painel.resetvar == true)
        {
            painel.Reset.setText("RESET");
            down = 0;
            painel.ScorePoints.setText("0");
            painel.LivesNumber.setText("3");
            for(i=0;i<=3;i++)
            {
                for(j=0;j<=7;j++)
                {
                    kill[i][j] = false;
                    points[i][j]= false;
                }
            }
            shootgun = false;
            up = 480;
            pixels = 384;
            estado = 1;
            painel.resetvar = false;
        }
    }

    public int getEstado() 
    {
        return estado;
    }
    
}
