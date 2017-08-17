package lv.bc.models;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Settings {
	
	//Strings for property names
	public static String foreignLanguage = "foreignLanguage";
	public static String lastLine = "lastLine";

	private String iniFile = "src/lv/bc/models/Settings.ini";
	Path path = Paths.get("src/lv/bc/models/Settings.ini");
	protected final int SETTING_COUNT = 2;
	Properties appProperties = new Properties();
	
	Settings()  {
		
		if (Files.exists(path)) {
			FileInputStream in;
			try {
				in = new FileInputStream(iniFile);
				appProperties.load(in);
				in.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(appProperties.getProperty(foreignLanguage));
			
			//What to do, if in file is not enough properties?
			//One thing we can do- make default property file
		}
		else {
			try {
				Files.createFile(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
			appProperties.setProperty(foreignLanguage, "English");
			appProperties.setProperty(lastLine, "0");
		}
	}	
	
	//TODO For setting new property values you need to use setProperty(String key, String value)
	//TODO call on EXIT controller
	public void saveAndExit() {
		try {
			FileOutputStream out = new FileOutputStream(iniFile);
			appProperties.store(out, "Looool");
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main (String[] args) {
		Settings set = new Settings();
		set.appProperties.setProperty(foreignLanguage, "Russian");
		System.out.println(set.appProperties.getProperty(foreignLanguage));
		set.saveAndExit();
		
	}
	
}







