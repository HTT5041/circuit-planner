package render.ui.menu;

import events.EventManager;
import events.impl.EventListener;
import render.ui.LoadFile;
import util.Constants;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JLayeredPane {
    private static final Button newCircuitBtn = new Button(280, 120, "New Circuit",
            () -> Constants.contentPane.gotoEditor());
    private static final Button loadCircuitBtn = new Button(280, 200, "Load Circuit",
            LoadFile::loadFile);
    private static final Button exitBtn = new Button(280, 280, "Exit",
            () -> System.exit(1));

    public MainMenu() {
        setBounds(0, 0, Constants.displayWidth, Constants.displayHeight);
        add(newCircuitBtn, Constants.L_UI);
        add(loadCircuitBtn, Constants.L_UI);
        add(exitBtn, Constants.L_UI);
        registerListeners();
    }

    public void registerListeners(){
        for (Component c : getComponents()) {
            if (c instanceof Button) {
                EventManager.registerListener((EventListener) c);
            }
        }
    }

    public void deRegisterListeners(){
        for (Component c : getComponents()) {
            if (c instanceof Button) {
                EventManager.deRegisterListener((EventListener) c);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Constants.menuBackground);
        g2d.fillRect(0, 0, Constants.displayWidth, Constants.displayHeight);
        g2d.setColor(Constants.textColour);
        drawCenteredString(g2d, "Circuit  Planner", new Rectangle(0, 0, Constants.displayWidth, 100), new Font("Arial", Font.PLAIN, 72));
    }

    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        FontMetrics metrics = g.getFontMetrics(font);
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        g.setFont(font);
        g.drawString(text, x, y);
    }
}
