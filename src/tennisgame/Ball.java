package tennisgame;

import java.awt.Rectangle;

public class Ball {
    private int xPosition =  (int) (Math.random() * 200 + 33) * 3;
    private int yPosition =  (int) (Math.random() * 33 + 100) * 3;
    private int xMovement = 2;
    private int yMovement = 2;
    private final int WIDTH = 15, HEIGHT = 15;
    
        public void move(){
        xPosition += xMovement;
        yPosition += yMovement;
    }
    
    public void bouncePaddle(){
       xMovement = -xMovement;
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
