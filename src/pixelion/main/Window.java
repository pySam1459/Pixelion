package pixelion.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import pixelion.utils.Keyboard;
import pixelion.utils.Mouse;

public class Window extends Canvas {

	private static final long serialVersionUID = -1370712036945684032L;
	private final String TITLE = "Pixelion";
	public static Dimension dim = new Dimension(1920, 1080); // A better method is to be decided on later, for now, no resizing
	
	private JFrame frame;
	private BufferStrategy bs;
	private Graphics2D g;
	
	public static Mouse mouse;
	public static Keyboard keyboard;
	
	public Window(Pixelion pxl) {
		this.frame = new JFrame(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFrameSize(dim);
		frame.setResizable(false); // TODO change in future (resizing)
		frame.add(this);
		
		Window.mouse = new Mouse(this);
		Window.keyboard = new Keyboard(this);
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent w) {
				pxl.stop();
				
			}
		});
	}
	
	public Graphics2D getGraphics2D() {
		// Creates a Graphics2D object to draw onto
		this.bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			this.bs = getBufferStrategy();
			
		}
		
		this.g = (Graphics2D) bs.getDrawGraphics();
		return this.g;
	}
	
	public void render() {
		bs.show();
		g.dispose(); // Supposedly this does something for memories' sake
		
	}
	
	private void setFrameSize(Dimension d) {
		Insets insets = frame.getInsets();
		frame.setSize(d.width + insets.top + insets.bottom, d.height + insets.left + insets.right);
		
	}
	
	public void start() {
		frame.setVisible(true);
	}
	
	public void stop() {
		frame.setVisible(false);
	}
	
}
