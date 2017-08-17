package lv.bc.models;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer {
    static File audioFile;
    static AudioInputStream stream;
    static AudioFormat format;
    
    public static void playFileWithPath(String pathToFile, String fileName) {
	   try {
//	    	String s3 = System.getProperty("user.dir");
//	    	audioFile = new File(s3 + "/src/viens.wav");
		   	audioFile = new File(pathToFile + fileName);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	public static void main(String[] args) {
		
	}

}

