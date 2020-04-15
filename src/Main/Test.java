/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import View.ElevatorInfo;
import View.ElevatorPanel;
import View.OperatorPanel;
import View.SummonElevator;

/**
 *
 * @author Raihan Ibrahim
 */
public class Test {
    public static void main(String args[]) throws InterruptedException{
        DoorOperator doorOperator = new DoorOperator();
        doorOperator.startOperation();
    }
}
