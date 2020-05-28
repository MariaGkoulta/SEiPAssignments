package codeanalyzer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class StrcompAnalyzerTest {
	
	@Test
	public void testStrcompLocMetric() throws IOException {
		LocMetric locMetric = new LocMetric();
		LocationReader locationReader = mock(LocationReader.class);
		List<String> sourceCodeList = new ArrayList<>();
		sourceCodeList.add("x + y = 5");
		sourceCodeList.add("//");
		sourceCodeList.add("return 0;");
		sourceCodeList.add("public class New");
		when(locationReader.readIntoList()).thenReturn(sourceCodeList);
		StrcompAnalyzer strcompAnalyzer = new StrcompAnalyzer(locationReader);
		assertEquals(3, strcompAnalyzer.calculate(locMetric));		
	}
	
	@Test
	public void testStrcompLomMetric() throws IOException {
		NomMetric nomMetric = new NomMetric();
		LocationReader locationReader = mock(LocationReader.class);
		List<String> sourceCodeList = new ArrayList<>();
		sourceCodeList.add("public void new() {");
		sourceCodeList.add("return 0;");
		sourceCodeList.add("private new() {");
		sourceCodeList.add("public class New");
		when(locationReader.readIntoList()).thenReturn(sourceCodeList);
		StrcompAnalyzer strcompAnalyzer = new StrcompAnalyzer(locationReader);
		assertEquals(2, strcompAnalyzer.calculate(nomMetric));		
	}
	
	@Test
	public void testStrcompNocMetric() throws IOException {
		NocMetric nocMetric = new NocMetric();
		LocationReader locationReader = mock(LocationReader.class);
		List<String> sourceCodeList = new ArrayList<>();
		sourceCodeList.add("public class New {");
		sourceCodeList.add("return 0;");
		sourceCodeList.add("//");
		sourceCodeList.add("public class New1 {");
		when(locationReader.readIntoList()).thenReturn(sourceCodeList);
		StrcompAnalyzer strcompAnalyzer = new StrcompAnalyzer(locationReader);
		assertEquals(2, strcompAnalyzer.calculate(nocMetric));		
	}
	

}
