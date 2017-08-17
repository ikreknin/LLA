package lv.bc.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TopicReader {
	
	List<Word> allTopicWords;
	String fileName;

	public TopicReader(String fileName) {
		super();
		this.fileName = fileName;
		//TODO: delete this hard code later later
		fileName  = "Animal.txt";

	}

	public List<Word> getAllTopicWords() {
		return allTopicWords;
	}

	public void setAllTopicWords(List<Word> allTopicWords) {
		this.allTopicWords = allTopicWords;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	//1:TODO: read from necessary file all words
	public void openFile() throws IOException{
        Path path = Paths.get(this.fileName);
    	if (Files.notExists(path)) {
    		System.exit(1);
    	}
    	
    	String inFileName = path.getFileName().toString();
    	BufferedReader reader = new BufferedReader(new FileReader(inFileName));
 
    	try{
	    	int i = 0;
	    	int l = 0; // we have to read 3 lines to create Word object
	    	String line = null;
	    	String txtFrom = "";
	    	String txtTo = "";
	    	int txtCnt = 0;
	        while((line = reader.readLine()) != null && i < 12) {
            	if(l == 3){
            		allTopicWords.add(new Word(txtFrom, txtTo, txtCnt));
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
	    }
	    finally {
	           reader.close();
	    }
	  	
	}

	public void resetFile(){
		//TODO: go through the file and set score for all words to 0
		// save changes
		// update pointer to 0 in settings?
	}
	
	public void saveFile(){
		//TODO: update all scores into file, take score for proper word from allTopicWords
	}	

}
