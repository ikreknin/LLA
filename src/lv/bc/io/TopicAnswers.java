package lv.bc.io;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;

public class TopicAnswers {
	List<Word> answerList;
	Word learnWord;
	
    //2: TODO: mixList mix the Topic object int the topicList
	// 2.1: check was answer correct
	// 2.2: check that 12 times correct answer was reached
	// 2.3: if answer was correct, then currWord has to be changed on Word who is in topicList and have count < 3
	// 2.4: if answer was incorrect , then just rebuild order of objects in topicList
	// 2.5: if successed 12 correct answers, then call initializeTopics()

	public TopicAnswers(List<Word> answerList) {
		setAnswerList();
		setLearnWord();
	}

	public List<Word> getAnswerList() {
		return answerList;
	}

	public void setAnswerList() {
		//this.answerList = answerList;
		//TODO: Delete hard code after demo
		this.answerList = new ArrayList<Word>();
		this.answerList.add(new Word(0,"suns", "dog", 0));
		this.answerList.add(new Word(1,"lauva", "lion", 0));
		this.answerList.add(new Word(2,"putns", "bird", 0));
		this.answerList.add(new Word(3, "kengurs", "kangaroo", 0));
	}

	public Word getLearnWord() {
		return learnWord;
	}

	public void setLearnWord() {
		//this.learnWord = learnWord;
		//TODO: Delete this hard code later
		int k = getRandomInt(1, 4);
		//if(this.answerList.size() > 0){
		//	learnWord = this.answerList.get(k);
	//	}
		//else
			learnWord = new Word(0, "suns", "dog", 0);
	}

	public static int getRandomInt(int min, int max) {
	    Random random = new Random();
	    return random.nextInt((max - min) + 1) + min;
	}
	
	public void mixAnswers(){
		Random rng = new Random(); 
		int[] randomInt = new int[4]; 
		
		// Note: use LinkedHashSet to maintain insertion order
		LinkedHashSet<Integer> randSet =new LinkedHashSet<Integer>();
		while(randSet.size() < 4){
			int k = getRandomInt(1, 4);
			randSet.add(k);
		}
		
		List<Word> tmpTopic = new ArrayList<Word>();
		Iterator<Integer> itr = randSet.iterator();
		System.out.println("[WAS] " + answerList.toString());
		int i = 0;
		while(itr.hasNext()){
			int t = itr.next();
	        if(answerList.get(t-1)!= null)
	        	tmpTopic.add(answerList.get(t-1));
		}    
		
		answerList.clear();
		answerList.addAll(tmpTopic);
		System.out.println("[NOW] " + answerList.toString());
	}
	
	public boolean checkAnswer(int answerNr){
			return false;
		
	}


}
