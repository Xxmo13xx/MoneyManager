package viewPackage;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.Box;
import java.util.*;
import modelPackage.Account;

public class EditAnAccountPanel extends JPanel {
	private JTextField newAccountName;
	private JTextField newAccountBalance;
	private JTextField newAccountSavingsGoal;
	JComboBox accountComboBox;

	/**
	 * Create the panel.
	 */
	public EditAnAccountPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 2;
		gbc_verticalStrut.gridy = 0;
		panel.add(verticalStrut, gbc_verticalStrut);
		
		JLabel lblNewLabel = new JLabel("Edit an Account");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		Component verticalStrut_1 = Box.createVerticalStrut(10);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 2;
		gbc_verticalStrut_1.gridy = 2;
		panel.add(verticalStrut_1, gbc_verticalStrut_1);
		
		accountComboBox = new JComboBox();
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 4;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		panel.add(accountComboBox, gbc_comboBox);
		
		JLabel lblOriginal = new JLabel("Original");
		GridBagConstraints gbc_lblOriginal = new GridBagConstraints();
		gbc_lblOriginal.insets = new Insets(0, 0, 5, 5);
		gbc_lblOriginal.gridx = 2;
		gbc_lblOriginal.gridy = 4;
		panel.add(lblOriginal, gbc_lblOriginal);
		
		JLabel lblNew = new JLabel("New");
		GridBagConstraints gbc_lblNew = new GridBagConstraints();
		gbc_lblNew.insets = new Insets(0, 0, 5, 0);
		gbc_lblNew.gridx = 4;
		gbc_lblNew.gridy = 4;
		panel.add(lblNew, gbc_lblNew);
		
		Component horizontalStrut = Box.createHorizontalStrut(100);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 5;
		panel.add(horizontalStrut, gbc_horizontalStrut);
		
		JLabel lblAccountName = new JLabel("Account Name");
		GridBagConstraints gbc_lblAccountName = new GridBagConstraints();
		gbc_lblAccountName.insets = new Insets(0, 0, 5, 5);
		gbc_lblAccountName.gridx = 1;
		gbc_lblAccountName.gridy = 5;
		panel.add(lblAccountName, gbc_lblAccountName);
		
		JLabel originalAccountName = new JLabel("---");
		GridBagConstraints gbc_originalAccountName = new GridBagConstraints();
		gbc_originalAccountName.insets = new Insets(0, 0, 5, 5);
		gbc_originalAccountName.gridx = 2;
		gbc_originalAccountName.gridy = 5;
		panel.add(originalAccountName, gbc_originalAccountName);
		
		newAccountName = new JTextField();
		GridBagConstraints gbc_newAccountName = new GridBagConstraints();
		gbc_newAccountName.anchor = GridBagConstraints.WEST;
		gbc_newAccountName.insets = new Insets(0, 0, 5, 0);
		gbc_newAccountName.gridx = 4;
		gbc_newAccountName.gridy = 5;
		panel.add(newAccountName, gbc_newAccountName);
		newAccountName.setColumns(10);
		
		JLabel lblAccountBalance = new JLabel("Account Balance");
		GridBagConstraints gbc_lblAccountBalance = new GridBagConstraints();
		gbc_lblAccountBalance.insets = new Insets(0, 0, 5, 5);
		gbc_lblAccountBalance.gridx = 1;
		gbc_lblAccountBalance.gridy = 6;
		panel.add(lblAccountBalance, gbc_lblAccountBalance);
		
		JLabel originalAccountBalance = new JLabel("---");
		GridBagConstraints gbc_originalAccountBalance = new GridBagConstraints();
		gbc_originalAccountBalance.insets = new Insets(0, 0, 5, 5);
		gbc_originalAccountBalance.gridx = 2;
		gbc_originalAccountBalance.gridy = 6;
		panel.add(originalAccountBalance, gbc_originalAccountBalance);
		
		newAccountBalance = new JTextField();
		GridBagConstraints gbc_newAccountBalance = new GridBagConstraints();
		gbc_newAccountBalance.anchor = GridBagConstraints.WEST;
		gbc_newAccountBalance.insets = new Insets(0, 0, 5, 0);
		gbc_newAccountBalance.gridx = 4;
		gbc_newAccountBalance.gridy = 6;
		panel.add(newAccountBalance, gbc_newAccountBalance);
		newAccountBalance.setColumns(10);
		
		JLabel lblAcountType = new JLabel("Acount Type");
		GridBagConstraints gbc_lblAcountType = new GridBagConstraints();
		gbc_lblAcountType.insets = new Insets(0, 0, 5, 5);
		gbc_lblAcountType.gridx = 1;
		gbc_lblAcountType.gridy = 7;
		panel.add(lblAcountType, gbc_lblAcountType);
		
		JLabel originalAccountType = new JLabel("---");
		GridBagConstraints gbc_originalAccountType = new GridBagConstraints();
		gbc_originalAccountType.insets = new Insets(0, 0, 5, 5);
		gbc_originalAccountType.gridx = 2;
		gbc_originalAccountType.gridy = 7;
		panel.add(originalAccountType, gbc_originalAccountType);
		
		JComboBox newAccountTypeComboBox = new JComboBox();
		newAccountTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Checkings", "Savings"}));
		GridBagConstraints gbc_newAccountTypeComboBox = new GridBagConstraints();
		gbc_newAccountTypeComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_newAccountTypeComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_newAccountTypeComboBox.gridx = 4;
		gbc_newAccountTypeComboBox.gridy = 7;
		panel.add(newAccountTypeComboBox, gbc_newAccountTypeComboBox);
		
		JLabel lblSavingsGoal = new JLabel("Savings Goal");
		GridBagConstraints gbc_lblSavingsGoal = new GridBagConstraints();
		gbc_lblSavingsGoal.insets = new Insets(0, 0, 5, 5);
		gbc_lblSavingsGoal.gridx = 1;
		gbc_lblSavingsGoal.gridy = 8;
		panel.add(lblSavingsGoal, gbc_lblSavingsGoal);
		
		JLabel originalSavingsLabel = new JLabel("---");
		GridBagConstraints gbc_originalSavingsLabel = new GridBagConstraints();
		gbc_originalSavingsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_originalSavingsLabel.gridx = 2;
		gbc_originalSavingsLabel.gridy = 8;
		panel.add(originalSavingsLabel, gbc_originalSavingsLabel);
		
		newAccountSavingsGoal = new JTextField();
		GridBagConstraints gbc_newAccountSavingsGoal = new GridBagConstraints();
		gbc_newAccountSavingsGoal.insets = new Insets(0, 0, 5, 0);
		gbc_newAccountSavingsGoal.fill = GridBagConstraints.HORIZONTAL;
		gbc_newAccountSavingsGoal.gridx = 4;
		gbc_newAccountSavingsGoal.gridy = 8;
		panel.add(newAccountSavingsGoal, gbc_newAccountSavingsGoal);
		newAccountSavingsGoal.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 4;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 9;
		panel.add(panel_1, gbc_panel_1);
		
		JButton btnNewButton = new JButton("Update Account");
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back to Accounts");
		panel_1.add(btnNewButton_1);

	}
	
	public void updateComboBox(ArrayList<Account> accountsArray){
		for(Account tempAccount: accountsArray){
			accountComboBox.addItem(tempAccount.getName());
		}
	}
}
