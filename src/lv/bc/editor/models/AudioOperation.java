package lv.bc.editor.models;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import lv.bc.editor.controllers.Controller;

public class AudioOperation {

	public static void playSound(String topicName, String fileName) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(Controller.FP + "file/"
					+ FileOperation.getLangDirectory() + "/" + topicName + "/" + fileName + ".wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
