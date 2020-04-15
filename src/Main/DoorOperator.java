/*
 * Created By Ananda Bayu Fauzan.
 */
package Main;
import Model.Door;

/**
 *
 * @author Ananda Bayu
 */
public class DoorOperator {
    Door door;  //closed door
    OpenDoorButton openDoorButton;
    DoorTimer timer;
    DoorOpeningDevice doorOpeningDevice;

    public DoorOperator() {
        this.door = new Door();
        this.openDoorButton = new OpenDoorButton();
        this.timer = new DoorTimer();
        this.doorOpeningDevice = new DoorOpeningDevice();
    }
    
    public void startOperation(){
        
    }
    
    /**
     * @param cabID
     */
    public void doorsOpened(){
        Door.DoorStatus doorOpeningDeviceSignal = doorOpeningDevice.sendOpenDoorSignal();
        door.setDoorStatusFromDevice(doorOpeningDeviceSignal);
    }
    
    /**
     * @param cabID
     */
    public void doorsClosed(){
        Door.DoorStatus doorOpeningDeviceSignal = doorOpeningDevice.sendCloseDoorSignal();
        door.setDoorStatusFromDevice(doorOpeningDeviceSignal);
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
    public void openDoorButtonPressed(){
        timer.stopTimer();
        timer.reset();
        while(openDoorButton.isPressed()) {
            doorsOpened();
        }
    }
    
    public void openDoorButtonReleased() {
        while(openDoorButton.isReleased()) {
            timer.run();
            doorsClosed();
            break;
        }
    }
    
    /**
     * @param direction 
     * @param floorNumber 
     */
    public void summonButtonPressed(int floorNumber){
        
    }
}
