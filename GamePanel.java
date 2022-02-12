import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    public static int NUM_OBSTACLES = 4;
    
    private Alien alien;
    private Obstacle[] obstacles;
    private GamePoint gamePoint;

    public GamePanel(){
        alien = null;
        obstacles = null;
        gamePoint = null;
    }

    public void createGameEntities(){
        
        obstacles = new Obstacle[4];
        obstacles[0] = new Obstacle(this, 90, 150, 15, 100);
        obstacles[1] = new Obstacle(this, 310, 150, 15, 100);
        obstacles[2] = new Obstacle(this, 160, 80, 100, 15);
        obstacles[3] = new Obstacle(this, 160, 300, 100, 15);
        gamePoint = new GamePoint(this, obstacles);
        alien = new Alien(this, gamePoint, obstacles);
        //gamePoint.setLocation();
    }

    public void drawGameEntities(){
        if(alien != null)
            alien.draw();

        if(obstacles != null){
            for(int i = 0; i<NUM_OBSTACLES; i++){
                obstacles[i].draw();
            }
        }
        if(gamePoint != null){
            //gamePoint.setLocation();
            //gamePoint.erase();
            gamePoint.draw();
        }
    }

    public void updateGameEntities(int direction){
        if(alien != null){
            alien.erase();
            alien.move(direction);
        }
    }


    public void run() {
       
    }

}