package tennisgame;

import java.awt.Rectangle;

public class Paddle {
    private int xPaddlePosition;
    private int yPaddlePosition;
    private final int WIDTH = 120, HEIGHT = 18;
    private final int PADDLE_MOVE = 5;
    
    
    public Paddle(int xPaddlePosition, int yPaddlePosition){
        this.xPaddlePosition = xPaddlePosition;
        this.yPaddlePosition = yPaddlePosition;
    }
    
    public Rectangle getRectangle(){
        return new Rectangle(xPaddlePosition, yPaddlePosition, WIDTH, HEIGHT);
    }
    
    public void move(Game.Direction dir){
        if (Game.Direction.LEFT == dir){
            if (xPaddlePosition >= PADDLE_MOVE)
                xPaddlePosition -= PADDLE_MOVE;
        }                   
        else {
            if (xPaddlePosition + WIDTH <= 792)
                xPaddlePosition += PADDLE_MOVE;
        } 
    }
       
}
