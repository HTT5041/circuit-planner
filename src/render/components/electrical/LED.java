package render.components.electrical;

import render.components.DragableComponent;
import util.Utils;

import java.awt.*;

public class LED extends DragableComponent {
    public LED(int x1, int y1){
        x = x1;
        y = y1;
        width = 60;
        height = 40;
        setBounds(x, y, width, height);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawLine(0, 20, 60, 20);
        g2d.drawOval(17, 7, 26, 26);
        g2d.drawLine(35, 13, 35, 27);
        //triangle
        g2d.drawLine(25, 12, 25, 28);
        g2d.drawLine(25, 12, 35, 20);
        g2d.drawLine(25, 28, 35, 20);

        // draw the mini arrows
        Utils.drawArrow(g2d, 41, 10, 44, 7, 3);
        Utils.drawArrow(g2d, 45, 14, 47, 11, 3);

        wiring.WireNodeManager.drawWireNodes(g, this);
    }
}
