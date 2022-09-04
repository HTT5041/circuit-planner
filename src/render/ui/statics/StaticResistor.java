package render.ui.statics;

import render.components.electrical.Resistor;

public class StaticResistor extends Resistor implements StaticComponent {
    public StaticResistor(int x1, int y1) {
        super(x1, y1);
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

            Resistor newResistor = new Resistor(x, y);
            util.Constants.contentPane.addComponent(newResistor, util.Constants.L_COMPONENT);

            newResistor.forceDrag(xRel, yRel);
        }
    }
}

