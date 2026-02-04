package skillbuilders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class SemesterAvg {

	private JFrame frame;
	private JTextField grade1;
	private JTextField grade2;
	private JTextField grade3;
	DecimalFormat dc = new DecimalFormat("0"); // to convert decimals to the nearest hundredth
	private JLabel output;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SemesterAvg window = new SemesterAvg();
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
	public SemesterAvg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel grade1ins = new JLabel("Enter the first grade:");
		grade1ins.setFont(new Font("Tahoma", Font.PLAIN, 16));
		grade1ins.setBounds(42, 44, 164, 31);
		frame.getContentPane().add(grade1ins);
		
		grade1 = new JTextField();
		grade1.setBounds(251, 46, 94, 31);
		frame.getContentPane().add(grade1);
		grade1.setColumns(10);
		
		JLabel grade2ins = new JLabel("Enter the second grade:");
		grade2ins.setFont(new Font("Tahoma", Font.PLAIN, 16));
		grade2ins.setBounds(42, 86, 181, 31);
		frame.getContentPane().add(grade2ins);
		
		grade2 = new JTextField();
		grade2.setColumns(10);
		grade2.setBounds(251, 88, 94, 31);
		frame.getContentPane().add(grade2);
		
		JLabel grade3ins = new JLabel("Enter the third grade:");
		grade3ins.setFont(new Font("Tahoma", Font.PLAIN, 16));
		grade3ins.setBounds(42, 128, 181, 31);
		frame.getContentPane().add(grade3ins);
		
		grade3 = new JTextField();
		grade3.setColumns(10);
		grade3.setBounds(251, 130, 94, 31);
		frame.getContentPane().add(grade3);
		
		JButton pressme = new JButton("Average");
		pressme.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pressme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txtgr1 = grade1.getText();
				double gr1 = Double.parseDouble(txtgr1);
				String txtgr2 = grade2.getText();
				double gr2 = Double.parseDouble(txtgr2);
				String txtgr3 = grade3.getText();
				double gr3 = Double.parseDouble(txtgr3);
				double avggrade = (gr1 + gr2 + gr3) /3;
				output.setText(dc.format(avggrade) + "%");
			}
		});
		pressme.setBounds(42, 170, 103, 42);
		frame.getContentPane().add(pressme);
		
		output = new JLabel("");
		output.setFont(new Font("Tahoma", Font.PLAIN, 18));
		output.setBounds(171, 170, 85, 42);
		frame.getContentPane().add(output);
	}
}
