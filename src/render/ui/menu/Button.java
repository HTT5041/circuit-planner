package render.ui.menu;

import events.impl.MousePressedListener;
import util.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Button extends JPanel implements MousePressedListener {
    private String text;
    private ButtonAction action;

    public Button(int x, int y, String text, ButtonAction action) {
        this.action = action;
        this.text = text;
        setBounds(x, y, 228, 71);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Constants.buttonColour);
        g2d.fillRoundRect(0, 0, 228, 71, 15, 15);

        g2d.setColor(Constants.textColour);
        Font f = new Font("Arial", Font.PLAIN, 38);
        drawCenteredString(g2d, text, new Rectangle(0, 0, 228, 71), f);
    }

    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        FontMetrics metrics = g.getFontMetrics(font);
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        g.setFont(font);
        g.drawString(text, x, y);
    }

    @Override
    public void onMousePressed(MouseEvent e) {
        //If mouse press in on this button
        if (e.getX() > getX() && e.getX() < getX() + getWidth() && e.getY() > getY() && e.getY() < getY() + getHeight()) {
            action.onPress(); //Call anonymous function which was passed in the constructor
        }
    }
}
