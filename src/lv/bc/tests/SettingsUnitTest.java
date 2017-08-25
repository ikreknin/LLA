package lv.bc.tests;

import static org.junit.Assert.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import lv.bc.settings.Settings;

public class SettingsUnitTest {

	Settings settings;

	/**
	 * Set up files and directory paths for constructing the Settings object.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		String dir = System.getProperty("user.dir");
		String filePath = dir + "/src/lv/bc/settings/Settings.ini";
		Path path = Paths.get(filePath);

		settings = new Settings();

		settings.setAudio(false);
		settings.setLearningDirection("ENG-LAT");
		settings.setScore(5);
		settings.setText(true);
		settings.setTopic("Home");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveAndExit() {
		settings.saveAndExit();
		assertEquals("Learning direction", "ENG-LAT", settings.getLearningDirection());
		assertEquals("Saved topic", "Home", settings.getTopic());
		assertEquals("Audio mode disabled", false, settings.getAudio());
		assertEquals("Updated score", 5, settings.getScore());
		assertEquals("Text mode enabled", true, settings.getText());
	}

}
