package tennisgame;

public class Game  {
    
    public static enum State {MENU, GAME};
    private final GamePanel gPanel;
    private State stateOfGame = State.MENU;
    private final MouseInput mouseInput;
    
    
    public Game() throws Exception{
        gPanel = new GamePanel();    
        mouseInput = new MouseInput(this, gPanel);
        gPanel.addMouseListener(mouseInput);
    }

   
    public void changeStateOfGame(State state){
        stateOfGame = state;
    }
    
    public GamePanel getGamePanel() {
        return gPanel;
    }
}
