package render.ui.statics;

import render.components.electrical.Cell;
import render.components.electrical.Voltmeter;
import util.Constants;

import java.awt.event.MouseEvent;

public class StaticVoltmeter extends Voltmeter implements StaticComponent {
    public StaticVoltmeter(int x1, int y1) {
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

            Voltmeter newVM = new Voltmeter(x, y);
            Constants.contentPane.addComponent(newVM, Constants.L_COMPONENT);

            newVM.forceDrag(xRel, yRel);
        }
    }
}
