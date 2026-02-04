package skillbuilders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class LatinPlantNames {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LatinPlantNames window = new LatinPlantNames();
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
	public LatinPlantNames() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(96, 96, 102));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel output = new JLabel("");
		output.setForeground(new Color(162, 166, 89));
		output.setFont(new Font("Tahoma", Font.PLAIN, 18));
		output.setBounds(45, 169, 351, 53);
		frame.getContentPane().add(output);
		
		JComboBox input = new JComboBox();
		input.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				output.setText("Selected plant: " + (String)input.getSelectedItem());
			}
		});
		
		input.setForeground(new Color(162, 166, 89));
		input.setBackground(new Color(96, 96, 102));
		input.setFont(new Font("Tahoma", Font.PLAIN, 25));
		input.setModel(new DefaultComboBoxModel(new String[] {"Basil", "Lavender", "Parsely", "Peppermint", "Saffron", "Sage"}));
		input.setBounds(38, 41, 160, 75);
		frame.getContentPane().add(input);
		
		JLabel lblNewLabel = new JLabel("Select a plant name:");
		lblNewLabel.setBackground(new Color(162, 166, 89));
		lblNewLabel.setForeground(new Color(162, 166, 89));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(41, 16, 160, 14);
		frame.getContentPane().add(lblNewLabel);
		
	}
}
