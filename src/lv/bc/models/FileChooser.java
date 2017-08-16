package lv.bc.models;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FileChooser {
	public FileChooser(){
		//null
	}
	
	public void chooseFile(JFrame parent){
		//TODO: open screen with file choose
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(parent);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
		    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		}
		
	};

}
