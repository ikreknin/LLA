package lv.bc.editor.views;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class View {

	private final String applicationTitle = "Language Learning Application Editor";
	private JMenuBar menuBar;
	private JFrame frame;
	private JMenu fileMenu;
	private JMenu optionsMenu;
	private JMenu modeMenu;
	private JMenu helpMenu;
	private JMenuItem menuItemOpen;
	private JMenuItem menuItemSave;
	private JMenuItem menuItemExit;
	private JRadioButtonMenuItem menuItemLanguageNative, menuItemLanguageForeign;
	private JMenuItem menuItemToApp;
	private JMenuItem menuItemHelp;
	private JMenuItem menuItemAbout;

	private JLabel label;
	private JLabel labelTopicName;
	private JLabel labelDirection;

	public JComboBox topicsList;
	DefaultComboBoxModel comboBoxModel;
	private JTextField textFieldTopicName;

	private JTextField textFieldN00;
	private JTextField textFieldN01;
	private JTextField textFieldN02;
	private JTextField textFieldN10;
	private JTextField textFieldN11;
	private JTextField textFieldN12;
	private JTextField textFieldN20;
	private JTextField textFieldN21;
	private JTextField textFieldN22;
	private JTextField textFieldN30;
	private JTextField textFieldN31;
	private JTextField textFieldN32;

	private String n00 = "";
	private String n01 = "";
	private String n02 = "";
	private String n10 = "";
	private String n11 = "";
	private String n12 = "";
	private String n20 = "";
	private String n21 = "";
	private String n22 = "";
	private String n30 = "";
	private String n31 = "";
	private String n32 = "";

	private JButton recordButton0;
	private JButton recordButton1;
	private JButton recordButton2;
	private JButton recordButton3;

	private JButton playButton0;
	private JButton playButton1;
	private JButton playButton2;
	private JButton playButton3;

	private JButton new4Button;
	private JButton backButton;
	private JButton forwardButton;
	private JButton saveButton;
	private JButton nativeButton;
	private JButton foreignButton;

	private String langRecord = "Record";
	private String langPlay = "Play";
	private String langSave = "Save";
	private String langBack = "Back";
	private String langForward = "Next";
	private String langFile = "File";
	private String langOpen = "Open";
	private String langExit = "Exit";
	private String langOptions = "Options";
	private String langLanguageNative = "English";
	private String langLanguageForeign = "Latvian";
	private String langNew4 = "New 4";
	
	private String modeText = "Mode";
	private String toAppText = "Switch to App";

	private String langHelp = "Help";
	private String langAbout = "About";
	private String langNative = "English";
	private String langForeign = "Latvian";

	private String langTopicName = "     " + "Topic:";
	private String langDirection = "Direction:";

	private String[] topics;
	// private ArrayList<String> topics = new ArrayList<>();
	private ArrayList<String> topicsForeign = new ArrayList<>();

	public ArrayList<String> getTopicsForeign() {
		return topicsForeign;
	}

	public void setTopicsForeign(ArrayList<String> topicsForeign) {
		this.topicsForeign = topicsForeign;
	}

	public ArrayList<String> getTopicsNative() {
		return topicsNative;
	}

	public void setTopicsNative(ArrayList<String> topicsNative) {
		this.topicsNative = topicsNative;
	}

	private ArrayList<String> topicsNative = new ArrayList<>();
	private JButton okButton = new JButton("OK");

	int fontSize;

	public JFrame getFrame() {
		return frame;
	}

	public View() {

		// ComboBox initialization
		File file = new File(System.getProperty("user.dir") + "/file/LAT-ENG");
		String[] names = file.list();
		for (String name : names) {
			if (new File(System.getProperty("user.dir") + "/file/LAT-ENG/" + name).isDirectory()) {
				topicsNative.add(name);
			}
		}

		fontSize = 24;

		frame = new JFrame();
		frame.setTitle(applicationTitle);
		try {
			java.net.URL resource = lv.bc.views.View.class.getResource("images/LLA_20x20v2.png");
			ImageIcon appIcon = new ImageIcon(resource);
			frame.setIconImage(appIcon.getImage());
		} catch (Exception ex) {
			System.out.println(ex);
		}
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		label = new JLabel("LLA Editor");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.0;
		c.weighty = 0.1;
		c.anchor = GridBagConstraints.PAGE_START;
		c.insets = new Insets(10, 10, 10, 10);
		label.setFont(new Font("Arial", Font.PLAIN, fontSize));
		panel.add(label, c);

		GridBagConstraints cpnl = new GridBagConstraints();
		JPanel topicPanel = new JPanel();
		topics = new String[topicsNative.size()];
		topics = topicsNative.toArray(topics);
		setTopicsList(new JComboBox());
		resetComboBox(topicsNative);
		getTopicsList().setSelectedIndex(0);
		getTopicsList().setVisible(true);
		topicPanel.add(getTopicsList());
		cpnl.gridx = 1;
		cpnl.gridy = 1;
		cpnl.insets = new Insets(15, 0, 0, 0);
		topicPanel.add(okButton);
		panel.add(topicPanel, cpnl);

		labelTopicName = new JLabel(langTopicName);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 0;
		c.gridy = 2;
		c.weightx = 0.0;
		c.weighty = 0.1;
		c.anchor = GridBagConstraints.PAGE_START;
		c.insets = new Insets(10, 10, 10, 10);
		labelTopicName.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(labelTopicName, c);

		textFieldTopicName = new JTextField("");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 1;
		c.gridy = 2;
		c.weightx = 0.0;
		c.weighty = 0.1;
		c.anchor = GridBagConstraints.PAGE_START;
		c.insets = new Insets(10, 10, 10, 10);
		textFieldTopicName.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(textFieldTopicName, c);

		GridBagConstraints cpnlb = new GridBagConstraints();
		JPanel dirPanel = new JPanel();
		labelDirection = new JLabel(langDirection);
		cpnlb.fill = GridBagConstraints.HORIZONTAL;
		cpnlb.ipadx = 0;
		cpnlb.ipady = 0;
		cpnlb.gridx = 2;
		cpnlb.gridy = 0;
		cpnlb.weightx = 0.0;
		cpnlb.weighty = 0.1;
		cpnlb.anchor = GridBagConstraints.PAGE_START;
		cpnlb.insets = new Insets(10, 10, 10, 10);
		foreignButton = new JButton(langForeign);
		foreignButton.setFont(new Font("Arial", Font.PLAIN, 18));
		dirPanel.add(foreignButton);
		JLabel to = new JLabel(">");
		dirPanel.add(to);
		nativeButton = new JButton(langNative);
		nativeButton.setFont(new Font("Arial", Font.PLAIN, 18));
		dirPanel.add(nativeButton);
		panel.add(dirPanel, cpnlb);

		textFieldN00 = new JTextField(n00);
		textFieldN00.setEditable(false);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 0;
		c.gridy = 3;
		c.weightx = 0.0;
		c.weighty = 0.01;
		c.insets = new Insets(10, 10, 10, 10);
		textFieldN00.setFont(new Font("Arial", Font.PLAIN, fontSize));
		panel.add(textFieldN00, c);

		textFieldN01 = new JTextField(n01);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 1;
		c.gridy = 3;
		c.weightx = 600.0;
		c.weighty = 0.0;
		c.insets = new Insets(10, 10, 10, 10);
		textFieldN01.setFont(new Font("Arial", Font.PLAIN, fontSize));
		panel.add(textFieldN01, c);

		textFieldN02 = new JTextField(n02);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 2;
		c.gridy = 3;
		c.weightx = 300.0;
		c.weighty = 0.0;
		c.insets = new Insets(10, 10, 10, 10);
		textFieldN02.setFont(new Font("Arial", Font.PLAIN, fontSize));
		panel.add(textFieldN02, c);

		recordButton0 = new JButton(langRecord);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 3;
		c.gridy = 3;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(10, 10, 10, 10);
		panel.add(recordButton0, c);

		playButton0 = new JButton(langPlay);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 4;
		c.gridy = 3;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(10, 10, 10, 10);
		panel.add(playButton0, c);

		textFieldN10 = new JTextField(n10);
		textFieldN10.setEditable(false);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 0;
		c.gridy = 4;
		c.weightx = 0.01;
		c.weighty = 0.0;
		c.insets = new Insets(10, 10, 10, 10);
		textFieldN10.setFont(new Font("Arial", Font.PLAIN, fontSize));
		panel.add(textFieldN10, c);

		textFieldN11 = new JTextField(n11);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 1;
		c.gridy = 4;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(10, 10, 10, 10);
		textFieldN11.setFont(new Font("Arial", Font.PLAIN, fontSize));
		panel.add(textFieldN11, c);

		textFieldN12 = new JTextField(n12);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 2;
		c.gridy = 4;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(10, 10, 10, 10);
		textFieldN12.setFont(new Font("Arial", Font.PLAIN, fontSize));
		panel.add(textFieldN12, c);

		recordButton1 = new JButton(langRecord);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 3;
		c.gridy = 4;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(10, 10, 10, 10);
		panel.add(recordButton1, c);

		playButton1 = new JButton(langPlay);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 4;
		c.gridy = 4;
		c.weightx = 0.0;
		c.weighty = 0.0;

		c.insets = new Insets(10, 10, 10, 10);
		panel.add(playButton1, c);

		textFieldN20 = new JTextField(n20);
		textFieldN20.setEditable(false);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 0;
		c.gridy = 5;
		c.weightx = 0.0;
		c.weighty = 0.01;
		c.insets = new Insets(10, 10, 10, 10);
		textFieldN20.setFont(new Font("Arial", Font.PLAIN, fontSize));
		panel.add(textFieldN20, c);

		textFieldN21 = new JTextField(n21);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 1;
		c.gridy = 5;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(10, 10, 10, 10);
		textFieldN21.setFont(new Font("Arial", Font.PLAIN, fontSize));
		panel.add(textFieldN21, c);

		textFieldN22 = new JTextField(n22);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 2;
		c.gridy = 5;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(10, 10, 10, 10);
		textFieldN22.setFont(new Font("Arial", Font.PLAIN, fontSize));
		panel.add(textFieldN22, c);

		recordButton2 = new JButton(langRecord);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 3;
		c.gridy = 5;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(10, 10, 10, 10);
		panel.add(recordButton2, c);

		playButton2 = new JButton(langPlay);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 4;
		c.gridy = 5;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(10, 10, 10, 10);
		panel.add(playButton2, c);

		textFieldN30 = new JTextField(n30);
		textFieldN30.setEditable(false);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 0;
		c.gridy = 6;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(10, 10, 10, 10);
		textFieldN30.setFont(new Font("Arial", Font.PLAIN, fontSize));
		panel.add(textFieldN30, c);

		textFieldN31 = new JTextField(n31);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 1;
		c.gridy = 6;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(10, 10, 10, 10);
		textFieldN31.setFont(new Font("Arial", Font.PLAIN, fontSize));
		panel.add(textFieldN31, c);

		textFieldN32 = new JTextField(n32);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 2;
		c.gridy = 6;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(10, 10, 10, 10);
		textFieldN32.setFont(new Font("Arial", Font.PLAIN, fontSize));
		panel.add(textFieldN32, c);

		recordButton3 = new JButton(langRecord);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 3;
		c.gridy = 6;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(10, 10, 10, 10);
		panel.add(recordButton3, c);

		playButton3 = new JButton(langPlay);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 4;
		c.gridy = 6;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(10, 10, 10, 10);
		panel.add(playButton3, c);

		new4Button = new JButton(langNew4);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 0;
		c.gridy = 7;
		c.weightx = 0.0;
		c.weighty = 0.1;
		c.anchor = GridBagConstraints.PAGE_END;
		c.insets = new Insets(10, 10, 10, 10);
		new4Button.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(new4Button, c);
		
		backButton = new JButton(langBack);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 1;
		c.gridy = 7;
		c.weightx = 0.0;
		c.weighty = 0.1;
		c.anchor = GridBagConstraints.PAGE_END;
		c.insets = new Insets(10, 10, 10, 10);
		backButton.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(backButton, c);

		forwardButton = new JButton(langForward);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 2;
		c.gridy = 7;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(10, 10, 10, 10);
		forwardButton.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(forwardButton, c);

		saveButton = new JButton(langSave);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 4;
		c.gridy = 7;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(10, 10, 10, 10);
		saveButton.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(saveButton, c);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 600);

		menuBar = new JMenuBar();

		fileMenu = new JMenu(langFile);
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);

