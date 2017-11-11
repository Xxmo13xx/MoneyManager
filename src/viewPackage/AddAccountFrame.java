package viewPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddAccountFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterTheAccount;
	private JTextField txtEnterTheAccount_1;
	private final ButtonGroup accountTypeRadioGroup = new ButtonGroup();
	private JTextField txtEnterTheSavings;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAccountFrame frame = new AddAccountFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddAccountFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JLabel lblAddAccountPage = new JLabel("Add Account Page");
		lblAddAccountPage.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblAddAccountPage);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{123, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 38, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblAccountName = new JLabel("Account Name");
		GridBagConstraints gbc_lblAccountName = new GridBagConstraints();
		gbc_lblAccountName.insets = new Insets(0, 0, 5, 5);
		gbc_lblAccountName.anchor = GridBagConstraints.EAST;
		gbc_lblAccountName.gridx = 0;
		gbc_lblAccountName.gridy = 0;
		panel.add(lblAccountName, gbc_lblAccountName);
		
		txtEnterTheAccount = new JTextField();
		txtEnterTheAccount.setText("Enter the account name");
		GridBagConstraints gbc_txtEnterTheAccount = new GridBagConstraints();
		gbc_txtEnterTheAccount.insets = new Insets(0, 0, 5, 0);
		gbc_txtEnterTheAccount.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnterTheAccount.gridx = 1;
		gbc_txtEnterTheAccount.gridy = 0;
		panel.add(txtEnterTheAccount, gbc_txtEnterTheAccount);
		txtEnterTheAccount.setColumns(10);
		
		JLabel lblAccountBalance = new JLabel("Account Balance");
		GridBagConstraints gbc_lblAccountBalance = new GridBagConstraints();
		gbc_lblAccountBalance.anchor = GridBagConstraints.EAST;
		gbc_lblAccountBalance.insets = new Insets(0, 0, 5, 5);
		gbc_lblAccountBalance.gridx = 0;
		gbc_lblAccountBalance.gridy = 1;
		panel.add(lblAccountBalance, gbc_lblAccountBalance);
		
		txtEnterTheAccount_1 = new JTextField();
		txtEnterTheAccount_1.setText("Enter the account balance");
		GridBagConstraints gbc_txtEnterTheAccount_1 = new GridBagConstraints();
		gbc_txtEnterTheAccount_1.insets = new Insets(0, 0, 5, 0);
		gbc_txtEnterTheAccount_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnterTheAccount_1.gridx = 1;
		gbc_txtEnterTheAccount_1.gridy = 1;
		panel.add(txtEnterTheAccount_1, gbc_txtEnterTheAccount_1);
		txtEnterTheAccount_1.setColumns(10);
		
		JLabel lblAccountType = new JLabel("Account Type");
		GridBagConstraints gbc_lblAccountType = new GridBagConstraints();
		gbc_lblAccountType.anchor = GridBagConstraints.EAST;
		gbc_lblAccountType.insets = new Insets(0, 0, 5, 5);
		gbc_lblAccountType.gridx = 0;
		gbc_lblAccountType.gridy = 2;
		panel.add(lblAccountType, gbc_lblAccountType);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 2;
		panel.add(panel_1, gbc_panel_1);
		
		JRadioButton rdbtnChecking = new JRadioButton("Checking");
		accountTypeRadioGroup.add(rdbtnChecking);
		panel_1.add(rdbtnChecking);
		
		JRadioButton rdbtnSavings = new JRadioButton("Savings");
		accountTypeRadioGroup.add(rdbtnSavings);
		panel_1.add(rdbtnSavings);
		
		JLabel lblSavingsGoal = new JLabel("Savings Goal");
		GridBagConstraints gbc_lblSavingsGoal = new GridBagConstraints();
		gbc_lblSavingsGoal.anchor = GridBagConstraints.EAST;
		gbc_lblSavingsGoal.insets = new Insets(0, 0, 5, 5);
		gbc_lblSavingsGoal.gridx = 0;
		gbc_lblSavingsGoal.gridy = 3;
		panel.add(lblSavingsGoal, gbc_lblSavingsGoal);
		
		txtEnterTheSavings = new JTextField();
		txtEnterTheSavings.setText("Enter the savings goal");
		GridBagConstraints gbc_txtEnterTheSavings = new GridBagConstraints();
		gbc_txtEnterTheSavings.insets = new Insets(0, 0, 5, 0);
		gbc_txtEnterTheSavings.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnterTheSavings.gridx = 1;
		gbc_txtEnterTheSavings.gridy = 3;
		panel.add(txtEnterTheSavings, gbc_txtEnterTheSavings);
		txtEnterTheSavings.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 4;
		panel.add(panel_2, gbc_panel_2);
		
		JButton btnAddAccount = new JButton("Add Account");
		btnAddAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("The Add Account Button was pressed. ");
			}
		});
		panel_2.add(btnAddAccount);
		
		JButton btnBackToMain = new JButton("Back to main menu");
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("The back to main menu button was pressed.");
			}
		});
		panel_2.add(btnBackToMain);
	}

}
