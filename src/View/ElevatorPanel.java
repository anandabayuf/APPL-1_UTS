/*
 Panel.java

 */
package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    
    public ElevatorPanel(){
        JFrame elevatorPanelFrame = new JFrame("Elevator Panel");
        elevatorPanelFrame.setSize(300, 500);
        elevatorPanelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
        
        //add action listener
        groundFloorButton.addActionListener(new GroundFloorButtonListener());
        firstFloorButton.addActionListener(new FirstFloorButtonListener());
        secondFloorButton.addActionListener(new SecondFloorButtonListener());
        
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
        
        elevatorPanelFrame.setLocationRelativeTo(null);
        elevatorPanelFrame.setLayout(null);
        elevatorPanelFrame.setVisible(true);
        
    }
    
    void enableButton(){
        groundFloorButton.setEnabled(true);
        firstFloorButton.setEnabled(true);
        secondFloorButton.setEnabled(true);
        openDoorButton.setEnabled(true);
    }
    
    void disableButton(){
        groundFloorButton.setEnabled(false);
        firstFloorButton.setEnabled(false);
        secondFloorButton.setEnabled(false);
        openDoorButton.setEnabled(false);
    }
    
    public void setFloorTextField(String s){
        floorTextField.setText(s);
    }
    
    void groundFloorButtonLights(boolean lights){
        if(lights == true){
            groundFloorButton.setBackground(Color.green);
        }
        else{
            groundFloorButton.setBackground(Color.lightGray);
        }
    }
    
    void firstFloorButtonLights(boolean lights){
        if(lights == true){
            firstFloorButton.setBackground(Color.green);
        }
        else{
            firstFloorButton.setBackground(Color.lightGray);
        }
    }
    
    void secondFloorButtonLights(boolean lights){
        if(lights == true){
            secondFloorButton.setBackground(Color.green);
        }
        else{
            secondFloorButton.setBackground(Color.lightGray);
        }
    }
    
    void openDoorButtonLights(boolean lights){
        if(lights == true){
            openDoorButton.setBackground(Color.green);
        }
        else{
            openDoorButton.setBackground(Color.lightGray);
        }
    }
    
    void emergencyStopButtonLights(boolean lights){
        if(lights == true){
            emergencyStopButton.setBackground(Color.green);
        }
        else{
            emergencyStopButton.setBackground(Color.lightGray);
        }
    }
    
    void emergencyBellButtonLights(boolean lights){
        if(lights == true){
            emergencyBellButton.setBackground(Color.green);
        }
        else{
            emergencyBellButton.setBackground(Color.lightGray);
        }
    }
    
    private class GroundFloorButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
        }
        
    }
    
    private class FirstFloorButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
        }
        
    }
    
    private class SecondFloorButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
        }
        
    }
    
}
