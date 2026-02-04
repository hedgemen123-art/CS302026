package skillbuilders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DivisibleBy3 {

	private JFrame frame;
	private JTextField input;

	
	public boolean divisby3(String x) {
		boolean divis; 
		double test;
	
		test = Double.parseDouble(x);

		
		if ((double)test % 3 > 0) {
			divis = false;
		} 
		else {
			divis = true;
		}
			
		return(divis);
	}
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DivisibleBy3 window = new DivisibleBy3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DivisibleBy3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 313, 135);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel output = new JLabel("");
		output.setFont(new Font("Tahoma", Font.PLAIN, 10));
		output.setBounds(133, 53, 86, 32);
		frame.getContentPane().add(output);
		
		JLabel lblNewLabel = new JLabel("Enter an Integer:");
		lblNewLabel.setBounds(34, 28, 102, 14);
		frame.getContentPane().add(lblNewLabel);
		
		input = new JTextField();
		input.setBounds(133, 25, 86, 20);
		frame.getContentPane().add(input);
		input.setColumns(10);
		
		JButton pressme = new JButton("Check\r\n");
		pressme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (divisby3((input.getText())) == true) {
					output.setText("<html>Number is divisible by 3.</html>");
				} else if (divisby3((input.getText())) == false) {
					output.setText("<html>Number is not divisible by 3.</html>");
				} else {
					output.setText("<html>Error. Try again.</html>");
				}
					
			}
		});
		pressme.setBounds(34, 53, 89, 23);
		frame.getContentPane().add(pressme);
		
		
	}

}
