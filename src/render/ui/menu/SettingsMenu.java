package render.ui.menu;

import events.EventManager;
import events.impl.KeyTypedListener;
import events.impl.MousePressedListener;
import render.ContentPane;
import render.ui.LoadFile;
import render.ui.SaveFile;
import util.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class SettingsMenu extends JPanel implements KeyTypedListener, MousePressedListener {

    private boolean isSettingsActive = false;

    public SettingsMenu() {
        setBounds(0, 0, 800, 600);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.BLACK);
        g2d.drawRect(199, 99, 401, 301);

        g2d.setColor(Constants.menuBackground);
        g2d.fillRect(200, 100, 400, 300);

        g2d.setColor(Constants.textColour);
        drawCenteredString(g2d, "Options", new Rectangle(200, 100, 400, 50), new Font("Arial", Font.BOLD, 30));

        g2d.setColor(Constants.buttonColour);
        g2d.fillRoundRect(280, 160, 228, 71, 15, 15);
        g2d.fillRoundRect(280, 240, 228, 71, 15, 15);

        g2d.setColor(Constants.textColour);
        Font f = new Font("Arial", Font.PLAIN, 38);
        drawCenteredString(g2d, "Save Circuit", new Rectangle(280, 160, 228, 71), f);
        drawCenteredString(g2d, "Main Menu", new Rectangle(280, 240, 228, 71), f);

    }

    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        FontMetrics metrics = g.getFontMetrics(font);
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        g.setFont(font);
        g.drawString(text, x, y);
    }

    public void allowSettingsInput() {
        isSettingsActive = true;
        EventManager.onSettingsToggle();
    }

    public void disallowSettingsInput() {
        isSettingsActive = false;
        EventManager.onSettingsToggle();
    }

    public void closeSettings(){
        disallowSettingsInput();
        Constants.contentPane.removeComponent(this);
    }

    //Remember to restore other listeners when returning to main menu too

    @Override
    public void onKeyTyped(KeyEvent e) {
        if(!isSettingsActive) return;

        if(e.getKeyChar() == 0x1B) { //1B (hex) is ASCII for escape
            closeSettings();
        }
    }

    @Override
    public void onMousePressed(MouseEvent e) {
        if(!isSettingsActive) return;

        //Save Circuit button pressed
        if(e.getX() > 280 && e.getX() < 508 && e.getY() > 160 && e.getY() < 231) {
            SaveFile.saveFile();
        }

        //Main Menu button pressed
        if(e.getX() > 280 && e.getX() < 508 && e.getY() > 240 && e.getY() < 311) {
            closeSettings();
            Constants.contentPane.gotoMainMenu();
        }
    }
}

