package render.components.electrical;

import render.components.DragableComponent;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Lamp extends DragableComponent {
    public Lamp(int x1, int y1){
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

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(1));

        g2d.drawLine(0, 20, 20, 20);
        g2d.drawOval(20, 10, 20, 20);
        g2d.drawLine(23, 13, 37, 27);
        g2d.drawLine(23, 27, 37, 13);
        g2d.drawLine(40, 20, 60, 20);

        wiring.WireNodeManager.drawWireNodes(g, this);
    }
}
