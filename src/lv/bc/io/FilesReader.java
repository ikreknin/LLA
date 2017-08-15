package lv.bc.io;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesReader {
	private String fileName;
	private List<Topic> topicList;
	private int pointer;
    private int totalGroupAnswers = 0;
	public FilesReader(String fileName) {
		super();
		this.fileName = fileName;
		this.pointer = 0;
		topicList = new ArrayList<Topic>();
		try {
			initializeTopic();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// read from necessary file and row the word
	// and fill in textFrom and textTo
	public void initializeTopic() throws IOException{
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
            		//1:Save previous Topic to Array
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
	    	    this.pointer = i;// hast to be 12 for first time olr less if in file is less then 4 words
	    }
	    finally {
	           reader.close();
	    }
	  	
	}
	    
    	//1: read 4 new words from file 
    	
    	//2:make random method to mix 2nd, 3rd, 4th Topic in List
	public void mixList(String answer){
		if(topicList.get(0).equals(answer)){
		   topicList.get(0).setCount(topicList.get(0).getCount()+1); 
		   totalGroupAnswers++;
		   // the FIRST element in array is word for translation
		   // mix all topics in list so,
		   // that previous will not be the first again and 
		   // also the Topic with count = 3 also can not be the first again
		   
		}
	}
    	
    	// make logic if answer success then 
    	// regenrate random and save count +1 to necessary array object,
    	// if not, then just random regeneration 
    	// if all words in list was passed, then 
    	
    	//3:save sucess study result of 4 words and update file
    	
    	//4:take the next 4 
  
}
