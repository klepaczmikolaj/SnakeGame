
package snakegame;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author kleps
 */
public class GraphicsPanel extends JPanel {

    private final GameBoard gameBoard;
    private final int xSize;
    private final int ySize;
    public GraphicsPanel(GameBoard board){
        this.gameBoard = board;
        this.xSize = board.numberOfElements*(board.elementSize + 1) + 1;
        this.ySize = board.numberOfElements*(board.elementSize + 1) + 1;
    }
    @Override
    public void paintComponent(Graphics g) {
        setSize(xSize,ySize);
        this.setBackground(Color.black);
        super.paintComponent(g);
        drawBoard(g);
    }
    private void drawBoard(Graphics g){
        g.setColor(Color.blue);
        for(int i = 0; i<gameBoard.numberOfElements; i++)
            for(int j = 0; j<gameBoard.numberOfElements; j++)
                if(gameBoard.board[i][j] == true)
                    g.fillRect(1 + i*(gameBoard.elementSize + 1), 
                            1+j*(gameBoard.elementSize + 1), 
                            gameBoard.elementSize, gameBoard.elementSize);
    }
}
