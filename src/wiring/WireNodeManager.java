package wiring;

import events.EventManager;
import events.impl.MouseDraggedListener;
import events.impl.MouseMovedListener;
import events.impl.MousePressedListener;
import events.impl.MouseReleasedListener;
import render.ContentPane;
import render.components.DragableComponent;
import render.ui.statics.StaticComponent;
import util.Constants;
import util.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class WireNodeManager extends JPanel implements MousePressedListener, MouseReleasedListener, MouseDraggedListener, MouseMovedListener {

    private static HashMap<DragableComponent, WireNode[]> components = new HashMap<DragableComponent, WireNode[]>();

    private boolean drawWireToolNode = false;

    public WireNodeManager(){
        EventManager.registerListener(this);
    }

    public static void register(DragableComponent comp) {
        components.put(comp, new WireNode[]{new WireNode(0), new WireNode(1)});
    }

    public static HashMap<DragableComponent, WireNode[]> getManagedComponents(){
        return components;
    }

    public static void clearManagedComponents(){
        components.clear();
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
        if(comp instanceof StaticComponent)
            return;

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

    public static DragableComponent findCompFromWireNode(WireNode node){
        for (DragableComponent comp:
                components.keySet()) {
            if(components.get(comp)[0] == node || components.get(comp)[1] == node)
                return comp;
        }
        return null;
    }

    private static void linkNodes(){
        //todo add check for already bound nodes

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
                    selectedNode1 = wnArr[1];
                }
            } else {
                if (wnArr[0].isSelected) {
                    selectedNode2 = wnArr[0];
                }
                if (wnArr[1].isSelected) {
                    selectedNode2 = wnArr[1];
                }
            }
            //There should only be 2 possible nodes selected at any one time
        }

        if(selectedNode2 != null){
            selectedNode1.partner = selectedNode2;
            selectedNode2.partner = selectedNode1;
            selectedNode1.isBound = true;
            selectedNode2.isBound = true;
            selectedNode1.isSelected = false;
            selectedNode2.isSelected = false;

            System.out.println("adding wire");
            WireCanvas.addWire(new Wire(selectedNode1, selectedNode2));

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
            if(compHovered != null && !(compHovered instanceof StaticComponent)){
                if((e.getX() - compHovered.x) > compHovered.width/2){
                    components.get(compHovered)[1].isSelected = !components.get(compHovered)[1].isSelected;
                } else {
                    components.get(compHovered)[0].isSelected = !components.get(compHovered)[0].isSelected;
                }
                Constants.contentPane.repaintScreen();

                //Todo add check for already bound nodes, if it is already bound then delete the wire
                linkNodes();
            }
        }
    }

    @Override
    public void onMouseReleased(MouseEvent e) {

    }

    public static ArrayList<DragableComponent> getSaveableComponents(){
        ArrayList<DragableComponent> rv = new ArrayList<DragableComponent>();
        for (DragableComponent comp:
                components.keySet()) {
            if(comp instanceof StaticComponent) continue;
            rv.add(comp);
        }
        return rv;
    }
}
