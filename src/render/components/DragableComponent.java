package render.components;

import events.EventManager;
import events.impl.*;
import render.ui.statics.StaticComponent;
import util.Constants;
import util.Utils;
import wiring.WireNodeManager;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public abstract class DragableComponent extends JPanel implements MousePressedListener, MouseReleasedListener, MouseDraggedListener, MouseMovedListener, KeyTypedListener {

    public String compUUID;

    public int x;
    public int y;
    public int width;
    public int height;

    private boolean isDragging;

    private int xRel;
    private int yRel;

    public DragableComponent(){
        compUUID = Utils.generateUUID();
        System.out.println("Created "+ getClass().getSimpleName() +" with UUID "+ compUUID);
        EventManager.registerListener(this);
        WireNodeManager.register(this);
    }

    public void forceDrag(int _xRel, int _yRel){
        xRel = _xRel;
        yRel = _yRel;
        isDragging = true;
    }

    @Override
    public void onMouseDragged(MouseEvent e) {
        if(isDragging){
            x = e.getX() - xRel;
            y = e.getY() - yRel;

            setBounds(x, y, width, height);

            Constants.contentPane.repaintScreen();
        }
    }

    @Override
    public void onMousePressed(MouseEvent e) {
        if(Constants.wireTool.enabled){
            return;
        }

        if(e.getX() > x && e.getX() < x + width && e.getY() > y && e.getY() < y + height){
            xRel = e.getX() - x;
            yRel = e.getY() - y;
            isDragging = true;
        }
    }

    @Override
    public void onMouseReleased(MouseEvent e) {
        isDragging = false;
        boolean moveAndRepaint = false;

        if(x + width > Constants.displayWidth) {
            x = Constants.displayWidth - width*2;
            moveAndRepaint = true;
        }
        if(y + height > Constants.displayHeight) {
            y = Constants.displayHeight - height*2;
            moveAndRepaint = true;
        }
        if(x < 0){
            x = 0;
            moveAndRepaint = true;
        }
        if(y < 0){
            y = 0;
            moveAndRepaint = true;
        }

        if(moveAndRepaint){
            setBounds(x, y, width, height);
            Constants.contentPane.repaintScreen();
        }
    }

    @Override
    public void onKeyTyped(KeyEvent e) {

    }

    @Override
    public void onMouseMoved(MouseEvent e) {
    }
}
