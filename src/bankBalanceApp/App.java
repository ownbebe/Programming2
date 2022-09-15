package bankBalanceApp;

import javax.swing.JFrame;

public class App extends bankBalanceApp{
	public static void main(String[] args) {
		bankBalanceApp myFrame = new bankBalanceApp();
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.add(getApp());
		myFrame.setSize(500, 500);
		myFrame.setVisible(true);
	}
}
