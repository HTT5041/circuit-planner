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
        setBounds(35, 10, 36, 36);

        try {
            JLabel imgLabel = new JLabel(new ImageIcon(ImageIO.read(new File("assets/power-cable.png"))));
            imgLabel.setBounds(0, 0, 16, 16);
            add(imgLabel);
        } catch(IOException e){
            System.out.println("Error loading resource: assets/power-cable.png");
        }

        EventManager.registerListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        if(enabled){
            g.setColor(Color.green);
        } else {
            g.setColor(Color.red);
        }
        g.fillRoundRect(0, 0, 35, 35, 20, 20);

        g.setColor(Color.black);
        g.drawRoundRect(0, 0, 35, 35, 20,20);
    }

    @Override
    public void onMousePressed(MouseEvent e) {
        if(e.getX() > 35 && e.getX() < 70 && e.getY() > 10 && e.getY() < 45){
            //was clicked
            enabled = !enabled;
            Constants.contentPane.repaintScreen();
        }
    }
}
