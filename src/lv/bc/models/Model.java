package lv.bc.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import lv.bc.io.TopicAnswers;
import lv.bc.io.TopicReader;
import lv.bc.io.Word;

public class Model {
	
	TopicAnswers topicAnswers = new TopicAnswers();;
	public List<Word> getTopicAnswers() {
		return topicAnswers.getAnswerList();
	}

	public Word getLearnWord() {
		return topicAnswers.getLearnWord();
	}

	public Model() {
	
	}

	// Buttons' methods ------------------------------------------------------------------------------------------------------
	public void doQuestion() {

	}

	public boolean doAnswer(int answerKey) {
		System.out.println("answerKey: " + answerKey);	
		if(topicAnswers != null){
			boolean answerCorrect = topicAnswers.checkAnswer(answerKey);
			return answerCorrect;
		}
		else 
			return false;
	}

	// Main "File" Menu Items --------------------------""----------------------------------------------------------------------------

	// Sub-Menu "Open" method
	public void doOpen(String lng, String topic) {
		System.out.println("===========File Path==========");
		System.out.println("Language: " + lng + "Topic:	" + topic);
		//TopicReader topicReader = new TopicReader("ENG-LAT", "Animals");
		TopicReader topicReader = new TopicReader(lng, topic);
		try {
			topicReader.openFile();
			if(topicReader.getAllTopicWords().size() > 0) {
				topicAnswers = new TopicAnswers(topicReader.getAllTopicWords());
				
				System.out.println("========Array=========");
				System.out.println("Full array: " + topicReader.getAllTopicWords().toString());
				System.out.println("left array: " + topicAnswers.getLeftToStudy().values());
				System.out.println("Answ array: " + topicAnswers.getAnswerList().toString());
				System.out.println("learnWord : " + topicAnswers.getLearnWord().toString());
				System.out.println("model.getLearnWord().getFromText():			" + this.getLearnWord().getFromText());
				System.out.println("model.getTopicAnswers().get(0).getToText(): " + this.getTopicAnswers().get(0).getToText());
				System.out.println("model.getTopicAnswers().get(1).getToText()):" + this.getTopicAnswers().get(1).getToText());
				System.out.println("model.getTopicAnswers().get(2).getToText(): " + this.getTopicAnswers().get(2).getToText());
				System.out.println("model.getTopicAnswers().get(3).getToText():	" + this.getTopicAnswers().get(3).getToText());
			}
		} catch (IOException e) {
			//SHOW Error message
			e.printStackTrace();
		}
	}
	public int getScore(){
		return topicAnswers.getRoundScore();
	}

	// Sub-Menu "Save" method
	public void doSave() {

	}

	// Sub-Menu "Reset" method
	public void doReset() {
		topicAnswers.reset();
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