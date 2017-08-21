package lv.bc.editor.models;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lv.bc.editor.controllers.Controller;
import lv.bc.editor.views.View;

public class Model {

	static String fileNameForRecording; // Variable for recorder
	static String path; // Variable for recorder

	// Method to start recorder; it operates for some time, for example, 2.5 sec
	public void recordWord(String topicName, String fileName) {
		path = Controller.FP + "file/" + FileOperation.getLangDirectory() + "/" + topicName + "/";
		fileNameForRecording = fileName;
		final JavaSoundRecorder recorder = new JavaSoundRecorder();
		Thread stopper = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(2500); // 60000 = 1 minute
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				recorder.finish();
			}
		});
		stopper.start();
		recorder.start();
	}

	public void doN00() {

	}

	public void doN01() {

	}

	public void doN02() {

	}

	public void doN03() {

	}

	public void doN10() {

	}

	public void doN11() {

	}

	public void doN12() {

	}

	public void doN13() {

	}

	public void doN20() {

	}

	public void doN21() {

	}

	public void doN22() {

	}

	public void doN23() {

	}

	public void doN30() {

	}

	public void doN31() {

	}

	public void doN32() {

	}

	public void doN33() {

	}

	public void doOpen(String topicName) throws IOException {
		FileOperation.read(topicName);
	}

	public void doSave(String topicName) {
		FileOperation.write(topicName);
	}

	public void doHelp() {
		File htmlFile = new File("help/index.html");
		if (htmlFile.exists()) {
			if (Desktop.isDesktopSupported()) {
				try {
					Desktop.getDesktop().open(htmlFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void doRecord0() {

	}

	public void doRecord1() {

	}

	public void doRecord2() {

	}

	public void doRecord3() {

	}

	public void doNew4() {

		if (FileOperation.getNumberOfLines() == 0) {
			FileOperation.add4EmptyLines();
		} else {
			FileOperation.add4EmptyLines();
		}

	}

	public void doBack() {

	}

	public void doForward() {

	}

}
