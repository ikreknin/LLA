package lv.bc.settings;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import lv.bc.views.View;

//For getting property values you need to use getProperty(String key)
//For setting new property values you need to use setProperty(String key, String value)

public class Settings {
	
	//Properties                             
	private String learningDirection;       
	private String topic;                  
	private boolean audio;               
	private int score;                   
	private boolean text;              


	String dir = System.getProperty("user.dir");
	String filePath = dir + "/doc/ini/Settings.ini";
	Path path = Paths.get(filePath);
	
	public Settings()  {
		Properties appProperties = new Properties();
		
		
		System.out.println("File path:	[" + filePath + "]");
		
		
		if (Files.exists(path)) {
			FileInputStream in;
			System.out.println("File " + filePath);
			//OutputStreamWriter writer = new OutputStreamWriter(out, StandardCharsets.UTF_8);
			
			try {
				in = new FileInputStream(filePath);
				InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
				appProperties.load(reader);
				in.close();
				reader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		else {
			try {
				Files.createFile(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
			appProperties.setProperty("learningDirection", "ENG-LAT");
			appProperties.setProperty("topic", "Animals");
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


	public void saveAndExit() {
		Properties appProperties = new Properties();
		appProperties.setProperty("learningDirection", learningDirection);
		appProperties.setProperty("topic", topic);
		appProperties.setProperty("audio", Boolean.toString(audio));
		appProperties.setProperty("score", String.valueOf(score));
		appProperties.setProperty("text", Boolean.toString(text));
		try {
			FileOutputStream out = new FileOutputStream(filePath);
			OutputStreamWriter writer = new OutputStreamWriter(out, StandardCharsets.UTF_8);
			appProperties.store(writer, "These are Your settings for language learning app. Don't touch this!!!");
			out.close();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

