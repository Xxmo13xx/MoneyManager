package viewPackage;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddADebtPanel extends JPanel {
	private JTextField debtNameField;
	private JTextField debtBalanceField;
	private JTextField debtMinPaymentField;
	private JTextField debtInterestRateField;

	/**
	 * Create the panel.
	 */
	public AddADebtPanel(ViewController controller) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel lblAddADebt = new JLabel("Add a Debt");
		lblAddADebt.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblAddADebt);
		
		JPanel panel = new JPanel();
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblDebtName = new JLabel("Debt Name");
		GridBagConstraints gbc_lblDebtName = new GridBagConstraints();
		gbc_lblDebtName.anchor = GridBagConstraints.EAST;
		gbc_lblDebtName.insets = new Insets(0, 0, 5, 5);
		gbc_lblDebtName.gridx = 3;
		gbc_lblDebtName.gridy = 1;
		panel.add(lblDebtName, gbc_lblDebtName);
		
		debtNameField = new JTextField();
		GridBagConstraints gbc_debtNameField = new GridBagConstraints();
		gbc_debtNameField.anchor = GridBagConstraints.WEST;
		gbc_debtNameField.insets = new Insets(0, 0, 5, 0);
		gbc_debtNameField.gridx = 4;
		gbc_debtNameField.gridy = 1;
		panel.add(debtNameField, gbc_debtNameField);
		debtNameField.setColumns(10);
		
		JLabel lblDebtType = new JLabel("Debt Type");
		GridBagConstraints gbc_lblDebtType = new GridBagConstraints();
		gbc_lblDebtType.anchor = GridBagConstraints.EAST;
		gbc_lblDebtType.insets = new Insets(0, 0, 5, 5);
		gbc_lblDebtType.gridx = 3;
		gbc_lblDebtType.gridy = 2;
		panel.add(lblDebtType, gbc_lblDebtType);
		
		JComboBox debtTypeComboBox = new JComboBox();
		debtTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Credit Card", "Loan"}));
		GridBagConstraints gbc_debtTypeComboBox = new GridBagConstraints();
		gbc_debtTypeComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_debtTypeComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_debtTypeComboBox.gridx = 4;
		gbc_debtTypeComboBox.gridy = 2;
		panel.add(debtTypeComboBox, gbc_debtTypeComboBox);
		
		JLabel lblDebtBalance = new JLabel("Debt Balance");
		GridBagConstraints gbc_lblDebtBalance = new GridBagConstraints();
		gbc_lblDebtBalance.anchor = GridBagConstraints.EAST;
		gbc_lblDebtBalance.insets = new Insets(0, 0, 5, 5);
		gbc_lblDebtBalance.gridx = 3;
		gbc_lblDebtBalance.gridy = 3;
		panel.add(lblDebtBalance, gbc_lblDebtBalance);
		
		debtBalanceField = new JTextField();
		GridBagConstraints gbc_debtBalanceField = new GridBagConstraints();
		gbc_debtBalanceField.anchor = GridBagConstraints.BELOW_BASELINE_LEADING;
		gbc_debtBalanceField.insets = new Insets(0, 0, 5, 0);
		gbc_debtBalanceField.gridx = 4;
		gbc_debtBalanceField.gridy = 3;
		panel.add(debtBalanceField, gbc_debtBalanceField);
		debtBalanceField.setColumns(10);
		
		JLabel lblMinimumPayment = new JLabel("Minimum Payment");
		GridBagConstraints gbc_lblMinimumPayment = new GridBagConstraints();
		gbc_lblMinimumPayment.anchor = GridBagConstraints.EAST;
		gbc_lblMinimumPayment.insets = new Insets(0, 0, 5, 5);
		gbc_lblMinimumPayment.gridx = 3;
		gbc_lblMinimumPayment.gridy = 4;
		panel.add(lblMinimumPayment, gbc_lblMinimumPayment);
		
		debtMinPaymentField = new JTextField();
		GridBagConstraints gbc_debtMinPaymentField = new GridBagConstraints();
		gbc_debtMinPaymentField.anchor = GridBagConstraints.SOUTHWEST;
		gbc_debtMinPaymentField.insets = new Insets(0, 0, 5, 0);
		gbc_debtMinPaymentField.gridx = 4;
		gbc_debtMinPaymentField.gridy = 4;
		panel.add(debtMinPaymentField, gbc_debtMinPaymentField);
		debtMinPaymentField.setColumns(10);
		
		JLabel lblInterestrate = new JLabel("Interest Rate");
		GridBagConstraints gbc_lblInterestrate = new GridBagConstraints();
		gbc_lblInterestrate.anchor = GridBagConstraints.EAST;
		gbc_lblInterestrate.insets = new Insets(0, 0, 5, 5);
		gbc_lblInterestrate.gridx = 3;
		gbc_lblInterestrate.gridy = 5;
		panel.add(lblInterestrate, gbc_lblInterestrate);
		
		debtInterestRateField = new JTextField();
		GridBagConstraints gbc_debtInterestRateField = new GridBagConstraints();
		gbc_debtInterestRateField.insets = new Insets(0, 0, 5, 0);
		gbc_debtInterestRateField.anchor = GridBagConstraints.WEST;
		gbc_debtInterestRateField.gridx = 4;
		gbc_debtInterestRateField.gridy = 5;
		panel.add(debtInterestRateField, gbc_debtInterestRateField);
		debtInterestRateField.setColumns(10);
		
		JButton btnAddDebt = new JButton("Add Debt");
		btnAddDebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (debtTypeComboBox.getSelectedItem() == "Credit Card"){
					controller.addADebt(debtNameField.getText(), "Credit", debtBalanceField.getText(),
							debtMinPaymentField.getText(), debtInterestRateField.getText());
					controller.changeCard("debtsEdit");
				} else if (debtTypeComboBox.getSelectedItem() == "Loan"){
					controller.addADebt(debtNameField.getText(), "Loan", debtBalanceField.getText(),
							debtMinPaymentField.getText(), debtInterestRateField.getText());
					controller.changeCard("debtsEdit");
				}
			}
		});
		GridBagConstraints gbc_btnAddDebt = new GridBagConstraints();
		gbc_btnAddDebt.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddDebt.gridx = 3;
		gbc_btnAddDebt.gridy = 6;
		panel.add(btnAddDebt, gbc_btnAddDebt);
		
		JButton btnBackToDebts = new JButton("Back to Debts");
		btnBackToDebts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.changeCard("debtsEdit");
			}
		});
		GridBagConstraints gbc_btnBackToDebts = new GridBagConstraints();
		gbc_btnBackToDebts.gridx = 4;
		gbc_btnBackToDebts.gridy = 6;
		panel.add(btnBackToDebts, gbc_btnBackToDebts);

	}

}
