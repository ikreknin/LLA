package lv.bc.models;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MenuList {
	List<String> languageMenu;
	List<String> topicMenu;
	
	public MenuList(String langMenu) {
		super();
		initalize(langMenu);
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


	public void setTopicMenu(String lng) {
		String dir = System.getProperty("user.dir");
		String filePath = dir + "/file/";
		
		if(lng == null)
		   lng = "LAT-ENG";
		
		String topicPath = filePath + lng + "/";
	    System.out.println(topicPath);
		
		DirectoryStream<Path> paths;
		try {
		 paths = Files.newDirectoryStream(Paths.get(topicPath));
		 for (Iterator<Path> iterator = paths.iterator(); iterator.hasNext();) {
			  Path path = iterator.next();
			  System.out.println(path.getFileName().toString()); // The filename here is correct
		 }
		} catch (IOException e) {
				// TODO Auto-generated catch block
			System.out.println("!!!!Wrong path name: " + topicPath);
			e.printStackTrace();
		}
	}

	public void initalize(String langMenu){
		languageMenu = new ArrayList<String>();
		topicMenu = new ArrayList<String>();
		setLanguageMenu();
		setTopicMenu(langMenu);	    
	}

}
