package lv.bc.io;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;

public class TopicAnswers {
	List<Word> answerList;
	List<Word> leftToLearn;
	List<Word> fullList;
	Word learnWord;
	int Score = 0;
    //2: TODO: mixList mix the Topic object int the topicList
	// 2.1: check was answer correct
	// 2.2: check that 12 times correct answer was reached
	// 2.3: if answer was correct, then currWord has to be changed on Word who is in topicList and have count < 3
	// 2.4: if answer was incorrect , then just rebuild order of objects in topicList
	// 2.5: if successes 12 correct answers, then call initializeTopics()
	public TopicAnswers(){
		answerList = new ArrayList<Word>();
		leftToLearn = new ArrayList<Word>();
		fullList = new ArrayList<Word>();
		learnWord = new Word(0,"","",0);		
	}
	public TopicAnswers(List<Word>  fileArray) {
		answerList = new ArrayList<Word>();
		leftToLearn = new ArrayList<Word>();
		fullList = new ArrayList<Word>();
		learnWord = new Word(0,"","",0);
		initializationOfArrays(fileArray);
	}
	
	public List<Word> getFullList() {
		return fullList;
	}
	
	public void setFullList(List<Word> fileArray) {
		this.fullList.addAll(fileArray);
	 }

	public List<Word> getAnswerList() {
		return answerList;
	}
	
	public List<Word> getLeftToLearn() {
		return leftToLearn;
	}

	public void setLeftToLearn(List<Word> leftToLearn) {
		this.leftToLearn.addAll(leftToLearn);		
	}

	public Word getLearnWord() {
		return learnWord;
	}

	public void setLearnWord() {
		if(this.answerList.size() > 0){
			int k = getRandomInt(0, 3);
			learnWord = this.answerList.get(k);
		}
		else
			learnWord = new Word(0, "", "", 0);
	}	
	
	public int getScore() {
		return Score;
	}
	
	public void setScore(int score) {
		Score = score;
	}
	
	public void initializationOfArrays(List<Word>  fileArray){
		setFullList(fileArray);
		System.out.println("fullList.size()		:	" + fullList.size());
		setLeftToLearn(fileArray);
		System.out.println("leftToLearn.size()	:	" + leftToLearn.size());
		setAnswerList(leftToLearn);
		System.out.println("answerList.size()	:	" + answerList.size());
		setLearnWord();
		System.out.println("Word				:	" + learnWord.toString());
				
	}
	
	public void setAnswerList(List<Word> wordsSet) {
		if(wordsSet.size() >= 4){
			LinkedHashSet<Integer> randSet =new LinkedHashSet<Integer>();
			while(randSet.size() < 4){
				int k = getRandomInt(0, wordsSet.size()-1);
				randSet.add(k);
			}
			Iterator<Integer> itr = randSet.iterator();
			List<Word> tmpTopic = new ArrayList<Word>();
			while(itr.hasNext()){
				int i = itr.next();
		        if(wordsSet.get(i)!= null)
		        	tmpTopic.add(wordsSet.get(i));
			}
			System.out.println("[WAS] " + answerList.toString());
			answerList.clear();
			answerList.addAll(tmpTopic);
			System.out.println("[NOW] " + answerList.toString());
		}
	}

	public static int getRandomInt(int min, int max) {
	    Random random = new Random();
	    return random.nextInt((max - min) + 1) + min;
	}
	
	public boolean checkAnswer(int answerNr){
		//TODO:
		boolean answerCorrect = false;
		System.out.println("CHECK learnWord:	"+ learnWord.toString());

		if (learnWord.getKey() == answerNr){			
			setAnswerList(leftToLearn);
			setLearnWord();
			answerCorrect = true;
		}
		else
			setAnswerList(answerList);

		System.out.println("Answer  is " + answerCorrect);
		return answerCorrect;
		
	}


}
