package viewPackage;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;

public class MainPageTest extends JFrame {

	private JPanel contentPane;
	private JTextField accountsPlaceHolder;
	private JTextField budgetPlaceHolder;
	private JTextField debtPlaceHolder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPageTest frame = new MainPageTest();
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
	public MainPageTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel = new JLabel("Money Manager ");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblNewLabel);
		
		JPanel accountsPanel = new JPanel();
		accountsPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(accountsPanel);
		
		JLabel accountsLabel = new JLabel("Accounts");
		accountsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		accountsPanel.add(accountsLabel);
		
		JButton accountsEditButton = new JButton("Edit Accounts");
		accountsEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		accountsPlaceHolder = new JTextField();
		accountsPlaceHolder.setText("place holder for file chooser");
		accountsPanel.add(accountsPlaceHolder);
		accountsPlaceHolder.setColumns(15);
		accountsPanel.add(accountsEditButton);
		
		JPanel budgetPanel = new JPanel();
		budgetPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(budgetPanel);
		
		JLabel budgetLabel = new JLabel("Budget");
		budgetLabel.setHorizontalAlignment(SwingConstants.LEFT);
		budgetPanel.add(budgetLabel);
		
		budgetPlaceHolder = new JTextField();
		budgetPlaceHolder.setText("place holder for file chooser");
		budgetPlaceHolder.setColumns(15);
		budgetPanel.add(budgetPlaceHolder);
		
		JButton budgetEditButton = new JButton("Edit Accounts");
		budgetPanel.add(budgetEditButton);
		
		JPanel debtsPanel = new JPanel();
		debtsPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(debtsPanel);
		
		JLabel debtsLabel = new JLabel("Debts");
		debtsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		debtsPanel.add(debtsLabel);
		
		debtPlaceHolder = new JTextField();
		debtPlaceHolder.setText("place holder for file chooser");
		debtPlaceHolder.setColumns(15);
		debtsPanel.add(debtPlaceHolder);
		
		JButton debtEditButton = new JButton("Edit Accounts");
		debtsPanel.add(debtEditButton);
		
		JPanel controlsPanel = new JPanel();
		controlsPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(controlsPanel);
		
		JButton runIterationButton = new JButton("Run Iteration");
		controlsPanel.add(runIterationButton);
		
		JButton btnRunIterations = new JButton("Run _ Iterations");
		controlsPanel.add(btnRunIterations);
		
		JButton runAllIterationsButton = new JButton("runAllIterations");
		controlsPanel.add(runAllIterationsButton);
		
		JPanel cards = new JPanel(new CardLayout());
		contentPane.add(cards);
	}

}
