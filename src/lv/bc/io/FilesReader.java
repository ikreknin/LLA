package lv.bc.io;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;

public class FilesReader {
	private String fileName;
	//TODO: save list of 4 elements members
	private List<Topic> topicList;
	//TODO: save in parameter the Topic for translation
	private Topic currWord;
	
	private int pointer;
	private int totalGroupAnswers = 0;
    
	//TODO: parse choosen fileName and line nr for cursor pointer. This number has to be saved in settings.ini file
	public FilesReader(String fileName, int pointer) {
		//TODO: delete this hardcode later later
		fileName  = "Animal.txt";
		pointer = 0;
		setTopicList();
		setCurrWord();
		//TODO: this.fileName = fileName and has to be only login inside initializeTopic
		//	initializeTopic();
	}
	public void setTopicList() {
		topicList = new ArrayList<Topic>();
		topicList.add(new Topic("suns", "dog", 0));
		topicList.add(new Topic("lauva", "lion", 0));
		topicList.add(new Topic("putns", "bird", 0));
		topicList.add(new Topic("kengurs", "kangaroo", 0));
	}
	
	public List<Topic> getTopicList() {
		return topicList;
	}

	public String getCurrWord() {
		return currWord.getFromText();
	}

	public void setCurrWord() {
		currWord = new Topic("suns", "dog", 0);
	}
	
	public boolean checkAnswer(Topic answerTopic){
		return true;
	}
	
	public void resetFile(){
		//TODO: go through the file and set score for all words to 0
		// save changes
		// update pointer to 0 in settings?
	}
	
	public void saveFile(){
		//TODO: update all scores into file, take score for proper word from topicList
		// update pointer in settings.ini
	}

	//1:TODO: change initialize so that it will read into List any read 4 new words from file 
	// read from necessary file next 4 words and place it into topicList
	// save currWord object
	public void openFile() throws IOException{
        Path path = Paths.get(this.fileName);
    	if (Files.notExists(path)) {
    		System.exit(1);
    	}
    	
    	String inFileName = path.getFileName().toString();
    	BufferedReader reader = new BufferedReader(new FileReader(inFileName));
 
    	try{
	    	int i = 0;
	    	int l = 0; // we have to read 3 rlines to create Topic object
	    	String line = null;
	    	String txtFrom = "";
	    	String txtTo = "";
	    	int txtCnt = 0;
	        while((line = reader.readLine()) != null && i < 12) {
            	if(l == 3){
            		//1: TODO: then you will the file will work Save previous Topic to Array
            		topicList.add(new Topic(txtFrom, txtTo, txtCnt));
            		l = 0;
            	}	
            	if(l == 0)
            		txtFrom = line;
            	if(l == 1)
            		txtTo = line;
            	if(l == 2)
            		txtCnt = Integer.parseInt(line);// has to be integer TODO: implement check on integer ParseInt
            	l++;
            	i++;
            }
	        //TODO: chage this hard for first init save word from 1st Array position
	        currWord = new Topic("suns", "dog", 0);
	        this.pointer = i;// hast to be 12 for first time olr less if in file is less then 4 words
	    }
	    finally {
	           reader.close();
	    }
	  	
	}
	    
    	
    //2: TODO: mixList mix the Topic object int the topicList
	// 2.1: check was answer correct
	// 2.2: check that 12 times correwct answer was reached
	// 2.3: if answer was correct, then currWord has to be changed on Word who is in topicList and have count < 3
	// 2.4: if answer was incorrect , then just rebuild order of objects in topicList
	// 2.5: if successed 12 correct answers, then call initializeTopics()

	public static int getRandomInt(int min, int max) {
	    Random random = new Random();
	    return random.nextInt((max - min) + 1) + min;
	}
	
	
	public void randomMix(){
		Random rng = new Random(); 
		int[] randomInt = new int[4]; 
		
		// Note: use LinkedHashSet to maintain insertion order
		LinkedHashSet<Integer> randSet =new LinkedHashSet<Integer>();
		while(randSet.size() < 4){
			int k = getRandomInt(1, 4);
			randSet.add(k);
		}
		
		List<Topic> tmpTopic = new ArrayList<Topic>();
		Iterator<Integer> itr = randSet.iterator();
		System.out.println("[WAS] " + topicList.toString());
		int i = 0;
		while(itr.hasNext()){
			int t = itr.next();
	        if(topicList.get(t-1)!= null)
	        	tmpTopic.add(topicList.get(t-1));
		}    
		
		topicList.clear();
		topicList.addAll(tmpTopic);
		System.out.println("[NOW] " + topicList.toString());
		
	}	
  
}