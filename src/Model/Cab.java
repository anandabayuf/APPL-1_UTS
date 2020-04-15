/*
 * Created By Ananda Bayu Fauzan.
 */
package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ananda Bayu
 */
public class Cab {
    private Floor floor;
    private Direction direction;
    private Door door;
    
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
        
        public void next(){
            value++;
        }
        
        public void before(){
            value++;
        }
        public int getValue() {
            return value;
        }
    }
    
    public enum Door{
        Closed,
        Open; 
    }
    
    public Cab(Direction direction, Floor floor){
        this.direction = direction;
        this.floor = floor;
        this.door = Door.Closed;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    public void setDoorStatus(Door status){
        this.door = status;
    }
    
    public Door getDoorStatus(){
        return this.door;
    }
    
    public void startTimerDoor(){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {}
    }
}
