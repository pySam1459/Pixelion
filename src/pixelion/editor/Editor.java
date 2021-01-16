package pixelion.editor;

import java.awt.Graphics2D;

import pixelion.layers.LayerManager;
import pixelion.main.Window;
import pixelion.utils.Consts;

public class Editor {
	
	private Stage stage;
	private LayerManager lm;
	
	public Editor() {
		this.stage = new Stage();
		this.lm = new LayerManager(stage);

	}

	public void tick() {
		stage.tick();
		lm.tick();
		
	}
	
	public void render(Graphics2D g) {
		g.setColor(Consts.BACKGROUND_COLOR);
		g.fillRect(0, 0, Window.dim.width, Window.dim.height);
		
		lm.render(stage.getGraphics());
		stage.render(g);
		
	}

}
