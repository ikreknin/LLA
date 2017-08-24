package lv.bc.controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.Normalizer;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.Timer;

import lv.bc.models.*;
import lv.bc.views.*;
import lv.bc.settings.Settings;
import lv.bc.myview.*;

public class Controller {
	
	private Model model;
	private View view;
	private Settings settings = new Settings();
	private Browse help;
	private AudioPlayer player;
//Action listeners for buttons
	private ActionListener  actionListenerQuestion,actionListenerAnswer1,	actionListenerAnswer2, actionListenerAnswer3, actionListenerAnswer4;
//Actions listeners for Menu
	private ActionListener actionListenerOpen, actionListenerReset, actionListenerExit, actionListenerToEditor, actionListenerAbout, actionListenerHelp;
	private ItemListener itemListenerAudio, itemListenerText;
////// Menu
	
	public String selectedLearningDirection = settings.getLearningDirection();
	public String selectedTopic = settings.getTopic(); //---> when getting parameter from view, Normalizer function removes all non-english characters.
	
	public String[] languageList;
	public String[] topicsList;
	
//Parameters for actions with answer keys
	private int answerKey;
	private boolean clientsAnswer, blocked = false;

//Helper methods-----------
	Timer timer;
	
	public void answerButtons (int buttonNr, JButton button) {
		timer.start();
		isAnswerButtonClickable(false);
		answerKey = model.getTopicAnswers().get(buttonNr-1).getKey();
		setClientsAnswer(model.doAnswer(answerKey));
		
		if(isClientsAnswer())
			button.setBackground(Color.green);
		else
			button.setBackground(Color.red);
	}
	
	public void isAnswerButtonClickable(boolean bool) {
		
		view.getAnswerButton1().setEnabled(bool);
		view.getAnswerButton2().setEnabled(bool);
		view.getAnswerButton3().setEnabled(bool);
		view.getAnswerButton4().setEnabled(bool);
		
	}
	
	public String normalString(String nonEnglish) {

		return Normalizer.normalize(nonEnglish, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
	
	
	//Getters and setters-------
	public int getAnswerKey() {
		return answerKey;
	}

	public void setAnswerKey(int answerKey) {
		this.answerKey = answerKey;
	}

	public boolean isClientsAnswer() {
		return clientsAnswer;
	}

	public void setClientsAnswer(boolean clientsAnswer) {
		this.clientsAnswer = clientsAnswer;
	}
	
	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean Blocked) {
		this.blocked = Blocked;
	}

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	public Model getModel() {
		return model;
	}

	public View getView() {
		return view;
	}

	public void contol() {
		
//On window open---------------------------------------------------------
		
		
		languageList = new String[model.getLanguageMenu().size()];
		languageList = model.getLanguageMenu().toArray(languageList);
		
		DefaultComboBoxModel<?> comboBoxLanguages = new DefaultComboBoxModel<Object>(languageList);
		view.languageList.setModel(comboBoxLanguages);
		
		
		
		view.getFrame().addWindowListener(new WindowAdapter() {
		    
			@Override
		    public void windowOpened(WindowEvent we) {
				
				int indexLanguageSwitch = -1;
				int indexTopicSwitch = -1;
				
				for(int i = 0; i < languageList.length; i++) {
					if(selectedLearningDirection.equals(languageList[i])) {
						indexLanguageSwitch = i;
						model.setMenuTopicList(selectedLearningDirection);
						topicsList = new String[model.getTopicMenu().size()];
						System.out.println("topicList" + model.getTopicMenu());
						System.out.println(selectedTopic + "!!!!!!!");
						topicsList = model.getTopicMenu().toArray(topicsList);
						
						for(int x = 0; x < topicsList.length; x++) {
							if(topicsList[x].equals(selectedTopic)) {
									
								indexTopicSwitch = x;
							}
						}
						i = languageList.length;
					}
				}

				view.languageList.setSelectedIndex(indexLanguageSwitch);
				view.topicsList.setSelectedIndex(indexTopicSwitch);
			
				view.getMenuItemAudio().setSelected(settings.getAudio());
				view.getPlayButton().setEnabled(settings.getAudio());
				view.getMenuItemText().setSelected(settings.getText());
			
				view.setScore(settings.getScore());
				
				model.doOpen(settings.getLearningDirection(), selectedTopic);
				
				view.setTextQuestion(model.getLearnWord().getFromText());
				
				view.setTextAnswer1(model.getTopicAnswers().get(0).getToText());
				view.setTextAnswer2(model.getTopicAnswers().get(1).getToText());
				view.setTextAnswer3(model.getTopicAnswers().get(2).getToText());
				view.setTextAnswer4(model.getTopicAnswers().get(3).getToText());
		    }

			
		});
		
// actionListenerToEditor triggers Window Close, here we override the close method to not only
//close the window, but to call the Editor
		view.getFrame().addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				JFrame newFrame = (JFrame) e.getComponent();
				System.out.println(newFrame.getTitle());
				System.out.println("closing LLA window"); 
				view.getFrame().dispose(); // get rid of the frame
				lv.bc.editor.Main.main(null);
			}
		});
		
