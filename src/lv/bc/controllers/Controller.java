package lv.bc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lv.bc.models.*;
import lv.bc.views.*;

public class Controller {
	
	private Model model;
	private View view;
//Action listeners for buttons
	private ActionListener  actionListenerQuestion,actionListenerAnswer1,
	actionListenerAnswer2, actionListenerAnswer3, actionListenerAnswer4;
//Actions listeners for Menu
	private ActionListener actionListenerOpen, actionListenerSave, actionListenerReset, actionListenerExit,
	actionListenerSilent, actionListenerAudio, actionListenerText, actionListenerFN, actionListenerNF, 
	actionListenerLanguage, actionListenerHelp;

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
				model.doAnswer1();		
			}
		};
		view.getAnswerButton1().addActionListener(actionListenerAnswer1);
		
		actionListenerAnswer2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doAnswer2();			
			}
		};	
		view.getAnswerButton2().addActionListener(actionListenerAnswer2);
		
		actionListenerAnswer3 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doAnswer3();			
			}
		};
		view.getAnswerButton3().addActionListener(actionListenerAnswer3);
		
		actionListenerAnswer4 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doAnswer4();			
			}
		};
		view.getAnswerButton4().addActionListener(actionListenerAnswer4);
		
//Action Listeners for menu----------------------------------------------------------------------------------------
		
		actionListenerOpen = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doOpen(view.getFrame());
			}
		};
		view.getMenuItemOpen().addActionListener(actionListenerOpen);
		
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
		
		actionListenerLanguage = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doLanguage();
			}
		};
		view.getMenuItemLanguage().addActionListener(actionListenerLanguage);
		
		actionListenerHelp = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doHelp();
			}
		};
		view.getMenuItemHelp().addActionListener(actionListenerHelp);
		
	}

}





