package render.components.electrical;

import render.components.DragableComponent;
import wiring.WireNodeManager;

import java.awt.*;

public class Fuse extends DragableComponent {
    public Fuse (int x1, int y1) {
        x = x1;
        y = y1;
        width = 60;
        height = 40;
        setBounds(x, y, width, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);

        g2d.drawLine(0, 20, 60, 20);
        g2d.drawRect(15, 15, 30, 10);

        WireNodeManager.drawWireNodes(g, this);
    }
}
