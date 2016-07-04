import java.awt.Color;
import java.awt.Graphics2D;

public class Ship 
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
/* Body */
s1d.fillRect(x, y+12, 8, 4);
s1d.fillRect(x+12, y+12, 8, 4);
s1d.fillRect(x+24, y+12, 8, 4);
/* Base */
s1d.fillRect(x, y+16, (8*4), 8);
}

public int x()
{
return _pos_x;
}

public void newx(int x)
{
_pos_x = x;
}

public int y()
{
return _pos_y;
}
}

