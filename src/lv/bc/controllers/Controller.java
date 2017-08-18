package lv.bc.controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import lv.bc.models.*;
import lv.bc.views.*;

public class Controller {
	
	private Model model;
	private View view;
//Action listeners for buttons
	private ActionListener  actionListenerQuestion,actionListenerAnswer1,	actionListenerAnswer2, actionListenerAnswer3, actionListenerAnswer4,actionListenerAnswer;
//Actions listeners for Menu
	private ActionListener actionListenerOpen, actionListenerSave, actionListenerReset, actionListenerExit,
	actionListenerSilent, actionListenerAudio, actionListenerText, actionListenerFN, actionListenerNF, actionListenerHelp, actionListenerLatvian, actionListenerEnglish;

	////// Menu---------
	
	
	
	
//For actions with answer keys
	private int answerKey;
	private boolean clientsAnswer, blocked = false;
	public Color red = new Color(255, 0, 0);
	public Color green = new Color(0, 255, 0);
	
	public void isAnswerButtonClickable(boolean bool) {
		view.getAnswerButton1().setEnabled(bool);
		view.getAnswerButton2().setEnabled(bool);
		view.getAnswerButton3().setEnabled(bool);
		view.getAnswerButton4().setEnabled(bool);
	}

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
				model.doOpen("LAT-ENG", "Dzivnieki");
				
				view.setTextQuestion(model.getLearnWord().getFromText());
				
				view.setTextAnswer1(model.getTopicAnswers().get(0).getToText());
				view.setTextAnswer2(model.getTopicAnswers().get(1).getToText());
				view.setTextAnswer3(model.getTopicAnswers().get(2).getToText());
				view.setTextAnswer4(model.getTopicAnswers().get(3).getToText());
		    }

		});
		
//Action listeners for buttons------------------------------------------------------------------------------------------
		
		actionListenerQuestion = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doQuestion();	
				
			}
		};
		view.getQuestionButton().addActionListener(actionListenerQuestion);
		
		actionListenerAnswer = new ActionListener() {
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
		};
		
		view.nextQuestion.addActionListener(actionListenerAnswer);
		/*view.getAnswerButton1().addActionListener(actionListenerAnswer);
		view.getAnswerButton2().addActionListener(actionListenerAnswer);
		view.getAnswerButton3().addActionListener(actionListenerAnswer);
		view.getAnswerButton4().addActionListener(actionListenerAnswer);*/
		
		
		
		
		actionListenerAnswer1 = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
		
		

		
//Action Listeners for menu----------------------------------------------------------------------------------------
		
		actionListenerOpen = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doOpen("LAT-ENG", "Dzivnieki"); //TODO here I need to give parameters from view labels!!!!!!!!
				
				view.setTextQuestion(model.getLearnWord().getFromText());
				
				view.setTextAnswer1(model.getTopicAnswers().get(0).getToText());
				view.setTextAnswer2(model.getTopicAnswers().get(1).getToText());
				view.setTextAnswer3(model.getTopicAnswers().get(2).getToText());
				view.setTextAnswer4(model.getTopicAnswers().get(3).getToText());
			
			/*view.setTextQuestion("suns");
				view.setTextAnswer1("pupper");
				view.setTextAnswer2("doge");
				view.setTextAnswer3("cate");
				view.setTextAnswer4("doggo"); */
			}
		};
		view.okButton.addActionListener(actionListenerOpen);
		
		 ActionListener actionListenerLanguage = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JComboBox cb = (JComboBox)e.getSource();
					String selectedString = (String)cb.getSelectedItem();
					System.out.println("Selected from dropdown: " + selectedString);
					//view.lang = deAccent(selectedString);
					if (selectedString == "LAT-ENG") {
						DefaultComboBoxModel comboBoxModel1 = new DefaultComboBoxModel(view.topicsEng);
						view.topicsList.setModel(comboBoxModel1);
					} else {
						DefaultComboBoxModel comboBoxModel2 = new DefaultComboBoxModel(view.topicsLv);
						view.topicsList.setModel(comboBoxModel2);
					}
				}
			};
			view.languageList.addActionListener(actionListenerLanguage);
	        
	        ActionListener actionListenerTopic = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JComboBox cb = (JComboBox)e.getSource();
					String selectedString = (String)cb.getSelectedItem();
					//view.topic = deAccent(selectedString);
					System.out.println("Selected from dropdown: " + selectedString);
//					updateLabel(petName);
				}
			};
			view.topicsList.addActionListener(actionListenerTopic);
//--------------------------------------------------------------------------------------
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
				System.exit(0);
			}
		};
		view.getMenuItemExit().addActionListener(actionListenerExit);
		
		actionListenerSilent = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doSilent();
			}
		};
		view.getMenuItemSilent().addActionListener(actionListenerSilent);
		
		actionListenerAudio = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doAudio();
			}
		};
		view.getMenuItemAudio().addActionListener(actionListenerAudio);
		
		actionListenerText = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doText();
			}
		};
		view.getMenuItemText().addActionListener(actionListenerText);
		
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
		
		actionListenerHelp = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doHelp();
			}
		};
		view.getMenuItemHelp().addActionListener(actionListenerHelp);
		
	}

}




