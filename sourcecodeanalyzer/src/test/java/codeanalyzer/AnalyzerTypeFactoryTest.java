package codeanalyzer;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.io.IOException;

public class AnalyzerTypeFactoryTest {
	private final static String TYPE_LOCAL = "local";
	private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
	
	@Test
	public void testCreateRegexAnalyzer() throws IOException {
		AnalyzerTypeFactory atf = new AnalyzerTypeFactory(TYPE_LOCAL, TEST_CLASS_LOCAL);
		AnalyzerType analyzerType = atf.createAnalyzerType("regex");
        assertThat(analyzerType, instanceOf(RegexAnalyzer.class));      
	}
	
	@Test
	public void testCreateStrcompAnalyzer() throws IOException {
		AnalyzerTypeFactory atf = new AnalyzerTypeFactory(TYPE_LOCAL, TEST_CLASS_LOCAL);
		AnalyzerType analyzerType = atf.createAnalyzerType("strcomp");
        assertThat(analyzerType, instanceOf(StrcompAnalyzer.class));      
	}
	
	@Test
	public void testNull() throws IOException {
		AnalyzerTypeFactory atf = new AnalyzerTypeFactory(TYPE_LOCAL, TEST_CLASS_LOCAL);
		AnalyzerType analyzerType = atf.createAnalyzerType("abc");
        assertNull(analyzerType);	
	}

}
