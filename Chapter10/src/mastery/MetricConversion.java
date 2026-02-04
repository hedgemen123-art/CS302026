package mastery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/*
Program: MetricConversion.java          Last Date of this Revision: December 9, 2024

Purpose: Create a MetricConversion application that allows the user to select a type of conversion from a combo box and then the corresponding formula is displayed in a label.

Author: bilal 
School: CHHS
Course: Computer Programming 30
*/


public class MetricConversion {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MetricConversion window = new MetricConversion();
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
	public MetricConversion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(117, 136, 166));
		frame.setBounds(100, 100, 255, 149);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel output = new JLabel("1 inch = 2.54 centimeters");
		output.setFont(new Font("Tahoma", Font.PLAIN, 12));
		output.setForeground(new Color(208, 202, 125));
		output.setBackground(new Color(117, 136, 166));
		output.setBounds(35, 62, 181, 20);
		frame.getContentPane().add(output);
		
		JComboBox input = new JComboBox();
		input.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) { // detects when a different option is selected from combo box
				if (input.getSelectedItem().equals("Inches to centimeters")){ // finds which option is selected by the combo box
					output.setText("1 inch = 2.54 centimeters"); //outputs formula for the type
					
				} else if (input.getSelectedItem().equals("Feet to meters")) {// finds which option is selected by the combo box
					output.setText("1 foot = 0.3048 meters");//outputs formula for the type
					
				} else if (input.getSelectedItem().equals("Gallons to liters")){// finds which option is selected by the combo box
					output.setText("1 gallon = 4.5461 liters");//outputs formula for the type
				}
				
			}
		});
		
		input.setBackground(new Color(117, 136, 166));
		input.setForeground(new Color(208, 202, 125));
		
		input.setModel(new DefaultComboBoxModel(new String[] {"Inches to centimeters", "Feet to meters", "Gallons to liters"}));
		input.setBounds(25, 37, 177, 20);
		frame.getContentPane().add(input);
		
		
		JLabel lblNewLabel = new JLabel("Select a conversion type:");
		lblNewLabel.setForeground(new Color(208, 202, 125));
		lblNewLabel.setBounds(25, 24, 142, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
	}
}
