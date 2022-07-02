import render.RenderEngine;
import render.components.SideBar;
import render.components.electrical.Switch;
import util.Constants;

//Todo
// Figure out a way to handle how to draw the sidebar and other stuff below comps

public class CircuitPlanner {

    public static void main(String[] args) {
        Constants.renderEngine = new RenderEngine();
        Constants.renderEngine.addComponent(new Switch(8, 50));
        Constants.renderEngine.addComponent(new Switch(8, 100));
        Constants.renderEngine.addComponent(new SideBar());
    }

}
