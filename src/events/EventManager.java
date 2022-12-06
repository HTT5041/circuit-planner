package events;

import events.impl.*;
import render.ui.menu.SettingsMenu;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class EventManager {

    private static ArrayList<EventListener> listeners = new ArrayList<>();
    private static boolean settingsActive = false;

    public static void onSettingsToggle(){
        settingsActive = !settingsActive;
    }

    public static void deRegisterAllListeners(){
        listeners.clear();
    }

    public static void postMousePressedEvent(MouseEvent e){
        try {
            for (EventListener listener : listeners) {

                if(!(listener instanceof SettingsMenu) && settingsActive) continue; //Pause input for all other listeners if settings is active

                if (listener instanceof MousePressedListener) {
                    ((MousePressedListener) listener).onMousePressed(e);
                }
            }
        } catch(ConcurrentModificationException ignored){
            //Ignore the exception as this will occur when the event is posted as an object is created
            //I manually trigger any required actions that are skipped due to the exception (see DragableComponent.java, forceDrag(II)V )
        }
    }
    public static void postMouseReleasedEvent(MouseEvent e){
        for(EventListener listener : listeners){

            if(!(listener instanceof SettingsMenu) && settingsActive) continue; //Pause input for all other listeners if settings is active

            if(listener instanceof MouseReleasedListener){
                ((MouseReleasedListener) listener).onMouseReleased(e);
            }
        }
    }
    public static void postMouseDraggedEvent(MouseEvent e){
        for(EventListener listener : listeners){

            if(!(listener instanceof SettingsMenu) && settingsActive) continue; //Pause input for all other listeners if settings is active

            if(listener instanceof MouseDraggedListener){
                ((MouseDraggedListener) listener).onMouseDragged(e);
            }
        }
    }
    public static void postMouseMovedEvent(MouseEvent e){
        for(EventListener listener : listeners){

            if(!(listener instanceof SettingsMenu) && settingsActive) continue; //Pause input for all other listeners if settings is active

            if(listener instanceof MouseMovedListener){
                ((MouseMovedListener) listener).onMouseMoved(e);
            }
        }
    }
    public static void postKeyTypedEvent(KeyEvent e){
        for(EventListener listener : listeners){

            if(!(listener instanceof SettingsMenu) && settingsActive) continue; //Pause input for all other listeners if settings is active

            if(listener instanceof KeyTypedListener){
                ((KeyTypedListener) listener).onKeyTyped(e);
            }
        }
    }

    public static void registerListener(EventListener listener){
        listeners.add(listener);
    }

    public static void deRegisterListener(EventListener listener){
        listeners.remove(listener);
    }

}
