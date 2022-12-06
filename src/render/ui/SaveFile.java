package render.ui;

import saveload.Base64Util;
import saveload.SaveSerializer;
import util.AlertBox;
import util.Constants;
import util.Scheduler;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;

public class SaveFile {

    public static void saveFile(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save to");
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String absolutePath = fileChooser.getSelectedFile().getAbsolutePath();
            if (!absolutePath.endsWith(".circuit")) {
                absolutePath += ".circuit";
            }
            File f = new File(absolutePath);
            String encodedSaveState = Base64Util.encode(SaveSerializer.serialize());

            try {
                FileWriter fw = new FileWriter(f);
                fw.write(encodedSaveState);
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(-1);
            }

            Constants.settingsMenu.closeSettings();
            new AlertBox("Save Success!", "Your save file has been saved to " + absolutePath + "!", 2);
        }
    }

}
