package pixelion.utils;

import java.awt.Canvas;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener {

	public boolean left=false, right=false;
	
	private Canvas canvas;
	private Point p1, p2;
	
	public Mouse(Canvas c) {
		this.canvas = c;
		c.addMouseListener(this);
		
	}

	@Override
	public void mousePressed(MouseEvent m) {
		if(m.getButton() == MouseEvent.BUTTON1) {
			left = true;
			
		} else if(m.getButton() == MouseEvent.BUTTON3) {
			right = true;
			
		}
	}

	@Override
	public void mouseReleased(MouseEvent m) {
		if(m.getButton() == MouseEvent.BUTTON1) {
			left = false;
			
		} else if(m.getButton() == MouseEvent.BUTTON3) {
			right = false;
			
		}
	}

	public Point getXY() {
		if(canvas.isVisible()) {
			p1 = MouseInfo.getPointerInfo().getLocation();
			p2 = canvas.getLocationOnScreen();
			return new Point(p1.x-p2.x, p1.y-p2.y);
			
		} else {
			// This will only be the case either when the frame is closing, and so returning some default Point object will stop other
			// processes producing an error, instead of an error being produced here
			return new Point(0, 0);
		}
	}
	
	// Don't need these
	public void mouseClicked(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	
}
