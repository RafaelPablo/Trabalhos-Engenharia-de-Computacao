import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GameOver extends JPanel implements ActionListener
{
    JLabel dados = new JLabel ("Insira o seu nome/apelido abaixo: ");
    JTextField name = new JTextField();
    JButton ok = new JButton("OK");
    JTable ranking;
    DefaultTableModel modelo;
    String db_table = "ranking";
    String db_url = "jdbc:mysql://localhost/space_invaders";
    String db_username = "root";
    String db_password = "";
    int i;
    String [] linha0 = new String[2];
    BufferedImage Over = null;
    Head painel;

    public GameOver(Head h) throws SQLException
    {
        painel = h;
        this.setFocusable(true);
        this.requestFocusInWindow();
        String[] cabecalho = {"Jogador","Score"};
        modelo = new DefaultTableModel(cabecalho,4);
        ranking = new JTable(modelo);    
        LoadImage();
        setLayout(null);
        add(dados);
        dados.setBounds(105, 55, 200, 30);
        add(name);
        name.setBounds(100, 80, 130, 25);
        add(ok);
        ok.setBounds(230, 80, 70, 25);
        ok.addActionListener(this);
    }
    
    public void paintComponent(Graphics g) 
    { 
    super.paintComponent(g);

    Graphics2D g1 = (Graphics2D)g;
    g1.drawImage(Over, 0, 0, this);
    }
        public void LoadImage()
    { 
        try
        {
            Over = ImageIO.read(new File("over.jpg"));
        }
        catch (Exception e)
        {
            System.out.println("Imagem não foi encontrada!");
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("OK"))
        {
        try
        {
        java.sql.Connection cx = DriverManager.getConnection(db_url, db_username, db_password);
        String sql_op2 = "INSERT INTO ranking VALUES (null,'"+name.getText()+"',"+Integer.valueOf(painel.ScorePoints.getText())+");";
        Statement stmt = cx.createStatement();
        int regs_select = stmt.executeUpdate(sql_op2);
        String sql_op = "select * from " + db_table + " order by pontos ASC";
        Statement stmt2 = cx.createStatement();
        ResultSet regs_select2 = stmt.executeQuery(sql_op); 

            i=0;
            while (regs_select2.next()) 
            {
                int id_num = regs_select2.getInt("id");
                String nome_str = regs_select2.getString("nome");
                int pontos_int = regs_select2.getInt("pontos");
               /* System.out.println("ID: "+ id_num + " " + 
                "NOME: " + nome_str + " " +
                "PONTOS: " + pontos_int ); */
                add(ranking);
                ranking.setBounds(100,130,200,80);
                linha0[0] = nome_str;
                linha0[1] = String.valueOf(pontos_int);
                modelo.insertRow(0,linha0);
                i++;
            }
        stmt.close(); 
        cx.close();
        ok.setEnabled(false);
        }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        name.setText(null);
        }
    }

}