package wiring;

//Wires should not have their locations saved, only linked nodes should be saved so that the wiring can be calculated later

import javax.swing.*;
import java.awt.*;

public class Wire extends JPanel {

    public WireNode node1;
    public WireNode node2;

    public Wire(WireNode node1, WireNode node2){
        this.node1 = node1;
        this.node2 = node2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        //paint wire from x1y1 to x2y2, which is from the location of the nodes.
        // got from getCompFromWireNode in WireNodeManager.class
    }
}
