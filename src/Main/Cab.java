/*
 * Created By Ananda Bayu Fauzan.
 */
package Main;

/**
 *
 * @author Ananda Bayu
 */
public class Cab {
    private FloorRequestButton[] floorRequestButton;
    
    public Cab(){
        floorRequestButton = new FloorRequestButton[6];
        
        floorRequestButton[0] = new FloorRequestButton();
        floorRequestButton[1] = new FloorRequestButton();
        floorRequestButton[2] = new FloorRequestButton();
        floorRequestButton[3] = new FloorRequestButton();
        floorRequestButton[4] = new FloorRequestButton();
        floorRequestButton[5] = new FloorRequestButton();
    }
}
