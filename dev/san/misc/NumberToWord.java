package dev.san.misc;

/**
 * Transforms a Number into plain Words.
 * @author Sandeep Hebbar
 * @version 1.0.0
 * @since 2017
 */
public class NumberToWord {

	private static final String SPACE = " ";
	private static final String NEGATIVE = "MINUS";
	private static final String ZERO = "ZERO";
	private static final int ONE = 1;
	private static final int MINUS_ONE = -1;
	private static final int UPPER_LIMIT= 1000000000;
	private static final int LOWER_LIMIT= -1000000000;
	private static final String[] DIGITS = {"","ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE"};
	private static final String[] TEENS = {"TEN","ELEVEN","TWELVE","THIRTEEN","FOURTEEN","FIVTEEN","SIXTEEN","SEVENTEEN","EIGHTEEN","NINETEEN"};
	private static final String[] TENS = {"","","TWENTY","THIRTY","FOURTY","FIFTY","SIXTY","SEVENTY","EIGHTY","NINETY"};
	private static final String[] POWER_LITERALS = {"","","HUNDRED","THOUSAND","THOUSAND","LAKH","LAKH","CRORE","CRORE"};
	private static final long[] POWER_DIVS = {1, 10, 100, 1000, 1000, 100000, 100000, 10000000, 10000000};
	private StringBuilder sb;
	
	/**
	 * <p>Input Number should be within UPPER_LIMIT and LOWER_LIMIT.</p>
	 * <p><u>Example:</u> 1000000000 > INPUT_NUMBER > -1000000000</p>
	 * 
	 * @param input : Input number for conversion
	 */
	public void numToLiteralConverter(long input) {
		int length;
		sb = new StringBuilder("Representation of Number ").append(input).append(" in Words::");
		if(input == 0) {
			sb.append(SPACE).append(ZERO);
		} else if(input >= UPPER_LIMIT || input <= LOWER_LIMIT) {
			System.out.println("Input Number should be within UPPER_LIMIT and LOWER_LIMIT ");
			System.out.println("Example: 1000000000 > INPUT_NUMBER > -1000000000 ");
			return;
		} else {
			if(input < 0) {
				input = input * MINUS_ONE;
				sb.append(SPACE).append(NEGATIVE);
			} 
			length = String.valueOf(input).length()-1;
			numToLiteral(input, length);
		}
		System.out.println(sb.toString());
	}
	
	private void numToLiteral(long input, int length) {
//		System.out.println("input:"+input+", length:"+length);
		long div = input / POWER_DIVS[length];
		long rem = input % POWER_DIVS[length];
//		System.out.println("power:"+POWER_DIVS[length]+", div:"+div+", rem:"+rem);
		if(length == 0) {
			sb.append(SPACE).append(DIGITS[(int) div]);
		} else if(length == 1) {
			if(div<2) {
				sb.append(SPACE).append(TEENS[(int) rem]);
			} else {
				sb.append(SPACE).append(TENS[(int) div]);
				numToLiteral(rem, --length);
			}
		} else {
			if(div>9) {
				numToLiteral(div, ONE);
			} else {
				sb.append(SPACE).append(DIGITS[(int) div]);
			}
			sb.append(SPACE).append(POWER_LITERALS[length]);
			length = String.valueOf(rem).length()-1;
			numToLiteral(rem, length);
		}
	}
}
