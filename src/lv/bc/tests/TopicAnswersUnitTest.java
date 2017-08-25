/**
 * 
 */
package lv.bc.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import lv.bc.io.TopicAnswers;
import lv.bc.io.TopicReader;

/**
 * @author Shokhruz Sattarov
 *
 */

public class TopicAnswersUnitTest {

	TopicReader topicReader;
	TopicAnswers topAnswers;

	@Before
	public void setUp() throws Exception {
		topicReader = new TopicReader("ENG-LAT", "Animals");
		try {
			topicReader.openFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link lv.bc.io.TopicAnswers#initializationOfArrays(java.util.List)}.
	 * 
	 * Tests initialization of structure for learning words
	 */
	@Test
	public final void testInitializationOfArrays() {
		topAnswers = new TopicAnswers(topicReader.getAllTopicWords());
		assertEquals("Words in file", topicReader.getAllTopicWords().size(), topAnswers.getFullList().size());
		assertEquals("Left words to study", topicReader.getAllTopicWords().size(), topAnswers.getLeftToStudy().size());
		assertEquals("List of answers", 4, topAnswers.getAnswerList().size());
	}

	/**
	 * Test method for {@link lv.bc.io.TopicAnswers#checkAnswer(int)}.
	 * 
	 * Testing passed answers are true. Overall right answers should be 0,
	 * because left words to study after the whole process must be 0.
	 * 
	 */
	@Test
	public final void testCheckAnswer() {
		topAnswers = new TopicAnswers(topicReader.getAllTopicWords());
		int counterOfTruth = topAnswers.getFullList().size();
		int answerNumb = topAnswers.getLeftToStudy().size();

		while (answerNumb > -1) {

			if (topAnswers.checkAnswer(answerNumb) != true) {
				answerNumb--;
				if (answerNumb == -1)
					answerNumb = topAnswers.getFullList().size();
			} else {
				counterOfTruth--;
				answerNumb = topAnswers.getFullList().size();
			}

			if (counterOfTruth == 0)
				break;
		}

		assertEquals("Left words to study after word checking", 0, counterOfTruth);

	}

	/**
	 * 
	 * Test method for {@link lv.bc.io.TopicAnswers#reset()}. for resetting of
	 * study words
	 */
	@Test
	public final void testReset() {
		topAnswers = new TopicAnswers(topicReader.getAllTopicWords());
		topAnswers.reset();
		assertEquals("Left words to study", 20, topAnswers.getLeftToStudy().size());
		assertEquals("List of answers", 4, topAnswers.getAnswerList().size());
		assertEquals("Initial Score", 0, topAnswers.getRoundScore());

	}

}
