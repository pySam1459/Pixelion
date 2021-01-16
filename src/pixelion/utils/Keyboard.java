package pixelion.utils;

import java.awt.Canvas;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class Keyboard extends HashMap<Integer, Boolean> implements KeyListener {
	// Making the KeyListener a subclass of a hashmap with key: KeyEvent.code, value: if it is pressed is a idea I just thought of
	// For textboxs, this class wouldn't be used but instead the interface is implemented directly to the textbox class
	// However, this class can be used for keybinds, etc

	private static final long serialVersionUID = -4862871434775652952L;
	
	public Keyboard(Canvas c) {
		c.addKeyListener(this);
		
	}
	
	public boolean get(int code) {
		return containsKey(code);
		
	}

	@Override
	public void keyPressed(KeyEvent k) {
		put(k.getKeyCode(), true);

	}

	@Override
	public void keyReleased(KeyEvent k) {
		remove(k.getKeyCode());

	}


	// Not gonna use (probably)
	public void keyTyped(KeyEvent arg0) {}

}
