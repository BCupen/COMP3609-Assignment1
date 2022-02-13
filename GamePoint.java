import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.JPanel;

public class GamePoint {

    private JPanel panel;
    private int x, y;
    private int width, height;

    private Rectangle2D.Double gamePt;

    private Color bgColor;
    private Dimension dimension;

    private Random random;

    private Obstacle[] obstacles;

    public GamePoint(JPanel p, Obstacle[] obstacles){
        panel = p;
        bgColor = panel.getBackground();
        dimension = panel.getSize();

        width = 10;
        height = 10;

        random = new Random();
        x = random.nextInt(390); //error using panelWidth()- width
        y = random.nextInt(390);
        this.obstacles = obstacles;
        
    }   
    
    public void setLocation(){
        int panelWidth = panel.getWidth();
        int panelHeight = panel.getHeight();
        x = random.nextInt(panelWidth-width);
        y = random.nextInt(panelHeight - height);
        while(collidesWithObstacles()){
            x = random.nextInt(panelWidth-width);
            y = random.nextInt(panelHeight - height); 
        }
        

    }

    public void draw(){
        Graphics g = panel.getGraphics ();
        Graphics2D g2 = (Graphics2D) g;

        gamePt = new Rectangle2D.Double(x, y, width, height);
        g2.setColor(Color.RED);
        g2.fill(gamePt);

        g.dispose();
    }

    public void erase(){
        Graphics g = panel.getGraphics ();
        Graphics2D g2 = (Graphics2D) g;
  
        // erase face by drawing a rectangle on top of it
  
        g2.setColor (bgColor);
        g2.fill (new Rectangle2D.Double (x-10, y-10, 30+20, 45+20));
  
        g.dispose();
      }

    public Rectangle2D.Double getBoundingRectangle(){
        return new Rectangle2D.Double (x,y, width, height);
    }

    public boolean collidesWithObstacles(){
        Rectangle2D.Double thisRect = getBoundingRectangle();
        Rectangle2D.Double obsRect = null;
        for(int i = 0; i < GamePanel.NUM_OBSTACLES; i++){
            obsRect = obstacles[i].getBoundingRectangle();
            if(thisRect.intersects(obsRect)){
                    // x += obsRect.getWidth() + 10;
                    // y += obsRect.getHeight() + 10;
                    return true;
            }
        }

        return false;
    }
}
