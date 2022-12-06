package wiring;

import render.components.DragableComponent;

public class WireNode {

    public DragableComponent parent; //Parent is used for serialising the wire node

    public boolean isSelected = false;
    public boolean isBound = false;
    public int side; //0 is left, 1 is right - Side is checked to know where to draw the on-screen wire from
    public WireNode partner = null;

    public WireNode(DragableComponent parent, int side){
        this.parent = parent;
        this.side = side;
    }

}
