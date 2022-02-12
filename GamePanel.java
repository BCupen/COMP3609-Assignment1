import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
<<<<<<< HEAD
    public static int NUM_OBSTACLES = 4;
=======
    private static int NUM_OBSTACLES = 4;
>>>>>>> e83789ff277aded1bb26eb8610952f8cac679f64
    
    private Alien alien;
    private Obstacle[] obstacles;
    private GamePoint gamePoint;

    public GamePanel(){
        alien = null;
        obstacles = null;
        gamePoint = null;
    }

    public void createGameEntities(){
<<<<<<< HEAD
        
        obstacles = new Obstacle[4];
=======
        alien = new Alien(this);
        obstacles = new Obstacle[5];
>>>>>>> e83789ff277aded1bb26eb8610952f8cac679f64
        obstacles[0] = new Obstacle(this, 90, 150, 15, 100);
        obstacles[1] = new Obstacle(this, 310, 150, 15, 100);
        obstacles[2] = new Obstacle(this, 160, 80, 100, 15);
        obstacles[3] = new Obstacle(this, 160, 300, 100, 15);
<<<<<<< HEAD
        gamePoint = new GamePoint(this, obstacles);
        alien = new Alien(this, gamePoint, obstacles);
        //gamePoint.setLocation();
=======
        gamePoint = new GamePoint(this);
    
>>>>>>> e83789ff277aded1bb26eb8610952f8cac679f64
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
<<<<<<< HEAD
            //gamePoint.setLocation();
            //gamePoint.erase();
=======
            gamePoint.setLocation();
>>>>>>> e83789ff277aded1bb26eb8610952f8cac679f64
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
