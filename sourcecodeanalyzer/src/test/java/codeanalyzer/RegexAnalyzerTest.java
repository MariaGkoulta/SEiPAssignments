package codeanalyzer;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RegexAnalyzerTest {

	@Test
	public void testRegexLocMetric() {
		LocMetric locMetric = new LocMetric();
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
		RegexAnalyzer regexAnalyzer = new RegexAnalyzer(sourceCode);
		assertEquals(12, regexAnalyzer.calculate(locMetric));		
	}
	
	@Test
	public void testRegexNocMetric() {
		NocMetric nocMetric = new NocMetric();
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
		RegexAnalyzer regexAnalyzer = new RegexAnalyzer(sourceCode);
		assertEquals(1, regexAnalyzer.calculate(nocMetric));		
	}
	
	@Test
	public void testRegexNomMetric() {
		NomMetric nomMetric = new NomMetric();
		String sourceCode = "public class Class1 {\r\n" + 
				"	public void foo() {}\r\n" + 
				"\r\n" + 
				"	String foo2() {\r\n" + 
				"		int x = Math.pow(2,2);\r\n" + 
				"	}\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"}";
		RegexAnalyzer regexAnalyzer = new RegexAnalyzer(sourceCode);
		assertEquals(2, regexAnalyzer.calculate(nomMetric));		
	}

}
