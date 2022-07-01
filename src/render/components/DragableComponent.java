package render.components;

import util.Constants;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class DragableComponent extends JComponent {

    protected int x;
    protected int y;
    protected int width;
    protected int height;

    private boolean isDragging;

    private int xRel;
    private int yRel;

    public DragableComponent(){
        super.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getX() > x && e.getX() < x + width && e.getY() > y && e.getY() < y + height){
                    xRel = e.getX() - x;
                    yRel = e.getY() - y;
                    isDragging = true;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isDragging = false;
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        super.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(isDragging){
                    x = e.getX() - xRel;
                    y = e.getY() - yRel;
                    Constants.renderEngine.repaintScreen();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });
    }
}
