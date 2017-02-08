package tennisgame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class TennisGame extends JFrame
{
    public final static  int WIDTH_GAME_FRAME = 800;
    public final static  int HEIGHT_GAME_FRAME = 700;
    
    
    public TennisGame() throws Exception 
    {
       this.setTitle("Game");
       this.setLayout(new BorderLayout());
       this.setSize(WIDTH_GAME_FRAME, HEIGHT_GAME_FRAME);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setLocationRelativeTo(null);
       
       Game game = new Game();
       this.add(game.getGamePanel());
       
       this.setResizable(false);
       this.setVisible(true);
       
    }
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            try{
                TennisGame tg = new TennisGame();
            }
            catch(Exception e){
                System.out.println("ERROR");
            }
        });
        
        
    }
}

