/*
 * Created By Ananda Bayu Fauzan.
 */
package Main;

/**
 *
 * @author Ananda Bayu
 */
public class FloorRequestButton {
    public enum Status{
        ON,
        OFF
    }
    
    private Status status;
    
    /**
     * @param cabID
     * @param floorNumber
     */
    void pressed(int floorNumber){
        
    }
    
    void turnLightOn(){
        this.status = Status.ON;
    }
    
    void turnLightOff(){
        this.status = Status.OFF;
    }
}
