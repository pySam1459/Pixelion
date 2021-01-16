package pixelion.layers;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

import pixelion.main.Window;

public class Layer {
	// A layer object will contain information regarding a single layer
	// Mainly, the BufferedImage object which holds the pixel data
	
	private int width, height;
	private int pwidth, pheight;
	private BufferedImage img;
	
	public boolean drawgrid = true;
	
	private BufferedImage temp;
	private Graphics2D g;
	
	private LayerManager lm;
	
	public Layer(int width, int height, LayerManager lm) {
		this.width = width;
		this.height = height;
		this.pwidth = lm.getlwidth() / width;
		this.pheight = lm.getlheight() / height;
		
		this.lm = lm;
		
		this.img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		fill(Color.WHITE);
		
	}
	
	public void fill(Color col) {
		g = getGraphics();
		g.setColor(col);
		g.fillRect(0, 0, width, height);
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
	
	public BufferedImage getRender() {
		temp = new BufferedImage(lm.getlwidth(), lm.getlheight(), BufferedImage.TYPE_INT_ARGB);
		g = (Graphics2D) temp.getGraphics();

		g.drawImage(img, 0, 0, lm.getlwidth(), lm.getlheight(), null);
		
		g.setStroke(new BasicStroke(1));
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, Window.dim.width, Window.dim.height);
		
		if(drawgrid) {
			g.setStroke(new BasicStroke(1));
			g.setColor(Color.BLACK);
			
			for(int j=0; j<height; j++) {
				for(int i=0; i<width; i++) {
					g.drawRect(i*pwidth, j*pheight, pwidth, pheight);
					
				}
			}
		}
		
		return temp;
	}

}
