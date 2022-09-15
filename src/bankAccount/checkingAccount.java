package bankAccount;
import java.util.Scanner;

public class checkingAccount extends bankAccount {
	private static double interestRate;
	private  static double overdraftFee = 30;
	private static double with;
	private static double dep;
	
	public static double processWithdrawl() {
		Scanner scan = new Scanner(System.in);
		System.out.println("How much would you like to withdraw: ");
		with = scan.nextDouble();
		
		with = Math.abs(with);
		
		if(with > getBalance()) {
			withdrawal(with);
			System.out.println("You have been charged an overdraft fee of " + overdraftFee + ".");
			setBalance(getBalance() - overdraftFee);
			System.out.println("Your balance is: " + getBalance());
		}
		
		else {
			withdrawal(with);
			System.out.println("Your balance is: " + getBalance());
		}
		return getBalance();
	}
	
	
	public static void displayAccount() {
		System.out.println("Your interest rate is: " + interestRate);
		accountSummary();
	}
	
	public static void menu() {
		System.out.println("Options");
		System.out.println("---------------");
		System.out.println("1. Deposit");
		System.out.println("2. Withdrawl");
		System.out.println("3. Account summary");
		System.out.println("4. Exit");
		System.out.println("Enter option: ");
	}

	public static double getDep() {
		return dep;
	}


	public static void setDep(double dep) {
		checkingAccount.dep = dep;
	}
}
