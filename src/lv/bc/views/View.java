package lv.bc.views;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.Normalizer;
import java.util.regex.Pattern;
public class View {

	private final String applicationTitle = "Language Learning Application";
	private JMenuBar menuBar;
	private JFrame frame;
	private JButton buttonQuestion; 
	private JButton buttonAnswer1;
	private JButton buttonAnswer2;
	private JButton buttonAnswer3;
	private JButton buttonAnswer4;
	private JMenu fileMenu;
	private JMenu modeMenu;
	private JMenu optionsMenu;
	private JMenu helpMenu;
	private JMenuItem menuItemOpen;
	private JMenuItem menuItemSave;
	private JMenuItem menuItemReset;
	private JMenuItem menuItemExit;
	private JCheckBoxMenuItem menuItemSilent;
	private JCheckBoxMenuItem menuItemAudio;
	private JCheckBoxMenuItem menuItemText;
	private JRadioButtonMenuItem menuItemFN;
	private JRadioButtonMenuItem menuItemNF;
	private JMenuItem menuItemLatvian;
	private JMenuItem menuItemEnglish;
	private JMenuItem menuItemHelp;
	private JMenuItem menuItemAbout;
	public String lang = "";
	public String topic = "";
	public JComboBox topicsList;
	public JComboBox languageList;
	public JButton okButton = new JButton("OK"); 
	public JButton nextQuestion;
	public String[] choices;
	public String[] topics;
	public String[] topicsLv = {"Animals","Family"};
	public String[] topicsEng = {"Dzīvnieki","Ģimene"};
	
	public JFrame getFrame() {
		return frame;
	}
	
	public View(String text) {
		frame = new JFrame();
		frame.setTitle(applicationTitle);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 800);
		
		// JPanel that holds all the other panels
		final JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		Border paneEdge = BorderFactory.createEmptyBorder(0,30,40,30);
		((JComponent) mainPanel).setBorder(paneEdge);
		GridBagConstraints cpnl = new GridBagConstraints();
		
		// JPanel for choosing language
		JPanel languagePanel = new JPanel();
		JLabel lbl = new JLabel("Select one of the possible language choices");
	    languagePanel.add(lbl);
	    choices = new String [2];
	    choices[0] = "LAT-ENG"; choices[1] = "ENG-LAT";
	    languageList = new JComboBox(choices);
	    languageList.setSelectedIndex(0);
	    languageList.setVisible(true);
	    languagePanel.add(languageList);
	    cpnl.gridx = 0;
        cpnl.gridy = 0;
        cpnl.insets = new Insets(15,0,0,0);  //top padding
        mainPanel.add(languagePanel, cpnl);
       
        
        // JPanel for choosing topic
		JPanel topicPanel = new JPanel();
	    topics = topicsEng;
	    topicsList = new JComboBox();
	    DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(topics);
	    topicsList.setModel(comboBoxModel);
	    topicsList.setSelectedIndex(0);
	    topicsList.setVisible(true);
	    topicPanel.add(topicsList);
	    cpnl.gridx = 0;
        cpnl.gridy = 1;
        cpnl.insets = new Insets(15,0,0,0); 
        topicPanel.add(okButton);
        mainPanel.add(topicPanel, cpnl);
       
		
        // JPanel for Question buttons
	    JPanel pane = new JPanel();
	    mainPanel.add(pane);
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
        buttonQuestion = new JButton("Māja (Hardcoded option)");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 50;      //make this component tall
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 0.0;   //request any extra vertical space
        c.weightx = 1.0;
        c.anchor = GridBagConstraints.PAGE_START; //bottom of space
        c.insets = new Insets(10,0,0,0);  //top padding
        buttonQuestion.setBorderPainted(false);
        buttonQuestion.setFocusPainted(false);
        buttonQuestion.setFocusable(false);
        buttonQuestion.setContentAreaFilled(false);
        buttonQuestion.setFont(new Font("Arial", Font.PLAIN, 40));
//        pane.add(comp, c);
        pane.add(buttonQuestion, c); // c = constraints
        
        buttonAnswer1 = new JButton("House");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;      //make this component tall
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 0.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_START; //bottom of space
        c.insets = new Insets(0,0,0,0);  //top padding
        buttonAnswer1.setFont(new Font("Arial", Font.PLAIN, 30));
        pane.add(buttonAnswer1, c);  
		
        buttonAnswer2 = new JButton("Mouse");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;      //make this component tall
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 1.0;
        c.weighty = 0.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_START; //bottom of space
        c.insets = new Insets(25,0,0,0);  //top padding
        buttonAnswer2.setFont(new Font("Arial", Font.PLAIN, 30));
        pane.add(buttonAnswer2, c); 
    
        buttonAnswer3 = new JButton("Work");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;      //make this component tall
        c.gridx = 0;
        c.gridy = 3;
        c.weightx = 1.0;
        c.weighty = 0.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_START; //bottom of space
        c.insets = new Insets(25,0,0,0);  //top padding
        buttonAnswer3.setFont(new Font("Arial", Font.PLAIN, 30));
        pane.add(buttonAnswer3, c);   
        
