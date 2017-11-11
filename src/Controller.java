import java.util.*;
import java.io.*;
import org.dom4j.*;
import org.dom4j.io.*;

public class Controller {

    ArrayList<Account> accountsArray;
    ArrayList<Loan> loanArray;
    ArrayList<CreditCard> creditCardArray;
    ArrayList<Bill> billsArray;
    ArrayList<Expense> expenseArray;
    ArrayList<Debt> orderedDebts;

    public Controller() {
        accountsArray = new ArrayList<Account>();
        loanArray = new ArrayList<Loan>();
        creditCardArray = new ArrayList<CreditCard>();
        billsArray = new ArrayList<Bill>();
        expenseArray = new ArrayList<Expense>();
        orderedDebts = new ArrayList<Debt>();
        
       
    }
    
    public void saveData(){
    	
    	try{
    		FileOutputStream fos = new FileOutputStream("testSaveData.xml");
    		OutputFormat format = OutputFormat.createPrettyPrint();
    		XMLWriter writer = new XMLWriter(fos, format);
    		
    		Document document = DocumentHelper.createDocument();
    		
    		Element root = document.addElement("testSaveData");
    		
    		// check if the there are any accounts.
    		//if there are then iterate through the accounts and then add them one by one. 
    		Element accountsElement = root.addElement("Accounts");
    		if(this.accountsArray.size() > 0){
    			for(Account tempAccount : this.accountsArray){
    				accountsElement.addElement("Account")
    						.addAttribute("Name", tempAccount.getName())
    						.addAttribute("Balance", Double.toString(tempAccount.getBalance()))
    						.addAttribute("Type", tempAccount.getType());
    			}
    		}
    		
    		Element paymentsElement = root.addElement("Payments");
    		// check if there are any bills
    		// if there are then itereate through the payment and then add them one by one.
    		Element billsElement = paymentsElement.addElement("Bills");
    		if(this.billsArray.size() > 0){
    			for(Bill tempBill : this.billsArray){
    				billsElement.addElement("Bill")
    						.addAttribute("Name", tempBill.getName())
    						.addAttribute("Balance", Double.toString(tempBill.getBalance()))
    						.addAttribute("minPayment", Double.toString(tempBill.getMinimumPayment()));
    			}
    		}
    		
    		Element expensesElement = paymentsElement.addElement("Expenses");
    		if(this.expenseArray.size() > 0){
    			for (Expense tempExpense : this.expenseArray){
    				expensesElement.addElement("Expense")
    						.addAttribute("Name", tempExpense.getName())
    						.addAttribute("Balance", Double.toString(tempExpense.getBalance()))
    						.addAttribute("minPayment", Double.toString(tempExpense.getMinimumPayment()));
    			}
    		}
    		
    		// check if there are any loans
    		// if there are then iterate through them and save them
    		Element loansElement = paymentsElement.addElement("Loans");
    		if(this.loanArray.size() > 0){
    			for(Loan tempLoan: this.loanArray){
    				loansElement.addElement("Loan")
    						.addAttribute("Name", tempLoan.getName())
    						.addAttribute("Balance", Double.toString(tempLoan.getBalance()))
    						.addAttribute("minPayment", Double.toString(tempLoan.getMinimumPayment()))
    						.addAttribute("interestRate", Double.toString(tempLoan.getInterestRate()));
    			}
    		}
    		
    		// check if there are any credit cards
    		// if there are then iterate through them and save them
    		Element creditCardsElement = paymentsElement.addElement("creditCards");
    		if(this.creditCardArray.size() > 0){
    			for(CreditCard tempCard : this.creditCardArray){
    				creditCardsElement.addElement("creditCard")
    						.addAttribute("Name", tempCard.getName())
    						.addAttribute("Balance", Double.toString(tempCard.getBalance()))
    						.addAttribute("minPayment", Double.toString(tempCard.getMinimumPayment()))
    						.addAttribute("interestRate", Double.toString(tempCard.getInterestRate()));
    			}
    		}
    		writer.write(document);
    		writer.flush();
    		
    	} catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void createTestOuputDocument(){

        try{
            FileOutputStream fos = new FileOutputStream("testXmlOutput.xml");
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer = new XMLWriter(fos, format);


            Document document = DocumentHelper.createDocument();
            
            Element root = document.addElement("controllerTestsData");
            
            Element accountsElement = root.addElement("Accounts");
            accountsElement.addElement("Account")
                    .addAttribute("Name", "Test Account")
                    .addAttribute("Balance","1000.00")
                    .addAttribute("Type", "Normal");
            accountsElement.addElement("Account")
                    .addAttribute("Name", "Test Checking Account")
                    .addAttribute("Balance", "1000.00")
                    .addAttribute("Type" , "Checkings");
            accountsElement.addElement("Account")
                    .addAttribute("Name", "Test Savings Account")
                    .addAttribute("Balance", "1000.00")
                    .addAttribute("SavingsGoal", "1500.00")
                    .addAttribute("Type", "Savings");
            
            Element paymentsElement = root.addElement("Payments");
            
            Element billsElement = paymentsElement.addElement("Bills");
            billsElement.addElement("Bill")
            		.addAttribute("Name", "Test Bill 1")
            		.addAttribute("Balance", "150.00")
            		.addAttribute("minPayment", "150.00");
            billsElement.addElement("Bill")
            		.addAttribute("Name", "Test Bill 2")
            		.addAttribute("Balance", "100.00")
            		.addAttribute("minPayment", "100.00");
            
            Element loansElement = paymentsElement.addElement("Loans");
            loansElement.addElement("Loan")
            			.addAttribute("Name", "Test Loan 1")
            			.addAttribute("Balance", "1400.00")
            			.addAttribute("minPayment", "650.00")
            			.addAttribute("interestRate", ".08");
            
            loansElement.addElement("Loan")
						.addAttribute("Name", "Test Loan 2")
						.addAttribute("Balance", "3400.00")
						.addAttribute("minPayment", "350.00")
						.addAttribute("interestRate", ".08");
            
            
            Element creditCardElement = paymentsElement.addElement("creditCards");
            creditCardElement.addElement("creditCard")
            			.addAttribute("Name", "Test Credit Card 1")
            			.addAttribute("Balance", "700.00")
            			.addAttribute("minPayment", "52.00")
            			.addAttribute("interestRate", ".08");
            
            creditCardElement.addElement("creditCard")
						.addAttribute("Name", "Test Credit Card 2")
						.addAttribute("Balance", "2750.00")
						.addAttribute("minPayment", "100.00")
						.addAttribute("interestRate", ".08");
            
            Element expenseElement = paymentsElement.addElement("Expenses");
            expenseElement.addElement("Expense")
            		.addAttribute("Name", "Test Expense 1")
            		.addAttribute("Balance", "50.00")
            		.addAttribute("minPayment", "50.00");
            expenseElement.addElement("Expense")
            		.addAttribute("Name", "Test Expense 2")
            		.addAttribute("Balance", "100.00")
            		.addAttribute("minPayment", "100.00");


            // pretty print the document to system out
           /* Use this to output to screen
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer;
            writer = new XMLWriter(System.out, format);
           */
            writer.write(document);
            writer.flush();



        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void loadData(String path){

        try {
            File inputFile = new File(path);
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputFile);
            Element rootElement = document.getRootElement();
            
            String accountsPath = "/controllerTestsData/Accounts/Account";
            List<Node> accountNodes = document.selectNodes(accountsPath);
            if (accountNodes.size() > 0) {
                for (Node node : accountNodes) {
                    if (node.valueOf("@Type") == "Savings"){
                        this.addAccount(node.valueOf("@Type"), node.valueOf("@Name"), Double.parseDouble(node.valueOf("@Balance")), Double.parseDouble(node.valueOf("@SavingsGoal")));
                    } else {
                        this.addAccount(node.valueOf("@Type"), node.valueOf("@Name"), Double.parseDouble(node.valueOf("@Balance")));
                    }

                }
            }
            
            String billsPath = "/controllerTestsData/Payments/Bills/Bill";
            List<Node> billNodes = document.selectNodes(billsPath);
            if (billNodes.size() > 0){
            	for(Node node : billNodes){
            		this.addPayment("Bill", node.valueOf("@Name"), Double.parseDouble(node.valueOf("@Balance")), Double.parseDouble(node.valueOf("@minPayment")));
            	}
            }
            
            String loansPath = "/controllerTestsData/Payments/Loans/Loan";
            List<Node> loanNodes = document.selectNodes(loansPath);
            if (loanNodes.size() > 0){
            	for(Node node : loanNodes){
            		this.addPayment("Loan", node.valueOf("@Name"), Double.parseDouble(node.valueOf("@Balance")), Double.parseDouble(node.valueOf("@minPayment")), Double.parseDouble(node.valueOf("@interestRate")));
            	}
            }
            
            String creditCardsPath = "controllerTestsData/Payments/creditCards/creditCard";
            List<Node> creditCardNodes = document.selectNodes(creditCardsPath);
            if (creditCardNodes.size() > 0){
            	for(Node node : creditCardNodes){
            		this.addPayment("Credit", node.valueOf("@Name"), Double.parseDouble(node.valueOf("@Balance")), Double.parseDouble(node.valueOf("@minPayment")), Double.parseDouble(node.valueOf("@interestRate")));
            	}
            }
            
            String expensesPath = "/controllerTestsData/Payments/Expenses/Expense";
            List<Node> expenseNodes = document.selectNodes(expensesPath);
            if (expenseNodes.size() > 0){
            	for(Node node : expenseNodes){
            		this.addPayment("Expense", node.valueOf("@Name"), Double.parseDouble(node.valueOf("@Balance")), Double.parseDouble(node.valueOf("@minPayment")));
            	}
            }
        
        
        }catch (DocumentException e){
            e.printStackTrace();
        }
    }




    public Account getAccount(int index){
        return accountsArray.get(index);
    }

    public void addAccount (Account accountToAdd){
        this.accountsArray.add(accountToAdd);
    }
    public void addAccount(String accountType, String name, Double balance){
        this.addAccount(accountType, name, balance, 0.00);
    }

    public void addAccount(String accountType, String name, Double balance, Double savingsGoal){
        Account tempAccount;
        switch (accountType){
            case "Normal":
                tempAccount = new Account(name, balance);
                this.accountsArray.add(tempAccount);
                break;
            case "Checkings":
                tempAccount = new CheckingAccount(name, balance);
                this.accountsArray.add(tempAccount);
                break;
            case "Savings":
                tempAccount = new SavingsAccount(name, balance, savingsGoal);
                this.accountsArray.add(tempAccount);
                break;
        }

    }

    public void removeAccount(int index){
        accountsArray.remove(index);
    }


    public boolean transferMoney(Account originalAccount, Account transferToAccount, double amount){
        boolean transferWentThrough = false;
        // transfer the balance from the original Account to the transferToAccount
        // check to see if the amount we are trying to transfer would overdraft the account.

        if (checkOverdraft(originalAccount.getBalance(), amount)){
            // if the account is a savings account then
            if(transferToAccount.getType() == "Savings"){
                if(checkTransferOverSavingsGoal(transferToAccount.getSavingsGoal(),transferToAccount.getBalance(),amount)){
                    originalAccount.setBalance(originalAccount.getBalance() - amount);
                    transferToAccount.setBalance(transferToAccount.getBalance() + amount);
                    transferWentThrough = true;
                }
            } else {
                originalAccount.setBalance(originalAccount.getBalance() - amount);
                transferToAccount.setBalance(transferToAccount.getBalance() + amount);
                transferWentThrough = true;
            }

        }
        // If it does then don't let the transfer go through.
        return transferWentThrough;
    }

    // if it will overdraft the account return false, otherwise allow.
    public boolean checkOverdraft(double originalAccountBalance,  double amount){
        if ((originalAccountBalance - amount) < 0) return false;
        else return true;
    }
    // if the transfer goes over the savings goal return false, otherwise allow it.
    public boolean checkTransferOverSavingsGoal(double savingsGoalAmount, double transferBalance, double amount){
        if ((transferBalance + amount) > savingsGoalAmount) return false;
        else return true;
    }
    
    public void addPayment(Payment paymentToAdd){
    	if (paymentToAdd instanceof Loan){
    		this.loanArray.add((Loan)paymentToAdd);
    	} else if (paymentToAdd instanceof CreditCard){
    		this.creditCardArray.add((CreditCard) paymentToAdd);
    	} else if (paymentToAdd instanceof Bill){
    		this.billsArray.add((Bill) paymentToAdd);
    	} else if (paymentToAdd instanceof Expense){
    		this.expenseArray.add((Expense) paymentToAdd);
    	}
    }
    
    public void addPayment(String type, String name, double amount, double minimumPayment){
    	switch(type){
    		case "Bill":
    			this.billsArray.add(new Bill(name, amount, minimumPayment));
    			break;
    		case "Expense":
    			this.expenseArray.add(new Expense(name, amount, minimumPayment));
    			break;
    	}
    }
    
    public void addPayment(String type, String name, double amount, double minimumPayment,  double interestRate){
    	switch(type){
    	case "Loan":
    		this.loanArray.add(new Loan(name, amount, minimumPayment, interestRate));
    		break;
    	case "Credit":
    		this.creditCardArray.add(new CreditCard(name, amount, minimumPayment, interestRate));
    		break;
    	}
    }
    
    public Bill getBill(int index){
    	return this.billsArray.get(index);
    }
    
    public Loan getLoan(int index){
    	return this.loanArray.get(index);
    }
    
    public CreditCard getCreditCard(int index){
    	return this.creditCardArray.get(index);
    }
    
    public Expense getExpense(int index){
    	return this.expenseArray.get(index);
    }

    
    /*
     * Order the debts from the loan and credit card arrays into the ordered array. 
     */
    public void createOrderedDebts(){
    	ArrayList<Debt> tempArray = new ArrayList<Debt>();
    	tempArray.addAll(this.creditCardArray);
    	tempArray.addAll(this.loanArray);
    	this.orderedDebts = mergeSort(tempArray);
    	
    }
    
    public ArrayList<Debt> mergeSort(ArrayList<Debt> unorderedArray){
    	ArrayList<Debt> leftSide = new ArrayList<Debt>();
    	ArrayList<Debt> rightSide = new ArrayList<Debt>();
    	int center;
    	
    	if (unorderedArray.size() == 1) {
    		return unorderedArray;
    	} else {
    		
    		center = unorderedArray.size() / 2;
    		
    		for(int i = 0; i < center; i++){
    			leftSide.add(unorderedArray.get(i));
    		}
    		
    		for(int x = center; x < unorderedArray.size(); x++){
    			rightSide.add(unorderedArray.get(x));
    		}
    		
    		leftSide = mergeSort(leftSide);
    		rightSide = mergeSort(rightSide);
    		
    		merge(leftSide, rightSide, unorderedArray);
    	}
    	return unorderedArray;

    }
    
    private void merge(ArrayList<Debt> left, ArrayList<Debt> right, ArrayList<Debt> whole){
    	int leftIndex = 0;
    	int rightIndex = 0;
    	int wholeIndex = 0;
    	
    	while(leftIndex < left.size() && rightIndex < right.size()){
    		if (compareBalances(left.get(leftIndex),right.get(rightIndex)) <= 0){
    			whole.set(wholeIndex, left.get(leftIndex));
    			leftIndex++;
    		} else {
    			whole.set(wholeIndex, right.get(rightIndex));
    			rightIndex ++;
    		}
    		wholeIndex++;
    	}
    	
    	ArrayList<Debt> rest;
    	int restIndex;
        if (leftIndex >= left.size()) {
            // The left ArrayList has been use up...
            rest = right;
            restIndex = rightIndex;
        } else {
            // The right ArrayList has been used up...
            rest = left;
            restIndex = leftIndex;
        }
     
        // Copy the rest of whichever ArrayList (left or right) was not used up.
        for (int i=restIndex; i<rest.size(); i++) {
            whole.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
    }
      
    private int compareBalances(Debt a, Debt b){
    	return Double.compare(a.getBalance(), b.getBalance());	
    }
    
    
    public static void main(String[] args){
    	Controller testOutput = new Controller();
    	testOutput.createTestOuputDocument();
    }

}

