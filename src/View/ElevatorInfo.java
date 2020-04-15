/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import java.awt.Color;
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
    JTextField bellStatusTextField;
    Font font;
    
    public ElevatorInfo(){
        JFrame elevatorInfoFrame = new JFrame("Elevator Info");
        elevatorInfoFrame.setSize(500, 500);
        elevatorInfoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //setting the font
        font = new Font("SansSerif", Font.BOLD, 20);
        
        //Inititate label
        JLabel statusLabel = new JLabel("Status");
        JLabel positionLabel = new JLabel("Position");
        JLabel doorLabel = new JLabel("Door");
        JLabel bellLabel = new JLabel("Bell");
        
        
        //initiate text-field
        statusTextField = new JTextField("Running");
        positionTextField = new JTextField("0");
        doorStatusTextField = new JTextField("Closed");
        bellStatusTextField = new JTextField("");
        
        //disabled edit on text field
        statusTextField.setEnabled(false);
        positionTextField.setEnabled(false);
        doorStatusTextField.setEnabled(false);
        bellStatusTextField.setEnabled(false);
        
        //set label position and font
        statusLabel.setFont(font);
        statusLabel.setBounds(20, 20, 100, 50);
        positionLabel.setFont(font);
        positionLabel.setBounds(20, 120, 100, 50);
        doorLabel.setFont(font);
        doorLabel.setBounds(20, 220, 100, 50);
        bellLabel.setFont(font);
        bellLabel.setBounds(20, 320, 100, 50);
        
        //set text field position and font
        statusTextField.setFont(font);
        statusTextField.setBounds(120, 20, 100, 50);
        positionTextField.setFont(font);
        positionTextField.setHorizontalAlignment(JTextField.CENTER);
        positionTextField.setBounds(120, 120, 50, 50);
        doorStatusTextField.setFont(font);
        doorStatusTextField.setBounds(120, 220, 100, 50);
        bellStatusTextField.setDisabledTextColor(Color.red);
        bellStatusTextField.setFont(font);
        bellStatusTextField.setHorizontalAlignment(JTextField.CENTER);
        bellStatusTextField.setBounds(120, 320, 200, 50);
        
        //add the component
        elevatorInfoFrame.add(statusLabel);
        elevatorInfoFrame.add(positionLabel);
        elevatorInfoFrame.add(doorLabel);
        elevatorInfoFrame.add(bellLabel);
        elevatorInfoFrame.add(statusTextField);
        elevatorInfoFrame.add(positionTextField);
        elevatorInfoFrame.add(doorStatusTextField);
        elevatorInfoFrame.add(bellStatusTextField);
        
        elevatorInfoFrame.setLocationRelativeTo(null);
        elevatorInfoFrame.setLayout(null);
        elevatorInfoFrame.setVisible(true);
    }
    
    public void setStatus(String status){
        if(status.equals("Running")){
            statusTextField.setDisabledTextColor(Color.green);
        }else if(status.equals("Waiting")){
            statusTextField.setDisabledTextColor(Color.orange);
        }else{
            statusTextField.setDisabledTextColor(Color.red);
        }
        statusTextField.setText(status);
    }
    
    public void setPosition(String pos){
        positionTextField.setText(pos);
    }
    
    public void setDoorStatus(String status){
        if(status.equals("Open")){
            doorStatusTextField.setDisabledTextColor(Color.green);
        }else{
            doorStatusTextField.setDisabledTextColor(Color.red);
        }
        doorStatusTextField.setText(status);
    }
    
    public void setBellStatus(String status){
        bellStatusTextField.setText(status);
    }
}
