package GridBagExample;
import java.awt.*;
import javax.swing.*;

public class GridBagExample extends JFrame{
	private static JPanel panel = new JPanel();
	private JLabel label = new JLabel("Title");
	private JButton button1 = new JButton("Button 1");
	private JButton button2 = new JButton("Button 2");
	private GridBagConstraints layoutConst = new GridBagConstraints();
	
	GridBagExample(){
		GridBagConstraints positionConst = null;
		GridBagLayout setLayout = (new GridBagLayout());
		panel.setLayout(setLayout);
		GridBagConstraints layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		panel.add(label, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		panel.add(button1, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 1;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		panel.add(button2, layoutConst);
	}
	
	public static void main(String[] args) {
		GridBagExample myFrame = new GridBagExample();
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.add(panel);
		myFrame.pack();;
		myFrame.setVisible(true);
	}
	
}