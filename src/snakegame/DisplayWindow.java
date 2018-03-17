
package snakegame;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author kleps
 */
public class DisplayWindow extends JFrame implements KeyListener{
    
    String windowName;
    GameBoard board;
    int xSize, ySize;
    
    public DisplayWindow(String windowName, GameBoard board){
        this.board = board;
        this.windowName = windowName;
        setTitleSizeVisibilityExit();
        
        GraphicsPanel p = new GraphicsPanel(this.board);
        add(p);
        addKeyListener(this);
    }
    private void setTitleSizeVisibilityExit(){
        setTitle(windowName);
        xSize = 420;
        ySize = 435;
        setSize(xSize,ySize);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int ch = e.getKeyCode();
        updateSnakeDirection(ch);
    }
    private void updateSnakeDirection(int ch){
        Snake.DIR dir = board.snake.getDirection();
        if(ch == 37 && dir != Snake.DIR.RIGHT)
            board.snake.setDirection(Snake.DIR.LEFT);
        else if(ch == 38 && dir != Snake.DIR.DOWN)
            board.snake.setDirection(Snake.DIR.UP);
        else if(ch == 39 && dir != Snake.DIR.LEFT)
            board.snake.setDirection(Snake.DIR.RIGHT);    
        else if(ch == 40 && dir != Snake.DIR.UP)
            board.snake.setDirection(Snake.DIR.DOWN);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
