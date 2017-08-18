package lv.bc.myview;

import java.io.File;
import java.io.IOException;
import java.awt.Desktop; 
import java.net.URI;
//import java.net.URISyntaxException;


public class Browse {

// Open HTML file in default browser
	
//	Test HTML file String url="/home/student/IDEs/LLA/help.html";
	
public static void openInBrowser(String url) throws IOException  {
	
   try {
	
   String path=new File(url).getAbsolutePath();
   
   File htmlFile = new File(path);   

   //System.out.println("openInBrowser print file URI  " + htmlFile.toURI());
	
   Desktop.getDesktop().browse(htmlFile.toURI());

} 
	
catch (IOException e) {
//	catch block
e.printStackTrace();
}

}

//to test openInBrowser(String url)
public static void main(String[] args) throws IOException {
	
	String filepath="help.html";
    openInBrowser(filepath);
}
}