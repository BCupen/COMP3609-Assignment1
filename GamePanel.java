import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class GamePanel extends JPanel implements Runnable{
    public static int NUM_OBSTACLES = 4;
    
    private Alien alien;
    private Obstacle[] obstacles;
    private GamePoint gamePoint;
    public boolean isRunning;
    private Thread gameThread;
    private int score;
    private int timeToSleep;

    public GamePanel(){
        alien = null;
        obstacles = null;
        gamePoint = null;
        isRunning = false;
        score = 0;
        timeToSleep = 250;
        createGameEntities();
    }

    public void startGame(){
        if(gameThread == null){
            isRunning = true;
            gameThread = new Thread(this);
            gameThread.start();
        }
    }

    public void endGame(){
        isRunning = false;

        alien.setCollided(true);
        gamePoint = null;
        for(int i=0; i <NUM_OBSTACLES; i++){
            obstacles[i].setCollided(true);;
        }

        Graphics g = this.getGraphics ();
        Graphics2D g2 = (Graphics2D) g;

        // erase face by drawing a rectangle on top of it

        g2.setColor (Color.RED);
        g2.fill (new Rectangle2D.Double (0, 0, 400, 400));

        Font f = new Font ("Bookman Old Style", Font.ITALIC, 24);
        g2.setFont (f);
        g2.setColor(Color.BLUE);
        g2.drawString("GAME OVER", 135, 200);

        g.dispose();
    }

    public void createGameEntities(){
        obstacles = new Obstacle[5];
        obstacles[0] = new Obstacle(this, 90, 150, 15, 100);
        obstacles[1] = new Obstacle(this, 310, 150, 15, 100);
        obstacles[2] = new Obstacle(this, 160, 80, 100, 15);
        obstacles[3] = new Obstacle(this, 160, 300, 100, 15);
        gamePoint = new GamePoint(this, obstacles);
        alien = new Alien(this, gamePoint, obstacles);
        //gamePoint.setLocation();
    }

    public void drawGameEntities(){
        if(alien != null && !alien.getCollided())
            alien.draw();
        else
            alien.clear();
        
        if(obstacles != null){
            for(int i = 0; i<NUM_OBSTACLES; i++){
                if (!obstacles[i].getCollided())
                    obstacles[i].draw();
                else
                    obstacles[i].clear();
            }
        }

        if(gamePoint != null){
            //gamePoint.setLocation();
            //gamePoint.erase();
            gamePoint.draw();
        }

    }

    public void updateGameEntities(){
        if(alien != null){
            alien.erase();
            //alien.setVel(direction);
            alien.move();
        }

        if(gamePoint != null){
            if(alien.collidesWithGamePoint()){
                gamePoint.erase();
                gamePoint.setLocation();
                score += 50;
                setScore();
                if(score % 100 == 0)
                    timeToSleep = (int) (0.9*timeToSleep);
            }
        }
    }

    public void updateAlienVel(int direction){
        if(alien!=null){
            alien.setVel(direction);
        }
    }


    public void run() {
       try{
           isRunning = true;
           while(isRunning){
               updateGameEntities();
               drawGameEntities();
               Thread.sleep(timeToSleep);
           }
       }catch(InterruptedException exception){}
    }

    public void setScore(){
        GameWindow.scoreTF.setText(String.valueOf(score));
    }
}
