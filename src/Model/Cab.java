/*
 * Created By Ananda Bayu Fauzan.
 */
package Model;

/**
 *
 * @author Ananda Bayu
 */
public class Cab {
    private Floor floor;
    private Direction direction;
    
    public enum Direction{
        Up, Down;
    }
    
    public enum Floor{
        GroundFloor ,FirstFloor, SecondFloor;
    }
    
    public Cab(Direction direction, Floor floor){
        this.direction = direction;
        this.floor = floor;
    }

    /**
     * @return the floor
     */
    public Floor getFloor() {
        return floor;
    }

    /**
     * @param floor the floor to set
     */
    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    /**
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    
}
