/*
 Panel.java

 */
package View;

import Controller.CabController;
import Model.Cab;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Evan Lokajaya
 */

public class ElevatorPanel{
    JTextField floorTextField;
    Font floorTextFieldFont;
    
    JButton groundFloorButton;
    JButton firstFloorButton;
    JButton secondFloorButton;
    JButton emergencyStopButton;
    JButton emergencyBellButton;
    JButton openDoorButton;
    
    ElevatorInfo elevatorInfo;
    SummonElevator summonElevator;
    CabController cabController;
    
    public ElevatorPanel(ElevatorInfo elevatorInfo, CabController cabController){
        JFrame elevatorPanelFrame = new JFrame("Elevator Panel");
        elevatorPanelFrame.setSize(300, 500);
        elevatorPanelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //assigning the parameter
        this.elevatorInfo = elevatorInfo;
        this.cabController = cabController;
        
        //Initiate Elevator Summon
        summonElevator = new SummonElevator(this, elevatorInfo, cabController);
        
        //Initiate Font for Floor Field
        floorTextFieldFont = new Font("SansSerif", Font.BOLD, 20);
        
        //Initiate Floor Field in Elevator Panel
        floorTextField = new JTextField("");
        floorTextField.setBounds(50, 50, 200, 100);
        floorTextField.setFont(floorTextFieldFont);
        floorTextField.setHorizontalAlignment(JTextField.CENTER);
        floorTextField.setEnabled(false);
        
        //Initiate the Button in Elevator Panel
        groundFloorButton = new JButton("0");
        firstFloorButton = new JButton("1");
        secondFloorButton = new JButton("2");
        openDoorButton = new JButton("<|>");
        emergencyStopButton = new JButton("Emergency Stop");
        emergencyBellButton = new JButton("Emergency Bell");
        
        //set the location
        groundFloorButton.setBounds(50, 175, 50, 50);
        firstFloorButton.setBounds(125, 175, 50, 50);
        secondFloorButton.setBounds(200, 175, 50, 50);
        openDoorButton.setBounds(50, 250, 200, 50);
        emergencyBellButton.setBounds(50, 325, 200, 50);
        emergencyStopButton.setBounds(50, 400, 200, 50);
        
        //set button color
        groundFloorButton.setForeground(Color.white);
        groundFloorButton.setBackground(Color.lightGray);
        firstFloorButton.setForeground(Color.white);
        firstFloorButton.setBackground(Color.lightGray);
        secondFloorButton.setForeground(Color.white);
        secondFloorButton.setBackground(Color.lightGray);
        emergencyBellButton.setForeground(Color.white);
        emergencyBellButton.setBackground(Color.lightGray);
        emergencyStopButton.setForeground(Color.white);
        emergencyStopButton.setBackground(Color.lightGray);
        openDoorButton.setForeground(Color.white);
        openDoorButton.setBackground(Color.lightGray);
        
        //add the component
        elevatorPanelFrame.add(floorTextField);
        elevatorPanelFrame.add(groundFloorButton);
        elevatorPanelFrame.add(firstFloorButton);
        elevatorPanelFrame.add(secondFloorButton);
        elevatorPanelFrame.add(openDoorButton);
        elevatorPanelFrame.add(emergencyBellButton);
        elevatorPanelFrame.add(emergencyStopButton);
        
        //add Action Listener
        groundFloorButton.addActionListener(new GroundFloorButtonListener());
        firstFloorButton.addActionListener(new FirstFloorButtonListener());
        secondFloorButton.addActionListener(new SecondFloorButtonListener());
        emergencyStopButton.addActionListener(new StopListener());
        emergencyBellButton.addActionListener(new BellListener());
        openDoorButton.addActionListener(new openDoorLIstener());
        
        elevatorPanelFrame.setLocationRelativeTo(null);
        elevatorPanelFrame.setLayout(null);
        elevatorPanelFrame.setVisible(true);
        
    }
    
    SummonElevator getSummonElevator(){
        return summonElevator;
    }
    