//		menuItemOpen = new JMenuItem(langOpen, KeyEvent.VK_O);
//		fileMenu.add(menuItemOpen);
//
//		menuItemSave = new JMenuItem(langSave, KeyEvent.VK_S);
//		fileMenu.add(menuItemSave);
//
//		fileMenu.addSeparator();

		menuItemExit = new JMenuItem(langExit, KeyEvent.VK_X);
		fileMenu.add(menuItemExit);

		optionsMenu = new JMenu(langOptions);
		optionsMenu.setMnemonic(KeyEvent.VK_O);
		menuBar.add(optionsMenu);

		ButtonGroup group = new ButtonGroup();

		menuItemLanguageNative = new JRadioButtonMenuItem(langLanguageNative);
		menuItemLanguageNative.setSelected(true);
		group.add(menuItemLanguageNative);
		optionsMenu.add(menuItemLanguageNative);

		menuItemLanguageForeign = new JRadioButtonMenuItem(langLanguageForeign);
		menuItemLanguageForeign.setSelected(false);
		group.add(menuItemLanguageForeign);
		optionsMenu.add(menuItemLanguageForeign);

		modeMenu = new JMenu(modeText);
		menuItemToApp = new JMenuItem(toAppText);
		modeMenu.add(menuItemToApp);
		menuBar.add(modeMenu);
		
		helpMenu = new JMenu(langHelp);
		helpMenu.setMnemonic(KeyEvent.VK_H);
		menuBar.add(helpMenu);

		menuItemHelp = new JMenuItem(langHelp, KeyEvent.VK_L);
		helpMenu.add(menuItemHelp);

		menuItemAbout = new JMenuItem(langAbout, KeyEvent.VK_A);
		helpMenu.add(menuItemAbout);

		frame.add(panel);
		frame.setJMenuBar(menuBar);
		frame.setVisible(true);
	}

	public JMenuItem getMenuItemOpen() {
		return menuItemOpen;
	}

	public JMenuItem getMenuItemSave() {
		return menuItemSave;
	}

	public JMenuItem getMenuItemExit() {
		return menuItemExit;
	}

	public JMenuItem getMenuItemLanguageNative() {
		return menuItemLanguageNative;
	}

	public JMenuItem getMenuItemLanguageForeign() {
		return menuItemLanguageForeign;
	}

	public JMenuItem getMenuItemToApp() {
		return menuItemToApp;
	}
	
	public JMenuItem getMenuItemHelp() {
		return menuItemHelp;
	}

	public JMenuItem getMenuItemAbout() {
		return menuItemAbout;
	}

	public JTextField getTextFieldN00() {
		return textFieldN00;
	}

	public String getTextTextFieldN00() {
		return textFieldN00.getText();
	}

	public JTextField getTextFieldN01() {
		return textFieldN01;
	}

	public String getTextTextFieldN01() {
		return textFieldN01.getText();
	}

	public JTextField getTextFieldN02() {
		return textFieldN02;
	}

	public String getTextTextFieldN02() {
		return textFieldN02.getText();
	}

	public JTextField getTextFieldN10() {
		return textFieldN10;
	}

	public String getTextTextFieldN10() {
		return textFieldN10.getText();
	}

	public JTextField getTextFieldN11() {
		return textFieldN11;
	}

	public String getTextTextFieldN11() {
		return textFieldN11.getText();
	}

	public JTextField getTextFieldN12() {
		return textFieldN12;
	}

	public String getTextTextFieldN12() {
		return textFieldN12.getText();
	}

	public JTextField getTextFieldN20() {
		return textFieldN20;
	}

	public String getTextTextFieldN20() {
		return textFieldN20.getText();
	}

	public JTextField getTextFieldN21() {
		return textFieldN21;
	}

	public String getTextTextFieldN21() {
		return textFieldN21.getText();
	}

	public JTextField getTextFieldN22() {
		return textFieldN22;
	}

	public String getTextTextFieldN22() {
		return textFieldN22.getText();
	}

	public JTextField getTextFieldN30() {
		return textFieldN30;
	}

	public String getTextTextFieldN30() {
		return textFieldN30.getText();
	}

	public JTextField getTextFieldN31() {
		return textFieldN31;
	}

	public String getTextTextFieldN31() {
		return textFieldN31.getText();
	}

	public JTextField getTextFieldN32() {
		return textFieldN32;
	}

	public String getTextTextFieldN32() {
		return textFieldN32.getText();
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getRecordButton0() {
		return recordButton0;
	}

	public JButton getRecordButton1() {
		return recordButton1;
	}

	public JButton getRecordButton2() {
		return recordButton2;
	}

	public JButton getRecordButton3() {
		return recordButton3;
	}

	public JButton getPlayButton0() {
		return playButton0;
	}

	public JButton getPlayButton1() {
		return playButton1;
	}

	public JButton getPlayButton2() {
		return playButton2;
	}

	public JButton getPlayButton3() {
		return playButton3;
	}

	public JButton getNew4Button() {
		return new4Button;
	}
	
	public JButton getBackButton() {
		return backButton;
	}

	public JButton getForwardButton() {
		return forwardButton;
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public JButton getNativeButton() {
		return nativeButton;
	}

	public JButton getForeignButton() {
		return foreignButton;
	}

	public JLabel getLabelTopicName() {
		return labelTopicName;
	}

	public JTextField getTextFieldTopicName() {
		return textFieldTopicName;
	}

	public String getTextTextFieldTopicName() {
		return textFieldTopicName.getText();
	}

	public void setTextFieldN00(String text) {
		textFieldN00.setText(text);
	}

	public void setTextFieldN01(String text) {
		textFieldN01.setText(text);
	}

	public void setTextFieldN02(String text) {
		textFieldN02.setText(text);
	}

	public void setTextFieldN10(String text) {
		textFieldN10.setText(text);
	}

	public void setTextFieldN11(String text) {
		textFieldN11.setText(text);
	}

	public void setTextFieldN12(String text) {
		textFieldN12.setText(text);
	}

	public void setTextFieldN20(String text) {
		textFieldN20.setText(text);
	}

	public void setTextFieldN21(String text) {
		textFieldN21.setText(text);
	}

	public void setTextFieldN22(String text) {
		textFieldN22.setText(text);
	}

	public void setTextFieldN30(String text) {
		textFieldN30.setText(text);
	}

	public void setTextFieldN31(String text) {
		textFieldN31.setText(text);
	}

	public void setTextFieldN32(String text) {
		textFieldN32.setText(text);
	}

	public void setTextNativeButton(String text) {
		nativeButton.setText(text);
	}

	public void setTextForeignButton(String text) {
		foreignButton.setText(text);
	}

	public String getTextNativeButton() {
		return nativeButton.getText();
	}

	public String getTextForeignButton() {
		return foreignButton.getText();
	}

	public void setTextFileMenu(String text) {
		fileMenu.setText(text);
	}

	public void setTextOptionsMenu(String text) {
		optionsMenu.setText(text);
	}

	public void setTextHelpMenu(String text) {
		helpMenu.setText(text);
	}

//	public void setTextMenuItemOpen(String text) {
//		menuItemOpen.setText(text);
//	}
//
//	public void setTextMenuItemSave(String text) {
//		menuItemSave.setText(text);
//	}

	public void setTextmenuItemExit(String text) {
		menuItemExit.setText(text);
	}
	
	public void setTextModeMenu(String text) {
		modeMenu.setText(text);
	}
	
	public void setTextMenuItemToApp(String text) {
		menuItemToApp.setText(text);
	}

	public void setTextMenuItemHelp(String text) {
		menuItemHelp.setText(text);
	}

	public void setTextMenuItemAbout(String text) {
		menuItemAbout.setText(text);
	}

	public void setTextMenuItemLanguageNative(String text) {
		menuItemLanguageNative.setText(text);
	}

	public void setTextMenuItemLanguageForeign(String text) {
		menuItemLanguageForeign.setText(text);
	}

	public void setTextRecordButton0(String text) {
		recordButton0.setText(text);
	}

	public void setTextRecordButton1(String text) {
		recordButton1.setText(text);
	}

	public void setTextRecordButton2(String text) {
		recordButton2.setText(text);
	}

	public void setTextRecordButton3(String text) {
		recordButton3.setText(text);
	}

	public void setTextPlayButton0(String text) {
		playButton0.setText(text);
	}

	public void setTextPlayButton1(String text) {
		playButton1.setText(text);
	}

	public void setTextPlayButton2(String text) {
		playButton2.setText(text);
	}

	public void setTextPlayButton3(String text) {
		playButton3.setText(text);
	}

	public void setTextNew4Button(String text) {
		new4Button.setText(text);
	}
	
	public void setTextBackButton(String text) {
		backButton.setText(text);
	}

	public void setTextForwardButton(String text) {
		forwardButton.setText(text);
	}

	public void setTextSaveButton(String text) {
		saveButton.setText(text);
	}

	public void setTextLabelTopicName(String text) {
		labelTopicName.setText(text);
	}

	public void setTextTextFieldTopicName(String text) {
		textFieldTopicName.setText(text);
	}

	public String deAccent(String str) {
		String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(nfdNormalizedString).replaceAll("");
	}

	public JComboBox getTopicsList() {
		return topicsList;
	}

	public void setTopicsList(JComboBox topicsList) {
		this.topicsList = topicsList;
	}

	public void resetComboBox(ArrayList<String> topicsNative) {
		topics = new String[topicsNative.size()];
		topics = topicsNative.toArray(topics);
		comboBoxModel = new DefaultComboBoxModel(topics);
		getTopicsList().setModel(comboBoxModel);
	}

	public void aboutPopupWindow() {
		String msg = "<html><body><center><br /><br />&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Language Learnin Application Editor 2017 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <br /><br /><br /><br /></center></body></html>";
		JOptionPane.showMessageDialog(null, msg, "About", JOptionPane.INFORMATION_MESSAGE);
	}

}