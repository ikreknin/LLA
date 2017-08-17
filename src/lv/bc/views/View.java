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
	public String lang = "";
	public String topic = "";
	String[] topics;
	String[] topics1 = {"Animals","Family"};
	String[] topics2 = {"Dzīvnieki","Ģimene"};
	JComboBox topicsList;
	public JButton okButton = new JButton("OK"); 
	
	public JFrame getFrame() {
		return frame;
	}
	
	public View(String text) {
		frame = new JFrame();
		frame.setTitle(applicationTitle);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 800);
		// frame.setSize(320, 480);
		
		final JPanel mainPanel = new JPanel();
//		GridLayout experimentLayout = new GridLayout(2,1);
		mainPanel.setLayout(new GridBagLayout());
//		frame.setLayout(experimentLayout);
		GridBagConstraints cpnl = new GridBagConstraints();
		
		JPanel languagePanel = new JPanel();
		JLabel lbl = new JLabel("Select one of the possible language choices");
	    lbl.setVisible(true);
	    languagePanel.add(lbl);
	    String[] choices = { "LAT-ENG","ENG-LAT"};
	    JComboBox languageList = new JComboBox(choices);
	    languageList.setSelectedIndex(0);
	    languageList.addActionListener(null);
	    languageList.setVisible(true);
	    languagePanel.add(languageList);
	    cpnl.gridx = 0;
        cpnl.gridy = 0;
        cpnl.insets = new Insets(15,0,0,0);  //top padding
        mainPanel.add(languagePanel, cpnl);
        ActionListener actionListenerLanguage = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				String selectedString = (String)cb.getSelectedItem();
				System.out.println("Selected from dropdown: " + selectedString);
//				updateLabel(petName);
				lang = deAccent(selectedString);
				System.out.println(lang);
				if (selectedString == "LAT-ENG") {
					DefaultComboBoxModel comboBoxModel1 = new DefaultComboBoxModel( topics2 );
					topicsList.setModel( comboBoxModel1 );
				} else {
					DefaultComboBoxModel comboBoxModel2 = new DefaultComboBoxModel( topics1 );
					topicsList.setModel( comboBoxModel2 );
				}
			}
		};
        languageList.addActionListener(actionListenerLanguage);
        
		JPanel topicPanel = new JPanel();
	    topics = topics2;
	    topicsList = new JComboBox();
	    DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel( topics );
	    topicsList.setModel(comboBoxModel);
	    topicsList.setSelectedIndex(0);
	    topicsList.addActionListener(null);
	    topicsList.setVisible(true);
	    topicPanel.add(topicsList);
	    cpnl.gridx = 0;
        cpnl.gridy = 1;
        topicPanel.add(okButton);
        mainPanel.add(topicPanel, cpnl);
        ActionListener actionListenerTopic = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				String selectedString = (String)cb.getSelectedItem();
				topic = deAccent(selectedString);
				System.out.println(topic);
				System.out.println("Selected from dropdown: " + selectedString);
//				updateLabel(petName);
			}
		};
        topicsList.addActionListener(actionListenerTopic);
		
	    JPanel pane = new JPanel();
	    mainPanel.add(pane);
//		Container pane = frame.getContentPane();
		pane.setLayout(new GridBagLayout());
		Border paneEdge = BorderFactory.createEmptyBorder(0,30,40,30);
		((JComponent) pane).setBorder(paneEdge);
		GridBagConstraints c = new GridBagConstraints();
		
        buttonQuestion = new JButton("Māja (Hardcoded option)");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 50;      //make this component tall
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 1.0;   //request any extra vertical space
        c.weightx = 0.5;
        c.anchor = GridBagConstraints.PAGE_START; //bottom of space
        c.insets = new Insets(100,0,0,0);  //top padding
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
        c.weightx = 0.0;
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
        c.weightx = 0.0;
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
        c.weightx = 0.0;
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
        c.weightx = 0.0;
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
    	fileMenu.setMnemonic(KeyEvent.VK_A);
//    	menu.getAccessibleContext().setAccessibleDescription(
//    	        "The only menu in this program that has menu items");
    	menuBar.add(fileMenu);

    	//a group of JMenuItems
    	menuItemOpen = new JMenuItem("Open", KeyEvent.VK_T);
//    	menuItem.setAccelerator(KeyStroke.getKeyStroke(
//    	        KeyEvent.VK_1, ActionEvent.ALT_MASK));
    	fileMenu.add(menuItemOpen);

    	menuItemSave = new JMenuItem("Save");
//    	menuItem.setMnemonic(KeyEvent.VK_B);
    	fileMenu.add(menuItemSave);

    	menuItemReset = new JMenuItem("Reset");
//    	menuItem.setMnemonic(KeyEvent.VK_D);
    	fileMenu.add(menuItemReset);
    	
    	fileMenu.addSeparator(); // --------------------------
    	
    	menuItemExit = new JMenuItem("Exit");
//    	menuItem.setMnemonic(KeyEvent.VK_D);
    	fileMenu.add(menuItemExit);

    	modeMenu = new JMenu("Mode");
    	menuBar.add(modeMenu);
    	
    	menuItemSilent = new JCheckBoxMenuItem("Silent");
//    	cbMenuItem.setMnemonic(KeyEvent.VK_C);
    	modeMenu.add(menuItemSilent);

    	menuItemAudio = new JCheckBoxMenuItem("Audio");
//    	cbMenuItem.setMnemonic(KeyEvent.VK_H);
    	modeMenu.add(menuItemAudio);
    	
    	menuItemText = new JCheckBoxMenuItem("Text");
    	menuItemText.setSelected(true);
//    	cbMenuItem.setMnemonic(KeyEvent.VK_H);
    	modeMenu.add(menuItemText);
    	
    	modeMenu.addSeparator(); // --------------------------
    	
    	ButtonGroup group = new ButtonGroup();
    	menuItemFN = new JRadioButtonMenuItem("Foreign to Native");
    	menuItemFN.setSelected(true);
    	group.add(menuItemFN);
    	modeMenu.add(menuItemFN);
    	
    	menuItemNF = new JRadioButtonMenuItem("Native to Foreign");
//    	menuItemNF.setMnemonic(KeyEvent.VK_O);
    	group.add(menuItemNF);
    	modeMenu.add(menuItemNF);
    	
    	optionsMenu = new JMenu("Language");
    	menuItemLatvian = new JMenuItem("lv-LV");
    	menuItemEnglish = new JMenuItem("en-US");
    	optionsMenu.add(menuItemLatvian);
    	optionsMenu.add(menuItemEnglish);
    	menuBar.add(optionsMenu);
    	
    	helpMenu = new JMenu("Help");
    	menuItemHelp = new JMenuItem("Help");
    	helpMenu.add(menuItemHelp);
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