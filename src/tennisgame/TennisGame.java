package tennisgame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import javax.swing.JFrame;

public class TennisGame extends JFrame
{
    public static  int WIDTH_GAME_FRAME = 800;
    public static  int HEIGHT_GAME_FRAME = 700;
    
    
    public TennisGame() 
    {
       this.setTitle("Game");
       this.setLayout(new BorderLayout());
       this.setSize(WIDTH_GAME_FRAME, HEIGHT_GAME_FRAME);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setLocationRelativeTo(null);
       

       
       this.setResizable(false);
       this.setVisible(true);
       
    }
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
           
              TennisGame tg = new TennisGame();
            
            
            
        });
    }
}

