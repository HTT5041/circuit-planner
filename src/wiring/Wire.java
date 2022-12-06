package wiring;

//Wires should not have their locations saved, only linked nodes should be saved so that the wiring can be calculated later

import render.components.DragableComponent;

import java.awt.*;

public class Wire {

    public WireNode node1;
    public WireNode node2;

    private Point getNodeLoc(WireNode node){
        DragableComponent c = WireNodeManager.findCompFromWireNode(node);
        if(node.side == 0){
            return new Point(c.x, c.y + (c.height/2));
        } else {
            return new Point(c.x + (c.width), c.y + c.height/2);
        }
    }

    public Wire(WireNode node1, WireNode node2){
        this.node1 = node1;
        this.node2 = node2;
    }

    public void paint(Graphics g){
        Point p1 = getNodeLoc(node1);
        Point p2 = getNodeLoc(node2);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
    }
}
