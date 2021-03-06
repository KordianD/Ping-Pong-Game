package tennisgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class GamePanel extends JPanel {

    private BufferedImage playImg, helpImg, exitImg, backgroundImg, titleImg;
    private BufferedImage paddleImg, ballImg;
    private final int X_MENU_IMG_POSITION, X_TITLE_POSITION = 280;
    private final int Y_IMG_POSITION = 280, ADD = 120;
    private final int Y_TITLE_POSITION = 25;
    private String winnerInfo;
    private final Paddle player, pc;
    private final Ball ball;

    public GamePanel(Paddle player, Paddle pc, Ball ball) throws Exception{
        this.X_MENU_IMG_POSITION = 251;
        loadImages();
        this.player = player;
        this.pc = pc;
        this.ball = ball;
    }

    public final void loadImages() throws IOException{
        playImg       = ImageIO.read(getClass().getResource
                ("/images/play.png"));
        helpImg       = ImageIO.read(getClass().getResource
                ("/images/help.png"));
        exitImg       = ImageIO.read(getClass().getResource
                ("/images/exit.png"));
        backgroundImg = ImageIO.read(getClass().getResource
                ("/images/bitmap.png"));
        titleImg      = ImageIO.read(getClass().getResource
                ("/images/title220.png"));
        paddleImg     = ImageIO.read(getClass().getResource
                ("/images/yellow.png"));
        ballImg       = ImageIO.read(getClass().getResource
                ("/images/football18.png"));
    }

    public int getXMenuImgPosition(){
        return X_MENU_IMG_POSITION;
    }

    public void endOfGame(boolean win)   {
        if (win)  {
            winnerInfo = "First player win!";
            JOptionPane.showMessageDialog(this, winnerInfo,
                    "End of game", JOptionPane.INFORMATION_MESSAGE);
        }

        else{
            winnerInfo = "Second player win!";
            JOptionPane.showMessageDialog(this, winnerInfo,
                    "End of game", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    protected void paintComponent(Graphics g)   {
        super.paintComponent(g);
        g.drawImage(backgroundImg, 0, 0, null);

        if (Game.getStateOfGame() == Game.State.MENU)
            paintMenu(g);
        else
            paintGame(g);
    }

    private void paintMenu(Graphics g){
        g.drawImage(titleImg, X_TITLE_POSITION, Y_TITLE_POSITION, null);
        g.drawImage(playImg, X_MENU_IMG_POSITION, Y_IMG_POSITION, null);
        g.drawImage(helpImg, X_MENU_IMG_POSITION, Y_IMG_POSITION + ADD, null);
        g.drawImage(exitImg, X_MENU_IMG_POSITION, Y_IMG_POSITION + 2 * ADD, null);
    }

    private void paintGame(Graphics g) {
        g.drawImage(ballImg, ball.getRectangle().x, ball.getRectangle().y, null);

        g.drawImage(paddleImg, player.getRectangle().x,
                player.getRectangle().y, null);
        g.drawImage(paddleImg, pc.getRectangle().x,
                pc.getRectangle().y, null);
    }
}
