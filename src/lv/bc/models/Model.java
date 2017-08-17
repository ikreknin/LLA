package lv.bc.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import lv.bc.io.TopicAnswers;
import lv.bc.io.TopicReader;
import lv.bc.io.Word;

public class Model {
	
	TopicAnswers topicAnswers;
	TopicReader topicReader;
	
	public List<Word> getTopicAnswers() {
		return topicAnswers.getAnswerList();
	}

	public Word getLearnWord() {
		return topicAnswers.getLearnWord();
	}

	private int x;

	public Model() {
		x = 0;
		this.topicAnswers = new TopicAnswers();
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

	public boolean doAnswer(int answerKey) {
		if(!(topicAnswers == null))
			return topicAnswers.checkAnswer(answerKey);
		else
			return false;
	}

	//TODO: delete doAnswer1, doAnswer2, doAnswer3, doAnswer4 to use one common method doAnswer()
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
	public void doOpen(String lng, String topic) {
		//TopicReader topicReader = new TopicReader(lng+"."+topic);
		// topicReader.openFile;
		List<Word> tmpList = new ArrayList<Word>();
		TopicAnswers topicAnswers= new TopicAnswers(tmpList);

		System.out.println("==========================");
		System.out.println("Array this.topicAnswers: " + topicAnswers.getAnswerList().toString());
		System.out.println("Word learnWord: " + topicAnswers.getLearnWord().toString());

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