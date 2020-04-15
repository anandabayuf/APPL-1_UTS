/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Evan Lokajaya
 */
public class ElevatorInfo {
    JTextField statusTextField;
    JTextField positionTextField;
    JTextField doorStatusTextField;
    Font font;
    
    public ElevatorInfo(){
        JFrame elevatorInfoFrame = new JFrame("Elevator Info");
        elevatorInfoFrame.setSize(350, 350);
        elevatorInfoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //setting the font
        font = new Font("SansSerif", Font.BOLD, 20);
        
        //Inititate label
        JLabel statusLabel = new JLabel("Status");
        JLabel positionLabel = new JLabel("Position");
        JLabel doorLabel = new JLabel("Door");
        
        //initiate text-field
        statusTextField = new JTextField("Running");
        positionTextField = new JTextField("0");
        doorStatusTextField = new JTextField("Closed");
        
        //disabled edit on text field
        statusTextField.setEnabled(false);
        positionTextField.setEnabled(false);
        doorStatusTextField.setEnabled(false);
        
        //set label position and font
        statusLabel.setFont(font);
        statusLabel.setBounds(20, 20, 100, 50);
        positionLabel.setFont(font);
        positionLabel.setBounds(20, 120, 100, 50);
        doorLabel.setFont(font);
        doorLabel.setBounds(20, 220, 100, 50);
        
        //set text field position and font
        statusTextField.setFont(font);
        statusTextField.setBounds(120, 20, 100, 50);
        positionTextField.setFont(font);
        positionTextField.setHorizontalAlignment(JTextField.CENTER);
        positionTextField.setBounds(120, 120, 50, 50);
        doorStatusTextField.setFont(font);
        doorStatusTextField.setBounds(120, 220, 100, 50);
        
        //add the component
        elevatorInfoFrame.add(statusLabel);
        elevatorInfoFrame.add(positionLabel);
        elevatorInfoFrame.add(doorLabel);
        elevatorInfoFrame.add(statusTextField);
        elevatorInfoFrame.add(positionTextField);
        elevatorInfoFrame.add(doorStatusTextField);
        
        elevatorInfoFrame.setLocationRelativeTo(null);
        elevatorInfoFrame.setLayout(null);
        elevatorInfoFrame.setVisible(true);
    }
    
    void setStatus(String status){
        statusTextField.setText(status);
    }
    
    void setPosition(String pos){
        positionTextField.setText(pos);
    }
    
    void setDoorStatus(String status){
        doorStatusTextField.setText(status);
    }
}
