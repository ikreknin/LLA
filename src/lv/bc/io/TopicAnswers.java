package lv.bc.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;

public class TopicAnswers {
	List<Word> answerList;
	List<Word> fullList;
	HashMap leftToStudy;
	Word learnWord;
	double score;

	public TopicAnswers(){
		fullList = new ArrayList<Word>();
		leftToStudy = new HashMap();
		answerList = new ArrayList<Word>();
		learnWord = new Word(0,"","",0);	
		score = 0;
	}
	public TopicAnswers(List<Word>  fileArray) {
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
	
	public HashMap getLeftToStudy() {
		return leftToStudy;
	}
	public void setLeftToStudy(List<Word> leftToLearn) {
		for(Word word :leftToLearn){
			this.leftToStudy.put(word.getKey(), word);			
		}
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
	
	public double getScore() {
		return this.score;
	}
	
	public void setScore(double score) {
		this.score = score;
	}
	
	public String scoreToString(){
		String sentence = String.format("%,.2f", this.score)+"%";
		return sentence;
	}

	public int getRoundScore(){
		return (int) this.score;
	}
	
	public void initializationOfArrays(List<Word>  fileArray){
		fullList = new ArrayList<Word>();
		leftToStudy = new HashMap();
		answerList = new ArrayList<Word>();
		learnWord = new Word(0,"","",0);	
		score = 0;
		setFullList(fileArray);
		System.out.println("fullList.size()		:	" + fullList.size());

		setLeftToStudy(fileArray);
		System.out.println("newmToLearn.size()	:	" + leftToStudy.size());
		System.out.println("newmToLearn.size()	:	" + leftToStudy);
		
		setAnswerList(new ArrayList<Word>(leftToStudy.values()));
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
			System.out.println("[was]: " + answerList.toString());
			answerList.clear();
			answerList.addAll(tmpTopic);
			System.out.println("[now]: " + answerList.toString());
		}
	}

	public static int getRandomInt(int min, int max) {
	    Random random = new Random();
	    return random.nextInt((max - min) + 1) + min;
	}
	
	public boolean checkAnswer(int answerNr){
		//TODO:
		boolean answerCorrect = false;
		System.out.println("====================CHECK ANSWER===================");
		System.out.println("[WAS] Word:	"+ learnWord.toString());

		if (learnWord.getKey() == answerNr){	
			//1: delete learned word from study HashMap
			 resetStudyList(answerNr);
			 
			//2: calculate user score
			calculateScore();
			
			//3: set new answers list
			System.out.println("step 3: Set new answers list");
			setAnswerList(new ArrayList<Word>(leftToStudy.values()));
			
			//4: set new word for study
			System.out.println("step 4: Set new word to study [was]: " + learnWord.toString());
			setLearnWord();
			System.out.println("step 4: Set new word to study [now]: " + learnWord.toString());
			
			answerCorrect = true;
		}
		else
			setAnswerList(answerList);

		System.out.println("Answer  is " + answerCorrect);
		return answerCorrect;		
	}

	public void calculateScore(){
		System.out.println("step 2: calculate score [was]: " + scoreToString());
		double tricked = fullList.size() - leftToStudy.size();
		setScore((tricked/fullList.size())*100);
		System.out.println("step 2: calculate score [now]: " + scoreToString());
		
	}
	
	public void resetStudyList(int answerNr){
		System.out.println("step 1: remove key " + answerNr + "left to staudey size [was]: " +leftToStudy.size() );
		leftToStudy.remove(answerNr);
		if(leftToStudy.size() <  4){
			setScore(100);
			setLeftToStudy(fullList);
		}
		System.out.println("step 1: remove key " + answerNr + "left to staudey size [now]: " +leftToStudy.size() );
	}

	public void reset(){
		//TODO: Just refresh like file was newly opened
		setLeftToStudy(fullList);
		setAnswerList(new ArrayList<Word>(leftToStudy.values()));
		setLearnWord();
		score = 0;

	}

}
