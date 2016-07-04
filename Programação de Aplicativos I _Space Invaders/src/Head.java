import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Head extends JPanel implements ActionListener
{
    JLabel Score = new JLabel("SCORE");
    JTextField ScorePoints = new JTextField();
    JButton Reset = new JButton("RESET");
    JLabel Lives = new JLabel("LIVES");
    JTextField LivesNumber = new JTextField();
    JLabel darkmatter = new JLabel ();
    Font f = new Font("ARIAL", Font.BOLD,15);
    boolean resetvar;
            
    public Head()
    {
    setBackground(Color.black);
    setPreferredSize(new Dimension (800, 30));
    setLayout(null);
    ScorePoints.setFont(f);
    ScorePoints.setForeground(Color.yellow);
    ScorePoints.setText("0");
    LivesNumber.setFont(f);
    LivesNumber.setForeground(Color.yellow);
    LivesNumber.setText("3");
    add(Score);
    Score.setBounds(10, 1, 70, 30);
    Score.setForeground(Color.white);
    ScorePoints.setBackground(Color.black);
    ScorePoints.setFocusable(false);
    add(ScorePoints);
    ScorePoints.setBounds(70,1,80,30);
    add(Reset);
    Reset.setBounds(345,1,100,30);
    Reset.addActionListener(this);
    LivesNumber.setBackground(Color.black);
    add(Lives);
    Lives.setBounds(680,1,60,30);
    Lives.setForeground(Color.white);
    add(LivesNumber);
    LivesNumber.setBounds(735,1,35,30);
    resetvar = false;
    }

    public JTextField getScorePoints() 
    {
        return ScorePoints;
    }
    
    public void setScorePoints(int pontos)
    {
        String scoretemp = String.valueOf(pontos);
        ScorePoints.setText(scoretemp);
    }
    
    public void setScorePoints(String rp) 
    {
        ScorePoints.setText(rp);
    }

    public JTextField getLivesNumber() 
    {
        return LivesNumber;
    }

    public void setLivesNumber(int vidas) 
    {
        String vidastemp = String.valueOf(vidas);
        LivesNumber.setText(vidastemp);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("RESET"))
        {
        resetvar = true;
        }
        if(e.getActionCommand().equals("AGAIN"))
        {
        resetvar = true;
        }
    }

    public boolean getResetvar() 
    {
        return resetvar;
    }
}
