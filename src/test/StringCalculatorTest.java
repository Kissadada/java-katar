package test;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.StringCalculator;

public class StringCalculatorTest {
	private StringCalculator underTest;

	@Before
	public void setUp() {
		underTest = new StringCalculator();
	}

	@Test
	public void testStringEmpty() {
		assertAdd("", 0);
	}

	@Test
	public void testReturnOneWhenInputAreOne() {
		assertAdd("1", 1);
	}

	@Test
	public void testReturnThreeWhenInputAreOneAndTwo() {
		assertAdd("1,2", 3);
	}

	@Test
	public void testThereIsSlashNinString() {
		assertAdd("1\\n2,3", 6);
	}

	@Test
	public void testReturnSixWhenOneTwoThree() {
		assertAdd("1,2,3", 6);
	}

	@Test
	public void testReturnSixWhenOneTwoThree2() {
		assertAdd("//%\\n1%2%3", 6);
	}

	@Test
	public void testReturnSixWhenOneTwoThree3() {
		assertAdd("//%\\n1\\n2%3", 6);
	}

	private void assertAdd(String inputString, int expectedResult) {
		int result = underTest.add(inputString);
		Assert.assertThat(result, CoreMatchers.equalTo(expectedResult));
	}

}