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
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(1));

        g2d.drawLine(0, 20, 20, 20);
        g2d.drawRoundRect(20, 16, 8, 8, 8, 8);
        g2d.drawLine(28, 16, 28 + 15, 6);
        g2d.drawRoundRect(28 + 15, 16, 8, 8, 8, 8);
        g2d.drawLine(28 + 15 + 8, 20, 28 + 15 + 8 + 16, +20);

        WireNodeManager.drawWireNodes(g, this);
    }
}
