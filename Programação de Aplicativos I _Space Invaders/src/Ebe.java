import java.awt.Color;
import java.awt.Graphics2D;

public class Ebe 
{
private int _pos_x;
private int _pos_y;
private boolean draw_shape1 = true;

public void draw(Graphics2D g2d, int x, int y, Color c)
{ 
_pos_x = x;
_pos_y = y;

g2d.setColor(c);

/* head */
g2d.fillRect(x+12, y, 8, 4);
g2d.fillRect(x+8, y+4, (8*2), 4);
g2d.fillRect(x+4, y+8, (8*3), 4);
/* eyes */
g2d.fillRect(x, y+12, 8, 4);
g2d.fillRect(x+12, y+12, 8, 4);
g2d.fillRect(x+24, y+12, 8, 4);
/* chin */
g2d.fillRect(x, y+16, (8*4), 4);

if (draw_shape1)
{
draw_shape1 = false;
/* hips */
g2d.fillRect(x+8, y+20, 5, 4);
g2d.fillRect(x+18, y+20, 5, 4);
/* legs part 1 */
g2d.fillRect(x+4, y+24, 5, 4);
g2d.fillRect(x+12, y+24, 7, 4);
g2d.fillRect(x+22, y+24, 5, 4);
/* legs part 2 */
g2d.fillRect(x, y+28, 5, 4);
g2d.fillRect(x+8, y+28, 5, 4);
g2d.fillRect(x+18, y+28, 5, 4);
g2d.fillRect(x+26, y+28, 5, 4);
}
else
{
draw_shape1 = true;
/* hips */
g2d.fillRect(x+3, y+20, 5, 4);
g2d.fillRect(x+12, y+20, 8, 4);
g2d.fillRect(x+24, y+20, 5, 4);
/* legs part 1 */
g2d.fillRect(x, y+24, 5, 4);
g2d.fillRect(x+27, y+24, 5, 4);
/* legs part 2 */
g2d.fillRect(x+3, y+28, 5, 4);
g2d.fillRect(x+24, y+28, 5, 4);
} 
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