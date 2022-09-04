package render.components.electrical;

import render.components.DragableComponent;
import wiring.WireNodeManager;

import java.awt.*;

public class Switch extends DragableComponent {

    public Switch(int x1, int y1){
        x = x1;
        y = y1;
        width = 66;
        height = 40;
        setBounds(x, y, width, height);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(1));

        if(rotated){
            // Swap x's and y's
            g2d.drawLine(20, 0, 20, 20);
            g2d.drawRoundRect(16, 20, 8, 8, 8, 8);
            g2d.drawLine(16, 28, 6, 28 + 15);
            g2d.drawRoundRect(16, 28 + 15, 8, 8, 8, 8);
            g2d.drawLine(20, 28 + 15 + 8, 20, 28 + 15 + 8 + 16);
        } else {
            g2d.drawLine(0, 20, 20, 20);
            g2d.drawRoundRect(20, 16, 8, 8, 8, 8);
            g2d.drawLine(28, 16, 28 + 15, 6);
            g2d.drawRoundRect(28 + 15, 16, 8, 8, 8, 8);
            g2d.drawLine(28 + 15 + 8, 20, 28 + 15 + 8 + 16, +20);
        }

        WireNodeManager.drawWireNodes(g, this);
    }
}
