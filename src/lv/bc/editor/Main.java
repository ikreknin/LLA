package lv.bc.editor;

import javax.swing.SwingUtilities;

import lv.bc.editor.controllers.*;
import lv.bc.editor.models.*;
import lv.bc.editor.views.*;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Model model = new Model();
				View view = new View();
				Controller controller = new Controller(model, view);
				controller.contol();
			}
		});
	}
}