import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

public class Alien{

    private JPanel panel;

    private float x, y;
    private int width, height;
    private int originalX, originalY;

    Ellipse2D.Double head;  //the head

    private int dx, dy;  //movement variables
    private float scal; //scalar to increase speed as game progresses
    private boolean noX, noY; //unidirectional control
    private Dimension dimension;
    private Color bgColor;
<<<<<<< HEAD

    private GamePoint gamePoint;
    private Obstacle[] obstacles;
    
    public Alien(JPanel p, GamePoint gamePoint, Obstacle[] obstacles){
=======
    
    public Alien(JPanel p){
>>>>>>> e83789ff277aded1bb26eb8610952f8cac679f64
        panel = p;
        dimension = panel.getSize();
        bgColor = panel.getBackground ();
        width = 20;
        height = 35;
        
        originalX = 200 - width/2;
        originalY = 200 - height/2;

        x = originalX;
        y = originalY;
  
        dx = 25;
        dy = 25;
        scal = 1;
        noX = true;
<<<<<<< HEAD
        noY = true; 
        
        this.gamePoint = gamePoint;
        this.obstacles = obstacles;
=======
        noY = true;    
>>>>>>> e83789ff277aded1bb26eb8610952f8cac679f64
    }

    public void draw(){
        Graphics g = panel.getGraphics();

        Graphics2D g2 = (Graphics2D) g;
  
        // Draw the head
  
        head = new Ellipse2D.Double(x, y, width, height);
  
        g2.setColor(Color.GREEN); 
        g2.fill(head);		// colour the head
  
        g2.setColor(Color.BLACK);	 
        g2.draw(head);		// draw outline around head
  
        g2.setColor(Color.BLACK);
  
        // Draw the eyes
        Line2D.Double eye1 = new Line2D.Double(x+5, y+7, x+6, y+12);
        g2.draw(eye1);
  
        Line2D.Double eye2 = new Line2D.Double(x+12, y+12, x+15, y+5);
        g2.draw(eye2);
  
        // Draw the mouth
        Rectangle2D.Double mouth = new Rectangle2D.Double(x+5, y+20, 10, 3);
        g2.setColor(Color.RED);
        g2.fill(mouth);
  
        g.dispose();
    }

    public void move(int direction){

        if(!panel.isVisible()) return;
        setVel(direction);
        if(!noX)
            x = x + dx;
        if(!noY)
            y = y + dy;
    }

    public void erase(){
      Graphics g = panel.getGraphics ();
      Graphics2D g2 = (Graphics2D) g;

      // erase face by drawing a rectangle on top of it

      g2.setColor (bgColor);
      g2.fill (new Rectangle2D.Double (x-10, y-10, 30+20, 45+20));

      g.dispose();
    }

    public void setVel(int direction){
         
        if(direction == 1 || direction == 2){
            //System.out.println("here");
            noY = false;
            noX = true;
            if(direction == 1){
                if(dy > 0)
                    dy = (int) (-scal*dy);
            }else if(direction == 2){
                if(dy < 0)
                    dy = (int) (-scal*dy);
            }
        }
        if(direction == 3 || direction == 4){
            //System.out.println("here");
            noY = true;
            noX = false;
            if(direction == 3){
                if(dx > 0)
                    dx = (int) (-scal*dx);
            }else if(direction == 4){
                if(dx < 0)
                    dx = (int) (-scal*dx);
            }
        }
    }

    public Rectangle2D.Double getBoundingRectangle(){
        return new Rectangle2D.Double(x,y,width,height);
    }
}
