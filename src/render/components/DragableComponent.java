package render.components;

import events.EventManager;
import events.impl.MouseDraggedListener;
import events.impl.MousePressedListener;
import events.impl.MouseReleasedListener;
import util.Constants;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class DragableComponent extends JComponent implements MousePressedListener, MouseReleasedListener, MouseDraggedListener {

    protected int x;
    protected int y;
    protected int width;
    protected int height;

    private boolean isDragging;

    private int xRel;
    private int yRel;

    public DragableComponent(){
        EventManager.registerListener(this);
    }

    @Override
    public void onMouseDragged(MouseEvent e) {
        if(isDragging){
            x = e.getXOnScreen() - xRel;
            y = e.getYOnScreen() - yRel;
            Constants.renderEngine.repaintScreen();
        }
    }

    @Override
    public void onMousePressed(MouseEvent e) {
        if(e.getX() > x && e.getX() < x + width && e.getY() > y + height/2 && e.getY() < y + 1.5*height){
            xRel = e.getX() - x;
            yRel = e.getY() - y;
            isDragging = true;
        }
    }

    @Override
    public void onMouseReleased(MouseEvent e) {
        isDragging = false;
    }
}
