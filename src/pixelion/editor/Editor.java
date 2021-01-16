package pixelion.editor;

import java.awt.Graphics2D;

import pixelion.layers.LayerManager;
import pixelion.main.Window;
import pixelion.utils.Consts;

public class Editor {
	
	private LayerManager lm;
	
	public Editor() {
		this.lm = new LayerManager();

	}

	public void tick() {
		lm.tick();
		
	}
	
	public void render(Graphics2D g) {
		g.setColor(Consts.BACKGROUND_COLOR);
		g.fillRect(0, 0, Window.dim.width, Window.dim.height);
		
		lm.render(g);
		
	}

}
