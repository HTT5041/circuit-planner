import render.RenderFrame;
import render.components.SideBar;
import render.components.electrical.Switch;
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
        RenderFrame contentPane = new RenderFrame();
        contentPane.setOpaque(true);
        frame.setContentPane(contentPane);

        //Display the window.
        frame.setVisible(true);

        Constants.contentPane = contentPane;
    }

    public static void main(String[] args) throws InterruptedException {
        createAndShowGUI();

        Constants.contentPane.addComponent(new SideBar(), Constants.L_BACKGROUND);
        Constants.contentPane.addComponent(new Switch(8, 50), Constants.L_COMPONENT);
    }

}
