package pixelion.main;

import java.awt.Graphics2D;

import pixelion.editor.Editor;
import pixelion.utils.Func;
import pixelion.utils.Settings;

public class Pixelion implements Runnable {
	/* Main class, contains main thread with the origins of the tick and render trees
	 * Currently ticking and rendering are done on the same thread, for concurrency (could be changed if necessary)
	 * */

	private final double TPS = 60.0;
	
	private Thread mainThread;
	private volatile boolean running = false;
	
	private Window window;
	private Editor edt;
	
	public Pixelion() {
		Settings.loadSettings();
		Func.loadFonts();
		
		this.window = new Window(this);
		this.edt = new Editor();
		
		start();
	}
	

	private void tick() {
		// Tick here
		edt.tick();
		
	}
	
	private void render() {
		Graphics2D g = window.getGraphics2D();
		
		// Render here
		edt.render(g);
		
		window.render();
	}
	
	
	@Override
	public void run() {
		// Simply, calls the tick and render methods every 1/TPS seconds
		double ns = 1000000000.0 / TPS;
		double delta = 0.0;
		long now, lastTime = System.nanoTime();
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1.0) {
				tick();
				render();
				delta--;
			}
		}
	}
	
	
	public synchronized void start() {
		window.start(); // Window must start before main Thread or frame visibility issues arrise
		running = true;
		mainThread = new Thread(this, "Main Thread");
		mainThread.start();
		
	}
	
	public synchronized void stop() {
		running = false;
		mainThread.interrupt();
		window.stop(); // Again, window must stop after thread, due to same reasons as starting
		
	}

	public static void main(String[] args) {
		new Pixelion();

	}

}
