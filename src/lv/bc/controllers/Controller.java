package lv.bc.controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.Normalizer;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.Timer;

import lv.bc.models.*;
import lv.bc.views.*;
import lv.bc.settings.Settings;;

public class Controller {
	
	private Model model;
	private View view;
	private Settings settings = new Settings();
//Action listeners for buttons
	private ActionListener  actionListenerQuestion,actionListenerAnswer1,	actionListenerAnswer2, actionListenerAnswer3, actionListenerAnswer4;
//Actions listeners for Menu
	private ActionListener actionListenerOpen, actionListenerSave, actionListenerReset, actionListenerExit, actionListenerFN, actionListenerNF,actionListenerAbout, actionListenerHelp, actionListenerLatvian, actionListenerEnglish;
	private ItemListener itemListenerAudio, itemListenerText;
////// Menu

	//TODO change dynamically what is in dropdown list
	
	public String selectedLearningDirection = "LAT-ENG";
	public String selectedTopic = "Dzivnieki"; //---> when getting parameter from view, Normalizer function removes all non-english characters.
	
	
//Parameters for actions with answer keys
	private int answerKey;
	private boolean clientsAnswer, blocked = false;
	public Color red = new Color(255, 0, 0);
	public Color green = new Color(0, 255, 0);

//Helper methods-----------
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
		
		view.getFrame().addWindowListener(new WindowAdapter() {
		    
			@Override
		    public void windowOpened(WindowEvent we) {
				view.getMenuItemAudio().setSelected(settings.getAudio());
				view.getMenuItemText().setSelected(settings.getText());
				
				
				//view.choices
				
				
				//view.topicsEng
				//view.topicsLv
				//view.topics
				
				
				
				model.doOpen(settings.getLearningDirection(), settings.getTopic());
				
				view.setTextQuestion(model.getLearnWord().getFromText());
				
				view.setTextAnswer1(model.getTopicAnswers().get(0).getToText());
				view.setTextAnswer2(model.getTopicAnswers().get(1).getToText());
				view.setTextAnswer3(model.getTopicAnswers().get(2).getToText());
				view.setTextAnswer4(model.getTopicAnswers().get(3).getToText());
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
		
		Timer timer = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			if(isClientsAnswer()) {
					view.setTextQuestion(model.getLearnWord().getFromText());
				}
				
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
				timer.start();
				isAnswerButtonClickable(false);
				answerKey = model.getTopicAnswers().get(0).getKey();
				setClientsAnswer(model.doAnswer(answerKey));
				
				if(isClientsAnswer())
					view.getAnswerButton1().setBackground(green);
				else
					view.getAnswerButton1().setBackground(red);
			}
		};
		view.getAnswerButton1().addActionListener(actionListenerAnswer1);
		
		actionListenerAnswer2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.start();
				isAnswerButtonClickable(false);
				answerKey = model.getTopicAnswers().get(1).getKey();
				setClientsAnswer(model.doAnswer(answerKey));
				
				if(isClientsAnswer())
					view.getAnswerButton2().setBackground(green);
				else
					view.getAnswerButton2().setBackground(red);
			}
		};	
		view.getAnswerButton2().addActionListener(actionListenerAnswer2);
		
		actionListenerAnswer3 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.start();
				isAnswerButtonClickable(false);
				answerKey = model.getTopicAnswers().get(2).getKey();
				setClientsAnswer(model.doAnswer(answerKey));
				
				if(isClientsAnswer())
					view.getAnswerButton3().setBackground(green);
				else
					view.getAnswerButton3().setBackground(red);
			}
		};
		view.getAnswerButton3().addActionListener(actionListenerAnswer3);
		
		actionListenerAnswer4 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.start();
				isAnswerButtonClickable(false);
				answerKey = model.getTopicAnswers().get(3).getKey();
				setClientsAnswer(model.doAnswer(answerKey));
				
				if(isClientsAnswer())
					view.getAnswerButton4().setBackground(green);
				else
					view.getAnswerButton4().setBackground(red);
			}
		};
		view.getAnswerButton4().addActionListener(actionListenerAnswer4);
		
		
