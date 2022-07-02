package events;

import events.impl.EventListener;
import events.impl.MouseDraggedListener;
import events.impl.MousePressedListener;
import events.impl.MouseReleasedListener;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class EventManager {

    private static ArrayList<EventListener> listeners = new ArrayList<>();

    public static void postMousePressedEvent(MouseEvent e){
        for(EventListener listener : listeners){
            if(listener instanceof MousePressedListener){
                ((MousePressedListener) listener).onMousePressed(e);
            }
        }
    }
    public static void postMouseReleasedEvent(MouseEvent e){
        for(EventListener listener : listeners){
            if(listener instanceof MouseReleasedListener){
                ((MouseReleasedListener) listener).onMouseReleased(e);
            }
        }
    }
    public static void postMouseDraggedEvent(MouseEvent e){
        for(EventListener listener : listeners){
            if(listener instanceof MouseDraggedListener){
                ((MouseDraggedListener) listener).onMouseDragged(e);
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
