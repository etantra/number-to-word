package dev.san.misc;

public class NumberToWordTest {

	public static void main(String[] args) {
		System.out.println("NumberToWordTest");
		long input = -987654321;
		NumberToWord test = new NumberToWord();
		test.numToLiteralConverter(input);
	}

}
