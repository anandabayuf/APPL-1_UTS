/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CabController;

/**
 *
 * @author Evan Lokajaya
 */
public class Elevator {
    public static void main(String args[]){
        CabController cabController = new Controller.CabController();
        ElevatorInfo elevatorInfo = new ElevatorInfo();
        ElevatorPanel elevatorPanel= new ElevatorPanel(elevatorInfo, cabController);
        OperatorPanel operatorPanel =new OperatorPanel(elevatorPanel, elevatorInfo, elevatorPanel.getSummonElevator(), cabController);
    }
}
