package util;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AlertBox extends JPanel implements SchedulerCallback {

    private String title;
    private ArrayList<String> lines;
    private int timeout;

    public AlertBox(String _title, String _text, int timeout_s){
        setBounds(250, 160, 300, 240);
        title = _title;
        lines = Utils.splitString(_text, 40);
        timeout = timeout_s;

        Constants.contentPane.addComponent(this, Constants.L_POPUP);
        Constants.contentPane.repaintScreen();

        Constants.scheduler.scheduleEvent(this, timeout);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.gray);
        g2d.fillRect(0, 0, 300, 240);
        g2d.setColor(new Color(0xf6, 0xe8, 0xb1));
        g2d.fillRect(1, 1, 298, 238);

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Ariel", Font.PLAIN, 22));
        g2d.drawString(title, 5, 20);
        g2d.setFont(new Font("Ariel", Font.PLAIN, 12));
        int lineNo = 0;
        for(String line : lines) {
            g2d.drawString(line, 5, 50 + (15*lineNo));
            lineNo++;
        }

    }

    @Override
    public void callback() {
        Constants.contentPane.removeComponent(this);
    }
}
