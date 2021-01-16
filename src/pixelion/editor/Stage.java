package pixelion.editor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import pixelion.main.Window;
import pixelion.utils.Consts;

public class Stage {
	/* This is the area on the screen which the drawing takes place on
	 * This class will handle the moving, resizing of the visible layers in the editor
	 * and render the current layer(s)
	 * */
	private final Dimension DEFAULT_SIZE = new Dimension(640, 640);
	
	private int[] rect;
	private BufferedImage img;
	
	public Stage() {
		this.rect = new int[] {Window.dim.width/2-DEFAULT_SIZE.width/3, Window.dim.height/2 - DEFAULT_SIZE.height/2,
								DEFAULT_SIZE.width, DEFAULT_SIZE.height};
		this.img = new BufferedImage(DEFAULT_SIZE.width, DEFAULT_SIZE.height, BufferedImage.TYPE_INT_ARGB);
		
	}
	
	public void tick() {
		move();
		resize();
		
	}
	
	private void move() {}
	
	private void resize() {}
	
	
	public void render(Graphics2D g) {
		// Rendering stage with xyoffset and resized width, height
		g.drawImage(img, rect[0], rect[1], rect[2], rect[3], null);
		
		// Border
		g.setStroke(Consts.THIN_STROKE);
		g.setColor(Color.BLACK);
		g.drawRect(rect[0], rect[1], rect[2], rect[3]);
		
	}
	
	public Graphics2D getGraphics() { 
		// To draw onto the stage
		return (Graphics2D) img.getGraphics();
		
	}
	
	public int getWidth() {
		return img.getWidth();
	}
	
	public int getHeight() {
		return img.getHeight();
	}

}
