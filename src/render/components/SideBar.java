package render.components;

import render.RenderEngine;
import util.Constants;

import javax.swing.*;
import java.awt.*;

public class SideBar extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Constants.lightGrey);
        g.fillRect(0, 0, 75, RenderEngine.frameHeight);
    }
}
