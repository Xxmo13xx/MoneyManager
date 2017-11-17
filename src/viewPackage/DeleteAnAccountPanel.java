package viewPackage;

import javax.swing.JPanel;

import modelPackage.Account;

import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteAnAccountPanel extends JPanel {
	JComboBox accountComboBox;
	/**
	 * Create the panel.
	 */
	public DeleteAnAccountPanel(ViewController controller) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel lblDeleteAnAccount = new JLabel("Delete an Account");
		lblDeleteAnAccount.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblDeleteAnAccount);
		
		accountComboBox = new JComboBox();
		accountComboBox.setAlignmentY(Component.TOP_ALIGNMENT);
		add(accountComboBox);
		
		JPanel panel = new JPanel();
		add(panel);
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.deleteAnAccount(accountComboBox.getSelectedIndex());
				controller.changeCard("accountsEdit");
			}
		});
		panel.add(btnDeleteAccount);
		
		JButton btnBackToAccounts = new JButton("Back to Accounts");
		btnBackToAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.changeCard("accountsEdit");
			}
		});
		panel.add(btnBackToAccounts);

	}
	
	public void updateComboBox(ArrayList<Account> accountsArray){
		accountComboBox.removeAllItems();
		for(Account tempAccount: accountsArray){
			accountComboBox.addItem(tempAccount.getName());
		}
	}

}
