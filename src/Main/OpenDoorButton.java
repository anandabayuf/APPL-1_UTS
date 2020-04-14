/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Raihan Ibrahim
 */
public class OpenDoorButton {
    //String cabID;
    
    public OpenDoorButton() {
        
    }
    
    public enum Status {
        PRESSED,
        RELEASED
    }
    
    Status openDoorButtonStatus;
    
    void pressOpenDoorButton() {
       this.openDoorButtonStatus = Status.PRESSED;
    }
    
    void releaseOpenDoorButton() {
        this.openDoorButtonStatus = Status.RELEASED;
    }
    
    boolean isPressed() {
        return openDoorButtonStatus == Status.PRESSED;
    }
    
    boolean isReleased() {
        return openDoorButtonStatus == Status.RELEASED;
    }
}
