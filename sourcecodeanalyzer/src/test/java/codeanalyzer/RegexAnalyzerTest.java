package codeanalyzer;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class RegexAnalyzerTest {

	@Test
	public void testRegexLocMetric() throws IOException {
		LocMetric locMetric = new LocMetric();
		LocationReader locationReader = mock(LocationReader.class);
		String sourceCode = "public class Class1 {\r\n" + 
				"		// simple comment\r\n" + 
				"// simple comment 2\r\n" + 
				"\r\n" + 
				" /* long comment 1 */\r\n" + 
				" \r\n" + 
				" /* \r\n" + 
				" * \r\n" + 
				" * long comment 2 \r\n" + 
				" */\r\n" + 
				"\r\n" + 
				"	public void foo() {}\r\n" + 
				"\r\n" + 
				"	String foo2() {\r\n" + 
				"		int x = Math.pow(2,2);\r\n" + 
				"	}\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"}";
		when(locationReader.readIntoString()).thenReturn(sourceCode);
		RegexAnalyzer regexAnalyzer = new RegexAnalyzer(locationReader);
		assertEquals(12, regexAnalyzer.calculate(locMetric));		
	}
	
	@Test
	public void testRegexNocMetric() throws IOException {
		NocMetric nocMetric = new NocMetric();
		LocationReader locationReader = mock(LocationReader.class);
		String sourceCode = "public class Class1 {\r\n" + 
				"		// simple comment\r\n" + 
				"// simple comment 2\r\n" + 
				"\r\n" + 
				" /* long comment 1 */\r\n" + 
				" \r\n" + 
				" /* \r\n" + 
				" * \r\n" + 
				" * long comment 2 \r\n" + 
				" */\r\n" + 
				"\r\n" + 
				"	public void foo() {}\r\n" + 
				"\r\n" + 
				"	String foo2() {\r\n" + 
				"		int x = Math.pow(2,2);\r\n" + 
				"	}\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"}";
		when(locationReader.readIntoString()).thenReturn(sourceCode);
		RegexAnalyzer regexAnalyzer = new RegexAnalyzer(locationReader);
		assertEquals(1, regexAnalyzer.calculate(nocMetric));		
	}
	
	@Test
	public void testRegexNomMetric() throws IOException {
		NomMetric nomMetric = new NomMetric();
		LocationReader locationReader = mock(LocationReader.class);
		String sourceCode = "public class Class1 {\r\n" + 
				"	public void foo() {}\r\n" + 
				"\r\n" + 
				"	String foo2() {\r\n" + 
				"		int x = Math.pow(2,2);\r\n" + 
				"	}\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"}";
		when(locationReader.readIntoString()).thenReturn(sourceCode);
		RegexAnalyzer regexAnalyzer = new RegexAnalyzer(locationReader);
		assertEquals(2, regexAnalyzer.calculate(nomMetric));		
	}

}
