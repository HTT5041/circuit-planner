package render.ui.statics;

import render.components.electrical.VariableResistor;

public class StaticVariableResistor extends VariableResistor implements StaticComponent {

    public StaticVariableResistor(int x, int y) {
        super(x, y);
    }

    @Override
    public void onMouseReleased(java.awt.event.MouseEvent e) {

    }

    @Override
    public void onMouseDragged(java.awt.event.MouseEvent e) {

    }

    @Override
    public void onMousePressed(java.awt.event.MouseEvent e) {
        if(util.Constants.wireTool.enabled){
            return;
        }

        if(e.getX() > x && e.getX() < x + width && e.getY() > y && e.getY() < y + height){

            int xRel = e.getX() - x;
            int yRel = e.getY() - y;

            VariableResistor newVR = new VariableResistor(x, y);
            util.Constants.contentPane.addComponent(newVR, util.Constants.L_COMPONENT);

            newVR.forceDrag(xRel, yRel);
        }
    }
}
