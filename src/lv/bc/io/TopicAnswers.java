package lv.bc.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;

public class TopicAnswers {
	private List<Word> answerList;
	private List<Word> fullList;
	private HashMap<Integer, Word>  leftToStudy;
	private Word learnWord;

	private double score;
	
	//then last 3 word is left to learn save theirs keys till those words will not be learnd
	//private HashMap lastThreeWords;

	public TopicAnswers(){
		fullList = new ArrayList<Word>();
		leftToStudy = new HashMap<Integer, Word> ();
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
	
	public HashMap<Integer, Word>  getLeftToStudy() {
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
		leftToStudy = new HashMap<Integer, Word> ();
		answerList = new ArrayList<Word>();
		learnWord = new Word(0,"","",0);	
		score = 0;
		//lastThreeWords = new HashMap(); 
		setFullList(fileArray);
		System.out.println("fullList.size()		:	" + fullList.size());

		setLeftToStudy(fileArray);
		System.out.println("leftToStudy	["+ leftToStudy.size() + "]:  " + leftToStudy.values());
		
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
			System.out.println("answerList [was]: " + answerList.toString());
			answerList.clear();
			answerList.addAll(tmpTopic);
			System.out.println("answerList [now]: " + answerList.toString());
		}
	}

	private static int getRandomInt(int min, int max) {
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
			
			if(leftToStudy.size() < 4)
				mixLastThreeWords(answerNr);
			else{
				//3: set new answers list
				System.out.println("step 3: Set new answers list");
				setAnswerList(new ArrayList<Word>(leftToStudy.values()));
				
				//4: set new word for study
				System.out.println("step 4: Set new word to study [was]: " + learnWord.toString());
				setLearnWord();
				System.out.println("step 4: Set new word to study [now]: " + learnWord.toString());
			}

			answerCorrect = true;
		}
		else
			setAnswerList(answerList);

		System.out.println("Answer  is " + answerCorrect);
		return answerCorrect;		
	}

	private void calculateScore(){
		System.out.println("step 2: calculate score [was]: " + scoreToString());
		double tricked = fullList.size() - leftToStudy.size();
		setScore((tricked/fullList.size())*100);
		System.out.println("step 2: calculate score [now]: " + scoreToString());
		
	}
	
	private void resetStudyList(int answerNr){
		System.out.println("step 1: remove key " + answerNr + "left to staudey size [was]: " +leftToStudy.size() );
		leftToStudy.remove(answerNr);
		System.out.println("step 1: remove key " + answerNr + "left to staudey size [now]: " +leftToStudy.size() );
	}
	
	private void mixLastThreeWords(int deleteKey){
		//TODO check Score. If score < 100 then not all words has been learned
		System.out.println("================MIX LAST WORDS================");
		if(leftToStudy.size() > 0){
		  System.out.println("leftToStudy size " + leftToStudy.size() + " < 4" );
		  HashMap<Integer, Word> tmpArray = new HashMap<Integer, Word>();
		  tmpArray.putAll(leftToStudy);
		  while(tmpArray.size() < 4){
				int k = getRandomInt(0, fullList.size()-1);
				tmpArray.put(fullList.get(k).getKey(), (Word) fullList.get(k));
		  }
		  //Set answers array
		  setAnswerList(new ArrayList<Word>(tmpArray.values()));
		  System.out.println("answerList [new]: " + getAnswerList().toString());
		  
		  //set learn form leftToStudy
		  System.out.println("Word [was]: " + learnWord.toString());
		  List<Word> newArray = new ArrayList<Word>();
		  newArray.addAll(leftToStudy.values());
		  
		  System.out.println("temporary array for last words: " +  newArray.toString());
		  int k = getRandomInt(0, newArray.size()-1);
		  learnWord = (Word) newArray.get(k);
		  System.out.println("Word [now]: " + learnWord.toString());
		} 
		else{
			reset();
			score = 100;
		}
	}

	public void reset(){
		//TODO: Just refresh like file was newly opened
		setLeftToStudy(fullList);
		setAnswerList(new ArrayList<Word>(leftToStudy.values()));
		setLearnWord();
		score = 0;
	}

}
