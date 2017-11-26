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
import modelPackage.Controller;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;


public class DebtSnowballPanel extends JPanel {
	private JTextField extraPayoffField;
	private JTable table;
	DefaultTableModel tableModel;
	Controller modelController;
	int iterationNumber;
	

	/**
	 * Create the panel.
	 */
	public DebtSnowballPanel(ViewController viewController, Controller modelController) {
		iterationNumber =0;
		this.modelController = modelController;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel lblDebtSnowball = new JLabel("Debt Snowball");
		lblDebtSnowball.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblDebtSnowball);
		
		JPanel panel = new JPanel();
		add(panel);
		
		JLabel extraPayoffLabel = new JLabel("Extra Payoff Amount");
		panel.add(extraPayoffLabel);
		
		extraPayoffField = new JTextField("100.00");
		panel.add(extraPayoffField);
		extraPayoffField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
		
		
		tableModel = new DefaultTableModel(viewController.getIterationArraySize(),0);		
		table = new JTable(tableModel);
		tableModel.addColumn("", setFirstColumn());
		tableModel.addColumn("", setInitialValuesColumn());
		tableModel.addColumn("", setMinPayments());
		table.setValueAt("Iteration", 0, 0);
		table.setValueAt("Payoff Amount", 1, 0);
		
		
		
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JButton btnRunOneIteration = new JButton("Run Iteration");
		btnRunOneIteration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double payoffAmount = Double.parseDouble(extraPayoffField.getText());
				modelController.setDebtSnowballPayoffAmount(payoffAmount);
				modelController.runAnIteration();
				tableModel.addColumn("", setAnIterationColumn());
				iterationNumber++;
			}
		});
		panel_1.add(btnRunOneIteration);
		
		JButton btnRunXIterations = new JButton("Run X Iterations");
		panel_1.add(btnRunXIterations);
		
		JButton btnRunAllIterations = new JButton("Run all Iterations");
		panel_1.add(btnRunAllIterations);

	}

	public void updateTable() {
		// TODO Auto-generated method stub
		
	}
	
	public String[] setFirstColumn() {
		String[] debtNames = modelController.getDebtSnowballDebtNames();
		String[] tempArray = new String[debtNames.length+2];
		tempArray[0] = "Iteration";
		tempArray[1] = "Payoff Amount";
		for(int x = 0; x < debtNames.length; x++) {
			System.out.println("Looked at: " + debtNames[x]);
			tempArray[x+2] = debtNames[x];
		}
		return tempArray;
	}
	
	public String[] setAnIterationColumn(){
		return modelController.getIterationArray(iterationNumber);

	}
	
	public String[] setInitialValuesColumn(){
		
		String[] initialValuesArray = modelController.getSnowballInitialValues();
		String tempValue = initialValuesArray[1];
		initialValuesArray[1] = initialValuesArray[0];
		initialValuesArray[0] = tempValue;
		return initialValuesArray;
	}
	
	public String[] setMinPayments(){
		String[] minPaymentsArray = modelController.getSnowballMinPayments();
		return minPaymentsArray;
	}

}
