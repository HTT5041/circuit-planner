package util;

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
}