//Action Listeners UI menu bar----------------------------------------------------------------------------------------
		
		actionListenerOpen = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Selected topic------------------" + selectedTopic);
				model.doOpen(selectedLearningDirection, selectedTopic); 
				
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
					selectedLearningDirection = (String)cb.getSelectedItem();
					//selectedLearningDirection = normalString(selectedLearningDirection);
					view.lang = view.deAccent(selectedLearningDirection);
					if (selectedLearningDirection == "LAT-ENG") {
						DefaultComboBoxModel<?> comboBoxModel1 = new DefaultComboBoxModel<Object>(view.topicsEng);
						view.topicsList.setModel(comboBoxModel1);
					} else {
						DefaultComboBoxModel<?> comboBoxModel2 = new DefaultComboBoxModel<Object>(view.topicsLv);
						view.topicsList.setModel(comboBoxModel2);
					}
				}
			};
			view.languageList.addActionListener(actionListenerLanguage);
	        
	        ActionListener actionListenerTopic = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JComboBox<?> cb = (JComboBox<?>)e.getSource();
					selectedTopic = (String)cb.getSelectedItem();
					selectedTopic = normalString(selectedTopic);
					view.topic = view.deAccent(selectedTopic);
				}
			};
			view.topicsList.addActionListener(actionListenerTopic);
			
//Menu bar options--------------------------------------------------------------------------------------
		actionListenerSave = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doSave();
			}
		};
		view.getMenuItemSave().addActionListener(actionListenerSave);
		
		actionListenerReset = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doReset();
			}
		};
		view.getMenuItemReset().addActionListener(actionListenerReset);
		
		actionListenerExit = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
	            	settings.saveAndExit();
	            }
	        });
	
		
		itemListenerAudio = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent paramItemEvent) {
				int audioState = paramItemEvent.getStateChange();
				
				if (audioState == 1) {
					settings.setAudio(true);
					//TODO enable sound button
				}
				else if(audioState == 2) {
					settings.setAudio(false);
					//TODO disable sound button
				}
				else {
					System.out.println("There shouldnt be value like " + audioState);
				}
			}
			
			
		};
		view.getMenuItemAudio().addItemListener(itemListenerAudio);
		
		itemListenerText = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent paramItemEvent) {
				int textState = paramItemEvent.getStateChange();
				
				if (textState == 1) {
					settings.setText(true);
					view.getQuestionButton().setVisible(true);
				}
				else if(textState == 2) {
					settings.setText(false);
					settings.setAudio(true);
					view.getMenuItemAudio().setSelected(true);
					//TODO enable sound icon
					view.getQuestionButton().setVisible(false);
				}
				else {
					System.out.println("There shouldnt be value like " + textState);
				}
				
			}

		};
		view.getMenuItemText().addItemListener(itemListenerText);
		
		actionListenerFN = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doFN();
			}
		};
		view.getMenuItemFN().addActionListener(actionListenerFN);
		
		actionListenerNF = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.NF();
			}
		};
		view.getMenuItemNF().addActionListener(actionListenerNF);

		
		actionListenerLatvian = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO
			}
		};
		view.getMenuItemLatvian().addActionListener(actionListenerLatvian);
		
		actionListenerEnglish = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO
			}
		};
		view.getMenuItemEnglish().addActionListener(actionListenerEnglish);
		
		actionListenerAbout = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//model.doHelp();
			}
		};
		//view.getMenuItemAbout().addActionListener(actionListenerAbout);
		//TODO wait for setters and getters for About
		
		actionListenerHelp = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doHelp();
			}
		};
		view.getMenuItemHelp().addActionListener(actionListenerHelp);
		
	}

}