    /**
    * @author Evan Lokajaya
    */
    void timer(int second) throws InterruptedException{
        TimeUnit.SECONDS.sleep(second);
    }
    
    /**
    * @author Evan Lokajaya
    */
    void enableButton(){
        groundFloorButton.setEnabled(true);
        firstFloorButton.setEnabled(true);
        secondFloorButton.setEnabled(true);
        openDoorButton.setEnabled(true);
    }
    
    /**
    * @author Evan Lokajaya
    */
    void disableButton(){
        groundFloorButton.setEnabled(false);
        firstFloorButton.setEnabled(false);
        secondFloorButton.setEnabled(false);
        openDoorButton.setEnabled(false);
    }
    
    public void setFloorTextField(String s){
        floorTextField.setText(s);
    }
    
    /**
    * @author Evan Lokajaya
    */
    public void groundFloorButtonLights(boolean lights){
        if(lights == true){
            groundFloorButton.setBackground(Color.green);
        }
        else{
            groundFloorButton.setBackground(Color.lightGray);
        }
    }
    
    /**
    * @author Evan Lokajaya
    */
    public void firstFloorButtonLights(boolean lights){
        if(lights == true){
            firstFloorButton.setBackground(Color.green);
        }
        else{
            firstFloorButton.setBackground(Color.lightGray);
        }
    }
    
    /**
    * @author Evan Lokajaya
    */
    public void secondFloorButtonLights(boolean lights){
        if(lights == true){
            secondFloorButton.setBackground(Color.green);
        }
        else{
            secondFloorButton.setBackground(Color.lightGray);
        }
    }
    
    /**
    * @author Evan Lokajaya
    */
    void openDoorButtonLights(boolean lights){
        if(lights == true){
            openDoorButton.setBackground(Color.green);
        }
        else{
            openDoorButton.setBackground(Color.lightGray);
        }
    }
    
    /**
    * @author Evan Lokajaya
    */
    void emergencyStopButtonLights(boolean lights){
        if(lights == true){
            emergencyStopButton.setBackground(Color.green);
        }
        else{
            emergencyStopButton.setBackground(Color.lightGray);
        }
    }
    
    /**
    * @author Evan Lokajaya
    */
    void emergencyBellButtonLights(boolean lights){
        if(lights == true){
            emergencyBellButton.setBackground(Color.green);
        }
        else{
            emergencyBellButton.setBackground(Color.lightGray);
        }
    }

    /**
    * @author Dwinanda Alfauzan
    */
    private class StopListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(emergencyStopButton.getBackground() == Color.lightGray){
            summonElevator.firstFloorButtonLights(false);
            summonElevator.secondFloorButtonLights(false);
            summonElevator.groundFloorButtonLights(false);
            summonElevator.disableButton();
            
            groundFloorButton.setEnabled(false);
            firstFloorButton.setEnabled(false);
            secondFloorButton.setEnabled(false);
            openDoorButton.setEnabled(false);
            
            elevatorInfo.setDoorStatus("Closed");
            elevatorInfo.setPosition("");
            elevatorInfo.setStatus("Disabled");
            
