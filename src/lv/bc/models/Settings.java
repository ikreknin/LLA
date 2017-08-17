package lv.bc.models;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Settings {
	
	
	private String foreignLanguage;	
	private int lastLine;
	private String iniFile = "src/lv/bc/models/Settings.ini";
	Path path = Paths.get("src/lv/bc/models/Settings.ini");
	protected final int SETTING_COUNT = 2;
	
	Settings() throws IOException  {
		String[] iniParameters = new String[SETTING_COUNT];
		
		
		if (Files.exists(path)) {
			
			//Implement Porperties
			
			 try(BufferedReader in = new BufferedReader(
					 new FileReader(iniFile))){
				 String line = in.readLine();
				 int i = 0;
				 while(line != null){
					 iniParameters[i] = line;
					 i++;
					 line = in.readLine();
				 }
			 }
			 catch(IOException e){
				 System.out.println(e);
			 }
			 
			 this.foreignLanguage = iniParameters[0];
			 this.lastLine = Integer.parseInt(iniParameters[1]);
		}
		else {
			Files.createFile(path);
			this.foreignLanguage = "English";
			this.lastLine = 0;
		}
		
		
	}
	
	public String getForeignLanguage() {
		return foreignLanguage;
	}

	public void setForeignLanguage(String foreignLanguage) {
		this.foreignLanguage = foreignLanguage;
	}

	public int getLastLine() {
		return lastLine;
	}

	public void setLastLine(int lastLine) {
		this.lastLine = lastLine;
	}

	public String getIniFile() {
		return iniFile;
	}

	public void setIniFile(String iniFile) {
		this.iniFile = iniFile;
	}

	
	public static void main(String[] args) throws IOException {
		Settings set = new Settings();
	}
	
	
	
}
