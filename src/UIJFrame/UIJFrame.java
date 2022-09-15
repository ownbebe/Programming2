package UIJFrame;

import java.awt.*;
import javax.swing.*;


import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class UIJFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton display = new JButton("Display date and time");
	private JButton write = new JButton("Save to file");
	private JButton color = new JButton("Change color");
	private JButton exit = new JButton("Exit");
	private JTextField date = new JTextField(15);
	private JTextField save = new JTextField(15);
	private static JPanel app = new JPanel();
	private GridBagConstraints layoutConst = new GridBagConstraints();
	
	UIJFrame(){
		
		display.addActionListener(this);
		write.addActionListener(this);
		color.addActionListener(this);
		exit.addActionListener(this);
		
		GridBagConstraints positionConst = null;
		GridBagLayout setLayout = (new GridBagLayout());
		app.setLayout(setLayout);
		GridBagConstraints layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		
		app.add(display);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 0;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		app.add(write, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 2;
		layoutConst.gridy = 0;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		app.add(color, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 3;
		layoutConst.gridy = 0;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		app.add(exit, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		app.add(date, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 1;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		app.add(save, layoutConst);
	}
	
	public void actionPerformed(ActionEvent event) {
		String button = event.getActionCommand();
		switch (button) {
		case "Display date and time": {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(("MM/dd/yyyy HH:mm:ss"));
			LocalDateTime now = LocalDateTime.now();
			
			date.setText(dtf.format(now));
			
			break;
		}
		
		case "Save to file":{
			try {
				File myObj = new File("log.txt");
				if (myObj.createNewFile()) {
					save.setText("log.txt created");
					FileWriter myWriter = new FileWriter("log.txt");
					myWriter.write(date.getText());
					myWriter.close();
					
					break;
				}
				else {
					save.setText("log.txt exists");
					FileWriter myWriter = new FileWriter("log.txt");
					myWriter.write(date.getText());
					myWriter.close();
					
					break;
				}
			}
				catch(IOException e) {
					e.printStackTrace();
					
					break;
				}
		}
		
		case "Change color":{
			Random rand = new Random();
			float r1 = rand.nextFloat() /3f;
			float g1 = rand.nextFloat();
			float b1 = rand.nextFloat() /3f;
			
			int r = Math.round(r1);
			int g = Math.round(g1);
			int b = Math.round(b1);
			
		}
		case "Exit":{
			System.exit(0);
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: ");
		}
	}
	public static void main(String[] args) {
		UIJFrame myFrame = new UIJFrame();
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.add(app);
		myFrame.setSize(500, 500);
		myFrame.setVisible(true);
	}
	
}