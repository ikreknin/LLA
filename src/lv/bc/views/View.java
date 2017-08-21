package lv.bc.views;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

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
	private	JButton playButton;
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
	public JProgressBar progressBar;
	public JLabel scoreLabel;
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
	public int score = 0;
	
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
//		mainPanel.setBackground(Color.DARK_GRAY);
		Border paneEdge = BorderFactory.createEmptyBorder(0,30,40,30); // (top, left, bottom, right)
		((JComponent) mainPanel).setBorder(paneEdge);
		GridBagConstraints cpnl = new GridBagConstraints();
		cpnl.fill = GridBagConstraints.HORIZONTAL;
		
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
        cpnl.insets = new Insets(10,10,0,10);  // add paddings to control span width
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
		
        // *GridLayout JPanel for holding the progress bar
        JPanel progressPanel = new JPanel();
//        progressPanel.setBackground(Color.PINK);
        progressPanel.setLayout(new GridLayout(1, 1));
        progressPanel.setBorder(new EmptyBorder(10, 0, 10, 0)); // 10px top and bottom padding
        progressBar = ScoreBar.makeBar();
        progressBar.setValue(5);
        progressPanel.add(progressBar);
//        progressPanel.add(new JProgressBar(0, 100));
	    cpnl.gridx = 0;
        cpnl.gridy = 2;
        cpnl.insets = new Insets(0, 5, 0, 5);  // add paddings to control span width        
        mainPanel.add(progressPanel, cpnl);
        
        // *FlowLayout JPanel for writing the score
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new GridLayout(1,1));
        scoreLabel = new JLabel("Score: " + score);
        scorePanel.add(scoreLabel);
	    cpnl.gridx = 0;
        cpnl.gridy = 3;
        cpnl.insets = new Insets(0, 5, 0, 5);  // add paddings to control span width 
        mainPanel.add(scorePanel, cpnl);
        
        // JPanel for Question buttons
	    JPanel buttonPanel = new JPanel();
	    mainPanel.add(buttonPanel);
		buttonPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JPanel questionPanel = new JPanel();
//		questionPanel.setBackground(Color.YELLOW);
		questionPanel.setLayout(new FlowLayout());
		
        buttonQuestion = new JButton("Māja (Hardcoded option)");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;      //make this component tall
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 0.0;   //request any extra vertical space
        c.weightx = 1.0;
        c.anchor = GridBagConstraints.PAGE_START; //bottom of space
        c.insets = new Insets(10,0,0,0);  //top padding // (top, left, bottom, right)
        buttonQuestion.setBorderPainted(false);
        buttonQuestion.setFocusPainted(false);
        buttonQuestion.setFocusable(false);
        buttonQuestion.setContentAreaFilled(false);
        buttonQuestion.setFont(new Font("Arial", Font.PLAIN, 40));
		playButton = new JButton("Button 2 (CENTER)");
		playButton.setPreferredSize(new Dimension(75, 75));
		try {
			ImageIcon icon = createImageIcon("images/300px-centered-gradient-Speaker_Icon.svg.png");
			playButton.setIcon(icon);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		questionPanel.add(buttonQuestion, BorderLayout.CENTER);
		questionPanel.add(playButton, BorderLayout.LINE_END);
        buttonPanel.add(questionPanel, c); // c = constraints
        
        buttonAnswer1 = new JButton("House");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30;      //make this component tall
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 0.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_START; //bottom of space
        c.insets = new Insets(0,0,0,0);  //top padding
        buttonAnswer1.setFont(new Font("Arial", Font.PLAIN, 30));
        buttonPanel.add(buttonAnswer1, c);  
		
        buttonAnswer2 = new JButton("Mouse");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30;      //make this component tall
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 1.0;
        c.weighty = 0.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_START; //bottom of space
        c.insets = new Insets(15,0,0,0);  //top padding
        buttonAnswer2.setFont(new Font("Arial", Font.PLAIN, 30));
        buttonPanel.add(buttonAnswer2, c); 
    
        buttonAnswer3 = new JButton("Work");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30;      //make this component tall
        c.gridx = 0;
        c.gridy = 3;
        c.weightx = 1.0;
        c.weighty = 0.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_START; //bottom of space
        c.insets = new Insets(15,0,0,0);  //top padding
        buttonAnswer3.setFont(new Font("Arial", Font.PLAIN, 30));
        buttonPanel.add(buttonAnswer3, c);   
        
        buttonAnswer4 = new JButton("Fork");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30;      //make this component tall
        c.gridx = 0;
        c.gridy = 4;
        c.weightx = 1.0;
        c.weighty = 0.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_START; //bottom of space
        c.insets = new Insets(15,0,0,0);  //top padding
        buttonAnswer4.setFont(new Font("Arial", Font.PLAIN, 30));
        buttonPanel.add(buttonAnswer4, c); 
        
	    cpnl.gridx = 0;
        cpnl.gridy = 4;
        cpnl.insets = new Insets(0, 60, 0, 60);
        mainPanel.add(buttonPanel, cpnl);
        
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
	
    /** Returns an ImageIcon, or null if the path was invalid. */
    public ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
//        button.setIcon(new ImageIcon(img));
    }
    
    /**
     * Updates the score and reflects those changes in 
     * @see ScoreBar (progressBar) and scoreLabel
     * @param score
     */
    public void setScore(int score) {
    	progressBar.setValue(score);
    	scoreLabel.setText("Score: " + String.valueOf(score));
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