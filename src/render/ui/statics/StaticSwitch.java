package render.ui.statics;

import render.components.electrical.Switch;
import util.Constants;

import java.awt.event.MouseEvent;

public class StaticSwitch extends Switch {
    public StaticSwitch(int x1, int y1) {
        super(x1, y1);
    }

    @Override
    public void onMouseReleased(MouseEvent e) {

    }

    @Override
    public void onMouseDragged(MouseEvent e) {

    }

    @Override
    public void onMousePressed(MouseEvent e) {
        if(Constants.wireTool.enabled){
            return;
        }

        if(e.getX() > x && e.getX() < x + width && e.getY() > y && e.getY() < y + height){

            int xRel = e.getX() - x;
            int yRel = e.getY() - y;

            Switch newSwitch = new Switch(x, y);
            Constants.contentPane.addComponent(newSwitch, Constants.L_COMPONENT);

            newSwitch.forceDrag(xRel, yRel);
        }
    }
}
