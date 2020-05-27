package codeanalyzer;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class StrcompAnalyzerTest {
	
	@Test
	public void testStrcompLocMetric() {
		LocMetric locMetric = new LocMetric();
		List<String> sourceCodeList = new ArrayList<>();
		sourceCodeList.add("x + y = 5");
		sourceCodeList.add("//");
		sourceCodeList.add("return 0;");
		sourceCodeList.add("public class New");
		StrcompAnalyzer strcompAnalyzer = new StrcompAnalyzer(sourceCodeList);
		assertEquals(3, strcompAnalyzer.calculate(locMetric));		
	}
	
	@Test
	public void testStrcompLomMetric() {
		NomMetric nomMetric = new NomMetric();
		List<String> sourceCodeList = new ArrayList<>();
		sourceCodeList.add("public void new() {");
		sourceCodeList.add("return 0;");
		sourceCodeList.add("private new() {");
		sourceCodeList.add("public class New");
		StrcompAnalyzer strcompAnalyzer = new StrcompAnalyzer(sourceCodeList);
		assertEquals(2, strcompAnalyzer.calculate(nomMetric));		
	}
	
	@Test
	public void testStrcompNocMetric() {
		NocMetric nocMetric = new NocMetric();
		List<String> sourceCodeList = new ArrayList<>();
		sourceCodeList.add("public class New {");
		sourceCodeList.add("return 0;");
		sourceCodeList.add("//");
		sourceCodeList.add("public class New1 {");
		StrcompAnalyzer strcompAnalyzer = new StrcompAnalyzer(sourceCodeList);
		assertEquals(2, strcompAnalyzer.calculate(nocMetric));		
	}
	

}
