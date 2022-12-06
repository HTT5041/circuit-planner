package util;

import java.awt.*;
import java.util.ArrayList;
import java.util.UUID;

public class Utils {

    public static void showAlert(String title, String text){
        new AlertBox(title, text, 3);
    }

    public static ArrayList<String> splitString(String str, int len){
        ArrayList<String> lines = new ArrayList<String>();
        String[] words = str.split(" ");
        String line = "";
        for(String word : words){
            if(line.length() + word.length() < len){
                line += word + " ";
            } else {
                lines.add(line);
                line = word + " ";
            }
        }
        lines.add(line);
        return lines;
    }

    public static String generateUUID(){
        return UUID.randomUUID().toString();
    }

    public static void drawArrow(Graphics2D g2d, int x1, int y1, int x2, int y2, int arrowSize){
        g2d.drawLine(x1, y1, x2, y2);
        double angle = Math.atan2(y2 - y1, x2 - x1);
        int x3 = (int) (x2 - arrowSize * Math.cos(angle - Math.PI / 6));
        int y3 = (int) (y2 - arrowSize * Math.sin(angle - Math.PI / 6));
        int x4 = (int) (x2 - arrowSize * Math.cos(angle + Math.PI / 6));
        int y4 = (int) (y2 - arrowSize * Math.sin(angle + Math.PI / 6));
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(x2, y2, x3, y3);
        g2d.drawLine(x2, y2, x4, y4);
    }
}
