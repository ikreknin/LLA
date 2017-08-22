package lv.bc.models;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MenuList {
	List<String> languageMenu;
	List<String> topicMenu;
	
	public MenuList() {
		super();
		initalize();
	}
		
	public List<String> getLanguageMenu() {
		return languageMenu;
	}

	public void setLanguageMenu() {
		String dir = System.getProperty("user.dir");
		String filePath = dir + "/file/";
        File[] files = new File(filePath).listFiles();

	    for (File file : files) {
	    	System.out.println("File: " + file.getName());
		    if (file.isDirectory()) {
		       languageMenu.add(file.getName());
		   } 
		}
	}

	public List<String> getTopicMenu() {
		return topicMenu;
	}


	public void setTopicMenu() {
		String dir = System.getProperty("user.dir");
		String filePath = dir + "/file/";
		for(String s : languageMenu){
			String topicPath = filePath +s + "/";
			System.out.println(topicPath);
			File[] files = new File(topicPath).listFiles();
			for (File file : files) {
		    	System.out.println("File: " + file.getName());
			    if (file.isDirectory()) {
			       topicMenu.add(file.getName());
			   } 
			}
		}	

	}

	public void initalize(){
		languageMenu = new ArrayList<String>();
		topicMenu = new ArrayList<String>();
		setLanguageMenu();
		setTopicMenu();	    
	}

}
