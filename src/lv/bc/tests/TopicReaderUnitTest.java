/**
 * 
 */
package lv.bc.tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import lv.bc.io.TopicReader;

/**
 * @author Shokhruz Sattarov
 *
 */
public class TopicReaderUnitTest {

	/**
	 * @throws java.lang.Exception
	 */

	private String langDir = "ENG-LAT";
	private String topicName = "Animals";

	TopicReader topReaderObj;

	private BufferedReader reader;

	/**
	 * @throws IOException
	 * @throws java.lang.Exception
	 */

	@Before
	public void setUp() throws Exception {
		String dir = System.getProperty("user.dir");
		String filePath = dir + File.separatorChar + "file" + File.separatorChar + this.langDir + File.separatorChar
				+ this.topicName + File.separatorChar + this.topicName.toLowerCase() + ".lst";
		File file = new File(filePath);
		reader = new BufferedReader(new FileReader(file));
	}

	/**
	 * Test method for {@link lv.bc.io.TopicReader#openFile()}.
	 * 
	 * Test whether amount of words in file is equal to read words from Topic
	 * file
	 * 
	 * @throws IOException
	 */
	@Test()
	public final void testOpenFile() throws IOException {
		long amountOfLines = 0;
		long wordsAmount = 0;
		long objectAmountWords = 0;
		String lines = null;
		try {
			while ((lines = reader.readLine()) != null) {
				amountOfLines++;
				if (amountOfLines % 3 == 0) {
					wordsAmount++;
				}

			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		topReaderObj = new TopicReader(langDir, topicName);
		topReaderObj.openFile();
		objectAmountWords = topReaderObj.getAllTopicWords().size();
		assertEquals(wordsAmount, objectAmountWords);

	}

	@After
	public void tearDown() throws IOException {
		reader.close();
	}

}
