package lv.bc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lv.bc.models.*;
import lv.bc.views.*;

public class Controller {
	
	private Model model;
	private View view;
//Action listeners for buttons
	private ActionListener  actionListenerQuestion,actionListenerAnswer1,	actionListenerAnswer2, actionListenerAnswer3, actionListenerAnswer4,actionListenerAnswer;
//Actions listeners for Menu
	private ActionListener actionListenerOpen, actionListenerSave, actionListenerReset, actionListenerExit,
	actionListenerSilent, actionListenerAudio, actionListenerText, actionListenerFN, actionListenerNF, 
	actionListenerLanguage, actionListenerHelp, actionListenerLatvian, actionListenerEnglish;
	
	public int answerKey;
	boolean clientsAnswer;

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
		
//Action listeners for buttons------------------------------------------------------------------------------------------
		
		actionListenerAnswer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean answer = model.doAnswer(answerKey);
				
				if(false) {
					model.doOpen("LAT-ENG", "Dzivnieki");
				}
				else {
					view.setTextAnswer1(model.getTopicAnswers().get(0).getToText());
					view.setTextAnswer2(model.getTopicAnswers().get(1).getToText());
					view.setTextAnswer3(model.getTopicAnswers().get(2).getToText());
					view.setTextAnswer4(model.getTopicAnswers().get(3).getToText());
				}
				
			}
		};
		view.getAnswerButton1().addActionListener(actionListenerAnswer);
		view.getAnswerButton2().addActionListener(actionListenerAnswer);
		view.getAnswerButton3().addActionListener(actionListenerAnswer);
		view.getAnswerButton4().addActionListener(actionListenerAnswer);
		
		
		actionListenerQuestion = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doQuestion();	
				
			}
		};
		view.getQuestionButton().addActionListener(actionListenerQuestion);
		
		actionListenerAnswer1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				answerKey = model.getTopicAnswers().get(0).getKey();
			}
		};
		view.getAnswerButton1().addActionListener(actionListenerAnswer1);
		
		actionListenerAnswer2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				answerKey = model.getTopicAnswers().get(1).getKey();;		
			}
		};	
		view.getAnswerButton2().addActionListener(actionListenerAnswer2);
		
		actionListenerAnswer3 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				answerKey = model.getTopicAnswers().get(2).getKey();;
			}
		};
		view.getAnswerButton3().addActionListener(actionListenerAnswer3);
		
		actionListenerAnswer4 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				answerKey = model.getTopicAnswers().get(3).getKey();;	
				model.doAnswer(answerKey);
			}
		};
		view.getAnswerButton4().addActionListener(actionListenerAnswer4);
		
		

		
//Action Listeners for menu----------------------------------------------------------------------------------------
		
		actionListenerOpen = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doOpen("LAT-ENG", "Dzivnieki");
				
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
		
//		actionListenerLanguage = new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				model.doLanguage();
//			}
//		};
//		view.getMenuItemLanguage().addActionListener(actionListenerLanguage);
		
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





