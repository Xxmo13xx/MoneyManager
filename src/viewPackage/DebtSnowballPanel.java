package viewPackage;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;


public class DebtSnowballPanel extends JPanel {
	private JTextField textField;
	private JTable table;
	DefaultTableModel tableModel;

	/**
	 * Create the panel.
	 */
	public DebtSnowballPanel(ViewController viewController) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel lblDebtSnowball = new JLabel("Debt Snowball");
		lblDebtSnowball.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblDebtSnowball);
		
		JPanel panel = new JPanel();
		add(panel);
		
		JLabel lblNewLabel = new JLabel("Extra Payoff Amount");
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		
		tableModel = new DefaultTableModel(viewController.getIterationArraySize(),0);		
		table = new JTable(tableModel);
		
		
		
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JButton btnRunOneIteration = new JButton("Run Iteration");
		panel_1.add(btnRunOneIteration);
		
		JButton btnRunXIterations = new JButton("Run X Iterations");
		panel_1.add(btnRunXIterations);
		
		JButton btnRunAllIterations = new JButton("Run all Iterations");
		panel_1.add(btnRunAllIterations);

	}

}
