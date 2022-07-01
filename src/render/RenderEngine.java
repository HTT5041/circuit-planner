package render;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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
                repaintScreen();
            }
        });
    }

    public void addComponent(JComponent comp){
        frame.add(comp);
        repaintScreen();
        comp.updateUI();
        comp.validate();
    }

    public void repaintScreen(){
        frame.invalidate();
        frame.repaint();
        frame.revalidate();
        frame.validate();
    }

}
