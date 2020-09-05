import javax.swing.JFrame;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;


public class Board extends JPanel implements ActionListener  {
    private final int B_WIDTH = 1360;
    private final int B_HEIGHT = 570;
    private final int DELAY = 50;

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    int [][] board = {
            {1,-1,-1,-1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,-1,-1,-1,-1,-1,-1,-1, 1},
            {1, 1, 1, 1, 1,-1,-1,-1, 1,-1,-1,-1,-1,-1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1,-1,-1,-1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,-1,-1,-1, 1,-1,-1,-1, 1},
            {1,-1, 1, 1, 1,-1,-1,-1, 1,-1,-1,-1,-1,-1, 1, 1, 1,-1, 1,-1,-1,-1, 1},
            {1,-1,-1,-1, 1,-1,-1,-1, 1,-1,-1,-1,-1,-1, 1,-1,-1,-1, 1,-1,-1,-1, 1},
            {1, 1, 1,-1, 1,-1, 1, 1, 1,-1, 1,-1, 1,-1, 1,-1, 1, 1, 1,-1,-1,-1, 1},
            {1,-1,-1,-1, 1,-1,-1,-1, 1,-1, 1,-1, 1,-1, 1,-1,-1,-1, 1,-1,-1,-1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    private Image background;
    private Image pacmanRight;
    private Image pacmanLeft;
    private Image pacmanUp;
    private Image pacmanDown;


    private Timer timer;

    private int pacPosX=54+6;
    private int pacPosY=54+6;

    private int pacBoardX=0;
    private int pacBoardY=0;




    public Board() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setVisible(true);

        loadImages();
        initGame();
    }

    private void loadImages() {
        /*Image pacmanRight = Toolkit.getDefaultToolkit().createImage("src/main/Images/pacmanRight.png");
        Image background = Toolkit.getDefaultToolkit().createImage("src/main/Images/back-small.png");*/
        ImageIcon iibackground = new ImageIcon("src/main/Images/back-small.png");
        background = iibackground.getImage();
        ImageIcon iipacmanRight = new ImageIcon("src/main/Images/pacmanRight.png");
        pacmanRight = iipacmanRight.getImage();
        ImageIcon iipacmanLeft = new ImageIcon("src/main/Images/pacmanLeft.png");
        pacmanLeft = iipacmanLeft.getImage();
        ImageIcon iipacmanUp = new ImageIcon("src/main/Images/pacmanUp.png");
        pacmanUp = iipacmanUp.getImage();
        ImageIcon iipacmanDown = new ImageIcon("src/main/Images/pacmanDown.png");
        pacmanDown = iipacmanDown.getImage();



    }

    private void initGame() {


        //locateApple();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        g.drawImage(background, 0,0,this);

        if (inGame) {
            if(leftDirection){
                g.drawImage(pacmanLeft,pacPosX,pacPosY,this);
            }else if(upDirection){
                g.drawImage(pacmanUp,pacPosX,pacPosY,this);
            }else if (downDirection) {
                g.drawImage(pacmanDown,pacPosX,pacPosY,this);
            }else{
                g.drawImage(pacmanRight,pacPosX,pacPosY,this);
            }
            Toolkit.getDefaultToolkit().sync();

        } else {

            //gameOver(g);
        }
    }

    private void gameOver(Graphics g) {


    }

    private void checkApple() {


    }

    private void move() {
        System.out.println("move");

        if(inGame){

            if (leftDirection && pacPosX>25) {
                pacPosX -= 5;
            }

            if (rightDirection && pacPosX<1340) {
                pacPosX += 5;
            }

            if (upDirection && pacPosY>25) {
                pacPosY -= 5;
            }

            if (downDirection && pacPosY<550) {
                pacPosY += 5;
            }
            //sytem.out.println(pacPosX+" "+pacPosY);
        }


    }

    private void canMoveUp(){

    }

    private void checkCollision() {


    }

    private void locateApple() {


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {

            //checkApple();
            //checkCollision();
            //();
        }

        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) ) {
                System.out.println("left");
                leftDirection = true;
                upDirection = false;
                downDirection = false;
                rightDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) ) {
                System.out.println("right");
                rightDirection = true;
                upDirection = false;
                downDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_UP) ) {
                System.out.println("up");
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) ) {
                System.out.println("down");
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
                upDirection = false;
            }
        }
    }

}


