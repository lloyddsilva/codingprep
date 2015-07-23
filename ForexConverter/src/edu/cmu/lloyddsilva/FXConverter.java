package edu.cmu.lloyddsilva;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class FXConverter {
	public static final BigDecimal BTCUSD = BigDecimal.valueOf(276.72);
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the source currency: ");
		String fromCurrency =  in.nextLine();
		System.out.println("Enter the target currency: ");
		String toCurrency = in.nextLine();
		System.out.println("Enter the amount: ");
		String amount = in.nextLine();
		
		BigDecimal amountBG = new BigDecimal(amount);
		
		fromCurrency = fromCurrency.toUpperCase();
		toCurrency = toCurrency.toUpperCase();
		
		BigDecimal finalAmount = BigDecimal.ONE; 
		MathContext mc = new MathContext(4);
		
		switch(fromCurrency) {
		case "BTC": finalAmount = amountBG.multiply(getCurrentBTCPrice(), mc);
		break;
		case "USD": finalAmount = amountBG.multiply(getCurrentUSDPrice(), mc);
		break;
		}
		
		System.out.println("Converted amount: " + finalAmount);
		
		
		
		
	}
	
	public static BigDecimal getCurrentBTCPrice(){
		return BTCUSD;
	}
	
	public static BigDecimal getCurrentUSDPrice() {
		MathContext mc = new MathContext(4);
		return BigDecimal.ONE.divide(BTCUSD, mc);
	}
}
