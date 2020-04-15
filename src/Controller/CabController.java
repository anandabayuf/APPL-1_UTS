/*
 * Created By Ananda Bayu Fauzan.
 */
package Controller;

import Model.Cab;
import Model.Cab.Direction;
import Model.Cab.Floor;
import View.ElevatorInfo;
import View.ElevatorPanel;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;

/**
 *
 * @author Ananda Bayu
 */
public class CabController{
    private Cab cab;
    private Queue<Floor> process;
    
    public CabController(){
        cab = new Cab(Direction.Up, Floor.GroundFloor);
        process = new LinkedList();
    }
    
    public Queue<Floor> getProcess(){
        if(process == null)
            return new LinkedList();
        return process;
    }
    
    public Cab getCab(){
        return cab;
    }
    
    public void move(Floor destinationFloor, ElevatorPanel elevatorPanel, ElevatorInfo elevatorInfo) throws InterruptedException{
        int temp = cab.getFloor().getValue();
        
        
        if(destinationFloor.getValue() > temp){
            cab.setDirection(Direction.Up);
            while(temp < 3){
                //perpindahan floor
                elevatorPanel.setFloorTextField(Floor.valueOf(temp).toString());
                elevatorInfo.setPosition(Integer.toString(temp));
                
                if(process.contains(Floor.valueOf(temp))){
                    //stop or wait
                    elevatorInfo.setStatus("Stopped");
                    elevatorInfo.setDoorStatus("Opened");
                    process.remove(Floor.valueOf(temp));
                    cab.setFloor(Floor.valueOf(temp));
                }
                
                if(process.isEmpty())
                    break;
                
                TimeUnit.SECONDS.sleep(2);
                temp++;
            }
        }
        else{
            cab.setDirection(Direction.Down);
            while(temp >= 0){
                //perpindahan floor
                elevatorPanel.setFloorTextField(Floor.valueOf(temp).toString());
                elevatorInfo.setPosition(Integer.toString(temp));
                
                if(process.contains(Floor.valueOf(temp))){
                    //stop or wait
                    elevatorInfo.setStatus("Stopped");
                    elevatorInfo.setDoorStatus("Opened");
                    process.remove(Floor.valueOf(temp));
                    cab.setFloor(Floor.valueOf(temp));
                }
                
                if(process.isEmpty())
                    break;
                
                TimeUnit.SECONDS.sleep(2);
                temp--;
            }
        }
    }
}
