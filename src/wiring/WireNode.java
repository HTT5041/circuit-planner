package wiring;

public class WireNode {

    public boolean isSelected = false;
    public boolean isBound = false;
    public int side; //0 is left, 1 is right - Side is checked to know where to draw the on-screen wire from
    public WireNode partner = null;

    public WireNode(int side){
        this.side = side;
    }

}
