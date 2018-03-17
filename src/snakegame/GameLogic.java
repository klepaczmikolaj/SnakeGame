
package snakegame;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author kleps
 */
public class GameLogic {
    
    class MyTimerTask extends TimerTask{
        @Override
        public void run(){
            moveSnake();
            if(isFoodEaten()){
                gameBoard.snake.addElementBeg(gameBoard.foodPoint.x, gameBoard.foodPoint.y);
                initializeFoodPoint();
            }
            if(isGameOver()){
                globalTimer.cancel();
                globalTimer.purge();
                timerTask.cancel();
                isRunning = false;
                return;
            }
            updateBoard();
            window.repaint();
        }

    }
    
    private Random ran = new Random();
    private final GameBoard gameBoard;
    private DisplayWindow window;
    private int numberOfElements;
    private int elementSize;
    private int timeDelay;
    private boolean isRunning;
    Timer globalTimer;
    MyTimerTask timerTask;
    
    
    public GameLogic(int numberOfElements, int elementSize){
        this.numberOfElements = numberOfElements;
        this.elementSize = elementSize;
        gameBoard = new GameBoard(numberOfElements, elementSize);
        window = new DisplayWindow("Okienko",gameBoard);
    }
    
    public void gameLoop(){
        timeDelay = 200;
        isRunning = false;
        while(true){
            if(!isRunning){
                initializeGame();
                isRunning = true;
                globalTimer.schedule(timerTask, timeDelay, timeDelay);
            }
            window.repaint();
        }
    }
    private void initializeGame(){
        globalTimer = new Timer();
        timerTask = new MyTimerTask();
        initializeSnake();
        initializeFoodPoint();
        updateBoard();
    }
    
    private void initializeSnake(){
        initializePosition();
        initializeDirection();
    }
    
    private void initializePosition(){
        gameBoard.snake.clear();
        gameBoard.snake.addElement(5, 7);
        gameBoard.snake.addElement(5, 6);
        gameBoard.snake.addElement(5, 5);
    }
    
    private void initializeDirection(){
        gameBoard.snake.setDirection(Snake.DIR.DOWN);
    }
    
    private void updateBoard(){
        gameBoard.clearBoard();
        Coords coords;
        for(int i = 0; i < gameBoard.snake.getSize(); i++){
            coords = gameBoard.snake.getCoords(i);
            gameBoard.setElementTrue(coords.x, coords.y);
        }
        Coords foodPoint = gameBoard.foodPoint;
        gameBoard.setElementTrue(foodPoint.x, foodPoint.y);
    }
    private boolean isGameOver(){
        Coords headCoords = new Coords(gameBoard.snake.getCoords(0));
        int x = headCoords.x;
        int y = headCoords.y;
        int max = gameBoard.numberOfElements;
        if(!(x != -1 && x != max && y != -1 && y != max))
            return true;
        else 
            return isTailEaten();
    }
    private boolean isTailEaten(){
        Coords tempCoords;
        Coords headCoords = new Coords(gameBoard.snake.getCoords(0));
        for(int i = 2; i < gameBoard.snake.getSize(); i++){
            tempCoords = gameBoard.snake.getCoords(i);
            if(tempCoords.x == headCoords.x && tempCoords.y == headCoords.y)
                return true;
        }
        return false;
    }
    private void moveSnake(){
        Snake snake = new Snake();
        snake = addNewHead(snake);
        snake = addRemainingBody(snake);
        gameBoard.snake = snake;
        
    }
    private Snake addRemainingBody(Snake snake){
        Coords tempCoords;
        for(int i = 0; i < gameBoard.snake.getSize() - 1; i++){
            tempCoords = gameBoard.snake.getCoords(i);
            snake.addElement(tempCoords.x, tempCoords.y);
        }
        return snake;
    }
    private Snake addNewHead(Snake snake){
        Coords snakeHead = new Coords(gameBoard.snake.getCoords(0));
        snake.setDirection(gameBoard.snake.getDirection());
        if(gameBoard.snake.getDirection() == Snake.DIR.UP)
            snakeHead.y--;
        else if(gameBoard.snake.getDirection() == Snake.DIR.DOWN)
            snakeHead.y++;
        else if(gameBoard.snake.getDirection() == Snake.DIR.LEFT)
            snakeHead.x--;
        else
            snakeHead.x++;
        snake.addElement(snakeHead.x, snakeHead.y);
        return snake;
    }
    private void initializeFoodPoint(){
        
        gameBoard.foodPoint.x = ran.nextInt(numberOfElements);
        gameBoard.foodPoint.y = ran.nextInt(numberOfElements);
    }
    private boolean isFoodEaten(){
        Coords snakeHead = new Coords(gameBoard.snake.getCoords(0));
        return snakeHead.x == gameBoard.foodPoint.x && 
                snakeHead.y == gameBoard.foodPoint.y;
    }
    
    
}
