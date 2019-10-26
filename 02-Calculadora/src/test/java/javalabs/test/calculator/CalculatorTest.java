package javalabs.test.calculator;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javalabs.calculator.Calculator;

public class CalculatorTest {

	private Calculator calculator;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void createCalculator() {
		
		calculator = new Calculator();
	}
	
	@Test
    public void testCreationDefault() {
		
		assertThat(calculator, is(notNullValue()));					
	}
	
	@Test
    public void testSum() {
		
		assertThat(calculator.sum(0, 0), is(0+0));		
		assertThat(calculator.sum(1, 0), is(1+0));	
		assertThat(calculator.sum(1, 1), is(1+1));
		assertThat(calculator.sum(0, 1), is(0+1));
	}
	
	@Test
    public void testMinus() {
		
		assertThat(calculator.minus(0, 0), is(0-0));		
		assertThat(calculator.minus(1, 0), is(1-0));	
		assertThat(calculator.minus(1, 1), is(1-1));
		assertThat(calculator.minus(0, 1), is(0-1));
	}
	
	@Test
    public void testMultiply() {
		
		assertThat(calculator.multiply(0, 0), is(0*0));		
		assertThat(calculator.multiply(1, 0), is(1*0));	
		assertThat(calculator.multiply(1, 1), is(1*1));
		assertThat(calculator.multiply(0, 1), is(0*1));
	}
	
	@Test (expected = ArithmeticException.class)
    public void testDivideByZero() {
		
		assertThat(calculator.divide(1, 0), is(0));	
	}
	
	@Test
	public void testDivide() {
		
		assertThat(calculator.divide(1, 1), is(1/1));
		assertThat(calculator.divide(0, 1), is(0/1));
	}
	
}
