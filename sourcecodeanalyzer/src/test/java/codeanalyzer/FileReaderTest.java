package codeanalyzer;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class FileReaderTest {
	
	private static List<String> expectedList;
	private static String expectedString;
	private final static String TYPE_WEB = "web";
	private final static String TYPE_LOCAL = "local";
	private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
	private final static String TEST_CLASS_WEB ="https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";
	
	
	@BeforeClass
	public static void setUp() throws IOException {
		expectedList = Files.readAllLines(new File(TEST_CLASS_LOCAL).toPath(), Charset.defaultCharset());
		expectedString = String.join("\n", expectedList) + "\n"; // transforms a list into a String (with 'new line' as delimiter) 
	}
	
	@Test
	public void testReadLocalFileIntoList() throws IOException {
		FileReader fileReader = new FileReader(TYPE_LOCAL, TEST_CLASS_LOCAL);
		List<String> actualList = fileReader.readFileIntoList();		
		String[] expecteds = expectedList.stream().toArray(String[]::new);
		String[] actuals = actualList.stream().toArray(String[]::new);		
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testReadLocalFileIntoString() throws IOException {
		FileReader fileReader = new FileReader(TYPE_WEB, TEST_CLASS_WEB);
		String actuals = fileReader.readFileIntoString();		
		assertEquals(expectedString, actuals);
	}
}
