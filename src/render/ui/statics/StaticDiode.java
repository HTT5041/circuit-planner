package render.ui.statics;

import render.components.electrical.Diode;
import render.components.electrical.Voltmeter;
import util.Constants;

import java.awt.event.MouseEvent;

public class StaticDiode extends Diode implements StaticComponent {
    public StaticDiode(int x1, int y1){
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

            Diode newDiode = new Diode(x, y);
            Constants.contentPane.addComponent(newDiode, Constants.L_COMPONENT);

            newDiode.forceDrag(xRel, yRel);
        }
    }

}
