package render.ui;

import events.EventManager;
import events.impl.MousePressedListener;
import render.ui.menu.SettingsMenu;
import util.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class SettingsButton extends JPanel implements MousePressedListener {

    public SettingsButton(){
        setBounds(21, 5, 36, 36);

        try {
            JLabel imgLabel = new JLabel(new ImageIcon(ImageIO.read(new File("assets/setting.png"))));
            imgLabel.setBounds(0, 0, 16, 16);
            add(imgLabel);
        } catch(IOException e){
            System.out.println("Error loading resource: assets/setting.png");
        }

        EventManager.registerListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Constants.buttonColour);
        g2d.fillRoundRect(0, 0, 35, 30, 20, 20);

        g2d.setColor(Color.black);
        g2d.drawRoundRect(0, 0, 35, 30, 20,20);
    }

    @Override
    public void onMousePressed(MouseEvent e) {
        if(e.getX() > 21 && e.getX() < 57 && e.getY() > 5 && e.getY() < 41){
            Constants.contentPane.addComponent(Constants.settingsMenu, Constants.L_POPUP);
            Constants.settingsMenu.allowSettingsInput();
        }
    }
}
