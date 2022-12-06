package saveload;

import render.components.DragableComponent;
import render.ui.statics.StaticComponent;
import util.Constants;
import wiring.Wire;
import wiring.WireCanvas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SaveSerializer {

    public static String serialize() {
        StringBuilder sb = new StringBuilder();

        //Add file header
        sb.append("[CircuitPlannerSaveFile]");

        //Serialize components
        sb.append("[Components]");
        //Filter then collect comps
        List<DragableComponent> comps = Arrays.stream(Constants.contentPane.layeredPane.getComponents())
                .filter(c -> c instanceof DragableComponent && !(c instanceof StaticComponent))
                .map(c -> (DragableComponent) c)
                .collect(Collectors.toList());

        for(DragableComponent c : comps){
            sb.append("{");//Start component
            sb.append(c.getClass().getSimpleName()).append(","); //Add class name
            sb.append(c.getX()).append(","); //Add x
            sb.append(c.getY()).append(","); //Add y
            sb.append(c.compUUID); //Add UUID (for linking wires)
        }
        sb.append("[EndComponents]");

        //Serialize wire nodes
        sb.append("[Wires]");
        ArrayList<Wire> wires = WireCanvas.getWires();
        for(Wire w : wires){
            sb.append("{");//Start wire
            sb.append(w.node1.parent.compUUID).append(","); //Add node 1 parent UUID
            sb.append(w.node1.side).append(","); //Add node 1 side
            sb.append(w.node2.parent.compUUID).append(","); //Add node 2 parent UUID
            sb.append(w.node2.side); //Add node 2 side
        }
        sb.append("[EndWires]");
        return sb.toString();
    }

}
