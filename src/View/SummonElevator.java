/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CabController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import Model.Cab.*;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author Evan Lokajaya
 */
public class SummonElevator{
    JButton groundFloor;
    JButton firstFloor;
    JButton secondFloor;
    boolean turnOn = true, turnOff = false;
    Controller.CabController cabController;
    ElevatorPanel elevatorPanel;
    ElevatorInfo elevatorInfo;
    
    public SummonElevator(ElevatorPanel elevatorPanel, ElevatorInfo elevatorInfo, CabController cabController){
        JFrame summonElevator = new JFrame("Summon Elevator");
        summonElevator.setSize(400, 220);
        summonElevator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //assigning the parameter
        this.elevatorPanel = elevatorPanel;
        this.elevatorInfo = elevatorInfo;
        this.cabController = cabController;
        
        //Initiate Button
        groundFloor = new JButton("Ground Floor");
        firstFloor = new JButton("First Floor");
        secondFloor = new JButton("Second Floor");
        
        //set button posistion
        secondFloor.setBounds(100, 15, 200, 40);
        firstFloor.setBounds(100, 70, 200, 40);
        groundFloor.setBounds(100, 125, 200, 40);
        
        //set button color
        secondFloor.setBackground(Color.lightGray);
        secondFloor.setForeground(Color.white);
        firstFloor.setBackground(Color.lightGray);
        firstFloor.setForeground(Color.white);
        groundFloor.setBackground(Color.lightGray);
        groundFloor.setForeground(Color.white);
        
        //add the component to frame
        summonElevator.add(secondFloor);
        summonElevator.add(firstFloor);
        summonElevator.add(groundFloor);
        
        summonElevator.setLocationRelativeTo(null);
        summonElevator.setLayout(null);
        summonElevator.setVisible(true);
        
        //add action listener
        groundFloor.addActionListener(new GroundFloorListener(this));
        firstFloor.addActionListener(new FirstFloorListener(this));
        secondFloor.addActionListener(new SecondFloorListener(this));
        
        this.elevatorPanel = elevatorPanel;
        this.elevatorInfo = elevatorInfo;
    }
    
    
    void enableButton(){
        groundFloor.setEnabled(true);
        firstFloor.setEnabled(true);
        secondFloor.setEnabled(true);
    }
    
    void disableButton(){
        groundFloor.setEnabled(false);
        firstFloor.setEnabled(false);
        secondFloor.setEnabled(false);
    }
    
    public void groundFloorButtonLights(boolean lights){
        if(lights == true){
            groundFloor.setBackground(Color.green);
        }
        else{
            groundFloor.setBackground(Color.lightGray);
        }
    }
    
    public void firstFloorButtonLights(boolean lights){
        if(lights == true){
            firstFloor.setBackground(Color.green);
        }
        else{
            firstFloor.setBackground(Color.lightGray);
        }
    }
    
    public void secondFloorButtonLights(boolean lights){
        if(lights == true){
            secondFloor.setBackground(Color.green);
        }
        else{
            secondFloor.setBackground(Color.lightGray);
        }
    }
    
    /**
     * @author Ananda Bayu
     */
    private class GroundFloorListener implements ActionListener{
        SummonElevator summonElevator;
        Timer timer;
        
        public GroundFloorListener(SummonElevator summonElevator){
            this.summonElevator = summonElevator;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(cabController.getCab().getFloor().equals(Floor.GroundFloor)){
                groundFloorButtonLights(turnOn);
                cabController.getCab().setDoorStatus(Door.Open);
                elevatorInfo.setDoorStatus("Open");
                elevatorInfo.setStatus("Waiting");
                
                timer = new Timer(2500, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cabController.getCab().setDoorStatus(Door.Closed);
                        elevatorInfo.setDoorStatus("Closed");
                        elevatorInfo.setStatus("Running");
                        groundFloorButtonLights(turnOff);
                    }
                });
                
                timer.start();
                
            }
            else{
                elevatorInfo.setStatus("Running");
                elevatorInfo.setDoorStatus("Closed");
                groundFloorButtonLights(turnOn);
                cabController.getProcess().add(Floor.GroundFloor);
                cabController.move(Floor.GroundFloor, elevatorPanel, elevatorInfo, summonElevator);
                 
            }
        }
        
    }
    
    private class FirstFloorListener implements ActionListener{
        SummonElevator summonElevator;
        Timer timer;
        
        public FirstFloorListener(SummonElevator summonElevator){
            this.summonElevator = summonElevator;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(cabController.getCab().getFloor().equals(Floor.FirstFloor)){
                firstFloorButtonLights(turnOn);
                cabController.getCab().setDoorStatus(Door.Open);
                elevatorInfo.setDoorStatus("Open");
                elevatorInfo.setStatus("Waiting");
                
                timer = new Timer(2000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cabController.getCab().setDoorStatus(Door.Closed);
                        elevatorInfo.setDoorStatus("Closed");
                        elevatorInfo.setStatus("Running");
                        firstFloorButtonLights(turnOff);
                    }
                });
                
                timer.start();
            }
            else{
                elevatorInfo.setStatus("Running");
                elevatorInfo.setDoorStatus("Closed");
                firstFloorButtonLights(turnOn);
                cabController.getProcess().add(Floor.FirstFloor);      
                cabController.move(Floor.FirstFloor, elevatorPanel, elevatorInfo, summonElevator);
              
            }
        }
        
    }
    
    private class SecondFloorListener implements ActionListener{
        SummonElevator summonElevator;
        Timer timer;
        
        public SecondFloorListener(SummonElevator summonElevator){
            this.summonElevator = summonElevator;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(cabController.getCab().getFloor().equals(Floor.SecondFloor)){
                secondFloorButtonLights(turnOn);
                cabController.getCab().setDoorStatus(Door.Open);
                elevatorInfo.setDoorStatus("Open");
                elevatorInfo.setStatus("Waiting");
                
                timer = new Timer(2000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cabController.getCab().setDoorStatus(Door.Closed);
                        elevatorInfo.setDoorStatus("Closed");
                        elevatorInfo.setStatus("Running");
                        secondFloorButtonLights(turnOff);
                    }
                });
                timer.start();
            }
            else{
                secondFloorButtonLights(turnOn);
                elevatorInfo.setStatus("Running");
                elevatorInfo.setDoorStatus("Closed");
                cabController.getProcess().add(Floor.SecondFloor);    
                cabController.move(Floor.SecondFloor, elevatorPanel, elevatorInfo, summonElevator);
                
            }
        }
        
    }
}
