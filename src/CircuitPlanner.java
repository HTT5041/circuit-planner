import render.RenderEngine;
import render.components.SideBar;
import render.components.electrical.Switch;
import util.Constants;

//Todo
// As multiple action listeners don't seem to work, have 1 class which can access the locations of all comps
// and handle all of their inputs, not ideal :/
// Figure out a way to handle how to draw the sidebar and other stuff below comps

public class CircuitPlanner {

    public static void main(String[] args) {
        Constants.renderEngine = new RenderEngine();
        Constants.renderEngine.addComponent(new Switch());
        Constants.renderEngine.addComponent(new SideBar());
    }

}
