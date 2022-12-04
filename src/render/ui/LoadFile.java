package render.ui;

import javax.swing.*;

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
        if(userSelection == 0) {
            System.out.println("Load file: " + fileChooser.getSelectedFile().getAbsolutePath());
        }
    }

}
