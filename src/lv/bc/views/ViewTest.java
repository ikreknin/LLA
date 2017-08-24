package lv.bc.views;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import javax.swing.ImageIcon;

import org.junit.Test;

public class ViewTest {

	@Test
	// dummy method
	public void test() {
		assertTrue(true);
	}

	@Test
	/**
	 * check that "invalid" input does not break the system
	 */
	public void checkValues() {
		View view = new View("");
		// excessively long text for buttons
		view.getAnswerButton1().setText("1234567890123456789012345678901234567890123456789012345678901234567890");
		// check handling of out-of-bounds values for progressbar
		view.setScore(9000);
		assertEquals(view.progressBar.getValue(), 100);
		// redirect output stream from error
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setErr(new PrintStream(outContent));
		ImageIcon icon = view.createImageIcon("images/non-existing-path");
		assertEquals("Couldn't find file: images/non-existing-path\n", outContent.toString());
	}
}
