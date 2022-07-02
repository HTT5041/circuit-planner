package render;

import events.EventManager;

import javax.swing.*;
import java.awt.event.*;

public class RenderEngine {

    private static JFrame frame;

    public static int frameWidth = 800;
    public static int frameHeight = 600;

    public RenderEngine(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setTitle("Circuit Planner");

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                frameHeight = frame.getHeight();
                frameWidth = frame.getWidth();
                frame.setSize(frameWidth, frameHeight);
                repaintScreen();
            }
        });

        addAWTEventListeners();
    }

    private void addAWTEventListeners(){
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                EventManager.postMousePressedEvent(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                EventManager.postMouseReleasedEvent(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                EventManager.postMouseDraggedEvent(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }

    public void addComponent(JComponent comp){
        frame.add(comp);
        repaintScreen();
    }

    public void repaintScreen(){
        frame.revalidate();
        frame.repaint();
    }

}
