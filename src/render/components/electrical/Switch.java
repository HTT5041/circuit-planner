package render.components.electrical;

import render.components.DragableComponent;

import java.awt.*;

public class Switch extends DragableComponent {

    public Switch(){
        x = 10;
        y = 50;
        width = 66;
        height = 40;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(1));
        g2d.drawLine(x, y + 20, x + 20, y + 20);
        g2d.drawRoundRect(x + 20, y + 16, 8, 8, 8, 8);
        g2d.drawLine(x + 28, y + 16, x + 28 + 15, y + 6);
        g2d.drawRoundRect(x + 28 + 15, y + 16, 8, 8, 8, 8);
        g2d.drawLine(x + 28 + 15 + 8, y + 20, x + 28 + 15 + 8 + 20, y + 20);
    }
}
