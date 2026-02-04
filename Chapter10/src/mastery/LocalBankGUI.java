package mastery;


/*
Program: LocalBankGUI.java          Last Date of this Revision: December 9, 2024

Purpose: Create a LocalBankGUI application that implements a GUI for the Local Bank case study from chapter 9

Author: bilal 
School: CHHS
Course: Computer Programming 30
*/


import java.awt.event.ActionEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LocalBankGUI 
{
	JFrame frame;
	JPanel contentPane;
	JComboBox bankActivities;
	JLabel bankListPrompt;
	JLabel instructions, acctPrompt, amtPrompt, fNamePrompt, lNamePrompt, begBalancePrompt;
	JLabel acctInfo;
	JTextField acctNum, amt, fName, lName, begBalance;
	JButton processTransaction;
	Bank easySave = new Bank();

    public LocalBankGUI(){
        /* Create and set up the frame */
        frame = new JFrame("LocalBankGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Create a content pane with a BoxLayout and empty borders */
        contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		/* Create a combo box and a descriptive label */
	    bankListPrompt = new JLabel("Select an action: ");
	    bankListPrompt.setAlignmentX(JLabel.LEFT_ALIGNMENT);
	    contentPane.add(bankListPrompt);

	    String[] actions = {"Deposit", "Withdrawal", "Check Balance", "Add Account", "Remove Account"};
	    bankActivities = new JComboBox(actions);
	    bankActivities.setAlignmentX(JComboBox.LEFT_ALIGNMENT);
	    bankActivities.setSelectedIndex(0);
	    bankActivities.addActionListener(new ActionSelectedListener());
	    contentPane.add(bankActivities);

		/* Create and add labels and text fields for retrieving input */
		instructions = new JLabel("Complete the information in RED");
	    instructions.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

	    contentPane.add(instructions);

	    acctPrompt = new JLabel("Account number: ");
	    acctPrompt.setForeground(Color.red);			//set to red because this is the default action
	    contentPane.add(acctPrompt);
	    acctNum = new JTextField(6);
	    contentPane.add(acctNum);

	    amtPrompt = new JLabel("Amount of deposit/withdrawal: ");
	    amtPrompt.setForeground(Color.red);				//set to red because this is the default action
	    contentPane.add(amtPrompt);
	    amt = new JTextField(10);
	    contentPane.add(amt);

	    fNamePrompt = new JLabel("First Name: ");
	    contentPane.add(fNamePrompt);
	    fName = new JTextField(12);
	    contentPane.add(fName);

	    lNamePrompt = new JLabel("Last Name: ");
	    contentPane.add(lNamePrompt);
	    lName = new JTextField(15);
	    contentPane.add(lName);

	    begBalancePrompt = new JLabel("Beginning Balance: ");
	    contentPane.add(begBalancePrompt);
	    begBalance = new JTextField(10);
	    contentPane.add(begBalance);

	    acctInfo = new JLabel("Account Info Displayed Here                              ");
	    acctInfo.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	    contentPane.add(acctInfo);

	    processTransaction = new JButton("Process Transaction");
	    processTransaction.addActionListener(new TransButtonListener());
	    contentPane.add(processTransaction);

		/* Add content pane to frame */
        frame.setContentPane(contentPane);

        /* Size and then display the frame. */
        frame.pack();
        frame.setVisible(true);
    }


	class ActionSelectedListener implements ActionListener {

		/**
		 * Handle a selection from the combo box
	 	 * pre: none
	 	 * post: The appropriate text field labels have been displayed in red.
	 	 */
    	public void actionPerformed(ActionEvent event) {
			JComboBox comboBox = (JComboBox)event.getSource();
			String action = (String)comboBox.getSelectedItem();

			if (action == "Deposit") {
				acctPrompt.setForeground(Color.red);
				amtPrompt.setForeground(Color.red);
				fNamePrompt.setForeground(Color.black);
				lNamePrompt.setForeground(Color.black);
				begBalancePrompt.setForeground(Color.black);
				acctInfo.setText("Account Info Displayed Here");
			} else if (action == "Withdrawal") {
				acctPrompt.setForeground(Color.red);
				amtPrompt.setForeground(Color.red);
				fNamePrompt.setForeground(Color.black);
				lNamePrompt.setForeground(Color.black);
				begBalancePrompt.setForeground(Color.black);
				acctInfo.setText("Account Info Displayed Here");
			} else if (action == "Check Balance") {
				acctPrompt.setForeground(Color.red);
				amtPrompt.setForeground(Color.black);
				fNamePrompt.setForeground(Color.black);
				lNamePrompt.setForeground(Color.black);
				begBalancePrompt.setForeground(Color.black);
				acctInfo.setText("Account Info Displayed Here");
			} else if (action == "Add Account") {
				acctPrompt.setForeground(Color.black);
				amtPrompt.setForeground(Color.black);
				fNamePrompt.setForeground(Color.red);
				lNamePrompt.setForeground(Color.red);
				begBalancePrompt.setForeground(Color.red);
				acctInfo.setText("Account Info Displayed Here");
			} else if (action == "Remove Account") {
				acctPrompt.setForeground(Color.red);
				amtPrompt.setForeground(Color.black);
				fNamePrompt.setForeground(Color.black);
				lNamePrompt.setForeground(Color.black);
				begBalancePrompt.setForeground(Color.black);
				acctInfo.setText("Account Info Displayed Here");
			}
    	}
	}


	class TransButtonListener implements ActionListener {

		/**
		 * Handle Process Transaction button click event
	 	 * pre: none
	 	 * post: The appropriate action has been taken based on the
	 	 * action selected in a comboBox
	 	 */
    	public void actionPerformed(ActionEvent event) {
    		String amount, message;

			if (bankActivities.getSelectedItem() == "Deposit") {
				amount = amt.getText();
				message = easySave.transaction(1, acctNum.getText(), Double.parseDouble(amount));
				acctInfo.setText(message);
			} else if (bankActivities.getSelectedItem() == "Withdrawal") {
				amount = amt.getText();
				message = easySave.transaction(2, acctNum.getText(), Double.parseDouble(amount));
				acctInfo.setText(message);
			} else if (bankActivities.getSelectedItem() == "Check Balance") {
				message = easySave.checkBalance(acctNum.getText());
				acctInfo.setText(message);
			} else if (bankActivities.getSelectedItem() == "Add Account") 
			{
				amount = begBalance.getText();
				message = easySave.addAccount(fName.getText(), lName.getText(), Double.parseDouble(amount));
				acctInfo.setText("New Account ID: " + message);
			} else if (bankActivities.getSelectedItem() == "Remove Account") {
				message = easySave.deleteAccount(acctNum.getText());
				acctInfo.setText(message);
			}
			acctNum.setText("");
			amt.setText("");
			fName.setText("");
			lName.setText("");
			begBalance.setText("");
    	}
	}


	/**
     * Create and show the GUI.
     */
    private static void runGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        LocalBankGUI myBank = new LocalBankGUI();
    }


    public static void main(String[] args) {
        /* Methods that create and show a GUI should be
           run from an event-dispatching thread */
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                runGUI();
            }
        });
    }

}
