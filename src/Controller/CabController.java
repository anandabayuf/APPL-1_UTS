/*
 * Created By Ananda Bayu Fauzan.
 */
package Controller;

import Model.Cab;
import Model.Cab.Direction;
import Model.Cab.Floor;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Ananda Bayu
 */
public class CabController {
    private Cab cab;
    private Queue<Floor> process;
    
    public CabController(){
        cab = new Cab(Direction.Up, Floor.GroundFloor);
        process = new LinkedList();
    }
    
    public Queue<Floor> getProcess(){
        if(process == null)
            return new LinkedList();
        return process;
    }
    
    public Cab getCab(){
        return cab;
    }
}
