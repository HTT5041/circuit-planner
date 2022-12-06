package render.ui.statics;

import render.ui.menu.Thermistor;
import util.Constants;

import java.awt.event.MouseEvent;

public class StaticThermistor extends Thermistor implements StaticComponent {

    public StaticThermistor(int x, int y) {
        super(x, y);
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

            Thermistor newVR = new Thermistor(x, y);
            Constants.contentPane.addComponent(newVR, Constants.L_COMPONENT);

            newVR.forceDrag(xRel, yRel);
        }
    }
}
