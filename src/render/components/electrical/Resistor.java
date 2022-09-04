package render.components.electrical;

import render.components.DragableComponent;

public class Resistor extends DragableComponent {

    public Resistor(int x1, int y1){
        x = x1;
        y = y1;
        width = 66;
        height = 40;
        setBounds(x, y, width, height);
    }

    @Override
    public void paintComponent(java.awt.Graphics g) {
        java.awt.Graphics2D g2d = (java.awt.Graphics2D) g;
        g2d.setColor(java.awt.Color.BLACK);
        g2d.setStroke(new java.awt.BasicStroke(1));

        g2d.drawLine(0, 20, 15, 20);
        g2d.drawRect(15, 15, 36, 10);
        g2d.drawLine(51, 20, 66, 20);

        wiring.WireNodeManager.drawWireNodes(g, this);
    }
}

