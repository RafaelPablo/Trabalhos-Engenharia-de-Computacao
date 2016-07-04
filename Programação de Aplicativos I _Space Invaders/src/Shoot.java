import java.awt.Color;
import java.awt.Graphics2D;

public class Shoot 
{
private int _pos_x;
private int _pos_y;

public void draw(Graphics2D s1d, int x, int y, Color c)
{ 
_pos_x = x;
_pos_y = y;

s1d.setColor(c);

/* Canon */
s1d.fillRect(x+14, y, 4, 20);
}

public int x()
{
return _pos_x;
}

public int y()
{
return _pos_y;
}
}    
