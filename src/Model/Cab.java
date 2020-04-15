/*
 * Created By Ananda Bayu Fauzan.
 */
package Model;

import java.util.HashMap;
import java.util.Map;

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
        GroundFloor(0),
        FirstFloor(1), 
        SecondFloor(2);
        
        private int value;
        private static Map map = new HashMap<>();

        private Floor(int value) {
            this.value = value;
        }

        static {
            for (Floor floor : Floor.values()) {
                map.put(floor.value, floor);
            }
        }

        public static Floor valueOf(int floor) {
            return (Floor) map.get(floor);
        }

        public int getValue() {
            return value;
        }
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
