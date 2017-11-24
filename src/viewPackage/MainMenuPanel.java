package viewPackage;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenuPanel extends JPanel {
	private JTextField txtAccountsFileChoosen;
	private JTextField txtBudgetFileChoosen;
	private JTextField txtDebtFileChoosen;
	private JTextField extraPayoffTextField;

	/**
	 * Create the panel.
	 */
	public MainMenuPanel(ViewController controller) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		Component verticalStrut = Box.createVerticalStrut(15);
		add(verticalStrut);
		
		JLabel lblMainMenu = new JLabel("Main Menu ");
		lblMainMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblMainMenu);
		
		Component verticalStrut_1 = Box.createVerticalStrut(15);
		add(verticalStrut_1);
		
		JPanel panel = new JPanel();
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 195, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 1;
		panel.add(horizontalStrut, gbc_horizontalStrut);
		
		JLabel lblAccounts = new JLabel("Accounts");
		GridBagConstraints gbc_lblAccounts = new GridBagConstraints();
		gbc_lblAccounts.insets = new Insets(0, 0, 5, 5);
		gbc_lblAccounts.anchor = GridBagConstraints.EAST;
		gbc_lblAccounts.gridx = 2;
		gbc_lblAccounts.gridy = 1;
		panel.add(lblAccounts, gbc_lblAccounts);
		
		txtAccountsFileChoosen = new JTextField();
		txtAccountsFileChoosen.setText("Accounts File Choosen");
		GridBagConstraints gbc_txtAccountsFileChoosen = new GridBagConstraints();
		gbc_txtAccountsFileChoosen.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAccountsFileChoosen.insets = new Insets(0, 0, 5, 5);
		gbc_txtAccountsFileChoosen.gridx = 3;
		gbc_txtAccountsFileChoosen.gridy = 1;
		panel.add(txtAccountsFileChoosen, gbc_txtAccountsFileChoosen);
		txtAccountsFileChoosen.setColumns(10);
		
		JButton btnEditAccounts = new JButton("Edit Accounts");
		btnEditAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.changeCard("accountsEdit");
			}
		});
		GridBagConstraints gbc_btnEditAccounts = new GridBagConstraints();
		gbc_btnEditAccounts.fill = GridBagConstraints.BOTH;
		gbc_btnEditAccounts.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditAccounts.gridx = 4;
		gbc_btnEditAccounts.gridy = 1;
		panel.add(btnEditAccounts, gbc_btnEditAccounts);
		
		JLabel lblBudget = new JLabel("Budget");
		GridBagConstraints gbc_lblBudget = new GridBagConstraints();
		gbc_lblBudget.anchor = GridBagConstraints.EAST;
		gbc_lblBudget.insets = new Insets(0, 0, 5, 5);
		gbc_lblBudget.gridx = 2;
		gbc_lblBudget.gridy = 2;
		panel.add(lblBudget, gbc_lblBudget);
		
		txtBudgetFileChoosen = new JTextField();
		txtBudgetFileChoosen.setText("Budget File Choosen");
		GridBagConstraints gbc_txtBudgetFileChoosen = new GridBagConstraints();
		gbc_txtBudgetFileChoosen.insets = new Insets(0, 0, 5, 5);
		gbc_txtBudgetFileChoosen.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBudgetFileChoosen.gridx = 3;
		gbc_txtBudgetFileChoosen.gridy = 2;
		panel.add(txtBudgetFileChoosen, gbc_txtBudgetFileChoosen);
		txtBudgetFileChoosen.setColumns(10);
		
		JButton btnEditBudget = new JButton("Edit Budget");
		btnEditBudget.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		GridBagConstraints gbc_btnEditBudget = new GridBagConstraints();
		gbc_btnEditBudget.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEditBudget.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditBudget.gridx = 4;
		gbc_btnEditBudget.gridy = 2;
		panel.add(btnEditBudget, gbc_btnEditBudget);
		
		JLabel lblDebt = new JLabel("Debt");
		GridBagConstraints gbc_lblDebt = new GridBagConstraints();
		gbc_lblDebt.anchor = GridBagConstraints.EAST;
		gbc_lblDebt.insets = new Insets(0, 0, 5, 5);
		gbc_lblDebt.gridx = 2;
		gbc_lblDebt.gridy = 3;
		panel.add(lblDebt, gbc_lblDebt);
		
		txtDebtFileChoosen = new JTextField();
		txtDebtFileChoosen.setText("Debt File Choosen");
		GridBagConstraints gbc_txtDebtFileChoosen = new GridBagConstraints();
		gbc_txtDebtFileChoosen.insets = new Insets(0, 0, 5, 5);
		gbc_txtDebtFileChoosen.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDebtFileChoosen.gridx = 3;
		gbc_txtDebtFileChoosen.gridy = 3;
		panel.add(txtDebtFileChoosen, gbc_txtDebtFileChoosen);
		txtDebtFileChoosen.setColumns(10);
		
		JButton btnEditDebt = new JButton("Edit Debt");
		btnEditDebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.changeCard("debtsEdit");
			}
		});
		GridBagConstraints gbc_btnEditDebt = new GridBagConstraints();
		gbc_btnEditDebt.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEditDebt.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditDebt.gridx = 4;
		gbc_btnEditDebt.gridy = 3;
		panel.add(btnEditDebt, gbc_btnEditDebt);
		
		JLabel lblExtraPayoff = new JLabel("Extra Payoff");
		GridBagConstraints gbc_lblExtraPayoff = new GridBagConstraints();
		gbc_lblExtraPayoff.anchor = GridBagConstraints.EAST;
		gbc_lblExtraPayoff.insets = new Insets(0, 0, 5, 5);
		gbc_lblExtraPayoff.gridx = 2;
		gbc_lblExtraPayoff.gridy = 4;
		panel.add(lblExtraPayoff, gbc_lblExtraPayoff);
		
		extraPayoffTextField = new JTextField();
		GridBagConstraints gbc_extraPayoffTextField = new GridBagConstraints();
		gbc_extraPayoffTextField.fill = GridBagConstraints.BOTH;
		gbc_extraPayoffTextField.insets = new Insets(0, 0, 5, 5);
		gbc_extraPayoffTextField.gridx = 3;
		gbc_extraPayoffTextField.gridy = 4;
		panel.add(extraPayoffTextField, gbc_extraPayoffTextField);
		extraPayoffTextField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 5;
		panel.add(panel_1, gbc_panel_1);
		
		JButton btnRunAllIterations = new JButton("Start Debt Snowball");
		btnRunAllIterations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.startDebtSnowball();
				controller.changeCard("debtSnowball");
			}
		});
		panel_1.add(btnRunAllIterations);

	}

}
