package render.components;

import util.Constants;

import javax.swing.*;
import java.awt.*;

public class SideBar extends JPanel {

    public SideBar(){
        setBounds(0, 0, 75, 600);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Constants.lightGrey);
        g.fillRect(0, 0, 75, 600);
    }
}
