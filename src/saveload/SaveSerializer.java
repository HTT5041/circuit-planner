package saveload;

import render.ContentPane;
import render.components.DragableComponent;
import render.ui.statics.StaticComponent;
import util.Constants;
import wiring.Wire;
import wiring.WireCanvas;
import wiring.WireNode;
import wiring.WireNodeManager;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
            sb.append(c.getClass().getSimpleName() + ","); //Add class name
            sb.append(c.getX() + ","); //Add x
            sb.append(c.getY() + ","); //Add y
            sb.append(c.compUUID + "}"); //Add UUID (for linking wires)
        }

        //Serialize wire nodes
        sb.append("[Wires]");
        ArrayList<Wire> wires = WireCanvas.getWires();


        System.out.println(sb.toString());
        return sb.toString();
    }

}
