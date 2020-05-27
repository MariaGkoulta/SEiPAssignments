package codeanalyzer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class NomMetricTest {

	NomMetric nomMetric = new NomMetric();

	@Test
	public void testGetCorrectLocPattern() {
		String expectedStringPattern = ".*(public |protected |private |static )?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*";
		assertEquals(expectedStringPattern, nomMetric.getPattern());
	}

	@Test
	public void testGetWrongLocPattern() {
		String expectedStringPattern = ".*(public |protected |static )?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*";
		assertNotEquals(expectedStringPattern, nomMetric.getPattern());
	}


	@Test
	public void testEvaluateValidLine() {
		Boolean allValid = true;
		List<String> expectedValidLines = new ArrayList<>();
		expectedValidLines.add("public new() {");
		expectedValidLines.add("private new() {");
		expectedValidLines.add("protected new() {");
		expectedValidLines.add("void new() {");
		expectedValidLines.add("int new() {");
		for (String line : expectedValidLines) {
			allValid = nomMetric.evaluateLine(line);
		}
		assertTrue(allValid);
	}

	@Test
	public void testEvaluateInvalidLine() {
		Boolean validExists = false;
		List<String> expectedInvalidLines = new ArrayList<>();
		expectedInvalidLines.add("no method");
		expectedInvalidLines.add("public { ");
		expectedInvalidLines.add("int } ");
		expectedInvalidLines.add("void (");
		expectedInvalidLines.add("protected ()");
		for (String line : expectedInvalidLines) {
			validExists = nomMetric.evaluateLine(line);
		}
		assertFalse(validExists);
	}

	@Test
	public void testGetCorrectLocName() {
		assertEquals("nom", nomMetric.getName());
	}

	@Test
	public void testSubstractFromTotal() {
		assertFalse(nomMetric.substractFromTotal());
	}
}
