package campos_problem2;

public class SavingsAccount {

	private static double annualInterestRate;
	public double savingsBalance;
	private static double monthlyInterest;
	
	public SavingsAccount(double balance) {
		savingsBalance = balance;
	}
	
	public void calculateMonthlyInterest() {
		monthlyInterest = (savingsBalance * annualInterestRate) / 12;
		savingsBalance += monthlyInterest;
	}
	
	public static void modifyInterestRate(double newRate) {
		annualInterestRate = newRate / 100;
	}
	
}
