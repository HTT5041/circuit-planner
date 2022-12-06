package render.ui.statics;

import render.components.electrical.Diode;
import render.components.electrical.LED;
import util.Constants;

import java.awt.event.MouseEvent;

public class StaticLED extends LED implements StaticComponent{
    public StaticLED(int x1, int y1) {
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

            LED newLED = new LED(x, y);
            Constants.contentPane.addComponent(newLED, Constants.L_COMPONENT);

            newLED.forceDrag(xRel, yRel);
        }
    }

}
