package viewPackage;

import java.awt.EventQueue;

import javax.swing.*;

import modelPackage.Controller;

import java.awt.*;

public class ViewController {
	
	private JFrame frame;
	JPanel cards, mainMenuPanel, addAccountPanel;
	AccountsEditPanel accountsEditPanel;
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
		accountsEditPanel = new AccountsEditPanel(this);
		mainMenuPanel = new MainMenuPanel(this);
		addAccountPanel = new AddAccountPanel(this);
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
		
		
		frame.getContentPane().add(cards);
	}
	
	public void changeCard(String cardToGoTo){
		cl.show(cards, cardToGoTo);
	}
	
	public void addAccount(String name, String balance, String savingsGoal, String type){
		
		
		modelController.addAccount(type, name, Double.parseDouble(balance), Double.parseDouble(savingsGoal));
		
		accountsEditPanel.updateTableModel(modelController.getAccountsArray());
	}

}
