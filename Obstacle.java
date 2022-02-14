import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;


//stationery objects that the alien must avoid. 
//No need to erase or move
public class Obstacle {
    
    private JPanel panel;
    private int x, y;
    private int width, height;

    private Rectangle2D.Double obs;

    private Color bgColor;
    private Dimension dimension;

    private boolean collided;

    public Obstacle(JPanel p, int xPos, int yPos, int width, int height){
        panel = p;
        dimension = panel.getSize();
        bgColor = panel.getBackground();
        x = xPos;
        y = yPos;
        this.width = width;
        this.height = height;

        collided = false;
        
    }


    public void draw(){
        Graphics g = panel.getGraphics ();
        Graphics2D g2 = (Graphics2D) g;

        obs = new Rectangle2D.Double(x, y, width, height);
        g2.setColor(Color.BLACK);
        g2.fill(obs);

        g.dispose();
    }

    public void erase(){
        Graphics g = panel.getGraphics ();
        Graphics2D g2 = (Graphics2D) g;

        // erase bat by drawing a rectangle on top of it with the background colour

        g2.setColor (bgColor);
        g2.fill (new Rectangle2D.Double (x-5, y-5, width+10, height+10));

        g.dispose();
    }

    public void clear() {
        Graphics g = panel.getGraphics ();
        Graphics2D g2 = (Graphics2D) g;

        // erase bat by drawing a rectangle on top of it with the background colour

        g2.setColor (Color.RED);
        g2.fill (new Rectangle2D.Double (x-5, y-5, width+10, height+10));

        g.dispose();
    }

    public Rectangle2D.Double getBoundingRectangle(){
        return new Rectangle2D.Double(x, y, width, height);
    }

    public boolean getCollided(){
        return this.collided;
    }

    public void setCollided(boolean stat){
        this.collided = stat;
    }


}
