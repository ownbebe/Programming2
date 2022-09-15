package simpleFrame;
import javax.swing.JFrame;

class simpleFrame {
	public static void main(String[] args) {
		JFrame myFrame = new JFrame("Discussion");
		myFrame.setSize(500, 500);
		myFrame.setLocation(100, 100);
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}