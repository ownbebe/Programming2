/* Owen Schneider

Creating a GUI Bank Balance Application: CSC 372-CTA2

Project Purpose: develop a simple GUI that that takes user input, and calculates final balance based on amount entered.

Program inputs: initial balance, amount to be deposited/ withdrawn

Program outputs: final balance

Program limitations: none

Program errors: none that I am aware of*/

package bankBalanceApp;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;

public class bankBalanceApp extends JFrame implements ActionListener{
	private static final long serialVersionUID = 6603520493419999610L;
	private static float balance;
	private static float amount;
	private static JPanel app = new JPanel();
	private static JTextField balanceField = new JTextField(15);
	private static JLabel label = new JLabel("Please enter your balance: ");
	private GridBagConstraints layoutConst = new GridBagConstraints();
	private static JButton dep = new JButton("Deposit");
	private static JButton with = new JButton("Withdrawal");
	private static JButton setBalance = new JButton("Set Balance");
	private static JLabel label2 = new JLabel ("Enter amount: ");
	private static JTextField amountField = new JTextField (15);
	private static boolean withDep = false;
	private static JButton submit = new JButton("Submit");
	private static JButton exit = new JButton("Exit");
	
	bankBalanceApp() {
		app.setBackground(Color.lightGray);
		
		dep.addActionListener(this);
		with.addActionListener(this);
		setBalance.addActionListener(this);
		submit.addActionListener(this);
		exit.addActionListener(this);
		
		balanceField.setEditable(true);
		balanceField.setText("0");
		
		GridBagConstraints positionConst = null;
		GridBagLayout setLayout = (new GridBagLayout());
		app.setLayout(setLayout);
		GridBagConstraints layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		
		app.add(label, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 0;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		app.add(balanceField, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 2;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		app.add(label2, layoutConst);
		label2.setVisible(false);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 2;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		app.add(amountField, layoutConst);
		amountField.setText("0");
		amountField.setVisible(false);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 5;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		app.add(setBalance, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 3;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		app.add(dep, layoutConst);
		dep.setVisible(false);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 3;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		app.add(with, layoutConst);
		with.setVisible(false);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 6;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		app.add(submit, layoutConst);
		submit.setVisible(false);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 6;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		app.add(exit, layoutConst);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String userInput;
		
		String button = event.getActionCommand();
		
		
		switch (button) {
		case "Set Balance": {
			if (balanceField.equals("")) {
				balanceField.setText("Invalid");
				break;
			}
			else {
				dep.setVisible(true);
				with.setVisible(true);
				setBalance.setVisible(false);
				balanceField.setEditable(false);
				userInput = balanceField.getText();
				balance = Float.parseFloat(userInput);
		
				break;
			}
		}
		case "Deposit":{
			label2.setVisible(true);
			amountField.setVisible(true);
			submit.setVisible(true);
			withDep = true;
			
			break;
		}
		
		case "Withdrawal":{
			label2.setVisible(true);
			amountField.setVisible(true);
			submit.setVisible(true);
			withDep = false;
			
			break;
		}
		
		case "Submit":{
			label.setText("Balance: ");
			
			if(withDep == true) {
				if (amountField.equals("")) {
					balanceField.setText("Invalid");
					break;
				}
				else {
					userInput = amountField.getText();
					amount = Float.parseFloat(userInput);
					balance += amount;
					balanceField.setText(Float.toString(balance));
					dep.setVisible(false);
					with.setVisible(false);
					submit.setVisible(false);
					label2.setVisible(false);
					amountField.setVisible(false);
					
					break;
				}
			}
			else {
				if (amountField.equals("")) {
					balanceField.setText("Invalid");
					break;
				}
				else {
					userInput = amountField.getText();
					amount = Float.parseFloat(userInput);
					if(amount > balance) {
						balanceField.setText("Insufficient funds");
						dep.setVisible(false);
						with.setVisible(false);
						submit.setVisible(false);
						label2.setVisible(false);
						amountField.setVisible(false);
						break;
					}
					balance -= amount;
					balanceField.setText(Float.toString(balance));
					dep.setVisible(false);
					with.setVisible(false);
					submit.setVisible(false);
					label2.setVisible(false);
					amountField.setVisible(false);
					
					break;
				}
			}
		}
		case "Exit": {
			System.exit(0);
			
			break;
		}
		default:
			throw new IllegalArgumentException();
		}	
	}

	public static JPanel getApp() {
		return app;
	}

	public static void setApp(JPanel app) {
		bankBalanceApp.app = app;
	}
	}