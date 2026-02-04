package mastery;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.util.Random;
import java.util.Random.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Panel;
import javax.swing.JPanel;
import java.awt.Font;

/*
Program: BreakAPlate.java          Last Date of this Revision: December 9, 2024

Purpose: Modify the BreakAPlate application to display a picture of the prize rather then text naming the prize.

Author: bilal 
School: CHHS
Course: Computer Programming 30
*/


public class BreakAPlate {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	    
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BreakAPlate window = new BreakAPlate();
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
	public BreakAPlate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Instance of the random class
	    Random rand = new Random(); 
	    
		//creating the varibles for the images used in the gui
		ImageIcon tigerplush = new ImageIcon("C:/Users/78353001/git/CS20P2F2024/Chapter10/pictures/images/tiger_plush.gif");
		ImageIcon sticker = new ImageIcon("C:/Users/78353001/git/CS20P2F2024/Chapter10/pictures/images/sticker.gif");
		ImageIcon brokenplate3 = new ImageIcon("C:/Users/78353001/git/CS20P2F2024/Chapter10/pictures/images/plates_all_broken.gif");
		ImageIcon brokenplate2 = new ImageIcon("C:/Users/78353001/git/CS20P2F2024/Chapter10/pictures/images/plates_two_broken.gif");
		ImageIcon brokenplate0 = new ImageIcon("C:/Users/78353001/git/CS20P2F2024/Chapter10/pictures/images/plates.gif");
		ImageIcon placeholder = new ImageIcon("C:/Users/78353001/git/CS20P2F2024/Chapter10/pictures/images/placeholder.gif;");
		
		
		
	
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel prize = new JLabel("");
		prize.setBounds(153, 134, 111, 80);
		prize.setIcon(placeholder);
		frame.getContentPane().add(prize);

		
		JLabel plate = new JLabel("");
		plate.setBounds(79, 18, 279, 71);
		plate.setIcon(brokenplate0);
		frame.getContentPane().add(plate);
		

		
		JButton pressme = new JButton("Play Again");
		pressme.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pressme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numb1 = rand.nextInt(2); //generating a random int between 0-1, and makes 3 of these varibles
				int numb2 = rand.nextInt(2);
				int numb3 = rand.nextInt(2);
				
				int score = numb1 + numb2 + numb3;
				
				
				if (score == 3) {//if so if the player wins and no plates break this is what happens
					plate.setIcon(brokenplate0); //sets plates to none broken
					prize.setIcon(tigerplush); //sets prize to the tiger
				}
				else if (score == 2){
					plate.setIcon(brokenplate2);
					prize.setIcon(sticker);
				} 
				else if (score <= 1){
					plate.setIcon(brokenplate3);
					prize.setIcon(sticker);
				} 
				
			}
		});
		pressme.setBounds(153, 100, 111, 38);
		frame.getContentPane().add(pressme);
		
		
		
	
		
	

	}
}
