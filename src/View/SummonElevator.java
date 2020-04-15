/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Cab;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JButton;
import javax.swing.JFrame;
import Model.Cab.*;
import java.util.TimerTask;
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
    
    public SummonElevator(){
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
                
                //groundFloorButtonLights(turnOff);
            }
            else{
                groundFloorButtonLights(turnOn);
                //wait
            }
        }
        
    }
    
    private class FirstFloorListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            firstFloorButtonLights(true);
        }
        
    }
    
    private class SecondFloorListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            secondFloorButtonLights(true);
        }
        
    }
}
