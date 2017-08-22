package lv.bc.editor.models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import lv.bc.editor.controllers.Controller;

public class FileOperation {

	private static Integer lesson;
	private static String mode;
	private static int numberOfLines = 0;
	private static List<String> foreignWords = new ArrayList<>();
	private static List<String> nativeWords = new ArrayList<>();
	private static List<Integer> learnt = new ArrayList<>();
	private static String en_lv = "ENG-LAT";
	private static String lv_en = "LAT-ENG";
	private static String langDirectory = lv_en;
	private static String direction = "lven";
	private static boolean notEmptyArray = true;
	private static boolean noEmptyCellsInArray = true;

	public static void setLangDirectory(String langDirectory) {
		FileOperation.langDirectory = langDirectory;
	}

	public static String getLangDirectory() {
		return langDirectory;
	}

	public static String getDirection() {
		return direction;
	}

	public static void setDirection(String dir) {
		direction = dir;
		if (dir.equals("lven"))
			langDirectory = lv_en;
		else
			langDirectory = en_lv;
	}

	public static void read(String topic) throws IOException {

		foreignWords.removeAll(foreignWords);
		nativeWords.removeAll(nativeWords);
		learnt.removeAll(learnt);
		setNumberOfLines(0);

		if (direction.equals("lven"))
			langDirectory = lv_en;
		else
			langDirectory = en_lv;

		String line = null;
		String filename = Controller.FP + "file/" + langDirectory + "/" + topic + "/" + topic.toLowerCase() + ".lst";
		FileInputStream fileInputStream = new FileInputStream(filename);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8));
		try {

			int j = 0;
			while ((line = bufferedReader.readLine()) != null) {
				numberOfLines++;

				if (direction.equals("lven"))
					foreignWords.add(line.trim());
				else
					nativeWords.add(line.trim());

				line = bufferedReader.readLine();
				if (direction.equals("lven"))
					nativeWords.add(line.trim());
				else
					foreignWords.add(line.trim());

				line = bufferedReader.readLine();
				learnt.add(Integer.valueOf(line.trim()));
				j++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		bufferedReader.close();

	}

	public static void write(String topic) {
		if (notEmptyArrayCheck() && noEmptyCellsInArrayCheck()) {
			Writer writer = null;
			try {
				writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
						Controller.FP + "file/" + langDirectory + "/" + topic + "/" + topic.toLowerCase() + ".lst"),
						StandardCharsets.UTF_8));
				for (int i = 0; i < nativeWords.size(); i++) {
					if (direction.equals("lven")) {
						writer.write(foreignWords.get(i) + "\n");
						writer.write(nativeWords.get(i) + "\n");
					} else {
						writer.write(nativeWords.get(i) + "\n");
						writer.write(foreignWords.get(i) + "\n");
					}

					writer.write(learnt.get(i) + "\n");
				}
			} catch (IOException e) {
			} finally {
				try {
					if (writer != null) {
						writer.close();
					}
				} catch (IOException e) {
				}
			}
		}
	}

	public static String getNativeWords(int number) {
		return nativeWords.get(number);
	}

	public static String getForeignWords(int number) {
		return foreignWords.get(number);
	}

	public static int getNumberOfLines() {
		return numberOfLines;
	}

	public static void setNumberOfLines(int numberOfLines) {
		FileOperation.numberOfLines = numberOfLines;
	}

	public static void rememberFourLines(String i0, String f0, String n0, String i1, String f1, String n1, String i2,
			String f2, String n2, String i3, String f3, String n3) {

		foreignWords.set(Integer.parseInt(i0) - 1, f0);
		nativeWords.set(Integer.parseInt(i0) - 1, n0);

		foreignWords.set(Integer.parseInt(i1) - 1, f1);
		nativeWords.set(Integer.parseInt(i1) - 1, n1);

		foreignWords.set(Integer.parseInt(i2) - 1, f2);
		nativeWords.set(Integer.parseInt(i2) - 1, n2);

		foreignWords.set(Integer.parseInt(i3) - 1, f3);
		nativeWords.set(Integer.parseInt(i3) - 1, n3);
	}

	public static void add4EmptyLines() {
		for (int i = 0; i < 4; i++) {
			foreignWords.add("L");
			nativeWords.add("E");
			learnt.add(0);
		}
		numberOfLines += 4;
	}

	private static boolean notEmptyArrayCheck() {
		if (nativeWords.size() == 0)
			notEmptyArray = false;
		return notEmptyArray;
	}

	private static boolean noEmptyCellsInArrayCheck() {
		for (int i = 0; i < nativeWords.size(); i++) {
			if (foreignWords.get(i).equals("") || nativeWords.get(i).equals(""))
				noEmptyCellsInArray = false;
		}
		return notEmptyArray;
	}

	public static void resetArray() {	
		foreignWords.clear();
		nativeWords.clear();
		learnt.clear();
	}

}
