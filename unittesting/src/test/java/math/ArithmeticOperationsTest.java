package math;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;
import org.junit.Rule;

public class ArithmeticOperationsTest {
	
	ArithmeticOperations obj = new ArithmeticOperations();

	@Test
	public void testDivide() {
		Assert.assertEquals(5.0, obj.divide(20.0, 4.0), 0.00001);
	}
	
	@Test
	public void testZeroNumDivision() {
		Assert.assertEquals(0, obj.divide(0, 5), 0.00001);
	}
	
	@Test(expected=ArithmeticException.class)
	public void testDevideByZero() {
		obj.divide(2,0);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testBothNegativesMultiplication() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		obj.multiply(-1, -4);
	} 
	
	@Test
	public void testIntegerFit() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The product does not fit in an Integer variable");
		obj.multiply(2, Integer.MAX_VALUE);
	} 
	
	@Test
	public void testNegativeXMultiplication() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		obj.multiply(-1, 5);
	} 
	
	@Test
	public void testNegativeYMultiplication() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		obj.multiply(1, -5);
	}
	
	@Test
	public void testMutiplication() {
		Assert.assertEquals(20, obj.multiply(4, 5));
	}
	
	@Test
	public void testZeroMultiplication() {
		Assert.assertEquals(0, obj.multiply(0, 3));
		Assert.assertEquals(0, obj.multiply(0, 0));
		Assert.assertEquals(0, obj.multiply(4, 0));
	}

}

	