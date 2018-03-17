
package snakegame;

/**
 *
 * @author kleps
 */
public class Coords{
        int x,y;
        
        public Coords(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public Coords(Coords coo){
            x = coo.x;
            y = coo.y;
        }
}
