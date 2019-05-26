package test;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.RomanNumberConverter;

public class RomanNumberConverterTest {

	private RomanNumberConverter underTest;

	@Before
	public void setUp() {
		underTest = new RomanNumberConverter();
	}

	@Test
	public void testIToBe1() {
		assertConvert("I", 1);
	}

	@Test
	public void testVToBe5() {
		assertConvert("V", 5);
	}

	@Test
	public void testVIToBe6() {
		assertConvert("VI", 6);

	}

	@Test
	public void testVToBe10() {
		assertConvert("X", 10);
	}

	@Test
	public void testIVToBe4() {
		assertConvert("IV", 4);
	}

	@Test
	public void testIXToBe9() {
		assertConvert("IX", 9);
	}

	@Test
	public void testXLToBe40() {
		assertConvert("XL", 40);
	}

	@Test
	public void testXCIXToBe99() {
		assertConvert("XCIX", 99);
	}

	private void assertConvert(String stringInput, int stringOutput) {
		int result = underTest.convert(stringInput);
		Assert.assertThat(result, CoreMatchers.equalTo(stringOutput));
	}
}