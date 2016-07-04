import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.sql.SQLException;
import javax.swing.JFrame;

public class SpaceInvaders
{
    public static void main(String[] args) throws SQLException
    {
        boolean jogando = true;
        Head cabecalho = new Head();
        Gameboard tabuleiro = new Gameboard(cabecalho);
        GameOver theEnd = new GameOver(cabecalho);
        tabuleiro.setBackground(Color.black);
        
        JFrame space = new JFrame("Space Invaders - Programação de Aplicativos I - Engenharia da Computação");
        space.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        space.setSize(800, 600);
        Container Conti = space.getContentPane();
        Conti.add(cabecalho, BorderLayout.NORTH);
        Conti.add(tabuleiro, BorderLayout.CENTER);
       
        JFrame gameOver = new JFrame("Space Invaders - Para jogar novamente clique em AGAIN");
        gameOver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameOver.setBackground(Color.BLACK);
        gameOver.setSize(400, 310);
        gameOver.add(theEnd);
         
        while (tabuleiro.getEstado() != 2)
        {
            space.setVisible(true);
            gameOver.setVisible(false);
        }
            space.setVisible(true);
            gameOver.setLocation(200, 200);
            gameOver.setVisible(true);
            gameOver.setFocusable(true);
            gameOver.requestFocusInWindow();
    }
}
