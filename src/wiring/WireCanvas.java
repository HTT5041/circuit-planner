package wiring;

import util.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WireCanvas extends JPanel {

    private static ArrayList<Wire> wires = new ArrayList<Wire>();

    public WireCanvas(){
        setBounds(0, 0, Constants.displayWidth, Constants.displayHeight);
    }

    public static ArrayList<Wire> getWires(){
        return wires;
    }

    public static void addWire(Wire wire){
        wires.add(wire);
    }

    public static void clearWires(){
        wires.clear();
    }

    @Override
    protected void paintComponent(Graphics g) {
        for(Wire wire : wires){
            wire.paint(g);
        }
    }
}
