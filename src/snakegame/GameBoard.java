
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
    
    public boolean isGameOver(){
        Coords headCoords = new Coords(snake.getCoords(0));
        int x = headCoords.x;
        int y = headCoords.y;
        int max = numberOfElements;
        if(!(x != -1 && x != max && y != -1 && y != max))
            return true;
        else 
            return isTailEaten();
    }
    
    private boolean isTailEaten(){
        Coords tempCoords;
        Coords headCoords = new Coords(snake.getCoords(0));
        for(int i = 2; i < snake.getSize(); i++){
            tempCoords = snake.getCoords(i);
            if(tempCoords.x == headCoords.x && tempCoords.y == headCoords.y)
                return true;
        }
        return false;
    }
    
}
