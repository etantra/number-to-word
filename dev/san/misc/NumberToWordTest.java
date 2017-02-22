package dev.san.misc;

/**
 * Test Class to run the Number to Word conversion logic
 * @author Sandeep Hebbar
 * @version 1.0.0
 * @since 2017
 */
public class NumberToWordTest {

	public static void main(String[] args) {
		System.out.println("NumberToWordTest");
		long input = -987654321;
		NumberToWord test = new NumberToWord();
		test.numToLiteralConverter(input);
	}

}
