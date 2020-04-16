package math;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class MyMathTest {

	MyMath obj = new MyMath();

	@Test(expected=IllegalArgumentException.class)
	public void testNegativeFactorial() {
		obj.factorial(-1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testLargeFactorial() {
		obj.factorial(15);
	}
}
