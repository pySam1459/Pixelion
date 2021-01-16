package pixelion.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Settings {
	
	private static HashMap<String, Object> sets = new HashMap<>();
	private static Object obj;
	
	public static int getInt(String key) {
		obj = sets.get(key);
		return obj != null ? (int) obj : 0; // Don't know what other default value to use
	}
	
	public static String getString(String key) {
		obj = sets.get(key);
		return obj != null ? (String) obj : "";
	}
	
	public static double getDouble(String key) {
		obj = sets.get(key);
		return obj != null ? (double) obj : 0.0;
	}
	
	public static boolean getBoolean(String key) {
		obj = sets.get(key);
		return obj != null ? (boolean) obj : false;
	}
	
	public static void loadSettings() {
		String filename = "res/settings/settings.txt";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
			String line;
			while((line = br.readLine()) != null) {
				parseLine(line);
				
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Settings.txt file was not found!");
			e.printStackTrace();
			
		} catch (IOException e) {
			System.out.println("An error occured when reading from file 'settings.txt'");
			e.printStackTrace();
		}
	}
	
	private static void parseLine(String line) {
		line = line.replaceAll(" ", "");
		String[] keyValue = line.split("=");
		sets.put(keyValue[0], toObject(keyValue[1]));
		
	}
	
	private static Object toObject(String sobj) {
		if(sobj.matches("\\d+")) {
			return Integer.parseInt(sobj);
			
		} else if(sobj.matches("\\d*\\.\\d+")) {
			return Double.parseDouble(sobj);
		
		} else if(sobj.matches("(true)|(false)")) {
			return "true".equals(sobj);
			
		} else {
			return sobj;
		}
	}

}
