package render;

import events.EventManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ContentPane extends JPanel {

    private JLayeredPane layeredPane;

    public ContentPane() {
        //Create and set up the layered pane.
        setLayout(null);
        layeredPane = new JLayeredPane();
        layeredPane.setSize(800, 600);
        add(layeredPane);
        addAWTEventListeners();
        setFocusable(true);
    }

    public void addComponent(Component c, int layer){
        layeredPane.add(c, layer, 0);
        repaintScreen();
    }

    public void removeComponent(Component c){
        layeredPane.remove(c);
        repaintScreen();
    }

    public void repaintScreen(){
        this.revalidate();
        this.repaint();
    }

    private void addAWTEventListeners(){
        addMouseListener(new MouseListener() {
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
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                EventManager.postMouseDraggedEvent(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                EventManager.postMouseMovedEvent(e);
            }
        });

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                EventManager.postKeyTypedEvent(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
}