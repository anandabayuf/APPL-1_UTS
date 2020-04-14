/*
 * Created By Ananda Bayu Fauzan.
 */
package Main;

/**
 *
 * @author Ananda Bayu
 */
public class SummonButtons {
    enum LightStatus {
        OFF, 
        ON
    }
    
    LightStatus lightStatus;
    
    public void turnLightOn(){
        //System.out.println("The light is on");
        lightStatus = LightStatus.ON;
    }
    
    public void turnLightOff(){
        //System.out.println("The light is off");
        lightStatus = LightStatus.OFF;
    }
    
    /**
     * @param direction 
     * @param floorNumber 
     */
    public void pressed(int floorNumber){
        
    }
    
    /**
     * @param direction 
     * @param floorNumber 
     */
    public void released(int floorNumber){
        
    }
}
