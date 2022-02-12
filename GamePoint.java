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

    public GamePoint(JPanel p){
        panel = p;
        bgColor = panel.getBackground();
        dimension = panel.getSize();

        width = 10;
        height = 10;

        random = new Random();
    }   
    
    public void setLocation(){
        int panelWidth = panel.getWidth();
        int panelHeight = panel.getHeight();
        x = random.nextInt(panelWidth-width);
        y = random.nextInt(panelHeight - height);
    }

    public void draw(){
        Graphics g = panel.getGraphics ();
        Graphics2D g2 = (Graphics2D) g;

        gamePt = new Rectangle2D.Double(x, y, width, height);
        g2.setColor(Color.RED);
        g2.fill(gamePt);

        g.dispose();
    }

    
}
