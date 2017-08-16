package lv.bc.models;

import javax.swing.JFrame;

public class Model {

	private int x;

	public Model() {
		x = 0;
	}

	public Model(int x) {
		this.x = x;
	}

	public void incX() {
		x++;
	}

	public int getX() {
		return x;
	}

	// Buttons' methods ------------------------------------------------------------------------------------------------------
	public void doQuestion() {

	}

	public void doAnswer1() {

	}

	public void doAnswer2() {

	}

	public void doAnswer3() {

	}

	public void doAnswer4() {

	}

	// Main "File" Menu Items ------------------------------------------------------------------------------------------------------

	// Sub-Menu "Open" method
	public void doOpen(JFrame parentFrame) {
		new FileChooser().chooseFile(parentFrame);;

	}

	// Sub-Menu "Save" method
				public void doSave() {

	}

	// Sub-Menu "Reset" method
				public void doReset() {

	}

	// Main Menu "Mode" Items------------------------------------------------------------------------------------------------------

	// Sub-menu "Silent" method
				public void doSilent() {

	}
	
	// Sub-menu "Audio" method
				public void doAudio() {

		}
	
		// Sub-menu "Text" method
				public void doText() {

						}
		
		// Sub-menu "Foreign-to-Native" method
				public void doFN() {

								}	
		// Sub-menu "Native-to-Foreign" method
				public void NF() {

										}	
				
		// Main Menu "Options" Items------------------------------------------------------------------------------------------------------	
				// Sub-menu "Language" method
				
				public void doLanguage() {

										}
				
		// Main Menu "Help" method------------------------------------------------------------------------------------------------------	
		
				public void doHelp() {

									}
}