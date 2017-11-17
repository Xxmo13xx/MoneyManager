package viewPackage;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import modelPackage.Account;
import modelPackage.Debt;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditADebtPanel extends JPanel {
	private JTextField newDebtName;
	private JTextField newDebtBalance;
	private JTextField newDebtMinPayment;
	private JTextField newDebtInterestRate;
	private JComboBox debtSelectorComboBox;
	private JLabel originalDebtName, originalDebtBalance, originalDebtMinPayment, originalDebtInterestRate;

	/**
	 * Create the panel.
	 */
	public EditADebtPanel(ViewController controller) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel_1 = new JLabel("Edit a Debt");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 4;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 0;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		debtSelectorComboBox = new JComboBox();
		debtSelectorComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String, String> debtInfo = controller.getDebtInfo(debtSelectorComboBox.getSelectedIndex());
				originalDebtName.setText(debtInfo.get("Name"));
				originalDebtBalance.setText(debtInfo.get("Balance"));
				originalDebtMinPayment.setText(debtInfo.get("MinPayment"));
				originalDebtInterestRate.setText(debtInfo.get("InterestRate"));
			}
		});
		GridBagConstraints gbc_debtSelectorComboBox = new GridBagConstraints();
		gbc_debtSelectorComboBox.gridwidth = 4;
		gbc_debtSelectorComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_debtSelectorComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_debtSelectorComboBox.gridx = 3;
		gbc_debtSelectorComboBox.gridy = 1;
		add(debtSelectorComboBox, gbc_debtSelectorComboBox);
		
		JLabel lblNewLabel = new JLabel("Original");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNew = new JLabel("New");
		GridBagConstraints gbc_lblNew = new GridBagConstraints();
		gbc_lblNew.insets = new Insets(0, 0, 5, 5);
		gbc_lblNew.gridx = 6;
		gbc_lblNew.gridy = 2;
		add(lblNew, gbc_lblNew);
		
		JLabel lblAccountName = new JLabel("Debt Name");
		GridBagConstraints gbc_lblAccountName = new GridBagConstraints();
		gbc_lblAccountName.anchor = GridBagConstraints.EAST;
		gbc_lblAccountName.insets = new Insets(0, 0, 5, 5);
		gbc_lblAccountName.gridx = 3;
		gbc_lblAccountName.gridy = 3;
		add(lblAccountName, gbc_lblAccountName);
		
		originalDebtName = new JLabel("---");
		GridBagConstraints gbc_originalDebtName = new GridBagConstraints();
		gbc_originalDebtName.insets = new Insets(0, 0, 5, 5);
		gbc_originalDebtName.gridx = 4;
		gbc_originalDebtName.gridy = 3;
		add(originalDebtName, gbc_originalDebtName);
		
		newDebtName = new JTextField();
		GridBagConstraints gbc_newDebtName = new GridBagConstraints();
		gbc_newDebtName.insets = new Insets(0, 0, 5, 5);
		gbc_newDebtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_newDebtName.gridx = 6;
		gbc_newDebtName.gridy = 3;
		add(newDebtName, gbc_newDebtName);
		newDebtName.setColumns(10);
		
		JLabel lblDebtBalance = new JLabel("Debt Balance");
		GridBagConstraints gbc_lblDebtBalance = new GridBagConstraints();
		gbc_lblDebtBalance.anchor = GridBagConstraints.EAST;
		gbc_lblDebtBalance.insets = new Insets(0, 0, 5, 5);
		gbc_lblDebtBalance.gridx = 3;
		gbc_lblDebtBalance.gridy = 4;
		add(lblDebtBalance, gbc_lblDebtBalance);
		
		originalDebtBalance = new JLabel("---");
		GridBagConstraints gbc_originalDebtBalance = new GridBagConstraints();
		gbc_originalDebtBalance.insets = new Insets(0, 0, 5, 5);
		gbc_originalDebtBalance.gridx = 4;
		gbc_originalDebtBalance.gridy = 4;
		add(originalDebtBalance, gbc_originalDebtBalance);
		
		newDebtBalance = new JTextField();
		GridBagConstraints gbc_newDebtBalance = new GridBagConstraints();
		gbc_newDebtBalance.insets = new Insets(0, 0, 5, 5);
		gbc_newDebtBalance.fill = GridBagConstraints.HORIZONTAL;
		gbc_newDebtBalance.gridx = 6;
		gbc_newDebtBalance.gridy = 4;
		add(newDebtBalance, gbc_newDebtBalance);
		newDebtBalance.setColumns(10);
		
		JLabel lblDebtMinPayment = new JLabel("Debt Min Payment");
		GridBagConstraints gbc_lblDebtMinPayment = new GridBagConstraints();
		gbc_lblDebtMinPayment.anchor = GridBagConstraints.EAST;
		gbc_lblDebtMinPayment.insets = new Insets(0, 0, 5, 5);
		gbc_lblDebtMinPayment.gridx = 3;
		gbc_lblDebtMinPayment.gridy = 5;
		add(lblDebtMinPayment, gbc_lblDebtMinPayment);
		
		originalDebtMinPayment = new JLabel("---");
		GridBagConstraints gbc_originalDebtMinPayment = new GridBagConstraints();
		gbc_originalDebtMinPayment.insets = new Insets(0, 0, 5, 5);
		gbc_originalDebtMinPayment.gridx = 4;
		gbc_originalDebtMinPayment.gridy = 5;
		add(originalDebtMinPayment, gbc_originalDebtMinPayment);
		
		newDebtMinPayment = new JTextField();
		GridBagConstraints gbc_newDebtMinPayment = new GridBagConstraints();
		gbc_newDebtMinPayment.insets = new Insets(0, 0, 5, 5);
		gbc_newDebtMinPayment.fill = GridBagConstraints.HORIZONTAL;
		gbc_newDebtMinPayment.gridx = 6;
		gbc_newDebtMinPayment.gridy = 5;
		add(newDebtMinPayment, gbc_newDebtMinPayment);
		newDebtMinPayment.setColumns(10);
		
		JLabel lblDebtInterestRate = new JLabel("Debt Interest Rate");
		GridBagConstraints gbc_lblDebtInterestRate = new GridBagConstraints();
		gbc_lblDebtInterestRate.anchor = GridBagConstraints.EAST;
		gbc_lblDebtInterestRate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDebtInterestRate.gridx = 3;
		gbc_lblDebtInterestRate.gridy = 6;
		add(lblDebtInterestRate, gbc_lblDebtInterestRate);
		
		originalDebtInterestRate = new JLabel("---");
		GridBagConstraints gbc_originalDebtInterestRate = new GridBagConstraints();
		gbc_originalDebtInterestRate.insets = new Insets(0, 0, 5, 5);
		gbc_originalDebtInterestRate.gridx = 4;
		gbc_originalDebtInterestRate.gridy = 6;
		add(originalDebtInterestRate, gbc_originalDebtInterestRate);
		
		newDebtInterestRate = new JTextField();
		GridBagConstraints gbc_newDebtInterestRate = new GridBagConstraints();
		gbc_newDebtInterestRate.insets = new Insets(0, 0, 5, 5);
		gbc_newDebtInterestRate.fill = GridBagConstraints.HORIZONTAL;
		gbc_newDebtInterestRate.gridx = 6;
		gbc_newDebtInterestRate.gridy = 6;
		add(newDebtInterestRate, gbc_newDebtInterestRate);
		newDebtInterestRate.setColumns(10);
		
		JButton btnUpdateDebt = new JButton("Update Debt");
		btnUpdateDebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = debtSelectorComboBox.getSelectedIndex();
				String name = newDebtName.getText();
				String balance = newDebtBalance.getText();
				String minimumPayment = newDebtMinPayment.getText();
				String interestRate = newDebtInterestRate.getText();
				controller.updateDebt(index, name, balance, minimumPayment, interestRate);
			}
		});
		GridBagConstraints gbc_btnUpdateDebt = new GridBagConstraints();
		gbc_btnUpdateDebt.insets = new Insets(0, 0, 0, 5);
		gbc_btnUpdateDebt.gridx = 3;
		gbc_btnUpdateDebt.gridy = 8;
		add(btnUpdateDebt, gbc_btnUpdateDebt);
		
		JButton btnBackToDebts = new JButton("Back to Debts");
		btnBackToDebts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.changeCard("debtsEdit");
			}
		});
		GridBagConstraints gbc_btnBackToDebts = new GridBagConstraints();
		gbc_btnBackToDebts.insets = new Insets(0, 0, 0, 5);
		gbc_btnBackToDebts.gridx = 6;
		gbc_btnBackToDebts.gridy = 8;
		add(btnBackToDebts, gbc_btnBackToDebts);

	}
	
	public void updateComboBox(ArrayList<Debt> debtsArray){
		debtSelectorComboBox.removeAllItems();
		for(Debt tempDebt: debtsArray){
			debtSelectorComboBox.addItem(tempDebt.getName());
		}
	}

}
