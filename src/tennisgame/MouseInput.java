package tennisgame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class MouseInput extends MouseAdapter {
    private final GamePanel gPanel;
    private final Game game;
    private final int ADD = 120;
    private final int Y_LEFT_EDGE = 280, Y_RIGHT_EDGE = 350;
    private final int X_RIGHT_EDGE = 551;
    private final String helpInfo = "This is a very simple game which imitates"
            + " world-known game Ping Pong \n\n " + "First player use arrows"
            + ", second player use A and D keys";

    public MouseInput(Game game, GamePanel gPanel) {
        this.game = game;
        this.gPanel = gPanel;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int xMousePosition = e.getX();
        int yMousePosition = e.getY();

        if (Game.getStateOfGame() == Game.State.GAME)
            return;

        if (xMousePosition < gPanel.getXMenuImgPosition() || xMousePosition > X_RIGHT_EDGE)
            return;

        if (yMousePosition > Y_LEFT_EDGE && yMousePosition < Y_RIGHT_EDGE)
            game.changeStateOfGame(Game.State.GAME);

        else if (yMousePosition > Y_LEFT_EDGE + ADD && yMousePosition < Y_RIGHT_EDGE + ADD)
            JOptionPane.showMessageDialog(gPanel, helpInfo,
                    "Help information", JOptionPane.INFORMATION_MESSAGE);

        else if (yMousePosition > Y_LEFT_EDGE + 2 * ADD && yMousePosition < Y_RIGHT_EDGE + 2 * ADD)
            System.exit(0);
    }
}


