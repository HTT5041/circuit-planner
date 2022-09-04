package events.impl;

import java.awt.event.KeyEvent;

public interface KeyTypedListener extends EventListener {
    void onKeyTyped(KeyEvent e);
}

