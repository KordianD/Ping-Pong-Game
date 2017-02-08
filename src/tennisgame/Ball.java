package tennisgame;


public class Ball {
    private int xPosition;
    private int yPosition;
    private int xMovement = 2;
    private int yMovement = 2;
    
       
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
}
