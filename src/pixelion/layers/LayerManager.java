package pixelion.layers;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class LayerManager {
	
	private List<Layer> layers;
	private Layer cLayer; // Current layer
	private int lxoff=64, lyoff=64, lwidth=768, lheight=768;
	
	public LayerManager() {
		this.layers = new ArrayList<>();
		
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics2D g) {
		if(cLayer != null) {
			g.drawImage(cLayer.getImg(), lxoff, lyoff, lwidth, lheight, null);
			
		}
	}
	
	public void newLayer(int w, int h) {
		this.cLayer = new Layer(w, h);
		layers.add(cLayer);
		
	}

}
