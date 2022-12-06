package render;

import events.EventManager;
import render.ui.SettingsButton;
import render.ui.SideBar;
import render.ui.menu.MainMenu;
import render.ui.statics.*;
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

        EventManager.registerListener(Constants.wireTool);
        EventManager.registerListener(Constants.wnm);
        EventManager.registerListener(Constants.settingsMenu);
        EventManager.registerListener(Constants.clearCircuit);

        Constants.contentPane.addComponent(new WireCanvas(), Constants.L_BACKGROUND);
        Constants.contentPane.addComponent(new SideBar(), Constants.L_BACKGROUND);
        Constants.contentPane.addComponent(Constants.wireTool, Constants.L_UI);
        Constants.contentPane.addComponent(new SettingsButton(), Constants.L_UI);
        Constants.contentPane.addComponent(Constants.clearCircuit, Constants.L_UI);

        // Add static components to the sidebar
        Constants.contentPane.addComponent(new StaticSwitch(8, 75), Constants.L_UI);
        Constants.contentPane.addComponent(new StaticCell(26, 100), Constants.L_UI);
        Constants.contentPane.addComponent(new StaticResistor(8, 130), Constants.L_UI);
        Constants.contentPane.addComponent(new StaticLamp(8, 160), Constants.L_UI);
        Constants.contentPane.addComponent(new StaticVoltmeter(8, 190), Constants.L_UI);
        Constants.contentPane.addComponent(new StaticAmmeter(8, 220), Constants.L_UI);
        Constants.contentPane.addComponent(new StaticFuse(8, 250), Constants.L_UI);
        Constants.contentPane.addComponent(new StaticThermistor(8, 280), Constants.L_UI);
        Constants.contentPane.addComponent(new StaticVariableResistor(8, 310), Constants.L_UI);
        Constants.contentPane.addComponent(new StaticDiode(8, 340), Constants.L_UI);
        Constants.contentPane.addComponent(new StaticLED(8, 375), Constants.L_UI);
    }

    public void gotoMainMenu(){
        Constants.clearCircuit.clearCircuit();
        removeAll();
        EventManager.deRegisterAllListeners();
        add(menuPane);
        menuPane.registerListeners();
        repaintScreen();
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