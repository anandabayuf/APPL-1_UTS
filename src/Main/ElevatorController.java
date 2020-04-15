/*
 * Created By Ananda Bayu Fauzan.
 */
package Main;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Ananda Bayu
 */
public class ElevatorController {
    private Queue<Request> q = new LinkedList<>();
    
    public static abstract class Request {
        public abstract int getCabID();

        public abstract int getFloorNumber();
    }
    
    public Queue<Request> getQueue(){
        return q;
    }
}
