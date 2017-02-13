package tennisgame;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Game implements Runnable {

    public static enum State {MENU, GAME}

    private final GamePanel gPanel;
    private static State stateOfGame;
    private final MouseInput mouseInput;
    private final Ball ball = new Ball();
    private final int UPDATE_INTERVAL = 15;
    private final Paddle player = new Paddle(300, 600);
    private final Paddle pc = new Paddle(300, 42);
    private boolean win = false;
    private final Box box;
    private final KeyInput keyInput;
    private final List<CollisionCheck> collisionChecks = new ArrayList<>();


    public Game() throws Exception {
        stateOfGame = State.MENU;
        gPanel = new GamePanel(player, pc, ball);
        mouseInput = new MouseInput(this, gPanel);
        gPanel.addMouseListener(mouseInput);
        box = new Box(GameFrame.WIDTH_GAME_FRAME, GameFrame.HEIGHT_GAME_FRAME);
        keyInput = new KeyInput(gPanel, player, pc);
        player.setTurn(true);

        ScheduledThreadPoolExecutor executor, keyExecutor;
        keyExecutor = new ScheduledThreadPoolExecutor(10);

        keyExecutor.scheduleAtFixedRate
                (keyInput, 0L, UPDATE_INTERVAL, TimeUnit.MILLISECONDS);

        executor = new ScheduledThreadPoolExecutor(10);
        keyExecutor = new ScheduledThreadPoolExecutor(10);

        executor.scheduleAtFixedRate
                (this, 0L, 15L, TimeUnit.MILLISECONDS);

        keyExecutor.scheduleAtFixedRate
                (keyInput, UPDATE_INTERVAL, 15L, TimeUnit.MILLISECONDS);

        collisionChecks.add(movedBall -> {
            if (movedBall.getRectangle().intersects(player.getRectangle()) && player.isTurn()) {
                ball.bouncePaddle();
                player.setTurn(false);
                pc.setTurn(true);
            }
            return stateOfGame;
        });

        collisionChecks.add(movedBall -> {
            if (movedBall.getRectangle().intersects(pc.getRectangle()) && pc.isTurn()) {
                ball.bouncePaddle();
                pc.setTurn(false);
                player.setTurn(true);
            }
            return stateOfGame;
        });

        collisionChecks.add(movedBall -> {
            if (movedBall.getRectangle().intersects(box.getLeftWall()) ||
                    movedBall.getRectangle().intersects(box.getRightWall()))
                movedBall.bounceWall();

            return stateOfGame;
        });

        collisionChecks.add(movedBall -> {
            if (movedBall.getRectangle().intersects(box.getUpperWall())) {
                win = true;
                stateOfGame = State.MENU;
                gPanel.endOfGame(true);
                resetSettings();
            }
            return stateOfGame;
        });

        collisionChecks.add(movedBall -> {
            if (movedBall.getRectangle().intersects(box.getBottomWall())) {
                win = false;
                stateOfGame = State.MENU;
                gPanel.endOfGame(false);
                resetSettings();
            }
            return stateOfGame;
        });
    }

    public static enum Direction {
        LEFT {
            @Override
            public int move(int xPaddlePosition) {
                if (xPaddlePosition >= Paddle.getPaddleMove())
                    xPaddlePosition -= Paddle.getPaddleMove();

                return xPaddlePosition;
            }
        },
        RIGHT {
            @Override
            public int move(int xPaddlePosition) {
                if (xPaddlePosition + Paddle.getPaddleWidth() <= 792)
                    xPaddlePosition += Paddle.getPaddleMove();

                return xPaddlePosition;
            }
        };

        abstract public int move(int xPaddlePosition);
    }

    @Override
    public void run() {
        if (stateOfGame == State.GAME) {
            ball.move();
            checkCollisions();
            gPanel.repaint();
        }
    }

    public void changeStateOfGame(State state) {
        stateOfGame = state;
    }

    public void checkCollisions() {
        collisionChecks.stream().forEach((cc) -> {
            stateOfGame = cc.checkCollisionWith(ball);
        });
    }

    public static State getStateOfGame() {
        return stateOfGame;
    }

    public GamePanel getGamePanel() {
        return gPanel;
    }

    public void resetSettings() {
        ball.reset();
        player.reset();
        pc.reset();
    }
}
