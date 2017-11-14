package viewPackage;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import modelPackage.Account;

import java.util.ArrayList;

public class AccountsEditPanel extends JPanel {
	private JTable table;
	DefaultTableModel tableModel;
	

	/**
	 * Create the panel.
	 */
	public AccountsEditPanel(ViewController controller) {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel lblEditAccounts = new JLabel("Edit Accounts");
		lblEditAccounts.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblEditAccounts);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		add(verticalStrut);
		
		String[] columns = {"Name", "Balance", "Type", "Savings Goal"};
		tableModel = new DefaultTableModel(columns, 0);
//		Object[][] data = {
//				{"USAA", "2000.00", "Checking","n/a"},
//				{"Centier", "450.00", "Checking","n/a"},
//				{"USAA Savings", "760.00", "Savings", "1500.00"}
//		};
		
			
		table = new JTable(tableModel);
		
		add(table);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		add(verticalStrut_1);
		
		JPanel panel = new JPanel();
		add(panel);
		
		JButton button = new JButton("Add Account");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.changeCard("addAccount");
			}
		});
		panel.add(button);
		
		JButton button_1 = new JButton("Edit Account");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.changeCard("editAccount");
			}
		});
		panel.add(button_1);
		
		JButton button_2 = new JButton("Delete Account");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.changeCard("deleteAccount");
			}
		});
		panel.add(button_2);
		
		JButton btnSelectNewFile = new JButton("Select New File");
		panel.add(btnSelectNewFile);
		
		JButton button_3 = new JButton("Back to menu");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.changeCard("mainMenu");
			}
		});
		panel.add(button_3);
	}
	
//	public void addAccountToTable(ArrayList<Account> accountsArray){
//		for (Account tempAccount : accountsArray){
//			
//			if (tempAccount.getType() == "Savings"){
//				Object[] newRow = {tempAccount.getName(), tempAccount.getBalance(), tempAccount.getType(), tempAccount.getSavingsGoal()};
//			} else {
//				Object [] newRow = {tempAccount.getName(), tempAccount.getBalance(), tempAccount.getType(), "n/a"};
//			}
//		}
//	}
	
	public void updateTableModel(ArrayList<Account> accountsArray){
		for(int i = tableModel.getRowCount()-1; i >= 0; i--){
			tableModel.removeRow(i);
		}
		
		for (Account tempAccount : accountsArray){
			
			if (tempAccount.getType() == "Savings"){
				Object[] newRow = {tempAccount.getName(), tempAccount.getBalance(), tempAccount.getType(), tempAccount.getSavingsGoal()};
				tableModel.addRow(newRow);
			} else {
				Object [] newRow = {tempAccount.getName(), tempAccount.getBalance(), tempAccount.getType(), "0.00"};
				tableModel.addRow(newRow);
			}
		}
	}

}
