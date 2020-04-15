/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import Model.Cab.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public SummonElevator(ElevatorPanel elevatorPanel, ElevatorInfo elevatorInfo){
        JFrame summonElevator = new JFrame("Summon Elevator");
        summonElevator.setSize(400, 220);
        summonElevator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
        groundFloor.addActionListener(new GroundFloorListener());
        firstFloor.addActionListener(new FirstFloorListener());
        secondFloor.addActionListener(new SecondFloorListener());
        
        cabController = new Controller.CabController();
        
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
    
    void groundFloorButtonLights(boolean lights){
        if(lights == true){
            groundFloor.setBackground(Color.green);
        }
        else{
            groundFloor.setBackground(Color.lightGray);
        }
    }
    
    void firstFloorButtonLights(boolean lights){
        if(lights == true){
            firstFloor.setBackground(Color.green);
        }
        else{
            firstFloor.setBackground(Color.lightGray);
        }
    }
    
    void secondFloorButtonLights(boolean lights){
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
        @Override
        public void actionPerformed(ActionEvent e) {
            if(cabController.getCab().getFloor().equals(Floor.GroundFloor)){
                groundFloorButtonLights(turnOn);
                //opendoor
                //timer
                //closedoor
                //groundFloorButtonLights(turnOff);
            }
            else{
                elevatorInfo.setStatus("Running");
                elevatorInfo.setDoorStatus("Closed");
                groundFloorButtonLights(turnOn);
                cabController.getProcess().add(Floor.GroundFloor);
                try {
                    
                    cabController.move(Floor.GroundFloor, elevatorPanel, elevatorInfo);
                    //wait
                } catch (InterruptedException ex) {
                    Logger.getLogger(SummonElevator.class.getName()).log(Level.SEVERE, null, ex);
                }
                groundFloorButtonLights(turnOff);
            }
        }
        
    }
    
    private class FirstFloorListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(cabController.getCab().getFloor().equals(Floor.FirstFloor)){
                firstFloorButtonLights(turnOn);
                //opendoor
                //timer
                //closedoor
                //groundFloorButtonLights(turnOff);
            }
            else{
                elevatorInfo.setStatus("Running");
                elevatorInfo.setDoorStatus("Closed");
                firstFloorButtonLights(turnOn);
                cabController.getProcess().add(Floor.FirstFloor);
                try {
                    
                    cabController.move(Floor.FirstFloor, elevatorPanel, elevatorInfo);
                    //wait
                } catch (InterruptedException ex) {
                    Logger.getLogger(SummonElevator.class.getName()).log(Level.SEVERE, null, ex);
                }
                firstFloorButtonLights(turnOff);
            }
        }
        
    }
    
    private class SecondFloorListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(cabController.getCab().getFloor().equals(Floor.SecondFloor)){
                secondFloorButtonLights(turnOn);
                //opendoor
                //timer
                //closedoor
                //groundFloorButtonLights(turnOff);
            }
            else{
                elevatorInfo.setStatus("Running");
                elevatorInfo.setDoorStatus("Closed");
                secondFloorButtonLights(turnOn);
                cabController.getProcess().add(Floor.SecondFloor);
                try {
                    
                    cabController.move(Floor.SecondFloor, elevatorPanel, elevatorInfo);
                    //wait
                } catch (InterruptedException ex) {
                    Logger.getLogger(SummonElevator.class.getName()).log(Level.SEVERE, null, ex);
                }
                secondFloorButtonLights(turnOff);
            }
        }
        
    }
}
