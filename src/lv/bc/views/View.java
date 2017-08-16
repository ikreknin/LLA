package lv.bc.views;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;

public class View {

	private JMenuBar menuBar;
	private JFrame frame;
	private JButton buttonQuestion; 
	private JButton buttonAnswer1;
	private JButton buttonAnswer2;
	private JButton buttonAnswer3;
	private JButton buttonAnswer4;
	String buttonQuestionString; // TODO
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
	private JMenuItem menuItemLanguage;

	public View(String text) {
		frame = new JFrame("Language Learning Application");
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 800);
		// frame.setSize(320, 480);

		Container pane = frame.getContentPane();
		pane.setLayout(new GridBagLayout());
		Border paneEdge = BorderFactory.createEmptyBorder(0,10,10,10);
		((JComponent) pane).setBorder(paneEdge);
		GridBagConstraints c = new GridBagConstraints();
		
        buttonQuestion = new JButton("Foreign_Test_Word");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;      //make this component tall
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 1.0;   //request any extra vertical space
        c.weightx = 0.5;
        c.anchor = GridBagConstraints.PAGE_START; //bottom of space
        c.insets = new Insets(30,0,0,0);  //top padding
        buttonQuestion.setBorderPainted(false);
        buttonQuestion.setFocusPainted(false);
        buttonQuestion.setFocusable(false);
        buttonQuestion.setContentAreaFilled(false);
//        pane.add(comp, c);
        pane.add(buttonQuestion, c); // c = constraints
        
        buttonAnswer1 = new JButton("Native_Word_1");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;      //make this component tall
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0.0;
        c.weighty = 0.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_START; //bottom of space
        c.insets = new Insets(0,0,0,0);  //top padding
        pane.add(buttonAnswer1, c);  
		
        buttonAnswer2 = new JButton("Native_Word_2");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;      //make this component tall
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 0.0;
        c.weighty = 0.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_START; //bottom of space
        c.insets = new Insets(10,0,0,0);  //top padding
        pane.add(buttonAnswer2, c); 
    
        buttonAnswer3 = new JButton("Native_Word_3");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;      //make this component tall
        c.gridx = 0;
        c.gridy = 3;
        c.weightx = 0.0;
        c.weighty = 0.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_START; //bottom of space
        c.insets = new Insets(10,0,0,0);  //top padding
        pane.add(buttonAnswer3, c);   
        
        buttonAnswer4 = new JButton("Native_Word_4");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;      //make this component tall
        c.gridx = 0;
        c.gridy = 4;
        c.weightx = 0.0;
        c.weighty = 0.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_START; //bottom of space
        c.insets = new Insets(10,0,0,0);  //top padding
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
    	
    	fileMenu.addSeparator();
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
    	
    	ButtonGroup group = new ButtonGroup();
    	menuItemFN = new JRadioButtonMenuItem("A radio button menu item");
    	menuItemFN.setSelected(true);
    	group.add(menuItemFN);
    	modeMenu.add(menuItemFN);
    	
    	menuItemNF = new JRadioButtonMenuItem("Another one");
//    	menuItemNF.setMnemonic(KeyEvent.VK_O);
    	group.add(menuItemNF);
    	modeMenu.add(menuItemNF);
    	
    	optionsMenu = new JMenu("Options");
    	menuItemLanguage = new JMenuItem("Language");
    	menuBar.add(optionsMenu);
    	
    	helpMenu = new JMenu("Help");
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

	public void setTextAnswer1(String text) {
		buttonQuestion.setText(text);
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
		return menuItemLanguage;
	}
	
}