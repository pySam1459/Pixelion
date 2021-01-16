package pixelion.editor;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Stage {
	/* This is the area on the screen which the drawing takes place on
	 * This class will handle the moving, resizing of the visible layers in the editor
	 * and render the current layer(s)
	 * */
	
	private int[] rect;
	private BufferedImage img;
	
	public Stage() {
		
		
	}
	
	public void tick() {
		move();
		resize();
		
	}
	
	private void move() {}
	
	private void resize() {}
	
	
	public void render(Graphics2D g) {
		g.drawImage(img, rect[0], rect[1], rect[2], rect[3], null);
		
	}
	
	public Graphics2D getGraphics() {
		return (Graphics2D) img.getGraphics();
		
	}
	
	public int getWidth() {
		return rect[2];
	}
	
	public int getHeight() {
		return rect[3];
	}

}
