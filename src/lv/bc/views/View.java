package lv.bc.views;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.KeyEvent;

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
	private String buttonQuestionString = "";
	private String buttonAnswer1String = "";
	private String buttonAnswer2String = "";
	private String buttonAnswer3String = "";
	private String buttonAnswer4String = "";

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

		Container pane = frame.getContentPane();
		pane.setLayout(new GridBagLayout());
		Border paneEdge = BorderFactory.createEmptyBorder(0,30,40,30);
		((JComponent) pane).setBorder(paneEdge);
		GridBagConstraints c = new GridBagConstraints();
		
        buttonQuestion = new JButton(buttonQuestionString);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;      //make this component tall
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
        
        buttonAnswer1 = new JButton(buttonAnswer1String);
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
		
        buttonAnswer2 = new JButton(buttonAnswer2String);
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
    
        buttonAnswer3 = new JButton(buttonAnswer3String);
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
        
        buttonAnswer4 = new JButton(buttonAnswer4String);
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
}