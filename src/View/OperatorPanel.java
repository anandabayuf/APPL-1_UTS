/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Evan Lokajaya
 */
public class OperatorPanel {
    JButton onButton;
    JButton offButton;
    
    ElevatorPanel elevatorPanel;
    ElevatorInfo elevatorInfo;
    SummonElevator summonElevator;
    
    public OperatorPanel(ElevatorPanel elevatorPanel, ElevatorInfo elevatorInfo, SummonElevator summonElevator){
        JFrame operatorPanelFrame = new JFrame("Operator Panel");
        operatorPanelFrame.setSize(300, 220);
        operatorPanelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Assign the parameters
        this.elevatorPanel = elevatorPanel;
        this.elevatorInfo = elevatorInfo;
        this.summonElevator = summonElevator;
        
        //Initiate Button
        onButton = new JButton("ON");
        offButton = new JButton("OFF");
        
        //set button location
        onButton.setBounds(100, 30, 100, 50);
        offButton.setBounds(100, 110, 100, 50);
        
        //add component
        operatorPanelFrame.add(onButton);
        operatorPanelFrame.add(offButton);
        
        //add action listener
        onButton.addActionListener(new OnListener());
        offButton.addActionListener(new OffListener());
        
        operatorPanelFrame.setLocationRelativeTo(null);
        operatorPanelFrame.setLayout(null);
        operatorPanelFrame.setVisible(true);
    }
    
    private class OnListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            elevatorPanel.enableButton();
            summonElevator.enableButton();
            //get cab position but not available
        }
        
    }
    
    private class OffListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //Stop the cab but not available
            //close the door but not available
            
            //set the lights off
            elevatorPanel.firstFloorButtonLights(false);
            elevatorPanel.secondFloorButtonLights(false);
            elevatorPanel.groundFloorButtonLights(false);
            elevatorPanel.disableButton();
            elevatorPanel.setFloorTextField("");
            
            summonElevator.firstFloorButtonLights(false);
            summonElevator.secondFloorButtonLights(false);
            summonElevator.groundFloorButtonLights(false);
            summonElevator.disableButton();
            
            //stop responding signal not available
            
            //update the info in elevator info
            elevatorInfo.setDoorStatus("Closed");
            elevatorInfo.setPosition("");
            elevatorInfo.setStatus("Disabled");
        }
        
    }
}
