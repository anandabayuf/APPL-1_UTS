/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Raihan Ibrahim
 */

class Task extends TimerTask {
    @Override
    public void run() {
        
    }
}

public class DoorTimer {
    Timer timer;
    TimerTask task = new Task();
    public DoorTimer() {
        this.timer = new Timer();
         
    }
    
    void startTimer() {
        timer.schedule(task, 4000);
    }
    
    void stopTimer() {
        timer.cancel();
        timer.purge();
    }
}
