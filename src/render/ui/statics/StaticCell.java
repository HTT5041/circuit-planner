package render.ui.statics;

import render.components.electrical.Cell;
import util.Constants;

import java.awt.event.MouseEvent;

public class StaticCell extends Cell implements StaticComponent {
    public StaticCell(int x1, int y1) {
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

            Cell newCell = new Cell(x, y);
            Constants.contentPane.addComponent(newCell, Constants.L_COMPONENT);

            newCell.forceDrag(xRel, yRel);
        }
    }

}
