package tennisgame;

import java.awt.Rectangle;

public class Paddle {

    private int xPaddlePosition;
    private int yPaddlePosition;
    private final int startingXPosition, startingYPosition;
    private static final int WIDTH = 120, HEIGHT = 18;
    private static final int PADDLE_MOVE = 5;
    private boolean myTurnBounce;

    public Paddle(int xPaddlePosition, int yPaddlePosition) {
        this.xPaddlePosition = startingXPosition = xPaddlePosition;
        this.yPaddlePosition = startingYPosition = yPaddlePosition;
        myTurnBounce = false;
    }

    public Rectangle getRectangle() {
        return new Rectangle(xPaddlePosition, yPaddlePosition, WIDTH, HEIGHT);
    }

    public void move(Game.Direction dir) {
        if (Game.Direction.LEFT == dir) {
            if (xPaddlePosition >= PADDLE_MOVE)
                xPaddlePosition -= PADDLE_MOVE;
        } else {
            if (xPaddlePosition + WIDTH <= 792)
                xPaddlePosition += PADDLE_MOVE;
        }
    }

    public void reset() {
        xPaddlePosition = startingXPosition;
        yPaddlePosition = startingYPosition;
    }

    public void setTurn(boolean turn) {
        myTurnBounce = turn;
    }

    public boolean isTurn() {
        return myTurnBounce;
    }

    public static int getPaddleMove() {
        return PADDLE_MOVE;
    }

    public static int getPaddleWidth() {
        return WIDTH;
    }
}
