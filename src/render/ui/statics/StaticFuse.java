package render.ui.statics;

import render.components.electrical.Ammeter;
import render.components.electrical.Fuse;
import util.Constants;

import java.awt.event.MouseEvent;

public class StaticFuse extends Fuse implements StaticComponent {
    public StaticFuse(int x1, int y1) {
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

            Fuse newFuse = new Fuse(x, y);
            Constants.contentPane.addComponent(newFuse, Constants.L_COMPONENT);

            newFuse.forceDrag(xRel, yRel);
        }
    }
}
