/*
 * Created By Ananda Bayu Fauzan.
 */
package Main;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Ananda Bayu
 */
public class DoorTimer extends TimerTask{
    private int count;
    private Timer timer;
    private TimerTask task;
    
    public DoorTimer(){
        timer = new Timer(); 
        task = this;
    }
    
    public int getCount(){
        return count;
    }
    
    public void startTimer(){
        timer.schedule(task, 2000, 5000);
    }
    
    public void stopTimer(){
        timer.cancel();
    }
    
    public void reset(){
        
    }
    
    public void Notify(){
        System.out.println("Door Times up...");
    }

    @Override
    public void run() {
        if(this.getCount() == 5){
            this.Notify();
            this.stopTimer();
        }
    }
}
