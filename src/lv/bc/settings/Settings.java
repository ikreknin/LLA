package lv.bc.settings;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import lv.bc.views.View;

//For getting property values you need to use getProperty(String key)
//For setting new property values you need to use setProperty(String key, String value)

public class Settings {
	
	//Properties                             //Now value should be:
	private View view;
	private String learningDirection;       // LAT-ENG
	private String topic;                  // Dzivnieki
	private boolean audio;                // true
	private int score;                   // 0
	private boolean text;               // true


	private String iniFile = "../Settings.ini";
	Path path = Paths.get(iniFile);
	
	public Settings()  {
		Properties appProperties = new Properties();
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
			
			//What to do, if in file is not enough properties?
			//One thing we can do- make default property file
		}
		else {
			try {
				Files.createFile(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
			appProperties.setProperty("learningDirection", "LAT-ENG");
			appProperties.setProperty("topic", "Dzivnieki");
			appProperties.setProperty("audio", "true");
			appProperties.setProperty("score", "0");
			appProperties.setProperty("text", "true");
		}
		
		this.learningDirection = appProperties.getProperty("learningDirection");
		this.topic = appProperties.getProperty("topic");
		this.audio = Boolean.valueOf(appProperties.getProperty("audio"));
		this.score = Integer.parseInt(appProperties.getProperty("score"));
		this.text = Boolean.valueOf(appProperties.getProperty("text"));
	}	
	

	
	
	public String getLearningDirection() {
		return learningDirection;
	}




	public void setLearningDirection(String learningDirection) {
		this.learningDirection = learningDirection;
	}




	public String getTopic() {
		return topic;
	}




	public void setTopic(String topic) {
		this.topic = topic;
	}




	public boolean getAudio() {
		return audio;
	}




	public void setAudio(boolean audio) {
		this.audio = audio;
	}




	public int getScore() {
		return score;
	}




	public void setScore(int score) {
		this.score = score;
	}




	public boolean getText() {
		return text;
	}




	public void setText(boolean text) {
		this.text = text;
	}


	//TODO call save and on EXIT controller
	public void saveAndExit() {
		Properties appProperties = new Properties();
		appProperties.setProperty("learningDirection", learningDirection);
		appProperties.setProperty("topic", topic);
		appProperties.setProperty("audio", Boolean.toString(audio));
		appProperties.setProperty("score", String.valueOf(score));
		appProperties.setProperty("text", Boolean.toString(text));
		try {
			FileOutputStream out = new FileOutputStream(iniFile);
			appProperties.store(out, "These are Your settings for language learning app. Don't touch this!!!");
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//for manual testing	
/*public static void main (String[] args) {
		Settings set = new Settings();
		set.setAudio(true);;
		System.out.println(set.getAudio());
		set.saveAndExit();		
	}*/
	
}







