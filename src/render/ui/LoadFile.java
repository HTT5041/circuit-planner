package render.ui;

import render.ContentPane;
import saveload.LoadDeserializer;
import util.Constants;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;

public class LoadFile {

    public static void loadFile() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a file to open");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            public boolean accept(java.io.File file) {
                return file.getName().toLowerCase().endsWith(".circuit") || file.isDirectory();
            }

            public String getDescription() {
                return "Circuit Planner Files (*.circuit)";
            }
        });
        int userSelection = fileChooser.showOpenDialog(null);
        if(userSelection == JFileChooser.APPROVE_OPTION) {
            File f = fileChooser.getSelectedFile();
            try{
                FileReader fr = new FileReader(f);
                char[] data = new char[(int) f.length()];
                fr.read(data);
                fr.close();
                String encodedSaveState = new String(data);

                Constants.contentPane.gotoEditor();

                LoadDeserializer.deSerialiseAndLoad(encodedSaveState);
            } catch(Exception e){
                e.printStackTrace();
                System.exit(-1);
            }

        }
    }

}
