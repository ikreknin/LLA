package lv.bc.editor.controllers;

import lv.bc.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import lv.bc.editor.models.*;
import lv.bc.editor.views.*;

public class Controller {

	private Model model;
	private View view;
	// Action listeners for Fields
	private ActionListener actionListenerN00, actionListenerN01, actionListenerN02, actionListenerN03,
			actionListenerN10, actionListenerN11, actionListenerN12, actionListenerN13, actionListenerN20,
			actionListenerN21, actionListenerN22, actionListenerN23, actionListenerN30, actionListenerN31,
			actionListenerN32, actionListenerN33;
	// Actions listeners for Menu
	private ActionListener actionMenuListenerOpen, actionListenerMenuSave, actionListenerExit,
			actionListenerLanguageNative, actionListenerLanguageForeign, actionListenerToApp, actionListenerHelp,
			actionListenerAbout;
	// Actions listeners for Buttons
	private ActionListener actionListenerRecord0, actionListenerRecord1, actionListenerRecord2, actionListenerRecord3,
			actionListenerAudio0, actionListenerAudio1, actionListenerAudio2, actionListenerAudio3, actionListenerNew4,
			actionListenerBack, actionListenerForward, actionListenerButtonSave, actionListenerButtonNative,
			actionListenerButtonForeign, actionListenerButtonOk;

	public final static String FP = System.getProperty("user.dir") + "/";

