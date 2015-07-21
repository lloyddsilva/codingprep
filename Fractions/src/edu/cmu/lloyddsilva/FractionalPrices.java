package edu.cmu.lloyddsilva;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/*
Buy 3 pairs of socks for $4.50
Buy 3 pairs of socks for $4 2/4

toFraction
input: decimal number
output: string

Requirements:
- Must have a denominator of 4: eg 4.50 => 4 2/4
- If numerator is 0, don't show fraction: 4.00 => 4
- If integer part is 0, don't show it: 0.75 => 3/4

 */

public class FractionalPrices {
	public static final BigDecimal PRICE_MIN = BigDecimal.ZERO;
	public static final BigDecimal PRICE_MAX = BigDecimal.valueOf(10000000);
	public static final BigDecimal PRICE_INTERVAL = BigDecimal.valueOf(0.25);
	public static final BigDecimal PRICE_DENOMINATOR = BigDecimal.valueOf(4);

	public static void main(String[] args) {

		//Test whole numbers
		assertEquals("0", toFraction(0.00));
		assertEquals("1", toFraction(1.00));
		assertEquals("10", toFraction(10.00));
		
		//Test exact fractions
		assertEquals("1/4", toFraction(0.25));
		assertEquals("2/4", toFraction(0.50));
		assertEquals("3/4", toFraction(0.75));
		
		//Test whole numbers + exact fractions
		assertEquals("1 1/4", toFraction(1.25));
		assertEquals("1 2/4", toFraction(1.50));
		assertEquals("1 3/4", toFraction(1.75));
		
		//Test round up fractions
		assertEquals("1", toFraction(0.95));
		assertEquals("1 1/4", toFraction(1.20));
		assertEquals("1 2/4", toFraction(1.45));
		assertEquals("1 3/4", toFraction(1.70));
		assertEquals("2", toFraction(1.90));
		
		//Test round down fractions
		assertEquals("1", toFraction(1.10));
		assertEquals("1 1/4", toFraction(1.30));
		assertEquals("1 2/4", toFraction(1.60));
		assertEquals("1 3/4", toFraction(1.80));
		
		//Test mid-point fractions
		assertEquals("1 1/4", toFraction(1.125));
		assertEquals("1 2/4", toFraction(1.375));
		assertEquals("1 3/4", toFraction(1.625));
		assertEquals("2", toFraction(1.875));
		
		//Test just above mid-point fractions
		assertEquals("1 1/4", toFraction(1.126));
		assertEquals("1 2/4", toFraction(1.376));
		assertEquals("1 3/4", toFraction(1.626));
		assertEquals("2", toFraction(1.876));
		
		//Test just below mid-point fractions
		assertEquals("1", toFraction(1.124));
		assertEquals("1 1/4", toFraction(1.374));
		assertEquals("1 2/4", toFraction(1.624));
		assertEquals("1 3/4", toFraction(1.874));
		
		//Test invalid input - acceptable range 0 <= price <= 10,000,000
		try {
			assertEquals("", toFraction(-1));
		} catch(NumberFormatException nfe) {
			System.out.println("Caught expected exception: " + nfe.getMessage());
		}
		
		try {
			assertEquals("", toFraction(10000001.00));
		} catch(NumberFormatException nfe) {
			System.out.println("Caught expected exception: " + nfe.getMessage());
		}
		
		//Test invalid input - null
		try {
			assertEquals("", toFraction(null));
		} catch(NumberFormatException nfe) {
			System.out.println("Caught expected exception: " + nfe.getMessage());
		}
		
	}

	/**
	 * Converts a decimal based price into a fractional price
	 * @param price (double)
	 * @return fractional representation of given price
	 */
	public static String toFraction(double price) {
		return toFraction(BigDecimal.valueOf(price));
	}

	/**
	 * Converts a decimal based price into a fractional price
	 * @param price (BigDecimal)
	 * @return fractional representation of given price
	 */
	public static String toFraction(BigDecimal price) {
		//Check that price is in the valid range
		if(price == null || !isInRange(price)) {
			throw new NumberFormatException("The price " + price + " is outside the expected range");
		}
		
		//Round price to the nearest decimal quarter
		price = roundToNearestQuarter(price);
		
		//Append the whole number portion for >0 prices
		StringBuilder output = new StringBuilder();
		BigInteger wholePrice = price.toBigInteger();
		if(wholePrice.compareTo(BigInteger.ZERO) > 0) {
			output.append(wholePrice);
		} 
		
		//Extract the decimal portion
		BigDecimal decimalPrice = price.remainder(BigDecimal.ONE);
		
		//Convert decimal to fraction and append to output. Add padding if an existing whole number is present
		if(decimalPrice.compareTo(BigDecimal.ZERO) > 0 ) {
			if(output.length() > 0) {
				output.append(" ");
			}
			output.append(getDecimalAsFraction(decimalPrice));
		}
		
		//Append the whole number portion for = 0 prices
		if(price.compareTo(BigDecimal.ZERO) == 0) {
			output.append(wholePrice);
		}
		
		return output.toString();
		
	}
	
	/**
	 * Checks if the given price is in a valid range. Uses a default range if no range (min, max) is specified
	 * @param decimal based price.
	 * @return returns true if the given price is within a valid range.
	 */
	public static boolean isInRange(BigDecimal price) {
		return isInRange(price, PRICE_MIN, PRICE_MAX);
	}
	
	/**
	 * Checks if the given price is in a valid range. 
	 * @param decimal based price.
	 * @param min value in range
	 * @param max value in range
	 * @return returns true if the given price is within a valid range.
	 */
	public static boolean isInRange(BigDecimal price, BigDecimal min, BigDecimal max) {
		return max.compareTo(price) >= 0  && min.compareTo(price) <= 0;
	}
	
	/**
	 * Rounds a given price to its nearest quarter interval i.e. .00, .25, .50, .75
	 * @param decimal based price
	 * @return rounded price
	 */
	public static BigDecimal roundToNearestQuarter(BigDecimal price) {
		return price.divide(PRICE_INTERVAL).setScale(0, RoundingMode.HALF_UP).multiply(PRICE_INTERVAL);
	}
	
	/**
	 * Converts a decimal into a fractional representation with a fixed denominator
	 * @param decimal number
	 * @return fractional representation as string
	 */
	public static String getDecimalAsFraction(BigDecimal input) {
		StringBuilder sb = new StringBuilder();
		sb.append(input.multiply(PRICE_DENOMINATOR).stripTrailingZeros());
		sb.append("/" + PRICE_DENOMINATOR);
		return sb.toString();
	}
	
	public static void assertEquals(String exp, String act)  {
		if ((exp == null && act == null) || exp.equals(act)) {
			System.out.printf("They match! '%s'%n", exp);
		} else {
			System.out.printf("Uh oh! exp='%s', act='%s'%n", exp, act);
		}
	}

}

