package render.ui.statics;

import render.components.electrical.Lamp;
import render.components.electrical.Switch;
import util.Constants;

import java.awt.event.MouseEvent;

public class StaticLamp extends Lamp implements StaticComponent {
    public StaticLamp(int x1, int y1) {
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

            Lamp newLamp = new Lamp(x, y);
            Constants.contentPane.addComponent(newLamp, Constants.L_COMPONENT);

            newLamp.forceDrag(xRel, yRel);
        }
    }
}