	int currentLesson = 0;
	String langEmptyCells = "Empty cells!";

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		addWindowListeners();
	}

	public void addWindowListeners() {
		JFrame editorFrame = getView().getFrame();
		editorFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("closing Editor window");
				editorFrame.dispose(); // get rid of the frame
				// editorFrame.setVisible(true);
				lv.bc.Main.main(null);
			}
		});
	}

	public Model getModel() {
		return model;
	}

	public View getView() {
		return view;
	}

	public void contol() {

		actionListenerButtonOk = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					model.doOpen((String) view.getTopicsList().getSelectedItem());
					currentLesson = 0;

					if (FileOperation.getDirection().equals("lven")) {
						setTextInAll(currentLesson);
					} else {
						setTextInAllReverse(currentLesson);
					}

				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		};
		view.getOkButton().addActionListener(actionListenerButtonOk);

		// Action listeners for TextFilelds

		actionListenerN00 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doN00();
			}
		};
		view.getTextFieldN00().addActionListener(actionListenerN00);

		actionListenerN01 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doN01();
			}
		};
		view.getTextFieldN01().addActionListener(actionListenerN01);

		actionListenerN02 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doN02();
			}
		};
		view.getTextFieldN02().addActionListener(actionListenerN02);

		actionListenerN10 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doN10();
			}
		};
		view.getTextFieldN10().addActionListener(actionListenerN10);

		actionListenerN11 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doN11();
			}
		};
		view.getTextFieldN11().addActionListener(actionListenerN11);

		actionListenerN12 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doN12();
			}
		};
		view.getTextFieldN12().addActionListener(actionListenerN12);

		actionListenerN20 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doN20();
			}
		};
		view.getTextFieldN20().addActionListener(actionListenerN20);

		actionListenerN21 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doN21();
			}
		};
		view.getTextFieldN21().addActionListener(actionListenerN21);

		actionListenerN22 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doN22();
			}
		};
		view.getTextFieldN22().addActionListener(actionListenerN22);

		actionListenerN30 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doN30();
			}
		};
		view.getTextFieldN30().addActionListener(actionListenerN30);

		actionListenerN31 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doN31();
			}
		};
		view.getTextFieldN31().addActionListener(actionListenerN31);

		actionListenerN32 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doN32();
			}
		};
		view.getTextFieldN32().addActionListener(actionListenerN32);

		actionListenerExit = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
		view.getMenuItemExit().addActionListener(actionListenerExit);

		actionListenerLanguageNative = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.setTextFileMenu("File");
				view.setTextOptionsMenu("Options");
				view.setTextHelpMenu("Help");
				// view.setTextMenuItemOpen("Open");
				// view.setTextMenuItemSave("Save");
				view.setTextmenuItemExit("Exit");
				view.setTextModeMenu("Mode");
				view.setTextMenuItemToApp("Switch to App");
				view.setTextMenuItemHelp("Help");
				view.setTextMenuItemAbout("About");
				view.setTextMenuItemLanguageNative("English");
				view.setTextMenuItemLanguageForeign("Latvian");
				view.setTextRecordButton0("Record");
				view.setTextRecordButton1("Record");
				view.setTextRecordButton2("Record");
				view.setTextRecordButton3("Record");
				view.setTextPlayButton0("Play");
				view.setTextPlayButton1("Play");
				view.setTextPlayButton2("Play");
				view.setTextPlayButton3("Play");
				view.setTextNew4Button("New 4");
				view.setTextBackButton("Back");
				view.setTextForwardButton("Next");
				view.setTextSaveButton("Save");
				view.setTextNativeButton("English");
				view.setTextForeignButton("Latvian");
				view.setTextLabelTopicName("Topic");

				langEmptyCells = "Empty cells!";
			}
		};
		view.getMenuItemLanguageNative().addActionListener(actionListenerLanguageNative);

		actionListenerLanguageForeign = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.setTextFileMenu("Fails");
				view.setTextOptionsMenu("Opcijas");
				view.setTextHelpMenu("Palīdzība");
				// view.setTextMenuItemOpen("Atvērt");
				// view.setTextMenuItemSave("Saglabāt");
				view.setTextmenuItemExit("Izeja");
				view.setTextModeMenu("Režīms");
				view.setTextMenuItemToApp("Pārslēgt uz Testa režīmu");
				view.setTextMenuItemHelp("Palīdzība");
				view.setTextMenuItemAbout("Par programmu");
				view.setTextMenuItemLanguageNative("Angļu");
				view.setTextMenuItemLanguageForeign("Latviešu");
				view.setTextRecordButton0("Ierakstīt");
				view.setTextRecordButton1("Ierakstīt");
				view.setTextRecordButton2("Ierakstīt");
				view.setTextRecordButton3("Ierakstīt");
				view.setTextPlayButton0("Spēlēt");
				view.setTextPlayButton1("Spēlēt“t");
				view.setTextPlayButton2("Spēlēt");
				view.setTextPlayButton3("Spēlēt");
				view.setTextNew4Button("Jauni 4");
				view.setTextBackButton("Atpakaļ");
				view.setTextForwardButton("Talāk");
				view.setTextSaveButton("Saglabāt");
				view.setTextNativeButton("Angļu");
				view.setTextForeignButton("Latviešu");
				view.setTextLabelTopicName("Temats");

				langEmptyCells = "Tukšas šūnas!";
			}
		};
		view.getMenuItemLanguageForeign().addActionListener(actionListenerLanguageForeign);

		actionListenerToApp = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame editorFrame = getView().getFrame();
				// temporarily disable window closing
				editorFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				editorFrame.dispatchEvent(new WindowEvent(editorFrame, WindowEvent.WINDOW_CLOSING));
				editorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// model.doToApp();
			}
		};
		view.getMenuItemToApp().addActionListener(actionListenerToApp);

		actionListenerHelp = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doHelp();
			}
		};
		view.getMenuItemHelp().addActionListener(actionListenerHelp);

		actionListenerAbout = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.aboutPopupWindow();
			}
		};
		view.getMenuItemAbout().addActionListener(actionListenerAbout);

		actionListenerRecord0 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!view.getTextTextFieldN00().equals("")) {
					int i = Integer.parseInt(view.getTextTextFieldN00()) - 1;
					if (FileOperation.getDirection().equals("lven")) {
						model.recordWord((String) view.getTopicsList().getSelectedItem(),
								view.deAccent(FileOperation.getForeignWords(i)));
					} else {
						model.recordWord((String) view.getTopicsList().getSelectedItem(),
								view.deAccent(FileOperation.getNativeWords(i)));
					}
				}

			}
		};
		view.getRecordButton0().addActionListener(actionListenerRecord0);

		actionListenerRecord1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!view.getTextTextFieldN10().equals("")) {
					int i = Integer.parseInt(view.getTextTextFieldN10()) - 1;
					if (FileOperation.getDirection().equals("lven")) {
						model.recordWord((String) view.getTopicsList().getSelectedItem(),
								view.deAccent(FileOperation.getForeignWords(i)));
					} else {
						model.recordWord((String) view.getTopicsList().getSelectedItem(),
								view.deAccent(FileOperation.getNativeWords(i)));
					}
				}
			}
		};
		view.getRecordButton1().addActionListener(actionListenerRecord1);

		actionListenerRecord2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!view.getTextTextFieldN20().equals("")) {
					int i = Integer.parseInt(view.getTextTextFieldN20()) - 1;
					if (FileOperation.getDirection().equals("lven")) {
						model.recordWord((String) view.getTopicsList().getSelectedItem(),
								view.deAccent(FileOperation.getForeignWords(i)));
					} else {
						model.recordWord((String) view.getTopicsList().getSelectedItem(),
								view.deAccent(FileOperation.getNativeWords(i)));
					}
				}
			}
		};
		view.getRecordButton2().addActionListener(actionListenerRecord2);

		actionListenerRecord3 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!view.getTextTextFieldN30().equals("")) {
					int i = Integer.parseInt(view.getTextTextFieldN30()) - 1;
					if (FileOperation.getDirection().equals("lven")) {
						model.recordWord((String) view.getTopicsList().getSelectedItem(),
								view.deAccent(FileOperation.getForeignWords(i)));
					} else {
						model.recordWord((String) view.getTopicsList().getSelectedItem(),
								view.deAccent(FileOperation.getNativeWords(i)));
					}
				}
			}
		};
		view.getRecordButton3().addActionListener(actionListenerRecord3);

		actionListenerAudio0 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!view.getTextTextFieldN01().equals("")) {
					int i = Integer.parseInt(view.getTextTextFieldN00()) - 1;
					if (FileOperation.getDirection().equals("lven")) {
						AudioOperation.playSound((String) view.getTopicsList().getSelectedItem(),
								view.deAccent(FileOperation.getForeignWords(i)));
					} else {
						AudioOperation.playSound((String) view.getTopicsList().getSelectedItem(),
								view.deAccent(FileOperation.getNativeWords(i)));
					}
				}
			}
		};
		view.getPlayButton0().addActionListener(actionListenerAudio0);

		actionListenerAudio1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!view.getTextTextFieldN01().equals("")) {
					int i = Integer.parseInt(view.getTextTextFieldN10()) - 1;
					if (FileOperation.getDirection().equals("lven")) {
						AudioOperation.playSound((String) view.getTopicsList().getSelectedItem(),
								view.deAccent(FileOperation.getForeignWords(i)));
					} else {
						AudioOperation.playSound((String) view.getTopicsList().getSelectedItem(),
								view.deAccent(FileOperation.getNativeWords(i)));
					}
				}
			}
		};
		view.getPlayButton1().addActionListener(actionListenerAudio1);

		actionListenerAudio2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!view.getTextTextFieldN01().equals("")) {
					int i = Integer.parseInt(view.getTextTextFieldN20()) - 1;
					if (FileOperation.getDirection().equals("lven")) {
						AudioOperation.playSound((String) view.getTopicsList().getSelectedItem(),
								view.deAccent(FileOperation.getForeignWords(i)));
					} else {
						AudioOperation.playSound((String) view.getTopicsList().getSelectedItem(),
								view.deAccent(FileOperation.getNativeWords(i)));
					}
				}
			}
		};
		view.getPlayButton2().addActionListener(actionListenerAudio2);

		actionListenerAudio3 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!view.getTextTextFieldN01().equals("")) {
					int i = Integer.parseInt(view.getTextTextFieldN30()) - 1;
					if (FileOperation.getDirection().equals("lven")) {
						AudioOperation.playSound((String) view.getTopicsList().getSelectedItem(),
								view.deAccent(FileOperation.getForeignWords(i)));
					} else {
						AudioOperation.playSound((String) view.getTopicsList().getSelectedItem(),
								view.deAccent(FileOperation.getNativeWords(i)));
					}
				}
			}
		};
		view.getPlayButton3().addActionListener(actionListenerAudio3);

		actionListenerNew4 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doNew4();
				// model.doSave(view.deAccent((String)
				// view.getTopicsList().getSelectedItem()));
				model.doSave((String) view.getTopicsList().getSelectedItem());
				if (FileOperation.getNumberOfLines() == 4) {
					currentLesson = 0;
					setTextInAll(currentLesson);
				} else {
					setTextInAll(++currentLesson);
				}
			}
		};
		view.getNew4Button().addActionListener(actionListenerNew4);

		actionListenerBack = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentLesson > 0) {

					rememberWindow();
					if (FileOperation.getDirection().equals("lven")) {
						setTextInAll(--currentLesson);
					} else {
						setTextInAllReverse(--currentLesson);
					}

				}
			}
		};
		view.getBackButton().addActionListener(actionListenerBack);

		actionListenerForward = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if ((++currentLesson) * 4 < FileOperation.getNumberOfLines()) {
					rememberWindow();
					if (FileOperation.getDirection().equals("lven")) {
						setTextInAll(currentLesson);
					} else {
						setTextInAllReverse(currentLesson);
					}

				} else {
					currentLesson--;
				}
			}
		};
		view.getForwardButton().addActionListener(actionListenerForward);

		actionListenerButtonSave = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				rememberWindow();

				String dir;
				if (FileOperation.getDirection().equals("lven"))
					dir = "/file/LAT-ENG";
				else
					dir = "/file/ENG-LAT";
				String str = "";
				str = view.getTextTextFieldTopicName();
				str = (str.trim());
				String fileName = str.toLowerCase() + ".lst";
				if (str.equals("")) {
					// model.doSave(view.deAccent((String)
					// view.getTopicsList().getSelectedItem()));
					model.doSave((String) view.getTopicsList().getSelectedItem());
				} else {
					try {
						Path path = Paths.get(FP + dir + "/" + str);
						Files.createDirectories(path);
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					if (!fileName.equals("")) {

						Path file = Paths.get(FP + dir + "/" + str + "/" + fileName);
						if (FileOperation.getDirection().equals("lven")) {
							List<String> lines = Arrays.asList("L", "E", "0", "L", "E", "0", "L", "E", "0", "L", "E",
									"0");
							try {
								Files.write(file, lines, Charset.forName("UTF-8"));
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						} else {
							List<String> lines = Arrays.asList("E", "L", "0", "E", "L", "0", "E", "L", "0", "E", "L",
									"0");

							try {
								Files.write(file, lines, Charset.forName("UTF-8"));
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}

					}
					ComboBoxInit();
				}
			}
		};
		view.getSaveButton().addActionListener(actionListenerButtonSave);

		actionListenerButtonSave = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// model.doSave(view.deAccent((String)
				// view.getTopicsList().getSelectedItem()));
				model.doSave((String) view.getTopicsList().getSelectedItem());
			}
		};
		view.getSaveButton().addActionListener(actionListenerButtonSave);

		actionListenerButtonNative = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FileOperation.setNumberOfLines(0);
				String s0 = view.getTextNativeButton();
				String s1 = view.getTextForeignButton();
				view.setTextForeignButton(s0);
				view.setTextNativeButton(s1);
				if (view.getTextForeignButton().equals("Latvian")) {
					FileOperation.setDirection("lven");
				} else {
					FileOperation.setDirection("enlv");
				}
				FileOperation.resetArray();
				ComboBoxInit();
			}
		};
		view.getNativeButton().addActionListener(actionListenerButtonNative);

		actionListenerButtonForeign = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FileOperation.setNumberOfLines(0);
				String s0 = view.getTextNativeButton();
				String s1 = view.getTextForeignButton();
				view.setTextForeignButton(s0);
				view.setTextNativeButton(s1);
				if (view.getTextForeignButton().equals("Latvian")) {
					FileOperation.setDirection("lven");
				} else {
					FileOperation.setDirection("enlv");
				}
				FileOperation.resetArray();
				ComboBoxInit();
			}
		};
		view.getForeignButton().addActionListener(actionListenerButtonForeign);

	}

	private void setTextInAll(int lesson) {
		int temp = lesson;
		lesson = temp * 4;
		lesson++;
		view.setTextFieldN00("" + lesson);
		view.setTextFieldN01(FileOperation.getForeignWords(lesson - 1));
		view.setTextFieldN02(FileOperation.getNativeWords(lesson - 1));
		lesson++;
		view.setTextFieldN10("" + lesson);
		view.setTextFieldN11(FileOperation.getForeignWords(lesson - 1));
		view.setTextFieldN12(FileOperation.getNativeWords(lesson - 1));
		lesson++;
		view.setTextFieldN20("" + lesson);
		view.setTextFieldN21(FileOperation.getForeignWords(lesson - 1));
		view.setTextFieldN22(FileOperation.getNativeWords(lesson - 1));
		lesson++;
		view.setTextFieldN30("" + lesson);
		view.setTextFieldN31(FileOperation.getForeignWords(lesson - 1));
		view.setTextFieldN32(FileOperation.getNativeWords(lesson - 1));
	}

	private void setTextInAllReverse(int lesson) {
		int temp = lesson;
		lesson = temp * 4;
		lesson++;
		view.setTextFieldN00("" + lesson);
		view.setTextFieldN02(FileOperation.getForeignWords(lesson - 1));
		view.setTextFieldN01(FileOperation.getNativeWords(lesson - 1));
		lesson++;
		view.setTextFieldN10("" + lesson);
		view.setTextFieldN12(FileOperation.getForeignWords(lesson - 1));
		view.setTextFieldN11(FileOperation.getNativeWords(lesson - 1));
		lesson++;
		view.setTextFieldN20("" + lesson);
		view.setTextFieldN22(FileOperation.getForeignWords(lesson - 1));
		view.setTextFieldN21(FileOperation.getNativeWords(lesson - 1));
		lesson++;
		view.setTextFieldN30("" + lesson);
		view.setTextFieldN32(FileOperation.getForeignWords(lesson - 1));
		view.setTextFieldN31(FileOperation.getNativeWords(lesson - 1));
	}

	private void clearTextInAll() {
		view.setTextTextFieldTopicName("");
		view.setTextFieldN00("");
		view.setTextFieldN02("");
		view.setTextFieldN01("");
		view.setTextFieldN10("");
		view.setTextFieldN12("");
		view.setTextFieldN11("");
		view.setTextFieldN20("");
		view.setTextFieldN22("");
		view.setTextFieldN21("");
		view.setTextFieldN30("");
		view.setTextFieldN32("");
		view.setTextFieldN31("");
	}

	public void ComboBoxInit() {
		String dir;
		if (FileOperation.getDirection().equals("lven"))
			dir = "/file/LAT-ENG";
		else
			dir = "/file/ENG-LAT";
		ArrayList<String> temp = new ArrayList<>();
		File file = new File(System.getProperty("user.dir") + dir);
		String[] names = file.list();
		for (String name : names) {
			if (new File(System.getProperty("user.dir") + dir + "/" + name).isDirectory()) {
				temp.add(name);
			}
		}
		view.resetComboBox(temp);
		clearTextInAll();
		currentLesson = 0;
	}

	private void rememberWindow() {
		if (emptyChecker() && view.getTextTextFieldTopicName().equals("")) {
			JOptionPane.showMessageDialog(null, langEmptyCells, "ERROR", JOptionPane.ERROR_MESSAGE);
		} else {
			if (view.getTextTextFieldTopicName().equals("")) {

				if (FileOperation.getDirection().equals("lven")) {
					FileOperation.rememberFourLines(view.getTextTextFieldN00(), view.getTextTextFieldN01(),
							view.getTextTextFieldN02(), view.getTextTextFieldN10(), view.getTextTextFieldN11(),
							view.getTextTextFieldN12(), view.getTextTextFieldN20(), view.getTextTextFieldN21(),
							view.getTextTextFieldN22(), view.getTextTextFieldN30(), view.getTextTextFieldN31(),
							view.getTextTextFieldN32());
				} else {
					FileOperation.rememberFourLines(view.getTextTextFieldN00(), view.getTextTextFieldN02(),
							view.getTextTextFieldN01(), view.getTextTextFieldN10(), view.getTextTextFieldN12(),
							view.getTextTextFieldN11(), view.getTextTextFieldN20(), view.getTextTextFieldN22(),
							view.getTextTextFieldN21(), view.getTextTextFieldN30(), view.getTextTextFieldN32(),
							view.getTextTextFieldN31());
				}
			}
		}
	}

	private boolean emptyChecker() {
		boolean bool = false; // No empty cells
		if (view.getTextTextFieldN00().equals(""))
			bool = true;
		if (view.getTextTextFieldN01().equals(""))
			bool = true;
		if (view.getTextTextFieldN02().equals(""))
			bool = true;
		if (view.getTextTextFieldN10().equals(""))
			bool = true;
		if (view.getTextTextFieldN11().equals(""))
			bool = true;
		if (view.getTextTextFieldN12().equals(""))
			bool = true;
		if (view.getTextTextFieldN20().equals(""))
			bool = true;
		if (view.getTextTextFieldN21().equals(""))
			bool = true;
		if (view.getTextTextFieldN22().equals(""))
			bool = true;
		if (view.getTextTextFieldN30().equals(""))
			bool = true;
		if (view.getTextTextFieldN31().equals(""))
			bool = true;
		if (view.getTextTextFieldN32().equals(""))
			bool = true;
		return bool;

	}

}
