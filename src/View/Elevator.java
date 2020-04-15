/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Evan Lokajaya
 */
public class Elevator {
    public static void main(String args[]){
        ElevatorInfo elevatorInfo = new ElevatorInfo();
        ElevatorPanel elevatorPanel= new ElevatorPanel();
        SummonElevator summonElevator = new SummonElevator();
        OperatorPanel operatorPanel =new OperatorPanel(elevatorPanel, elevatorInfo, summonElevator);
    }
}
