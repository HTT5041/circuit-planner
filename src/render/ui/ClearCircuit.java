package render.ui;

import events.EventManager;
import events.impl.EventListener;
import events.impl.MousePressedListener;
import render.components.DragableComponent;
import render.ui.statics.StaticComponent;
import saveload.SaveSerializer;
import util.Constants;
import wiring.WireCanvas;
import wiring.WireNodeManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ClearCircuit extends JPanel implements MousePressedListener {

    public ClearCircuit(){
        setBounds(18, 500, 40, 45);

        try {
            JLabel imgLabel = new JLabel(new ImageIcon(ImageIO.read(new File("assets/bin.png"))));
            imgLabel.setBounds(0, 0, 40, 45);
            add(imgLabel);
        } catch(IOException e){
            System.out.println("Error loading resource: assets/bin.png");
        }
        EventManager.registerListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Constants.lightGrey);
        g.fillRect(0, 0, 75, 600);
    }

    @Override
    public void onMousePressed(MouseEvent e) {
        if(e.getX() > 18 && e.getX() < 58 && e.getY() > 500 && e.getY() < 545) {
            SaveSerializer.serialize();
            //WireCanvas.clearWires();
            //WireNodeManager.clearManagedComponents();
            //for(Component c : Constants.contentPane.layeredPane.getComponents()){
            //    if(c instanceof DragableComponent && !(c instanceof StaticComponent)){
            //        EventManager.deRegisterListener((EventListener) c);
            //        Constants.contentPane.layeredPane.remove(c);
            //    }
            //}
            //Constants.contentPane.repaintScreen();
        }
    }
}