        buttonAnswer4 = new JButton("Fork");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;      //make this component tall
        c.gridx = 0;
        c.gridy = 4;
        c.weightx = 1.0;
        c.weighty = 0.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_START; //bottom of space
        c.insets = new Insets(25,0,0,0);  //top padding
        buttonAnswer4.setFont(new Font("Arial", Font.PLAIN, 30));
        pane.add(buttonAnswer4, c); 
        
	    cpnl.gridx = 0;
        cpnl.gridy = 2;
        mainPanel.add(pane, cpnl);
        
    	//Create the menu bar.
    	menuBar = new JMenuBar();
    	//Build the first menu.
    	fileMenu = new JMenu("File");
    	menuBar.add(fileMenu);

    	menuItemSave = new JMenuItem("Save");
    	fileMenu.add(menuItemSave);

    	menuItemReset = new JMenuItem("Reset");
    	fileMenu.add(menuItemReset);
    	
    	fileMenu.addSeparator(); // --------------------------
    	
    	menuItemExit = new JMenuItem("Exit");
    	fileMenu.add(menuItemExit);

    	modeMenu = new JMenu("Mode");
    	menuBar.add(modeMenu);
    	
    	menuItemAudio = new JCheckBoxMenuItem("Audio");
    	modeMenu.add(menuItemAudio);
    	
    	menuItemText = new JCheckBoxMenuItem("Text");
    	menuItemText.setSelected(true);
    	modeMenu.add(menuItemText);
    	
    	modeMenu.addSeparator(); // --------------------------
    	
    	ButtonGroup group = new ButtonGroup();
    	menuItemFN = new JRadioButtonMenuItem("Foreign to Native");
    	menuItemFN.setSelected(true);
    	group.add(menuItemFN);
    	modeMenu.add(menuItemFN);
    	
    	menuItemNF = new JRadioButtonMenuItem("Native to Foreign");
    	group.add(menuItemNF);
    	modeMenu.add(menuItemNF);
    	
    	optionsMenu = new JMenu("Language");
    	menuItemLatvian = new JMenuItem("lv-LV");
    	menuItemEnglish = new JMenuItem("en-US");
    	optionsMenu.add(menuItemLatvian);
    	optionsMenu.add(menuItemEnglish);
    	menuBar.add(optionsMenu);
    	
    	helpMenu = new JMenu("Help");
    	menuItemAbout = new JMenuItem("About");
    	menuItemHelp = new JMenuItem("Help");
    	helpMenu.add(menuItemHelp);
    	helpMenu.add(menuItemAbout);
    	menuBar.add(helpMenu);        
        
    	frame.add(mainPanel);
    	frame.setJMenuBar(menuBar);
		frame.setVisible(true);
	}

	public JButton getQuestionButton() {
		return buttonQuestion;
	}
	
	public JButton getAnswerButton1() {
		return buttonAnswer1;
	}	
	
	public JButton getAnswerButton2() {
		return buttonAnswer2;
	}	
	
	public JButton getAnswerButton3() {
		return buttonAnswer3;
	}	
	
	public JButton getAnswerButton4() {
		return buttonAnswer4;
	}	

	public void setTextQuestion(String text) {
		buttonQuestion.setText(text);
	}
	
	public void setTextAnswer1(String text) {
		buttonAnswer1.setText(text);
	}
	
	public void setTextAnswer2(String text) {
		buttonAnswer2.setText(text);
	}
	
	public void setTextAnswer3(String text) {
		buttonAnswer3.setText(text);
	}
	
	public void setTextAnswer4(String text) {
		buttonAnswer4.setText(text);
	}

	public JMenuItem getMenuItemOpen() {
		return menuItemOpen;
	}

	public JMenuItem getMenuItemSave() {
		return menuItemSave;
	}

	public JMenuItem getMenuItemReset() {
		return menuItemReset;
	}

	public JMenuItem getMenuItemExit() {
		return menuItemExit;
	}

	public JCheckBoxMenuItem getMenuItemSilent() {
		return menuItemSilent;
	}

	public JCheckBoxMenuItem getMenuItemAudio() {
		return menuItemAudio;
	}

	public JCheckBoxMenuItem getMenuItemText() {
		return menuItemText;
	}

	public JRadioButtonMenuItem getMenuItemFN() {
		return menuItemFN;
	}

	public JRadioButtonMenuItem getMenuItemNF() {
		return menuItemNF;
	}

	public JMenuItem getMenuItemLanguage() {
		return null;
	}
	
	public JMenuItem getMenuItemLatvian() {
		return menuItemLatvian;
	}
	
	public JMenuItem getMenuItemEnglish() {
		return menuItemEnglish;
	}	
	
	public JMenuItem getMenuItemHelp() {
		return menuItemHelp;
	}
	
	public String deAccent(String str) {
	    String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
	    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	    return pattern.matcher(nfdNormalizedString).replaceAll("");
	}
}