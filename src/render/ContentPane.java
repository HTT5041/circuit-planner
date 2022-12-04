package render;

import events.EventManager;
import events.impl.EventListener;
import render.ui.ClearCircuit;
import render.ui.SideBar;
import render.ui.menu.MainMenu;
import render.ui.statics.StaticCell;
import render.ui.statics.StaticLamp;
import render.ui.statics.StaticResistor;
import render.ui.statics.StaticSwitch;
import util.Constants;
import wiring.WireCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ContentPane extends JPanel {

    public JLayeredPane layeredPane; // The editor contentPane

    public MainMenu menuPane; // The menu contentPane

    public ContentPane() {
        //Create and set up the layered pane.
        addAWTEventListeners();
        setLayout(null);
        setFocusable(true);

        layeredPane = new JLayeredPane();
        layeredPane.setSize(800, 600);

        menuPane = new MainMenu();

        add(menuPane);

        repaintScreen();
    }

    public void gotoEditor() {
        removeAll();
        menuPane.deRegisterListeners();
        add(layeredPane);

        Constants.contentPane.addComponent(new WireCanvas(), Constants.L_BACKGROUND);
        Constants.contentPane.addComponent(new SideBar(), Constants.L_BACKGROUND);
        Constants.contentPane.addComponent(Constants.wireTool, Constants.L_UI);
        Constants.contentPane.addComponent(new ClearCircuit(), Constants.L_UI);

        // Add static components to the sidebar
        Constants.contentPane.addComponent(new StaticSwitch(8, 50), Constants.L_UI);
        Constants.contentPane.addComponent(new StaticCell(26, 75), Constants.L_UI);
        Constants.contentPane.addComponent(new StaticResistor(8, 100), Constants.L_UI);
        Constants.contentPane.addComponent(new StaticLamp(8, 125), Constants.L_UI);
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