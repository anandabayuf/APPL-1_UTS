package Main;
import Model.*;

/**
 *
 * @author Raihan Ibrahim
 */
public class DoorOpeningDevice {
    public DoorOpeningDevice() {
        
    }
    
    Door.DoorStatus sendOpenDoorSignal() {
        return Door.DoorStatus.OPENED;
    }

    Door.DoorStatus sendCloseDoorSignal() {
        return Door.DoorStatus.CLOSED;
    }
}
