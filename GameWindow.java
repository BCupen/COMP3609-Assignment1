import javax.swing.*;   //gui
import java.awt.*;      //layout
import java.awt.event.*;    //response to gui events

public class GameWindow extends JFrame implements ActionListener, KeyListener, MouseListener{

    private JLabel scoreL;

    private JTextField scoreTF;

    private JButton exitB;
    private JButton startB;
    private JButton focusB;

    private Container c;
    private GamePanel gamePanel;

    private JPanel mainPanel;

    public GameWindow(){
        setTitle("Alien Moves");
        setSize(600, 650);

        //score 
        scoreL = new JLabel("SCORE: ");
        scoreTF = new JTextField(10);
        scoreTF.setEditable(false);
        scoreTF.setText("00");

        //buttons
        exitB = new JButton("Exit Game");
        startB = new JButton("Start Game");
        focusB = new JButton("Focus on Key");

        exitB.addActionListener(this);
        focusB.addActionListener(this);
        startB.addActionListener(this);

        //main panel
        mainPanel = new JPanel();
        FlowLayout  flowLayout = new FlowLayout();
        mainPanel.setLayout(flowLayout);

        GridLayout gridLayout;

        //game panel
        gamePanel = new GamePanel();
        gamePanel.setPreferredSize(new Dimension(400, 400));
        gamePanel.setBackground(Color.WHITE);
        gamePanel.createGameEntities();
        //gamePanel.drawGameEntities();

        //info panel
        JPanel infoPanel = new JPanel();
        gridLayout = new GridLayout(1, 2);
        infoPanel.setLayout(gridLayout);
        infoPanel.setBackground(Color.ORANGE);

        //add to infoPanel
        infoPanel.add(scoreL);
        infoPanel.add(scoreTF);


        //button panel
        JPanel buttonPanel = new JPanel();
        gridLayout = new GridLayout(1,2);
        buttonPanel.setLayout(gridLayout);

        //add to button panel
        buttonPanel.add(startB);
        buttonPanel.add(exitB);
        buttonPanel.add(focusB);


        //add to mainPanel
        mainPanel.add(infoPanel);
        mainPanel.add(gamePanel);
        mainPanel.add(buttonPanel);

        //add main to window
        c = getContentPane();
        c.add(mainPanel);

        //add listeners to panels
        mainPanel.addKeyListener(this);

        //window properties
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
  
    }

    public void mouseReleased(MouseEvent e) {
   
    }
    public void mouseEntered(MouseEvent e) {
 
    }

    public void mouseExited(MouseEvent e) {

    }

    public void keyTyped(KeyEvent e) { 
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_UP){
            gamePanel.updateGameEntities(1);
            gamePanel.drawGameEntities();
        }
        if(keyCode == KeyEvent.VK_DOWN){
            gamePanel.updateGameEntities(2);
            gamePanel.drawGameEntities();
        }
        if(keyCode == KeyEvent.VK_LEFT){
            gamePanel.updateGameEntities(3);
            gamePanel.drawGameEntities();
        }
        if(keyCode == KeyEvent.VK_RIGHT){
            gamePanel.updateGameEntities(4);
            gamePanel.drawGameEntities();
        }
 
    }

    public void keyReleased(KeyEvent e) {
  
    }

    public void actionPerformed(ActionEvent e) { 
        String command = e.getActionCommand();
        
        if(command.equals(startB.getText()))
            gamePanel.drawGameEntities();

        if(command.equals(exitB.getText()))
            System.exit(0);

        if(command.equals(focusB.getText()))
            mainPanel.requestFocus();
    }


}