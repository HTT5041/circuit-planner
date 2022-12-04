import render.ContentPane;
import render.ui.ClearCircuit;
import render.ui.SideBar;
import render.ui.WireTool;
import render.ui.statics.StaticCell;
import render.ui.statics.StaticLamp;
import render.ui.statics.StaticResistor;
import render.ui.statics.StaticSwitch;
import util.Constants;
import util.Scheduler;
import wiring.WireCanvas;

import javax.swing.*;


public class CircuitPlanner {

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Circuit Planner");
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        ContentPane contentPane = new ContentPane();
        contentPane.setOpaque(true);
        frame.setContentPane(contentPane);

        //Display the window.
        frame.setVisible(true);

        Constants.frame = frame;
        Constants.contentPane = contentPane;
    }

    public static void main(String[] args) {
        Constants.scheduler = new Scheduler();

        createAndShowGUI();
    }

}
