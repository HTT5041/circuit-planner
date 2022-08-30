package util;

import render.ContentPane;
import wiring.WireNodeManager;
import render.ui.WireTool;

import javax.swing.*;
import java.awt.*;

public class Constants {
    public static ContentPane contentPane;
    public static JFrame frame;
    public static int displayWidth = 800;
    public static int displayHeight = 600;

    public static WireTool wireTool = new WireTool();
    public static WireNodeManager wnm = new WireNodeManager();

    public static Color lightGrey = new Color(170, 170, 170);

    public static int L_BACKGROUND = 1;
    public static int L_UI = 2;
    public static int L_COMPONENT = 3;
    public static int L_POPUP = 4;

}
