package tennisgame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class GameFrame{
    public final static  int WIDTH_GAME_FRAME = 800;
    public final static  int HEIGHT_GAME_FRAME = 700;

     public GameFrame(JFrame theFrame) throws Exception{
       theFrame.setTitle("Game");
       theFrame.setLayout(new BorderLayout());
       theFrame.setSize(WIDTH_GAME_FRAME, HEIGHT_GAME_FRAME);
       theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       theFrame.setLocationRelativeTo(null);

       Game game = new Game();
       theFrame.add(game.getGamePanel());    
       theFrame.setResizable(false);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            try{
                JFrame theFrame = new JFrame();
                GameFrame tg = new GameFrame(theFrame);
                theFrame.setVisible(true);
            }
            catch(Exception e){
                System.out.println("ERROR");
            }
        });                        
    }
}