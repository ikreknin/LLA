package lv.bc.views;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class View {

	private JFrame frame;
	private JLabel label;
	private JButton buttonQuestion; 
	private JButton buttonAnswer1;
	private JButton buttonAnswer2;
	private JButton buttonAnswer3;
	private JButton buttonAnswer4;
	

	public View(String text) {
		frame = new JFrame("Language Learning Application");
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setSize(600, 800);
		frame.setSize(320, 480);

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

	public void setText(String text) {
		label.setText(text);
	}

}