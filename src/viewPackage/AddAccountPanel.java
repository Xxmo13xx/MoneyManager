package viewPackage;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.AbstractButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.Box;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Enumeration;

public class AddAccountPanel extends JPanel {
	private JTextField accountNameTextField;
	private JTextField accountBalanceTextField;
	private JTextField savingsGoalTextField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public AddAccountPanel(ViewController controller) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel lblAddAccount = new JLabel("Add Account ");
		lblAddAccount.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblAddAccount);
		
		JPanel panel = new JPanel();
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		Component horizontalStrut = Box.createHorizontalStrut(50);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 1;
		panel.add(horizontalStrut, gbc_horizontalStrut);
		
		JLabel lblNewLabel = new JLabel("Account Name");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		accountNameTextField = new JTextField();
		GridBagConstraints gbc_accountNameTextField = new GridBagConstraints();
		gbc_accountNameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_accountNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_accountNameTextField.gridx = 3;
		gbc_accountNameTextField.gridy = 1;
		panel.add(accountNameTextField, gbc_accountNameTextField);
		accountNameTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Account Balance");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		accountBalanceTextField = new JTextField();
		GridBagConstraints gbc_accountBalanceTextField = new GridBagConstraints();
		gbc_accountBalanceTextField.insets = new Insets(0, 0, 5, 0);
		gbc_accountBalanceTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_accountBalanceTextField.gridx = 3;
		gbc_accountBalanceTextField.gridy = 2;
		panel.add(accountBalanceTextField, gbc_accountBalanceTextField);
		accountBalanceTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Account Type");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 3;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 3;
		gbc_panel_1.gridy = 3;
		panel.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JRadioButton accountTypeCheckingRadio = new JRadioButton("Checkings");
		accountTypeCheckingRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				savingsGoalTextField.setText("0.00");
			}
		});
		accountTypeCheckingRadio.setSelected(true);
		buttonGroup.add(accountTypeCheckingRadio);
		panel_1.add(accountTypeCheckingRadio);
		
		JRadioButton accountTypeSavingsRadio = new JRadioButton("Savings");
		accountTypeSavingsRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				savingsGoalTextField.setText("0.00");
			}
		});
		buttonGroup.add(accountTypeSavingsRadio);
		panel_1.add(accountTypeSavingsRadio);
		
		JLabel lblNewLabel_2 = new JLabel("Savings Goal");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 4;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		savingsGoalTextField = new JTextField("0.00");
		GridBagConstraints gbc_savingsGoalTextField = new GridBagConstraints();
		gbc_savingsGoalTextField.insets = new Insets(0, 0, 5, 0);
		gbc_savingsGoalTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_savingsGoalTextField.gridx = 3;
		gbc_savingsGoalTextField.gridy = 4;
		panel.add(savingsGoalTextField, gbc_savingsGoalTextField);
		savingsGoalTextField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 5;
		panel.add(panel_2, gbc_panel_2);
		
		JButton btnAddAccount = new JButton("Add Account");
		btnAddAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				controller.addAccount(accountNameTextField.getText(), 
						accountBalanceTextField.getText(),
						savingsGoalTextField.getText(),
						getSelectedButtonText(buttonGroup));
				controller.changeCard("accountsEdit");
				
			}
		});
		panel_2.add(btnAddAccount);
		
		JButton btnBackToAccounts = new JButton("Back to Accounts");
		panel_2.add(btnBackToAccounts);

	}
	
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

}
