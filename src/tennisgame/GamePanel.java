package tennisgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class GamePanel extends JPanel {
    
    private BufferedImage playImg, helpImg, exitImg, backgroundImg, titleImg;
    private final int X_MENU_IMG_POSITION;
    
    public GamePanel() throws Exception{
        this.X_MENU_IMG_POSITION = 251;
          loadImages();
    }
    
    public void loadImages() throws IOException{
        playImg = ImageIO.read(getClass().getResource
                                                      ("/images/play.png"));
        helpImg = ImageIO.read(getClass().getResource
                                                      ("/images/help.png"));
        exitImg = ImageIO.read(getClass().getResource
                                                      ("/images/exit.png"));
        backgroundImg = ImageIO.read(getClass().getResource
                                                      ("/images/bitmap.png"));
        titleImg = ImageIO.read(getClass().getResource
                                                      ("/images/title220.png"));
    }
    
    public int getXMenuImgPosition(){
        return X_MENU_IMG_POSITION;
    }
    
    @Override
    protected void paintComponent(Graphics g) 
    {
       super.paintComponent(g);
       g.drawImage(backgroundImg, 0, 0, null);        
       
       paintMenu(g);              
    }
      
    private void paintMenu(Graphics g){
 
       
        g.drawImage(titleImg, 280, 25, null);
        g.drawImage(playImg, X_MENU_IMG_POSITION, 280, null);
        g.drawImage(helpImg, X_MENU_IMG_POSITION, 400, null);
        g.drawImage(exitImg, X_MENU_IMG_POSITION, 520, null);
    }
}
