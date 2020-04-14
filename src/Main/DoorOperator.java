/*
 * Created By Ananda Bayu Fauzan.
 */
package Main;

/**
 *
 * @author Ananda Bayu
 */
public class DoorOperator {
    
    public void startOperation(){
        
    }
    
    /**
     * @param cabID
     */
    public void doorsOpened(){
        
    }
    
    /**
     * @param cabID
     */
    public void doorsClosed(){
        
    }
    
    public void suspend(){
        
    }
    
    public void resume(){
        
    }
    
    public void suspendFromLoad(){
        
    }
    
    public void resumeFromLoad(){
        
    }
    
    /**
     * @param cabID
     */
    OpenDoorButton openDoorButton = new OpenDoorButton();
    DoorTimer timer = new DoorTimer();
    public void openDoorButtonPressed(){
        while(openDoorButton.isPressed()) {
            timer.stopTimer();
            timer.reset();
            doorsOpened();
        }
    }
    
    
    public void openDoorButtonReleased() {
        while(openDoorButton.isReleased()) {
            timer.run();
            doorsClosed();
        }
    }
    
    /**
     * @param direction 
     * @param floorNumber 
     */
    public void summonButtonPressed(int floorNumber){
        
    }
}
