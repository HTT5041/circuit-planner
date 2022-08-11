package util;

import render.ContentPane;
import render.ui.WireTool;

import java.awt.*;

public class Constants {
    public static ContentPane contentPane;
    public static int displayWidth = 800;
    public static int displayHeight = 600;

    public static WireTool wireTool = new WireTool();

    public static Color lightGrey = new Color(170, 170, 170);

    public static int L_BACKGROUND = 0;
    public static int L_UI = 1;
    public static int L_COMPONENT = 2;
    public static int L_POPUP = 3;

}
