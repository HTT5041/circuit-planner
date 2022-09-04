package wiring;

import events.EventManager;
import events.impl.MouseDraggedListener;
import events.impl.MouseMovedListener;
import events.impl.MousePressedListener;
import events.impl.MouseReleasedListener;
import render.components.DragableComponent;
import util.Constants;
import util.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class WireNodeManager extends JPanel implements MousePressedListener, MouseReleasedListener, MouseDraggedListener, MouseMovedListener {

    private static HashMap<DragableComponent, WireNode[]> components = new HashMap<DragableComponent, WireNode[]>();

    private boolean drawWireToolNode = false;

    public WireNodeManager(){
        EventManager.registerListener(this);
    }

    public static void register(DragableComponent comp) {
        components.put(comp, new WireNode[]{new WireNode(), new WireNode()});
    }
    public static void deregister(DragableComponent comp) {
        components.remove(comp);
    }

    private static boolean isMouseInBounds(DragableComponent comp){
        Point offset = MouseInfo.getPointerInfo().getLocation();
        Point loc = Constants.frame.getLocation();
        return offset.getX() - loc.getX() > comp.x && offset.getX() - loc.getX() < comp.x + comp.width
                && offset.getY() - loc.getY()-20 > comp.y && offset.getY() - loc.getY()-20 < comp.y + comp.height;
    }

    private boolean isMouseInBoundsOfAny(){
        boolean rv = false;
        for (DragableComponent comp:
             components.keySet()) {
            if(isMouseInBounds(comp))
                rv = true;
        }
        return rv;
    }

    public DragableComponent getCompMouseOver(){
        for (DragableComponent comp:
                components.keySet()) {
            if(isMouseInBounds(comp))
                return comp;
        }
        return null;
    }

    public static void drawWireNodes(Graphics g, DragableComponent comp){
        //Todo fix for rotated components
        Graphics2D g2d = (Graphics2D) g;

        if(isMouseInBounds(comp) && Constants.wireTool.enabled) {
            g2d.setColor(Color.orange);
            if(components.get(comp)[0].isSelected){
                g2d.setColor(Color.green);
            }
            g2d.fillOval(-1, (comp.height / 2) - 4, 8, 8);

            g2d.setColor(Color.orange);
            if(components.get(comp)[1].isSelected){
                g2d.setColor(Color.green);
            }
            g2d.fillOval(comp.width - 8, (comp.height / 2) - 4, 8, 8);
        }
    }

    private static void linkNodes(){
        WireNode selectedNode1 = null;
        WireNode selectedNode2 = null;

        for (WireNode[] wnArr:
                components.values()) {
            if(wnArr[0].isSelected && wnArr[1].isSelected){
                Utils.showAlert("Warning!", "You cannot attach a node to another node of the same component.");
                wnArr[0].isSelected = false;
                wnArr[1].isSelected = false;
                break;
            }
            if(selectedNode1 == null) {
                if (wnArr[0].isSelected) {
                    selectedNode1 = wnArr[0];
                }
                if (wnArr[1].isSelected) {
                    selectedNode1 = wnArr[0];
                }
            } else {
                if (wnArr[0].isSelected) {
                    selectedNode2 = wnArr[0];
                }
                if (wnArr[1].isSelected) {
                    selectedNode2 = wnArr[0];
                }
            }
        }

        if(selectedNode2 != null){
            //link them
        }

    }


    @Override
    public void onMouseDragged(MouseEvent e) {

    }

    @Override
    public void onMouseMoved(MouseEvent e) {
        if(Constants.wireTool.enabled && isMouseInBoundsOfAny()){
            drawWireToolNode = true;
            Constants.contentPane.repaintScreen();
        } else {
            if(drawWireToolNode){
                drawWireToolNode = false;
                Constants.contentPane.repaintScreen();
            }
            drawWireToolNode = false;
        }
    }

    @Override
    public void onMousePressed(MouseEvent e) {
        if(Constants.wireTool.enabled && isMouseInBoundsOfAny()){
            DragableComponent compHovered = getCompMouseOver();
            if(compHovered != null){
                if((e.getX() - compHovered.x) > compHovered.width/2){
                    components.get(compHovered)[1].isSelected = !components.get(compHovered)[1].isSelected;
                } else {
                    components.get(compHovered)[0].isSelected = !components.get(compHovered)[0].isSelected;
                }
                Constants.contentPane.repaintScreen();
                linkNodes();
            }
        }
    }

    @Override
    public void onMouseReleased(MouseEvent e) {

    }
}
