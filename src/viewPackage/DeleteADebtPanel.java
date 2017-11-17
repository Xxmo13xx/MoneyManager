package viewPackage;

import javax.swing.JPanel;

import modelPackage.Debt;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class DeleteADebtPanel extends JPanel {
	
	JComboBox debtSelectorComboBox;
	/**
	 * Create the panel.
	 */
	public DeleteADebtPanel(ViewController controller) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel lblDeleteADebt = new JLabel("Delete A Debt");
		lblDeleteADebt.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblDeleteADebt);
		
		debtSelectorComboBox = new JComboBox();
		add(debtSelectorComboBox);
		
		JPanel panel = new JPanel();
		add(panel);
		
		JButton btnNewButton = new JButton("DeleteDebt");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.deleteADebt(debtSelectorComboBox.getSelectedIndex());
				controller.changeCard("debtsEdit");
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back to Debts");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.changeCard("debtsEdit");
			}
		});
		panel.add(btnNewButton_1);

	}
	
	public void updateComboBox(ArrayList<Debt> debtsArray){
		debtSelectorComboBox.removeAllItems();
		for(Debt tempDebt: debtsArray){
			debtSelectorComboBox.addItem(tempDebt.getName());
		}
	}

}
