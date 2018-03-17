
package snakegame;

import java.util.Random;

/**
 *
 * @author kleps
 */
public class GameBoard {
    public boolean [][] board;
    public int numberOfElements;
    public int elementSize;
    public Snake snake;
    public Coords foodPoint;
    private Random ran = new Random();
    
    GameBoard(int numberOfElements, int elementSize){
        snake = new Snake();
        this.numberOfElements = numberOfElements;
        this.elementSize = elementSize;
        board = new boolean[numberOfElements][numberOfElements];
        clearBoard();
        foodPoint = new Coords(0,0);
    }
    public void clearBoard(){
        for(int i = 0; i<numberOfElements; i++)
            for(int j = 0; j<numberOfElements; j++)
                board[i][j] = false;
    }
    public void setElementTrue(int x, int y){
        board[x][y] = true;
    }
    
}
