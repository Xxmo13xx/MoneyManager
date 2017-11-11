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

public class testCardLayout {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private final JLabel lblNewLabel_1 = new JLabel("Money Manager");
	private JTextField txtPlaceHolderFor;
	private JTextField txtPlaceHolderFor_1;
	private JTextField txtPlaceHolderFor_2;
	private JTable table;

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
		
		
		JPanel mainMenuPanel = new JPanel();
		
		cards.add(mainMenuPanel, "mainMenu");
		GridBagLayout gbl_mainMenuPanel = new GridBagLayout();
		gbl_mainMenuPanel.columnWidths = new int[]{0, 0, 99, 0, 0, 0, 0};
		gbl_mainMenuPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_mainMenuPanel.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_mainMenuPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		mainMenuPanel.setLayout(gbl_mainMenuPanel);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 0;
		mainMenuPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 3;
		gbc_verticalStrut_1.gridy = 1;
		mainMenuPanel.add(verticalStrut_1, gbc_verticalStrut_1);
		
		JLabel lblNewLabel_2 = new JLabel("Accounts");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		mainMenuPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtPlaceHolderFor = new JTextField();
		txtPlaceHolderFor.setText("place holder for file chooser");
		GridBagConstraints gbc_txtPlaceHolderFor = new GridBagConstraints();
		gbc_txtPlaceHolderFor.gridwidth = 3;
		gbc_txtPlaceHolderFor.insets = new Insets(0, 0, 5, 5);
		gbc_txtPlaceHolderFor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPlaceHolderFor.gridx = 2;
		gbc_txtPlaceHolderFor.gridy = 2;
		mainMenuPanel.add(txtPlaceHolderFor, gbc_txtPlaceHolderFor);
		txtPlaceHolderFor.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Edit Accounts");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(cards, "editAccounts");
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 5;
		gbc_btnNewButton_3.gridy = 2;
		mainMenuPanel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JLabel lblBudget_1 = new JLabel("Budget");
		GridBagConstraints gbc_lblBudget_1 = new GridBagConstraints();
		gbc_lblBudget_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblBudget_1.gridx = 1;
		gbc_lblBudget_1.gridy = 3;
		mainMenuPanel.add(lblBudget_1, gbc_lblBudget_1);
		
		txtPlaceHolderFor_1 = new JTextField();
		txtPlaceHolderFor_1.setText("place holder for file chooser");
		GridBagConstraints gbc_txtPlaceHolderFor_1 = new GridBagConstraints();
		gbc_txtPlaceHolderFor_1.gridwidth = 3;
		gbc_txtPlaceHolderFor_1.insets = new Insets(0, 0, 5, 5);
		gbc_txtPlaceHolderFor_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPlaceHolderFor_1.gridx = 2;
		gbc_txtPlaceHolderFor_1.gridy = 3;
		mainMenuPanel.add(txtPlaceHolderFor_1, gbc_txtPlaceHolderFor_1);
		txtPlaceHolderFor_1.setColumns(10);
		
		JButton btnEditBudgets = new JButton("Edit Budgets");
		GridBagConstraints gbc_btnEditBudgets = new GridBagConstraints();
		gbc_btnEditBudgets.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditBudgets.gridx = 5;
		gbc_btnEditBudgets.gridy = 3;
		mainMenuPanel.add(btnEditBudgets, gbc_btnEditBudgets);
		
		JLabel lblDebts = new JLabel("Debts");
		GridBagConstraints gbc_lblDebts = new GridBagConstraints();
		gbc_lblDebts.insets = new Insets(0, 0, 5, 5);
		gbc_lblDebts.gridx = 1;
		gbc_lblDebts.gridy = 4;
		mainMenuPanel.add(lblDebts, gbc_lblDebts);
		
		txtPlaceHolderFor_2 = new JTextField();
		txtPlaceHolderFor_2.setText("place holder for file chooser");
		GridBagConstraints gbc_txtPlaceHolderFor_2 = new GridBagConstraints();
		gbc_txtPlaceHolderFor_2.gridwidth = 3;
		gbc_txtPlaceHolderFor_2.insets = new Insets(0, 0, 5, 5);
		gbc_txtPlaceHolderFor_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPlaceHolderFor_2.gridx = 2;
		gbc_txtPlaceHolderFor_2.gridy = 4;
		mainMenuPanel.add(txtPlaceHolderFor_2, gbc_txtPlaceHolderFor_2);
		txtPlaceHolderFor_2.setColumns(10);
		
		JButton btnEditDebts = new JButton("Edit Debts");
		GridBagConstraints gbc_btnEditDebts = new GridBagConstraints();
		gbc_btnEditDebts.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditDebts.gridx = 5;
		gbc_btnEditDebts.gridy = 4;
		mainMenuPanel.add(btnEditDebts, gbc_btnEditDebts);
		
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
		
		JButton btnRunAnIteration = new JButton("Run an Iteration");
		panel_3.add(btnRunAnIteration);
		
		JButton btnRunXIterations = new JButton("Run x Iterations");
		panel_3.add(btnRunXIterations);
		
		JButton btnRunAllIterations = new JButton("Run all Iterations");
		panel_3.add(btnRunAllIterations);
		
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
		
		JPanel panel_2 = new JPanel();
		cards.add(panel_2, "name_1510007681521237000");
		panel_2.setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Account");
		panel_2.add(lblNewLabel);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		panel_2.add(btnNewButton);
		
		JLabel lblBudget = new JLabel("Budget");
		panel_2.add(lblBudget);
		
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_2.add(btnNewButton_1);
		
		JLabel lblDebt = new JLabel("Debt");
		panel_2.add(lblDebt);
		
		textField_2 = new JTextField();
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel_2.add(btnNewButton_2);
		
		
	}

}
