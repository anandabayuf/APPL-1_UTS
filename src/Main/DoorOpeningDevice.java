package Main;

import Model.*;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Raihan Ibrahim
 */
public class DoorOpeningDevice {
    public DoorOpeningDevice() {
        
    }
    
    Door.DoorStatus sendOpenDoorSignal() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return Door.DoorStatus.OPENED;
    }

    Door.DoorStatus sendCloseDoorSignal() throws InterruptedException { 
        TimeUnit.SECONDS.sleep(3);
        return Door.DoorStatus.CLOSED;
    }
}
