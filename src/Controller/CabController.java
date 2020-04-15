/*
 * Created By Ananda Bayu Fauzan.
 */
package Controller;

import Model.Cab;
import Model.Cab.Direction;
import Model.Cab.Floor;
import View.ElevatorInfo;
import View.ElevatorPanel;
import View.SummonElevator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author Ananda Bayu
 */
public class CabController{
    private Cab cab;
    private Queue<Floor> process;
    Timer timer;
    int temp;
    
    public CabController(){
        cab = new Cab(Direction.Up, Floor.GroundFloor);
        process = new LinkedList();
    }
    
    public Queue<Floor> getProcess(){
        if(process == null)
            return new LinkedList();
        return process;
    }
    
    void timerProcess(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {}
    }
    
    public Cab getCab(){
        return cab;
    }
    
    public void clearProcess(){
        process.clear();
    }
    
    /**
    * @author Ananda Bayu
    * @author Evan Lokajaya
    */
    public void move(Floor destinationFloor, ElevatorPanel elevatorPanel, ElevatorInfo elevatorInfo, SummonElevator summonElevator){
        temp = cab.getFloor().getValue();
        
        if(destinationFloor.getValue() > temp){
            cab.setDirection(Direction.Up);   
            
            while(temp < 3){
            
                if(process.contains(Floor.valueOf(temp))){
                    //stop or wait
                    elevatorInfo.setStatus("Waiting");
                    cab.setDoorStatus(Cab.Door.Open);
                    elevatorInfo.setDoorStatus("Open");
                    process.remove(Floor.valueOf(temp));
                    cab.setFloor(Floor.valueOf(temp));
                    
                    //turn off the lights
                    switch (cab.getFloor().getValue()) {
                        case 0:
                            elevatorPanel.groundFloorButtonLights(false);
                            summonElevator.groundFloorButtonLights(false);
                            break;
                        case 1:
                            elevatorPanel.firstFloorButtonLights(false);
                            summonElevator.firstFloorButtonLights(false);
                            break;
                        default:
                            elevatorPanel.secondFloorButtonLights(false);
                            summonElevator.secondFloorButtonLights(false);
                            break;
                    }
                    
                    timer = new Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cab.setDoorStatus(Cab.Door.Closed);
                            elevatorInfo.setDoorStatus("Closed");
                        }
                    });
                    
                    timer.start();
                }
                
                if(process.isEmpty())
                    break;
                
                temp += 1;
                
                timer = new Timer(2000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {    
                    //perpindahan floor
                    elevatorPanel.setFloorTextField(Floor.valueOf(temp).toString());
                    elevatorInfo.setPosition(Integer.toString(temp));
                    }
                });
                
                timer.setRepeats(true);
                timer.start();
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
                    elevatorInfo.setStatus("Waiting");
                    cab.setDoorStatus(Cab.Door.Open);
                    elevatorInfo.setDoorStatus("Opened");
                    process.remove(Floor.valueOf(temp));
                    cab.setFloor(Floor.valueOf(temp));
                    
                    //Turn off Lights
                    if(cab.getFloor().getValue() == 0){
                        elevatorPanel.groundFloorButtonLights(false);
                        summonElevator.groundFloorButtonLights(false);
                    }
                    else if(cab.getFloor().getValue() == 1){
                        elevatorPanel.firstFloorButtonLights(false);
                        summonElevator.firstFloorButtonLights(false);
                    }
                    else{
                        elevatorPanel.secondFloorButtonLights(false);
                        summonElevator.secondFloorButtonLights(false);
                    }
                    
                    cab.startTimerDoor();
                    cab.setDoorStatus(Cab.Door.Closed);
                    elevatorInfo.setDoorStatus("Closed");
                }
                
                if(process.isEmpty())
                    break;
                
                //timer(1500);
                temp--;
            }
        }
    }

}
