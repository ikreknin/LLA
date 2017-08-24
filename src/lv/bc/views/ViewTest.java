package lv.bc.views;

import static org.junit.Assert.*;

import org.junit.Test;

public class ViewTest {

	@Test
	public void test() {
		assertTrue(true);;
	}

	@Test
	public void evaluate() {
		View view = new View("");
		view.getAnswerButton1().setText("1234567890123456789012345678901234567890123456789012345678901234567890");
		view.setScore(9000);
		assertEquals(view.progressBar.getValue(), 100);
	}
}
