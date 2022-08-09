package render.components;

import events.EventManager;
import events.impl.MouseDraggedListener;
import events.impl.MousePressedListener;
import events.impl.MouseReleasedListener;
import util.Constants;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class DragableComponent extends JPanel implements MousePressedListener, MouseReleasedListener, MouseDraggedListener {

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
            x = e.getX() - xRel;
            y = e.getY() - yRel;

            //if(x + width > Constants.displayWidth) {
            //    x = Constants.displayWidth - width;
            //}
            //if(y + height > Constants.displayHeight) {
            //    y = Constants.displayHeight - height;
            //}
            //if(x < 0){
            //    x = 0;
            //}
            //if(y < 0){
            //    y = 0;
            //}
            setBounds(x, y, width, height);
            Constants.contentPane.repaintScreen();
        }
    }

    @Override
    public void onMousePressed(MouseEvent e) {
        if(e.getX() > x && e.getX() < x + width && e.getY() > y && e.getY() < y + height){
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
