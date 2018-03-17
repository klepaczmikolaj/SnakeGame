
package snakegame;

/**
 *
 * @author Mikolaj Klepacz
 */
public class SnakeGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numberOfElements = 20;
        int elementSize = 19;
        
        GameLogic game = new GameLogic(numberOfElements, elementSize);
        game.gameLoop();
        
    }
    
}
