package tennisgame;

import java.awt.Rectangle;

public class Ball {
    private int xPosition;
    private int yPosition;
    private int xMovement = 3;
    private int yMovement = 3;
    private final int WIDTH = 25, HEIGHT = 20;
    
    
    public Ball(){
         xPosition =  (int) (Math.random() * 200 + 33) * 3;
         yPosition =  (int) (Math.random() * 33 + 100) * 3;
    }
    
    
    public void move(){
        xPosition += xMovement;
        yPosition += yMovement;
    }
    
    public void bouncePaddle(){
       yMovement = -yMovement;
    }
    
    public void bounceWall(){
        xMovement = -xMovement;
    }
    
    public void reset(){
         xPosition =  (int) (Math.random() * 200 + 33) * 3;
         yPosition =  (int) (Math.random() * 33 + 100) * 3;
    }
    
    public Rectangle getRectangle(){
        return new Rectangle(xPosition, yPosition, WIDTH, HEIGHT);
    }
}