//Action listeners for answer buttons------------------------------------------------------------------------------------------
		
		actionListenerQuestion = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doQuestion();	
				
			}
		};
		view.getQuestionButton().addActionListener(actionListenerQuestion);
		
		timer = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			if(isClientsAnswer()) {
					view.setTextQuestion(model.getLearnWord().getFromText());					
				}
			view.setScore(model.getScore());
			
				view.setTextAnswer1(model.getTopicAnswers().get(0).getToText());
				view.setTextAnswer2(model.getTopicAnswers().get(1).getToText());
				view.setTextAnswer3(model.getTopicAnswers().get(2).getToText());
				view.setTextAnswer4(model.getTopicAnswers().get(3).getToText());
				
				view.getAnswerButton1().setBackground(null);
				view.getAnswerButton2().setBackground(null);
				view.getAnswerButton3().setBackground(null);
				view.getAnswerButton4().setBackground(null);
				
				isAnswerButtonClickable(true);
			}
		});
		timer.setRepeats(false);

		actionListenerAnswer1 = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				answerButtons(1, view.getAnswerButton1());
			}
		};
		view.getAnswerButton1().addActionListener(actionListenerAnswer1);
		
		actionListenerAnswer2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				answerButtons(2, view.getAnswerButton2());
			}
		};	
		view.getAnswerButton2().addActionListener(actionListenerAnswer2);
		
		actionListenerAnswer3 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				answerButtons(3, view.getAnswerButton3());
			}
		};
		view.getAnswerButton3().addActionListener(actionListenerAnswer3);
		
		actionListenerAnswer4 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				answerButtons(4, view.getAnswerButton4());
			}
		};
		view.getAnswerButton4().addActionListener(actionListenerAnswer4);
		
		view.getPlayButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				String fileName = normalString(model.getLearnWord().getFromText()).toLowerCase() + ".wav";
				
				String dir = System.getProperty("user.dir");
				String fileFolder = dir + "/file/" + selectedLearningDirection + "/" + selectedTopic + "/";
				
				AudioPlayer.playFileWithPath(fileFolder, fileName);
				
			}
		});
		
		
//UI menu ----------------------------------------------------------------------------------------
		
		
		actionListenerOpen = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				selectedTopic = view.topicsList.getSelectedItem().toString();
				selectedLearningDirection = view.languageList.getSelectedItem().toString();
				view.setScore(model.getScore());
				
				model.doOpen(selectedLearningDirection, selectedTopic); 
				settings.setTopic(selectedTopic);
				settings.setLearningDirection(selectedLearningDirection);
				
				view.setTextQuestion(model.getLearnWord().getFromText());
				
				view.setTextAnswer1(model.getTopicAnswers().get(0).getToText());
				view.setTextAnswer2(model.getTopicAnswers().get(1).getToText());
				view.setTextAnswer3(model.getTopicAnswers().get(2).getToText());
				view.setTextAnswer4(model.getTopicAnswers().get(3).getToText());

			}
		};
		view.okButton.addActionListener(actionListenerOpen);
		
		 ActionListener actionListenerLanguage = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JComboBox<?> cb = (JComboBox<?>)e.getSource();
					
					model.setMenuTopicList((String)cb.getSelectedItem());
					topicsList = new String[model.getTopicMenu().size()];
					topicsList = model.getTopicMenu().toArray(topicsList);
				
					DefaultComboBoxModel<?> comboBoxModel1 = new DefaultComboBoxModel<Object>(topicsList);
					view.topicsList.setModel(comboBoxModel1);
					
				}
			};
			view.languageList.addActionListener(actionListenerLanguage);
	      
//Menu bar options--------------------------------------------------------------------------------------
		
		actionListenerReset = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doReset();
				view.setScore(model.getScore());
			}
		};
		view.getMenuItemReset().addActionListener(actionListenerReset);
		
		actionListenerExit = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				settings.setScore(model.getScore());
				settings.saveAndExit();
				System.exit(0);
			}
		};
		view.getMenuItemExit().addActionListener(actionListenerExit);
		
		view.getFrame().addWindowListener(new WindowAdapter()
	        {
	            @Override
	            public void windowClosing(WindowEvent e)
	            {
	            	settings.setScore(model.getScore());
	            	settings.saveAndExit();
	            }
	        });
	

		itemListenerAudio = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent paramItemEvent) {
				int audioState = paramItemEvent.getStateChange();
				
				if (settings.getText()) {
					
					if (audioState == 1) {
						settings.setAudio(true);
						view.getPlayButton().setEnabled(true);
					}
					else if(audioState == 2) {
						settings.setAudio(false);
						view.getPlayButton().setEnabled(false);
					}
					else {
						System.out.println("There shouldnt be value like " + audioState);
					}
				}
				else {
					
					settings.setAudio(true);
					view.getPlayButton().setEnabled(true);
				}	
			}
		};
		view.getMenuItemAudio().addItemListener(itemListenerAudio);
		
		
		itemListenerText = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent paramItemEvent) {
				int textState = paramItemEvent.getStateChange();
				
				if (textState == 1) {
					view.getMenuItemAudio().setEnabled(true);
					settings.setText(true);
					view.getQuestionButton().setVisible(true);
				}
				else if(textState == 2) {
					view.getMenuItemAudio().setEnabled(false);
					settings.setText(false);
					settings.setAudio(true);
					view.getPlayButton().setEnabled(true);
					view.getMenuItemAudio().setSelected(true);
					view.getQuestionButton().setVisible(false);
				}
				else {
					System.out.println("There shouldnt be value like " + textState);
				}
			}
		};
		view.getMenuItemText().addItemListener(itemListenerText);
		
		// on clicking menuItemToEditor dispatch WINDOW_CLOSING Event
		actionListenerToEditor = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// temporarily disable closing
				view.getFrame().setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
				view.getFrame().dispatchEvent(new WindowEvent(view.getFrame(), WindowEvent.WINDOW_CLOSING));
				view.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		};
		view.getMenuItemToEditor().addActionListener(actionListenerToEditor);
		
		actionListenerAbout = new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				//model.doHelp();
			}
		};
		view.getMenuItemAbout().addActionListener(actionListenerAbout);
		
		actionListenerHelp = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Browse.openInBrowser("help.html");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		};
		view.getMenuItemHelp().addActionListener(actionListenerHelp);
		
	}

}