            emergencyStopButtonLights(true);
            }
            else{
                
                elevatorInfo.setStatus("Running");
                summonElevator.enableButton();
                groundFloorButton.setEnabled(true);
                firstFloorButton.setEnabled(true);
                secondFloorButton.setEnabled(true);
                openDoorButton.setEnabled(true);
                emergencyStopButtonLights(false);
            }
        }
    }
    
    /**
    * @author Zefan Gracio
    */
    private class BellListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(emergencyBellButton.getBackground() == Color.green){
                emergencyBellButton.setBackground(Color.lightGray);
                elevatorInfo.setBellStatus("");
            }
            else{
                emergencyBellButton.setBackground(Color.green);
                elevatorInfo.setBellStatus("*RINGING!*");
            }
        }
    }
    
    /**
    * @author Raihan Ibrahim
    */
    private class openDoorLIstener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            openDoorButtonLights(true);
            cabController.getCab().setDoorStatus(Cab.Door.Open);
            elevatorInfo.setDoorStatus("Open");
            elevatorInfo.setStatus("Waiting");
            
            Timer timer = new Timer(5000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    openDoorButtonLights(false);
                    cabController.getCab().setDoorStatus(Cab.Door.Closed);
                    elevatorInfo.setDoorStatus("Closed");
                    elevatorInfo.setStatus("Running");
                }
            });
            timer.start();
        }
        
    }
    
    /**
    * @author Ananda Bayu
    */
    private class GroundFloorButtonListener implements ActionListener{
        Timer timer;
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(cabController.getCab().getFloor().equals(Cab.Floor.GroundFloor)){
                groundFloorButtonLights(true);
                cabController.getCab().setDoorStatus(Cab.Door.Open);
                elevatorInfo.setDoorStatus("Open");
                elevatorInfo.setStatus("Waiting");
                
                timer = new Timer(2500, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cabController.getCab().setDoorStatus(Cab.Door.Closed);
                        elevatorInfo.setDoorStatus("Closed");
                        elevatorInfo.setStatus("Running");
                        groundFloorButtonLights(false);
                    }
                });
                
                timer.start();
                
            }
            else{
                elevatorInfo.setStatus("Running");
                elevatorInfo.setDoorStatus("Closed");
                groundFloorButtonLights(true);
                cabController.getProcess().add(Cab.Floor.GroundFloor);
                cabController.move(Cab.Floor.GroundFloor, ElevatorPanel.this, elevatorInfo, summonElevator);
                elevatorInfo.setDoorStatus("Open");
                elevatorInfo.setStatus("Waiting");
            }
        }
        
    }
    
    /**
    * @author Ananda Bayu
    */
    private class FirstFloorButtonListener implements ActionListener{
        Timer timer;
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(cabController.getCab().getFloor().equals(Cab.Floor.FirstFloor)){
                firstFloorButtonLights(true);
                cabController.getCab().setDoorStatus(Cab.Door.Open);
                elevatorInfo.setDoorStatus("Open");
                elevatorInfo.setStatus("Waiting");
                
                timer = new Timer(2500, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cabController.getCab().setDoorStatus(Cab.Door.Closed);
                        elevatorInfo.setDoorStatus("Closed");
                        elevatorInfo.setStatus("Running");
                        firstFloorButtonLights(false);
                    }
                });
                
                timer.start();
                
            }
            else{
                elevatorInfo.setStatus("Running");
                elevatorInfo.setDoorStatus("Closed");
                firstFloorButtonLights(true);
                cabController.getProcess().add(Cab.Floor.FirstFloor);
                cabController.move(Cab.Floor.FirstFloor, ElevatorPanel.this, elevatorInfo, summonElevator);
                elevatorInfo.setDoorStatus("Open");
                elevatorInfo.setStatus("Waiting");
            }
        }
        
    }
    
    /**
    * @author Ananda Bayu
    */
    private class SecondFloorButtonListener implements ActionListener{
        Timer timer;
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(cabController.getCab().getFloor().equals(Cab.Floor.SecondFloor)){
                secondFloorButtonLights(true);
                cabController.getCab().setDoorStatus(Cab.Door.Open);
                elevatorInfo.setDoorStatus("Open");
                elevatorInfo.setStatus("Waiting");
                
                timer = new Timer(2500, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cabController.getCab().setDoorStatus(Cab.Door.Closed);
                        elevatorInfo.setDoorStatus("Closed");
                        elevatorInfo.setStatus("Running");
                        secondFloorButtonLights(false);
                    }
                });
                
                timer.start();
                
            }
            else{
                elevatorInfo.setStatus("Running");
                elevatorInfo.setDoorStatus("Closed");
                secondFloorButtonLights(true);
                cabController.getProcess().add(Cab.Floor.SecondFloor);
                cabController.move(Cab.Floor.SecondFloor, ElevatorPanel.this, elevatorInfo, summonElevator);
                elevatorInfo.setDoorStatus("Open");
                elevatorInfo.setStatus("Waiting");
            }
        }
        
    }
}

