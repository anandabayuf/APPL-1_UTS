/*
 * Created By Ananda Bayu Fauzan.
 */
package Main;

/**
 *
 * @author Ananda Bayu
 */
public class SummonRequestLogger {
    private SummonButtons summonButton;
    private ElevatorController elevatorController;
    
    
    public void addSummonRequestToQueue(){
        
    }
    
    /**
     * @param direction
     * @param floorNumber 
     */
    public void summonButtonPressed(int floorNumber){
        summonButton.pressed(floorNumber);
        summonButton.turnLightOn();
    }
    
    public void run(){
        summonButtonPressed(0);
        summonButton.turnLightOn();
        addSummonRequestToQueue();
    }
}
