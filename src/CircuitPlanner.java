import render.ContentPane;
import render.ui.SideBar;
import render.components.electrical.Switch;
import render.ui.WireTool;
import render.ui.statics.StaticSwitch;
import util.Constants;

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
        createAndShowGUI();

        Constants.contentPane.addComponent(new SideBar(), Constants.L_BACKGROUND);
        Constants.contentPane.addComponent(new StaticSwitch(8, 50), Constants.L_UI);
        Constants.contentPane.addComponent(Constants.wireTool, Constants.L_UI);
    }

}
