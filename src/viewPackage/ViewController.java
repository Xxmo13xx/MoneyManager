package viewPackage;

import java.awt.EventQueue;
import java.util.*;

import javax.swing.*;

import modelPackage.Account;
import modelPackage.Controller;
import modelPackage.Debt;

import java.awt.*;

public class ViewController {
	
	private JFrame frame;
	JPanel cards, mainMenuPanel, addAccountPanel;
	AccountsEditPanel accountsEditPanel;
	EditAnAccountPanel editAnAccountPanel;
	DeleteAnAccountPanel deleteAnAccountPanel;
	DebtsEditPanel debtsEditPanel;
	DeleteADebtPanel deleteADebtPanel;
	AddADebtPanel addADebtPanel;
	EditADebtPanel editADebtPanel;
	CardLayout cl;
	Controller modelController;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try{
					ViewController window = new ViewController();
					window.frame.setVisible(true);
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		});
	}
	
	public ViewController(){
		modelController = new Controller();
		modelController.loadData("testXmlOutput.xml");
		modelController.createOrderedDebts();
		
		accountsEditPanel = new AccountsEditPanel(this);
		mainMenuPanel = new MainMenuPanel(this);
		addAccountPanel = new AddAccountPanel(this);
		editAnAccountPanel = new EditAnAccountPanel(this);
		deleteAnAccountPanel = new DeleteAnAccountPanel(this);
		debtsEditPanel = new DebtsEditPanel(this);
		addADebtPanel = new AddADebtPanel(this);
		deleteADebtPanel = new DeleteADebtPanel(this);
		editADebtPanel = new EditADebtPanel(this);
		
		initialize();
		
	}
	
	private void initialize(){
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cards = new JPanel(new CardLayout());
		cl = (CardLayout)(cards.getLayout());
		
		// Add main menu
		cards.add(mainMenuPanel, "mainMenu");
		
		// Accounts Edit Page
		accountsEditPanel.updateTableModel(modelController.getAccountsArray());
		cards.add(accountsEditPanel, "accountsEdit");
		
		// Add Account Page
		cards.add(addAccountPanel, "addAccount");
		
		// Edit a specific account page
		editAnAccountPanel.updateComboBox(modelController.getAccountsArray());
		cards.add(editAnAccountPanel, "editAccount");
		
		//Delete an account panel
		deleteAnAccountPanel.updateComboBox(modelController.getAccountsArray());
		cards.add(deleteAnAccountPanel, "deleteAccount");
		
		// Edit Debts Panel
		debtsEditPanel.updateTableModel(modelController.getOrderedDebtsArray());
		cards.add(debtsEditPanel, "debtsEdit");
		
		// Add a Debt Panel
		cards.add(addADebtPanel, "addADebt");
		
		// Edit a debt panel
		editADebtPanel.updateComboBox(modelController.getOrderedDebtsArray());
		cards.add(editADebtPanel , "editADebt");
		
		// Delete a Debt Panel
		deleteADebtPanel.updateComboBox(modelController.getOrderedDebtsArray());
		cards.add(deleteADebtPanel, "deleteADebt");
		
		frame.getContentPane().add(cards);
	}
	
	public void changeCard(String cardToGoTo){
		cl.show(cards, cardToGoTo);
	}
	
	public void addAccount(String name, String balance, String savingsGoal, String type){
		
		
		modelController.addAccount(type, name, Double.parseDouble(balance), Double.parseDouble(savingsGoal));
		accountsEditPanel.updateTableModel(modelController.getAccountsArray());
	}
	
	public HashMap<String, String> getAccountInfo(int index){
		HashMap<String, String> accountInfo = new HashMap<String, String>();
		Account tempAccount = modelController.getAccount(index);
		accountInfo.put("name", tempAccount.getName());
		accountInfo.put("balance", Double.toString(tempAccount.getBalance()));
		accountInfo.put("type", tempAccount.getType());
		accountInfo.put("savingsGoal", Double.toString(tempAccount.getSavingsGoal()));
		
		return accountInfo;
	}
	

	public void updateAnAccount(int index, String accountName, String accountBalance, String accountType,
			String accountSavingsGoal) {
		modelController.updateAnAccount(index, accountName, accountBalance, accountType, accountSavingsGoal);
		accountsEditPanel.updateTableModel(modelController.getAccountsArray());
	}

	public void deleteAnAccount(int selectedIndex) {
		// TODO Auto-generated method stub
		modelController.removeAccount(selectedIndex);
		accountsEditPanel.updateTableModel(modelController.getAccountsArray());
		
	}

	public void addADebt(String name, String type, String amount, String minimumPayment, String interestRate) {

		modelController.addPayment(type, name, Double.parseDouble(amount), Double.parseDouble(minimumPayment), Double.parseDouble(interestRate));
		modelController.createOrderedDebts();
		debtsEditPanel.updateTableModel(modelController.getOrderedDebtsArray());
	}

	public void updateDebt(int index, String name, String balance, String minimumPayment, String interestRate) {
		// TODO Auto-generated method stub
		modelController.updateADebt(index, name, balance, minimumPayment, interestRate);
		modelController.createOrderedDebts();
		debtsEditPanel.updateTableModel(modelController.getOrderedDebtsArray());
		
	}

	public HashMap<String, String> getDebtInfo(int selectedIndex) {
		// TODO Auto-generated method stub
		HashMap<String, String> debtInfo = new HashMap<String, String>();
		Debt tempDebt = modelController.getDebt(selectedIndex);
		debtInfo.put("Name", tempDebt.getName());
		debtInfo.put("Balance", Double.toString(tempDebt.getBalance()));
		debtInfo.put("MinPayment", Double.toString(tempDebt.getMinimumPayment()));
		debtInfo.put("InterestRate", Double.toString(tempDebt.getInterestRate()));
		return debtInfo;
	}

	public void deleteADebt(int selectedIndex) {
		// TODO Auto-generated method stub
		modelController.removeDebt(selectedIndex);
		debtsEditPanel.updateTableModel(modelController.getOrderedDebtsArray());
	}

	public int getIterationArraySize() {
		// TODO Auto-generated method stub
		return modelController.getIterationArraySize();
	}

}
