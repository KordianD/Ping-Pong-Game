package tennisgame;

public class Game  {

    public static enum State {MENU, GAME}
    public static enum Direction {LEFT, RIGHT}
    private final GamePanel gPanel;
    private State stateOfGame = State.MENU;
    private final MouseInput mouseInput;
    private Ball ball;
    private final int UPDATE_INTERVAL = 15;
    private Paddle player, pc;
    
    
    public Game() throws Exception{
        gPanel = new GamePanel();    
        mouseInput = new MouseInput(this, gPanel);
        gPanel.addMouseListener(mouseInput);
        ball = new Ball();
        player = new Paddle(300, 600);
        pc = new Paddle(300, 42);
    }

    public void play() throws Exception{
        while (stateOfGame == State.GAME) {
        
        ball.move();
        checkCollisions();

        gPanel.repaint();
        Thread.sleep(UPDATE_INTERVAL);
    }
    }
   
    public void changeStateOfGame(State state){
        stateOfGame = state;
        System.out.println("here");
    }
    
    public void checkCollisions(){
        if (ball.getRectangle().intersects(player.getRectangle()))
            ball.bouncePaddle();
        else if (ball.getRectangle().intersects(pc.getRectangle()))
            ball.bouncePaddle();
        
        
        
    }
    
   /* public void checkCollisions(){
        yDownBall = yBallPosition + DIAMETER;
        xCenterBall = xBallPosition + DIAMETER/2;
        yCenterBall = yBallPosition + DIAMETER/2;
        
        if (yDownBall  == fPaddle.yPaddlePosition && 
             xCenterBall >= fPaddle.xPaddlePosition && 
             xCenterBall <= fPaddle.xPaddleEnd)
        {
            yBallDirection = -yBallDirection;
            firstBounce = true;
        }
        
        else if (yDownBall + yBallDirection/2 == fPaddle.yPaddlePosition  &&
                xCenterBall >= fPaddle.xPaddlePosition + xBallDirection/2 &&
                xCenterBall <= fPaddle.xPaddleEnd + xBallDirection/2)
        {
            yBallDirection = -yBallDirection;
            firstBounce = true;
        }
        
        else if (yBallPosition == sPaddle.yDownPaddle && 
                xCenterBall >= sPaddle.xPaddlePosition &&
                xCenterBall <= sPaddle.xPaddleEnd)
        {
            yBallDirection = -yBallDirection;
            firstBounce = false;
        }
        
          else if (yBallPosition + yBallDirection/2 == sPaddle.yDownPaddle && 
                xCenterBall >= sPaddle.xPaddlePosition + xBallDirection/2 &&
                xCenterBall <= sPaddle.xPaddleEnd + xBallDirection/2)
        {
            yBallDirection = -yBallDirection;  
            firstBounce = false;
        }
        
        else if (RandomGenerator.obstacleActive && 
                yBallPosition == ob.yDownObstacle && 
                xCenterBall <= ob.xObstacleEnd && 
                xCenterBall >= ob.xObstaclePosition &&
                yBallDirection < 0)
        {
            yBallDirection = -yBallDirection;
            firstBounce = true;
        }
        
        else if (RandomGenerator.obstacleActive &&
                yDownBall == ob.yObstaclePosition &&
                xCenterBall <= ob.xObstacleEnd && 
                xCenterBall >= ob.xObstaclePosition &&
                yBallDirection > 0)
        {
            yBallDirection = -yBallDirection;
            firstBounce = true;
        }
        
        else if (yBallPosition < -20 || yBallPosition > 670)
        {
         if (yBallPosition < -20)
           {gPanel.endOfGame(GamePanel.Winner.FIRSTPLAYER);}
           else if (yBallPosition > 670)
           {gPanel.endOfGame(GamePanel.Winner.SECONDPLAYER);} 

        }
    
    }

*/
    
    public GamePanel getGamePanel() {
        return gPanel;
    }
}
