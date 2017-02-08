package tennisgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Menu 
{   
    private final BufferedImage playImage, helpImage, exitImage, backgroundImage;
    private final BufferedImage titleImage;
    public static final int X_IMAGE_POSITION = 251;

    public Menu() throws IOException
    {             
        playImage  = ImageIO.read(getClass().getResource
                                                   ("/images/play.png"));
        helpImage  = ImageIO.read(getClass().getResource
                                                   ("/images/help.png"));
        exitImage = ImageIO.read(getClass().getResource
                                                   ("/images/exit.png"));
        backgroundImage = ImageIO.read(getClass().getResource
                                                   ("/images/bitmap.png"));
        titleImage = ImageIO.read(getClass().getResource
                                                   ("/images/title220.png"));
    }
    
    public void paint(Graphics g)
    {   
        
        g.drawImage(backgroundImage, 0, 0, null);
        g.drawImage(titleImage, 280, 25, null);
        g.drawImage(playImage, X_IMAGE_POSITION, 280, null);
        g.drawImage(helpImage, X_IMAGE_POSITION, 400, null);
        g.drawImage(exitImage, X_IMAGE_POSITION, 520, null);
    }
}