/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Evan Lokajaya
 */
public class SummonElevator {
    JButton groundFloor;
    JButton firstFloor;
    JButton secondFloor;
    
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
}
