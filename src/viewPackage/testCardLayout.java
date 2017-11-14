package viewPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class testCardLayout {

	private JFrame frame;
	private final JLabel mainMenuTitleLabel = new JLabel("Money Manager");
	private JTextField accountsFileTextBox;
	private JTextField budgetFileTextBox;
	private JTextField debtFileTextField;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JRadioButton rdbtnNewRadioButton = new JRadioButton("Savings");
	private JTextField textField_2;
	private JTextField newAccountNameField;
	private JTextField newAccountBalanceField;
	private JTextField newSavingsGoalField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testCardLayout window = new testCardLayout();
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
	public testCardLayout() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel cards = new JPanel(new CardLayout());
		CardLayout cl = (CardLayout)(cards.getLayout());
		
		
		/*
		 * Main Menu Panel
		 * 
		 */
		JPanel mainMenuPanel = new JPanel();
		
		cards.add(mainMenuPanel, "mainMenu");
		GridBagLayout gbl_mainMenuPanel = new GridBagLayout();
		gbl_mainMenuPanel.columnWidths = new int[]{0, 0, 99, 0, 0, 0, 0};
		gbl_mainMenuPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_mainMenuPanel.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_mainMenuPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		mainMenuPanel.setLayout(gbl_mainMenuPanel);
		GridBagConstraints gbc_mainMenuTitleLabel = new GridBagConstraints();
		gbc_mainMenuTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_mainMenuTitleLabel.gridx = 3;
		gbc_mainMenuTitleLabel.gridy = 0;
		mainMenuPanel.add(mainMenuTitleLabel, gbc_mainMenuTitleLabel);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 3;
		gbc_verticalStrut_1.gridy = 1;
		mainMenuPanel.add(verticalStrut_1, gbc_verticalStrut_1);
		
		JLabel mainMenuAccountsLabel = new JLabel("Accounts");
		GridBagConstraints gbc_mainMenuAccountsLabel = new GridBagConstraints();
		gbc_mainMenuAccountsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_mainMenuAccountsLabel.gridx = 1;
		gbc_mainMenuAccountsLabel.gridy = 2;
		mainMenuPanel.add(mainMenuAccountsLabel, gbc_mainMenuAccountsLabel);
		
		accountsFileTextBox = new JTextField();
		accountsFileTextBox.setText("place holder for file chooser");
		GridBagConstraints gbc_accountsFileTextBox = new GridBagConstraints();
		gbc_accountsFileTextBox.gridwidth = 3;
		gbc_accountsFileTextBox.insets = new Insets(0, 0, 5, 5);
		gbc_accountsFileTextBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_accountsFileTextBox.gridx = 2;
		gbc_accountsFileTextBox.gridy = 2;
		mainMenuPanel.add(accountsFileTextBox, gbc_accountsFileTextBox);
		accountsFileTextBox.setColumns(10);
		
		JButton mainMenuEditAccountsButton = new JButton("Edit Accounts");
		mainMenuEditAccountsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(cards, "editAccounts");
			}
		});
		
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 5;
		gbc_btnNewButton_3.gridy = 2;
		mainMenuPanel.add(mainMenuEditAccountsButton, gbc_btnNewButton_3);
		
		JLabel mainMenuBudgetLabel = new JLabel("Budget");
		GridBagConstraints gbc_mainMenuBudgetLabel = new GridBagConstraints();
		gbc_mainMenuBudgetLabel.insets = new Insets(0, 0, 5, 5);
		gbc_mainMenuBudgetLabel.gridx = 1;
		gbc_mainMenuBudgetLabel.gridy = 3;
		mainMenuPanel.add(mainMenuBudgetLabel, gbc_mainMenuBudgetLabel);
		
		budgetFileTextBox = new JTextField();
		budgetFileTextBox.setText("place holder for file chooser");
		GridBagConstraints gbc_budgetFileTextBox = new GridBagConstraints();
		gbc_budgetFileTextBox.gridwidth = 3;
		gbc_budgetFileTextBox.insets = new Insets(0, 0, 5, 5);
		gbc_budgetFileTextBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_budgetFileTextBox.gridx = 2;
		gbc_budgetFileTextBox.gridy = 3;
		mainMenuPanel.add(budgetFileTextBox, gbc_budgetFileTextBox);
		budgetFileTextBox.setColumns(10);
		
		JButton mainMenuEditBudget = new JButton("Edit Budgets");
		GridBagConstraints gbc_mainMenuEditBudget = new GridBagConstraints();
		gbc_mainMenuEditBudget.insets = new Insets(0, 0, 5, 0);
		gbc_mainMenuEditBudget.gridx = 5;
		gbc_mainMenuEditBudget.gridy = 3;
		mainMenuPanel.add(mainMenuEditBudget, gbc_mainMenuEditBudget);
		
		JLabel mainMenuDebtsLabel = new JLabel("Debts");
		GridBagConstraints gbc_mainMenuDebtsLabel = new GridBagConstraints();
		gbc_mainMenuDebtsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_mainMenuDebtsLabel.gridx = 1;
		gbc_mainMenuDebtsLabel.gridy = 4;
		mainMenuPanel.add(mainMenuDebtsLabel, gbc_mainMenuDebtsLabel);
		
		debtFileTextField = new JTextField();
		debtFileTextField.setText("place holder for file chooser");
		GridBagConstraints gbc_debtFileTextField = new GridBagConstraints();
		gbc_debtFileTextField.gridwidth = 3;
		gbc_debtFileTextField.insets = new Insets(0, 0, 5, 5);
		gbc_debtFileTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_debtFileTextField.gridx = 2;
		gbc_debtFileTextField.gridy = 4;
		mainMenuPanel.add(debtFileTextField, gbc_debtFileTextField);
		debtFileTextField.setColumns(10);
		
		JButton mainMenuEditDebts = new JButton("Edit Debts");
		GridBagConstraints gbc_mainMenuEditDebts = new GridBagConstraints();
		gbc_mainMenuEditDebts.insets = new Insets(0, 0, 5, 0);
		gbc_mainMenuEditDebts.gridx = 5;
		gbc_mainMenuEditDebts.gridy = 4;
		mainMenuPanel.add(mainMenuEditDebts, gbc_mainMenuEditDebts);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 3;
		gbc_verticalStrut.gridy = 5;
		mainMenuPanel.add(verticalStrut, gbc_verticalStrut);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridwidth = 5;
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 6;
		mainMenuPanel.add(panel_3, gbc_panel_3);
		
		JButton runAnIterationButton = new JButton("Run an Iteration");
		panel_3.add(runAnIterationButton);
		
		JButton runXIterationsButton = new JButton("Run x Iterations");
		panel_3.add(runXIterationsButton);
		
		JButton runAllIterationsButton = new JButton("Run all Iterations");
		panel_3.add(runAllIterationsButton);
		
		frame.getContentPane().add(cards);
		
		JPanel accountsEditPanel = new JPanel();
		cards.add(accountsEditPanel, "name_1510008523164956000");
		accountsEditPanel.setLayout(new BoxLayout(accountsEditPanel, BoxLayout.Y_AXIS));
		
		JLabel lblEditAccountsPage = new JLabel("Edit Accounts Page");
		lblEditAccountsPage.setAlignmentX(Component.CENTER_ALIGNMENT);
		accountsEditPanel.add(lblEditAccountsPage);
		
		
		Object[] columns = {"Name", "Balance", "Type", "Savings Goal"};
		Object[][] data = {
				{"USAA", "2000.00", "Checking","n/a"},
				{"Centier", "450.00", "Checking","n/a"},
				{"USAA Savings", "760.00", "Savings", "1500.00"}
		};
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		accountsEditPanel.add(verticalStrut_2);
		
		table = new JTable(data, columns);
		accountsEditPanel.add(table);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		accountsEditPanel.add(verticalStrut_3);
		
		JPanel panel = new JPanel();
		accountsEditPanel.add(panel);
		
		JButton button = new JButton("Add Account");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(cards, "addAccounts");
			}
		});
		panel.add(button);
		
		JButton button_1 = new JButton("Edit Account");
		panel.add(button_1);
		
		JButton button_2 = new JButton("Delete Account");
		panel.add(button_2);
		
		JButton button_3 = new JButton("Back to menu");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(cards, "mainMenu");
			}
		});
		panel.add(button_3);
		cards.add(accountsEditPanel, "editAccounts");
		
		JPanel addAccountPanel = new JPanel();
		cards.add(addAccountPanel, "name_815528071229515");
		addAccountPanel.setLayout(new BoxLayout(addAccountPanel, BoxLayout.Y_AXIS));
		
		JLabel lblAddAccountPage = new JLabel("Add Account Page");
		lblAddAccountPage.setAlignmentX(Component.CENTER_ALIGNMENT);
		addAccountPanel.add(lblAddAccountPage);
		
		JPanel panel_1 = new JPanel();
		addAccountPanel.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 140, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblAccountName = new JLabel("Account Name");
		GridBagConstraints gbc_lblAccountName = new GridBagConstraints();
		gbc_lblAccountName.gridwidth = 2;
		gbc_lblAccountName.insets = new Insets(0, 0, 5, 5);
		gbc_lblAccountName.gridx = 2;
		gbc_lblAccountName.gridy = 0;
		panel_1.add(lblAccountName, gbc_lblAccountName);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 0;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblAccountBalance = new JLabel("Account Balance");
		GridBagConstraints gbc_lblAccountBalance = new GridBagConstraints();
		gbc_lblAccountBalance.gridwidth = 2;
		gbc_lblAccountBalance.insets = new Insets(0, 0, 5, 5);
		gbc_lblAccountBalance.gridx = 2;
		gbc_lblAccountBalance.gridy = 1;
		panel_1.add(lblAccountBalance, gbc_lblAccountBalance);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 1;
		panel_1.add(textField_1, gbc_textField_1);
		
		JLabel lblAccountType = new JLabel("Account Type");
		GridBagConstraints gbc_lblAccountType = new GridBagConstraints();
		gbc_lblAccountType.gridwidth = 2;
		gbc_lblAccountType.insets = new Insets(0, 0, 5, 5);
		gbc_lblAccountType.gridx = 2;
		gbc_lblAccountType.gridy = 2;
		panel_1.add(lblAccountType, gbc_lblAccountType);
		
		JRadioButton rdbtnChecking = new JRadioButton("Checking");
		buttonGroup.add(rdbtnChecking);
		GridBagConstraints gbc_rdbtnChecking = new GridBagConstraints();
		gbc_rdbtnChecking.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnChecking.anchor = GridBagConstraints.WEST;
		gbc_rdbtnChecking.gridx = 4;
		gbc_rdbtnChecking.gridy = 2;
		panel_1.add(rdbtnChecking, gbc_rdbtnChecking);
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton.gridx = 5;
		gbc_rdbtnNewRadioButton.gridy = 2;
		buttonGroup.add(rdbtnNewRadioButton);
		panel_1.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		JLabel lblSavingsGoal = new JLabel("Savings Goal");
		GridBagConstraints gbc_lblSavingsGoal = new GridBagConstraints();
		gbc_lblSavingsGoal.gridwidth = 2;
		gbc_lblSavingsGoal.insets = new Insets(0, 0, 5, 5);
		gbc_lblSavingsGoal.gridx = 2;
		gbc_lblSavingsGoal.gridy = 3;
		panel_1.add(lblSavingsGoal, gbc_lblSavingsGoal);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridwidth = 2;
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 4;
		gbc_textField_2.gridy = 3;
		panel_1.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 4;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 4;
		panel_1.add(panel_2, gbc_panel_2);
		
		JButton btnAddAccount = new JButton("Add Account");
		panel_2.add(btnAddAccount);
		
		JButton btnBackToMain = new JButton("Back to accounts");
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(cards, "editAccounts");
			}
		});
		panel_2.add(btnBackToMain);
		
		cards.add(addAccountPanel, "addAccounts");
		
		JPanel editAccountPanel = new JPanel();
		cards.add(editAccountPanel, "name_862120942120654");
		editAccountPanel.setLayout(new BoxLayout(editAccountPanel, BoxLayout.Y_AXIS));
		
		JLabel editAccountsTitleLabel = new JLabel("Edit Accounts Page");
		editAccountPanel.add(editAccountsTitleLabel);
		
		JPanel panel_4 = new JPanel();
		editAccountPanel.add(panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0, 0, 140, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblOriginal = new JLabel("Original");
		GridBagConstraints gbc_lblOriginal = new GridBagConstraints();
		gbc_lblOriginal.insets = new Insets(0, 0, 5, 5);
		gbc_lblOriginal.gridx = 4;
		gbc_lblOriginal.gridy = 0;
		panel_4.add(lblOriginal, gbc_lblOriginal);
		
		JLabel lblNewValues = new JLabel("New Values");
		GridBagConstraints gbc_lblNewValues = new GridBagConstraints();
		gbc_lblNewValues.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewValues.gridx = 5;
		gbc_lblNewValues.gridy = 0;
		panel_4.add(lblNewValues, gbc_lblNewValues);
		
		JLabel label = new JLabel("Account Name");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridwidth = 2;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 1;
		panel_4.add(label, gbc_label);
		
		JLabel originalAccountNameLabel = new JLabel("USAA Credit");
		GridBagConstraints gbc_originalAccountNameLabel = new GridBagConstraints();
		gbc_originalAccountNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_originalAccountNameLabel.gridx = 4;
		gbc_originalAccountNameLabel.gridy = 1;
		panel_4.add(originalAccountNameLabel, gbc_originalAccountNameLabel);
		
		newAccountNameField = new JTextField();
		newAccountNameField.setColumns(10);
		GridBagConstraints gbc_newAccountNameField = new GridBagConstraints();
		gbc_newAccountNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_newAccountNameField.insets = new Insets(0, 0, 5, 0);
		gbc_newAccountNameField.gridx = 5;
		gbc_newAccountNameField.gridy = 1;
		panel_4.add(newAccountNameField, gbc_newAccountNameField);
		
		JLabel label_1 = new JLabel("Account Balance");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.gridwidth = 2;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 2;
		panel_4.add(label_1, gbc_label_1);
		
		JLabel originalAccountBalanceLabel = new JLabel("1000.00");
		GridBagConstraints gbc_originalAccountBalanceLabel = new GridBagConstraints();
		gbc_originalAccountBalanceLabel.insets = new Insets(0, 0, 5, 5);
		gbc_originalAccountBalanceLabel.gridx = 4;
		gbc_originalAccountBalanceLabel.gridy = 2;
		panel_4.add(originalAccountBalanceLabel, gbc_originalAccountBalanceLabel);
		
		newAccountBalanceField = new JTextField();
		newAccountBalanceField.setColumns(10);
		GridBagConstraints gbc_newAccountBalanceField = new GridBagConstraints();
		gbc_newAccountBalanceField.fill = GridBagConstraints.HORIZONTAL;
		gbc_newAccountBalanceField.insets = new Insets(0, 0, 5, 0);
		gbc_newAccountBalanceField.gridx = 5;
		gbc_newAccountBalanceField.gridy = 2;
		panel_4.add(newAccountBalanceField, gbc_newAccountBalanceField);
		
		JLabel label_2 = new JLabel("Account Type");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.gridwidth = 2;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 2;
		gbc_label_2.gridy = 3;
		panel_4.add(label_2, gbc_label_2);
		
		JRadioButton radioButton = new JRadioButton("Checking");
		GridBagConstraints gbc_radioButton = new GridBagConstraints();
		gbc_radioButton.anchor = GridBagConstraints.WEST;
		gbc_radioButton.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton.gridx = 4;
		gbc_radioButton.gridy = 3;
		panel_4.add(radioButton, gbc_radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Savings");
		GridBagConstraints gbc_radioButton_1 = new GridBagConstraints();
		gbc_radioButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_radioButton_1.gridx = 5;
		gbc_radioButton_1.gridy = 3;
		panel_4.add(radioButton_1, gbc_radioButton_1);
		
		JLabel label_3 = new JLabel("Savings Goal");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.gridwidth = 2;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 2;
		gbc_label_3.gridy = 4;
		panel_4.add(label_3, gbc_label_3);
		
		JLabel originalSavingsGoalLabel = new JLabel("1500.00");
		GridBagConstraints gbc_originalSavingsGoalLabel = new GridBagConstraints();
		gbc_originalSavingsGoalLabel.insets = new Insets(0, 0, 5, 5);
		gbc_originalSavingsGoalLabel.gridx = 4;
		gbc_originalSavingsGoalLabel.gridy = 4;
		panel_4.add(originalSavingsGoalLabel, gbc_originalSavingsGoalLabel);
		
		newSavingsGoalField = new JTextField();
		newSavingsGoalField.setColumns(10);
		GridBagConstraints gbc_newSavingsGoalField = new GridBagConstraints();
		gbc_newSavingsGoalField.fill = GridBagConstraints.HORIZONTAL;
		gbc_newSavingsGoalField.insets = new Insets(0, 0, 5, 0);
		gbc_newSavingsGoalField.gridx = 5;
		gbc_newSavingsGoalField.gridy = 4;
		panel_4.add(newSavingsGoalField, gbc_newSavingsGoalField);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridwidth = 4;
		gbc_panel_5.gridx = 2;
		gbc_panel_5.gridy = 5;
		panel_4.add(panel_5, gbc_panel_5);
		
		JButton editAccountsPanelSaveChangesButton = new JButton("Save Changes");
		editAccountsPanelSaveChangesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Save Changes to their variable
				cl.show(cards, "editAccounts");
				
			}
		});
		panel_5.add(editAccountsPanelSaveChangesButton);
		
		JButton editAccountsBackToAccountsButton = new JButton("Back to accounts");
		panel_5.add(editAccountsBackToAccountsButton);
		
		
	}

}
