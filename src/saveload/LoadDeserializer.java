package saveload;

import render.ContentPane;
import render.components.DragableComponent;
import util.AlertBox;
import util.Constants;
import wiring.Wire;
import wiring.WireCanvas;
import wiring.WireNode;
import wiring.WireNodeManager;

import javax.swing.text.html.parser.Entity;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LoadDeserializer {

    public static void deSerialiseAndLoad(String encodedSave){
        String decoded = Base64Util.decode(encodedSave);
        if(!decoded.startsWith("[CircuitPlannerSaveFile]")){
            new AlertBox("Invalid Save File", "The file you have selected is not a valid CircuitPlanner save file!", 2);
            return;
        }

        String[] components = decoded.substring(decoded.indexOf("[Components]") + 12, decoded.indexOf("[EndComponents]")).split("\\{");
        for(String s : components) {
            if (s.equals("")) continue;
            String[] data = s.split(",");
            String className = data[0];
            int x = Integer.parseInt(data[1]);
            int y = Integer.parseInt(data[2]);
            String uuid = data[3];

            try {
                //Get class and instantiate via reflection
                Class<?> clazz = Class.forName("render.components.electrical." + className);
                Constructor<?> constructor = clazz.getConstructor(int.class, int.class);
                DragableComponent comp = (DragableComponent) constructor.newInstance(x, y);
                comp.compUUID = uuid;

                Constants.contentPane.addComponent(comp, Constants.L_COMPONENT);
            } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                System.exit(-1);
            }

            //Add wires

            String[] wires = decoded.substring(decoded.indexOf("[Wires]") + 7, decoded.indexOf("[EndWires]")).split("\\{");
            for(String w : wires) {
                if (w.equals("")) continue;
                String[] wireData = w.split(",");
                String uuid1 = wireData[0];
                int side1 = Integer.parseInt(wireData[1]);
                String uuid2 = wireData[2];
                int side2 = Integer.parseInt(wireData[3]);

                WireNode[] nodes1 = WireNodeManager.getNodeByUUID(uuid1);
                WireNode[] nodes2 = WireNodeManager.getNodeByUUID(uuid2);

                if(nodes1 == null || nodes2 == null) continue;

                WireNode node1 = nodes1[side1];
                WireNode node2 = nodes2[side2];

                WireCanvas.addWire(new Wire(node1, node2));
            }
        }
    }

}
