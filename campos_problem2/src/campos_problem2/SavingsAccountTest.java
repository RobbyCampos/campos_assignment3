package campos_problem2;

import java.text.DecimalFormat;

public class SavingsAccountTest {
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	
	private static void printTwelveMonthlyInterest(SavingsAccount saver1, SavingsAccount saver2)
	{
		for(int i = 1; i < 13; i++)
		{
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			System.out.println("Month " + i + ": " + "\tSaver 1 - " + df2.format(saver1.savingsBalance) + "\tSaver 2 - " +df2.format(saver2.savingsBalance));
		}
	}
	
	private static void printOneMonthlyInterest(SavingsAccount saver1, SavingsAccount saver2)
	{
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		System.out.println("\n\nMonth " + "13 at 5%" + ": " + "\tSaver 1 - " + df2.format(saver1.savingsBalance) + "\tSaver 2 - " +df2.format(saver2.savingsBalance));
	}
	
	public static void main(String []args) {

		
		SavingsAccount saver1 = new SavingsAccount (2000.00);
		SavingsAccount saver2 = new SavingsAccount (3000.00);
		
		SavingsAccount.modifyInterestRate(4.0);
		
		printTwelveMonthlyInterest(saver1, saver2);
		
		SavingsAccount.modifyInterestRate(5.0);
		
		printOneMonthlyInterest(saver1, saver2);
		
		
	}
	
}
