package render.components.electrical;

import render.components.DragableComponent;
import wiring.WireNodeManager;

import java.awt.*;

public class Voltmeter extends DragableComponent {

    public Voltmeter (int x1, int y1) {
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

        g2d.drawLine(0, 20, 20, 20);
        g2d.drawOval(20, 10, 20, 20);
        g2d.drawLine(40, 20, 60, 20);

        //draw the v
        g2d.drawString("V", 27, 25);

        WireNodeManager.drawWireNodes(g, this);
    }
}
