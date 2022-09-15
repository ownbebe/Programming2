package bankAccount;

import java.util.Scanner;

public class bank extends checkingAccount{
	public static void main(String[] args) {
		boolean flag = true; 
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		
		while(flag) {
			menu();
			choice = scan.nextInt();
			
			switch (choice) {
			case 1: {
				System.out.println("How  much would you like to deposit: ");
				setDep(scan.nextDouble());
				if(getDep() < 0) {
					System.out.println("Invalid input.");
					
					
					break;
				}
					
				
				deposit(getDep());
				
				break;
			}
			case 2: {
				processWithdrawl();
				
				break;
			}
			
			case 3: {
				displayAccount();
				
				break;
			}
			
			case 4: {
				System.out.println("Exiting");
				flag =  false;
				
				break;
			}
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}
}
