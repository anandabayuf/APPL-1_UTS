/*
 * Created By Ananda Bayu Fauzan.
 */
package Main;
import Model.*;
import View.ElevatorInfo;
import View.ElevatorPanel;

/**
 *
 * @author Ananda Bayu
 */
public class DoorOperator {
    Door door;
    Cab cab;
    OpenDoorButton openDoorButton;
    DoorTimer timer;
    DoorOpeningDevice doorOpeningDevice;
    ElevatorInfo elevatorInfo;
    ElevatorPanel elevatorPanel;

    public DoorOperator() {
        this.timer = new DoorTimer();
        this.doorOpeningDevice = new DoorOpeningDevice();
    }
    
    public void startOperation() throws InterruptedException{
        while (true) {
            openDoorButtonPressed();
            openDoorButtonReleased();
        }
    }
    
    /**
     * @param cabID
     * @throws java.lang.InterruptedException
     */
    public void doorsOpened() throws InterruptedException{
        Door.DoorStatus doorOpeningDeviceSignal = doorOpeningDevice.sendOpenDoorSignal();
        door.setDoorStatusFromDevice(doorOpeningDeviceSignal);
        elevatorInfo.setDoorStatus("Door is Opened");
    }
    
    /**
     * @param cabID
     * @throws java.lang.InterruptedException
     */
    public void doorsClosed() throws InterruptedException{
        Door.DoorStatus doorOpeningDeviceSignal = doorOpeningDevice.sendCloseDoorSignal();
        door.setDoorStatusFromDevice(doorOpeningDeviceSignal);
        elevatorInfo.setDoorStatus("Door is Closed");
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
    public void openDoorButtonPressed() throws InterruptedException{
        timer.stopTimer();
        if(cab.getFloor() == null) {
            while(openDoorButton.isPressed()) {
                doorsOpened();
            }
        }
    }
    
    public void openDoorButtonReleased() throws InterruptedException {
        while(openDoorButton.isReleased()) {
            if(door.isOpened()) {
                timer.startTimer();
                doorsClosed();
            }
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
