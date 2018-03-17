
package snakegame;

import java.util.ArrayList;

/**
 *
 * @author kleps
 */
public class Snake {
    enum DIR{UP, DOWN, LEFT, RIGHT};
    
    private DIR direction;
    private ArrayList<Coords> body = new ArrayList<>();
    
    public void addElement(int x, int y){
        Coords coords = new Coords(x,y);
        body.add(coords);
    }
    public void addElementBeg(int x, int y){
        Coords coords = new Coords(x,y);
        body.add(0, coords);
    }
    public DIR getDirection(){
        return direction;
    }
    public void setDirection(DIR newDirection){
        direction = newDirection;
    }
    public Coords getCoords(int index){
        return body.get(index);
    }
    public void setCoords(int index, Coords newCoords){
        body.set(index, newCoords);
    }
    public int getSize(){
        return body.size();
    }
    public void clear(){
        body.clear();
    }
}