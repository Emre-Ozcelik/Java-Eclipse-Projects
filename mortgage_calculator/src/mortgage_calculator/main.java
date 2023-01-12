package mortgage_calculator;

import java.text.NumberFormat;
import java.util.Scanner;



public class main {
	public static void main(String[] args) {
		final int MONTH = 12;
		final int PERCENT = 100;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Principal: ");
		int principal = scanner.nextInt();
		
		System.out.print("Annual Interest Rate: ");
		float annualInterest = scanner.nextFloat();
		float monthlyInterest =annualInterest / PERCENT / MONTH;
		
		System.out.println("Period (Years): ");
		int years = scanner.nextInt();
		int numberOfPayments = years * MONTH;
		
		double mortgage = principal *
                (monthlyInterest * Math.pow(1+monthlyInterest,numberOfPayments))
                /(Math.pow(1+monthlyInterest,numberOfPayments)-1);
		
		String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
	    System.out.println("Mortgage: "+mortgageFormatted);
	    
	}
 
}
