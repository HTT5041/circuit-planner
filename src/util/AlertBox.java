package util;

import javax.swing.*;
import java.awt.*;

public class AlertBox extends JPanel {

    private String title;
    private String[] text = new String[]{"", ""};
    private int timeout;

    public AlertBox(String _title, String _text, int timeout_s){
        setBounds(250, 160, 300, 240);
        title = _title;

        if(_text.length() <= 40){
            text[0] = _text;
        } else {
            text[0] = _text.substring(0, 39);
            text[1] = _text.substring(39, _text.length()-1);
        }

        timeout = timeout_s;
        Constants.contentPane.addComponent(this, Constants.L_POPUP);
        Constants.contentPane.repaintScreen();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(0, 0, 300, 240);
        g.setColor(new Color(0xf6, 0xe8, 0xb1));
        g.fillRect(1, 1, 298, 238);

        g.setColor(Color.BLACK);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font("Monospaced", Font.PLAIN, 22));
        g2d.drawString(title, 5, 20);
        g2d.setFont(new Font("Monospaced", Font.PLAIN, 12));
        int lineNo = 0;
        for(String line : text) {
            g2d.drawString(line, 5, 50 + (15*lineNo));
            lineNo++;
        }

    }
}
