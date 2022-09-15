/* Owen Schneider

Implementing a Superclass Bank Account: CSC 372-CTA1

Project Purpose: implement a superclass bank account and a subclass checking account that accepts all bank account transactions.
The subclass should display all information for both classes.

Program inputs: deposit, and withdrawal amount

Program outputs: first name, last name, accountID, and balance

Program limitations: testing, more information in bankAccountTest.java

Program errors: none that I am aware of*/

package bankAccount;
import java.util.Scanner;

class bankAccount {
	private static String  firstName;
	private static String lastName;
	private static int accountID;
	private static double balance;
	
	public bankAccount() {
		setBalance(0);
	}
	
	public static double deposit(double deposit) {
		setBalance(getBalance() + deposit);
		System.out.println("Your new balance is: " + getBalance());
		return getBalance();
	}
	
	public static double withdrawal(double withdrawl) {
		setBalance(getBalance() - withdrawl);
		return getBalance();
	}
	
	public static String getFirstName() {
		return firstName;
	}

	public static void setFirstName(String firstName) {
		bankAccount.firstName = firstName;
	}

	public static String getLastName() {
		return lastName;
	}

	public static void setLastName(String lastName) {
		bankAccount.lastName = lastName;
	}

	public static int getAccountID() {
		return accountID;
	}

	public static void setAccountID(int accountID) {
		bankAccount.accountID = accountID;
	}
	
	public static double getBalance() {
		return balance;
	}
	
	public static void accountSummary() {
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(accountID);
		System.out.println(getBalance());
	}

	public static void setBalance(double balance) {
		bankAccount.balance = balance;
	}
}