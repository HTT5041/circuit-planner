package render.ui;

import events.EventManager;
import events.impl.MousePressedListener;
import util.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class WireTool extends JPanel implements MousePressedListener {

    public boolean enabled = false;

    public WireTool() {
        setBounds(21, 40, 36, 36);

        try {
            JLabel imgLabel = new JLabel(new ImageIcon(ImageIO.read(new File("assets/power-cable.png"))));
            imgLabel.setBounds(0, 0, 16, 16);
            add(imgLabel);
        } catch(IOException e){
            System.out.println("Error loading resource: assets/power-cable.png");
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if(enabled){
            g2d.setColor(Color.green);
        } else {
            g2d.setColor(Color.red);
        }
        g2d.fillRoundRect(0, 0, 35, 30, 20, 20);

        g2d.setColor(Color.black);
        g2d.drawRoundRect(0, 0, 35, 30, 20,20);
    }

    @Override
    public void onMousePressed(MouseEvent e) {
        if(e.getX() > 21 && e.getX() < 57 && e.getY() > 45 && e.getY() < 70) {
            enabled = !enabled;
            Constants.contentPane.repaintScreen();
        }
    }
}
