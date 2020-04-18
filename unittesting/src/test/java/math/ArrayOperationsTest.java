package math;

import org.junit.Assert;
import org.junit.Test;

import io.FileIO;

import static org.mockito.Mockito.*;

public class ArrayOperationsTest {
	ArrayOperations arrop = new ArrayOperations();
	
	@Test
	public void testFindPrimesInFile() {
		MyMath myMath = mock(MyMath.class);
		FileIO fileIo = mock(FileIO.class);
		
		String path = "src/test/resources/numbers";
		when(fileIo.readFile(path)).thenReturn(new int[] {20, 15, 12, 11, 13, 7, 9, 10});
		when(myMath.isPrime(20)).thenReturn(false);
		when(myMath.isPrime(15)).thenReturn(false);
		when(myMath.isPrime(12)).thenReturn(false);
		when(myMath.isPrime(11)).thenReturn(true);
		when(myMath.isPrime(13)).thenReturn(true);
		when(myMath.isPrime(7)).thenReturn(true);
		when(myMath.isPrime(9)).thenReturn(false);
		when(myMath.isPrime(10)).thenReturn(false);
		int[] expected = {11, 13, 7};
		int[] actual = arrop.findPrimesInFile(fileIo, path, myMath);
		
		Assert.assertArrayEquals(expected, actual);		
	}

}
