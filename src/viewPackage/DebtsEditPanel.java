package viewPackage;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelPackage.Account;
import modelPackage.Debt;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DebtsEditPanel extends JPanel {
	private JTable table;
	DefaultTableModel tableModel;

	/**
	 * Create the panel.
	 */
	public DebtsEditPanel(ViewController controller) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel lblEditDebtsPanel = new JLabel("Edit Debts Panel");
		lblEditDebtsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblEditDebtsPanel);
		
		String[] columns = {"Name", "Type", "Balance", "Min Payment", "Interest Rate"};
		tableModel = new DefaultTableModel(columns,0);
		
		table = new JTable(tableModel);
		add(table);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAddADebt = new JButton("Add a Debt");
		btnAddADebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.changeCard("addADebt");
			}
		});
		panel.add(btnAddADebt);
		
		JButton btnEditADebt = new JButton("Edit a Debt");
		btnEditADebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				controller.changeCard("editADebt");
			}
		});
		panel.add(btnEditADebt);
		
		JButton btnDeleteADebt = new JButton("Delete a Debt");
		btnDeleteADebt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				controller.changeCard("deleteADebt");
			}
		});
		panel.add(btnDeleteADebt);
		
		JButton btnBackToMain = new JButton("Back to Main Menu");
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.changeCard("mainMenu");
			}
		});
		panel.add(btnBackToMain);

	}
	
	public void updateTableModel(ArrayList<Debt> orderedDebtsArray){
		for(int i = tableModel.getRowCount()-1; i >= 0; i--){
			tableModel.removeRow(i);
		}
		
		for (Debt tempDebt : orderedDebtsArray){
			Object[] newRow = {tempDebt.getName(), tempDebt.getType(), tempDebt.getBalance(), tempDebt.getMinimumPayment(), tempDebt.getInterestRate()};
			tableModel.addRow(newRow);
		}
	}

}
