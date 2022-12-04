package render.ui.menu;

import events.EventManager;
import events.impl.MousePressedListener;
import render.ui.LoadFile;
import util.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Button extends JPanel implements MousePressedListener {
    private String text;

    public Button(int x, int y, String text) {
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
            //If the button is the new circuit button
            if (text.equals("New Circuit")) {
                //Deregister the button listeners for the main menu
                Constants.contentPane.gotoEditor();
            }
            //If the button is the load circuit button
            else if (text.equals("Load Circuit")) {
                LoadFile.loadFile();
            }
            //If the button is the exit button
            else if (text.equals("Exit")) {
                System.exit(1);
            }
        }
    }
}
