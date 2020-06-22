package codeanalyzer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class NocMetricTest {
	NocMetric nocMetric = new NocMetric();
	
	@Test
	public void testGetCorrectLocPattern() {
		String expectedStringPattern = ".*\\s*class\\s+.*";
		assertEquals(expectedStringPattern, nocMetric.getPattern());
		}
	
	@Test
	public void testGetWrongLocPattern() {
		String expectedStringPattern = ".*\\\\s*clas\\\\s+.*";
		assertNotEquals(expectedStringPattern, nocMetric.getPattern());
		}
	
	@Test
	public void testEvaluateValidLine() {
		Boolean allValid = true;
		List<String> expectedInvalidLines = new ArrayList<>();
		expectedInvalidLines.add("class  ");
		expectedInvalidLines.add("public class NewClass {  ");
		for (String line: expectedInvalidLines) {
			allValid = nocMetric.evaluateLine(line);
		}
		assertTrue(allValid);
	}
	
	@Test
	public void testEvaluateInvalidLine() {
		String invalidLine = "clas";
		assertFalse(nocMetric.evaluateLine(invalidLine));
	}
	
	@Test
	public void testGetCorrectLocName() {
		assertEquals("noc", nocMetric.getName());		
	}
	
	@Test
	public void testSubstractFromTotal() {
		assertFalse(nocMetric.substractFromTotal());		
	}

}
