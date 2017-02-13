package tennisgame;

import java.awt.Rectangle;

public class Ball {
    private int xPosition;
    private int yPosition;
    private int xMovement = 3;
    private int yMovement = 3;
    private final int WIDTH = 25, HEIGHT = 20;
    private final int MULTIPLY = 3, RANDOM_ADDITIONAL = 100;
    private final int START_HEIGHT = 30;


    public Ball() {
        xPosition = (int) (Math.random() * RANDOM_ADDITIONAL) * MULTIPLY;
        yPosition = (int) (Math.random() * START_HEIGHT + RANDOM_ADDITIONAL) * MULTIPLY;
    }

    public void move() {
        xPosition += xMovement;
        yPosition += yMovement;
    }

    public void bouncePaddle() {
        yMovement = -yMovement;
    }

    public void bounceWall() {
        xMovement = -xMovement;
    }

    public void reset() {
        xPosition = (int) (Math.random() * RANDOM_ADDITIONAL) * MULTIPLY;
        yPosition = (int) (Math.random() * START_HEIGHT + RANDOM_ADDITIONAL) * MULTIPLY;
    }

    public Rectangle getRectangle() {
        return new Rectangle(xPosition, yPosition, WIDTH, HEIGHT);
    }
}
