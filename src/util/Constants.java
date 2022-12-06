package util;

import render.ContentPane;
import render.ui.ClearCircuit;
import render.ui.menu.SettingsMenu;
import wiring.WireNodeManager;
import render.ui.WireTool;

import javax.swing.*;
import java.awt.*;

public class Constants {
    public static Scheduler scheduler;

    public static ContentPane contentPane;
    public static JFrame frame;
    public static int displayWidth = 800;
    public static int displayHeight = 600;

    public static WireTool wireTool = new WireTool();
    public static WireNodeManager wnm = new WireNodeManager();
    public static SettingsMenu settingsMenu = new SettingsMenu();
    public static ClearCircuit clearCircuit = new ClearCircuit();

    public static Color lightGrey = new Color(170, 170, 170);
    public static Color menuBackground = new Color(234,235,233);
    public static Color buttonColour = new Color(207,216,220);
    public static Color textColour = new Color(123,141,147);


    public static int L_BACKGROUND = 1;
    public static int L_UI = 2;
    public static int L_COMPONENT = 3;
    public static int L_POPUP = 4;

}
