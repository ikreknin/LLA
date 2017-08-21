package lv.bc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TopicReader {
	
	List<Word> allTopicWords;
	String topicName;
	String langDirr;
	public TopicReader(String langDirr, String topicName) {
		this.topicName = topicName;
		this.langDirr = langDirr;

	}

	public List<Word> getAllTopicWords() {
		return allTopicWords;
	}

	public void setAllTopicWords(List<Word> allTopicWords) {
		this.allTopicWords = allTopicWords;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String fileName) {
		this.topicName = topicName;
	}

	//1:TODO: read from necessary file all words
	public void openFile() throws IOException{
		String dir = System.getProperty("user.dir");
		System.out.println(dir);
		String filePath = dir + "/file/" + this.langDirr + "/" + this.topicName + "/" +this.topicName.toLowerCase() +".lst";
		System.out.println("File path:	[" + filePath + "]");
		
		this.allTopicWords = new ArrayList<Word>();
				
       
    	/*	this.allTopicWords.add(new Word(0,"suns", "dog", 0));
    		this.allTopicWords.add(new Word(1,"lauva", "lion", 0));
    		this.allTopicWords.add(new Word(2,"putns", "bird", 0));
    		this.allTopicWords.add(new Word(3, "kengurs", "kangaroo", 0));
    		
    		this.allTopicWords.add(new Word(4,"tīģeris", "tiger", 0));
    		this.allTopicWords.add(new Word(5,"krokodils", "crocodile", 0));
    		this.allTopicWords.add(new Word(6,"zirgs", "horse", 0));
    		this.allTopicWords.add(new Word(7, "govs", "cow", 0));
    		
    		this.allTopicWords.add(new Word(8,"lapsa", "fox", 0));
    		this.allTopicWords.add(new Word(9,"zilonis", "elephant", 0));
    		this.allTopicWords.add(new Word(10,"aita", "sheep", 0));
    		this.allTopicWords.add(new Word(11, "pērtiķis", "monkey", 0));
    		
    		this.allTopicWords.add(new Word(12,"lācis", "bear", 0));    */		

		System.out.println("1");
    	final File file = new File(filePath);
		System.out.println("2");
    	BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
		   	try{
		    	int i = 0;
		    	int l = 0; // we have to read 3 lines to create Word object
		    	String line = null;
		    	String txtFrom = "";
		    	String txtTo = "";
		        while((line = reader.readLine()) != null) {
		        	if (l== 0)
			        		txtFrom = line;
		        	else if(l == 1)
			        		txtTo = line;
		        	else if(l == 3){
		        		    int key = allTopicWords.size();
			        		Word word = new Word(key, txtFrom, txtTo, 0);
			        		allTopicWords.add(word);
			        		l = 0;
			        		txtFrom = line;
	            	}	
	            	l++;
	            	i++;
	            }
		        if(l==3){
		        	int key = allTopicWords.size();
	        		Word word = new Word(key, txtFrom, txtTo, 0);
	        		allTopicWords.add(word);		        	
		        }
		    }
		    finally {
		           reader.close();
		    }
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File " + filePath + "is not found!");
			//e.printStackTrace();
			//System.exit(-1);
		}
	}

}
