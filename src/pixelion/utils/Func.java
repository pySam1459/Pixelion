package pixelion.utils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class Func {

	public static void loadFonts() {
		String[] fontsToLoad = new String[] {"VCR_OSD_MONO.ttf"};
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		for(String filename: fontsToLoad) {
			try {
				ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/" + filename)));
				
			} catch (FontFormatException | IOException e) {
				System.out.printf("An error occurred when trying to load the font '%s'\n", filename);
				e.printStackTrace();
			}
		}
	}
	
}
