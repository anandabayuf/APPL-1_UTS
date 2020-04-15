package Model;

/**
 *
 * @author Raihan Ibrahim
 */
public class Door {
    public enum DoorStatus {
        OPENED,
        CLOSED;
    }
    DoorStatus doorStatus;
    
    public Door() {
        this.doorStatus = DoorStatus.CLOSED;
    }
    
    public boolean isOpened() {
        return doorStatus == DoorStatus.OPENED;
    }
    
    public boolean isClosed() {
        return doorStatus == DoorStatus.CLOSED;
    }
    
    public void setDoorStatusFromDevice(DoorStatus status) {
        doorStatus = status;
    }
}
