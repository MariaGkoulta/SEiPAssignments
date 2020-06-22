package codeanalyzer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LocMetricTest {
	
	LocMetric locMetric = new LocMetric();
	
	@Test
	public void testGetCorrectLocPattern() {
		String expectedStringPattern = "((//.*)|(/\\*.*)|(\\*+.*))";
		assertEquals(expectedStringPattern, locMetric.getPattern());
		}
	
	@Test
	public void testGetWrongLocPattern() {
		String expectedStringPattern = "((//.*)|(/\\*.*)|(+.*))";
		assertNotEquals(expectedStringPattern, locMetric.getPattern());
		}
	
	@Test
	public void testEvaluateInvalidLine() {
		Boolean allValid = true;
		List<String> expectedInvalidLines = new ArrayList<>();
		expectedInvalidLines.add("//  ");
		expectedInvalidLines.add("/* comment  ");
		expectedInvalidLines.add("* one more comment ");
		expectedInvalidLines.add("{");
		expectedInvalidLines.add("}");
		expectedInvalidLines.add("");
		for (String line: expectedInvalidLines) {
			allValid = locMetric.evaluateLine(line);
		}
		assertTrue(allValid);
	}
	
	@Test
	public void testEvaluateValidLine() {
		String invalidLine = "return x + y";
		assertFalse(locMetric.evaluateLine(invalidLine));
	}
	
	@Test
	public void testGetCorrectLocName() {
		assertEquals("loc", locMetric.getName());		
	}
	
	@Test
	public void testSubstractFromTotal() {
		assertTrue(locMetric.substractFromTotal());		
	}
}
