package render.components.electrical;

import render.components.DragableComponent;
import wiring.WireNodeManager;

import java.awt.*;

public class Cell extends DragableComponent {

    public Cell (int x1, int y1) {
        x = x1;
        y = y1;
        width = 35;
        height = 40;
        setBounds(x, y, width, height);
    }

    @Override
    public void paintComponent(java.awt.Graphics g) {
        BasicStroke thinStroke = new BasicStroke(1);
        BasicStroke thickStroke = new BasicStroke(2);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);

        g2d.setStroke(thinStroke);
        g2d.drawLine(0, 20, 15, 20);

        g2d.setStroke(thickStroke);
        g2d.drawLine(15, 10, 15, 30);
        g2d.drawLine(20, 15, 20, 25);

        g2d.setStroke(thinStroke);
        g2d.drawLine(20, 20, 35, 20);

        WireNodeManager.drawWireNodes(g, this);
    }

}
