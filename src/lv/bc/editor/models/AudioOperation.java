package lv.bc.editor.models;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import lv.bc.editor.controllers.Controller;

public class AudioOperation {

	static File audioFile;
	static AudioInputStream stream;
	static AudioFormat format;

	public static void playSound(String topicName, String fileName) {
		try {
			audioFile = new File(Controller.FP + "file/" + FileOperation.getLangDirectory() + "/" + topicName + "/"
					+ fileName.toLowerCase() + ".wav");
			stream = AudioSystem.getAudioInputStream(audioFile.getAbsoluteFile());
			format = stream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			Clip clip;
			if (!AudioSystem.isLineSupported(info)) {
				// handle the error
				System.err.println("not supported audio format");
				System.exit(-1);
			}
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

}
