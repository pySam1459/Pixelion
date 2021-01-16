package pixelion.layers;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

public class Layer {
	// A layer object will contain information regarding a single layer
	// Mainly, the BufferedImage object which holds the pixel data
	
	private int width, height;
	private BufferedImage img;
	
	public Layer(int width, int height) {
		this.width = width;
		this.height = height;
		
		this.img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
	}
	
	public Graphics2D getGraphics() {
		return (Graphics2D) img.getGraphics();
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public BufferedImage getImg() {
		// This copies the BufferedImage, otherwise a reference of the object would be returned, not good
		// If changes to the img object is to be made, use the getGraphics method
		
		ColorModel cm = img.getColorModel();
		boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		WritableRaster raster = img.copyData(null);
		return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}

}
