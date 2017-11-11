package viewPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class AccountsEditPage extends JFrame {

	private JPanel contentPane;
	private JTable accountsTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountsEditPage frame = new AccountsEditPage();
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
	public AccountsEditPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JLabel accountsEditPageLabel = new JLabel("Accounts Edit Page");
		accountsEditPageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(accountsEditPageLabel);
		// get the accounts from the controller, temporarily I am addind data. 
		
		Object[] columns = {"Name", "Balance", "Type", "Savings Goal"};
		Object[][] data = {
				{"USAA", "2000.00", "Checking","n/a"},
				{"Centier", "450.00", "Checking","n/a"},
				{"USAA Savings", "760.00", "Savings", "1500.00"}
		};
		accountsTable = new JTable(data, columns);
		accountsTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(accountsTable);
		
		JPanel controlsPanel = new JPanel();
		contentPane.add(controlsPanel);
		
		JButton addAccountButton = new JButton("Add Account");
		addAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Pressed the Add account button. ");
			}
		});
		controlsPanel.add(addAccountButton);
		
		JButton editAccountsButton = new JButton("Edit Account");
		editAccountsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Pressed the Edit Accounts Button" );
			}
		});
		controlsPanel.add(editAccountsButton);
		
		JButton deleteAccountButton = new JButton("Delete Account");
		deleteAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Pressed the delete an account button");
			}
		});
		controlsPanel.add(deleteAccountButton);
		
		JButton backToMenuButton = new JButton("Back to menu");
		backToMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Pressed the back to menu button");
			}
		});
		controlsPanel.add(backToMenuButton);
	}

}
