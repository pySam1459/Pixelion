package pixelion.layers;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import pixelion.editor.Stage;

public class LayerManager {
	/* This class managers the layers and how to render them
	 * NOTE: the rendered layer(s) are rendered onto the stage, which is rendered onto the screen
     * The stage may change dimensions, which is to be noted
	 * */
	
	private List<Layer> layers;
	private Layer cLayer; // Current layer
	private Stage stage;
	
	public LayerManager(Stage stage) {
		this.layers = new ArrayList<>();
		this.stage = stage;
		
		newLayer(32, 32);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics2D g) {
		if(cLayer != null) {
			g.drawImage(cLayer.getImg(), 0, 0, stage.getWidth(), stage.getHeight(), null);
			
		}
	}
	
	public Layer getCLayer() {
		return cLayer;
	}
	
	public void newLayer(int w, int h) {
		this.cLayer = new Layer(w, h);
		layers.add(cLayer);
		
	}

}
