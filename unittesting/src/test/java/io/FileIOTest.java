package io;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FileIOTest {

	FileIO fileio = new FileIO();
	public static String resourcesPath = "src/test/resources/";

	@Test
	public void testReadFileValidInput() {
		int[] expectedNumbers = new int[] {20, 15, 12, 11, 13, 7, 9, 10};
		String validInputFilepath = resourcesPath.concat("numbers");

		Assert.assertArrayEquals(expectedNumbers, fileio.readFile(validInputFilepath));
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testNonexistentFile() {
		String invalidInputFilepath = resourcesPath.concat("xyz");
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input file does not exist");
		fileio.readFile(invalidInputFilepath);
	}

	@Test
	public void testBothNegativesMultiplication() {
		String emptyFilepath = resourcesPath.concat("emptyFile");
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Given file is empty");
		fileio.readFile(emptyFilepath);
	}

	@Test
	public void testReadFileContainsInvalidEntries() {
		int[] expectedNumbers = new int[] {10, 12, 13, 17, 11};
		String misformatedFilepath = resourcesPath.concat("random");
		Assert.assertArrayEquals(expectedNumbers, fileio.readFile(misformatedFilepath));
	}
}
