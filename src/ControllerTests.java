import org.junit.*;

import junit.framework.*;
import org.junit.Test;

public class ControllerTests extends TestCase {

    protected Account testAccount, testCheckingAccount, testSavingsAccount, testCheckingsAccountToAdd;
    protected Controller testController;
    protected Payment testPayment, testBillPayment, testDebtPayment, testLoanPayment, testCreditPayment, testExpensePayment;
    protected Payment testBillPayment2, testExpensePayment2;

    // File that has the test data.
    String testDataFile = "Users\\Willie\\IdeaProjects\\MoneyManager\\controllerTestDataFile.txt";

    @Before
    protected void setUp(){
        testAccount = new Account("Test Account", 1000.00);
        testCheckingAccount = new CheckingAccount("Test Checking Account", 1000.00);
        testSavingsAccount = new SavingsAccount("Test Savings Account", 1000.00, 1500.00);
        testPayment = new Payment("Test Payment", 1000.00, 50.00);
        testBillPayment = new Bill("Test Bill", 4000.00, 100.00);
        testBillPayment2 = new Bill("Test Bill 2" , 3000.00, 150.00);
        testLoanPayment = new Loan("Test Loan", 13400.00, 250.00, .08);
        testCreditPayment = new CreditCard("Test Credit", 2750.00, 52.00, .05);
        testExpensePayment = new Expense("Test Expense", 150.00, 150.00);
        testExpensePayment2 = new Expense("Test Expense 2", 100.00, 100.00);

        testController = new Controller();
    }

    @Test
    public void testLoadAccounts(){
        //loading all the information from the file.
    	// loadDataFile path testXmlOutput.xml 
        testController.loadData("testXmlOutput.xml");
        //testing to make sure the accounts were added correctly.
        assertEquals(testController.getAccount(0).getName(), testAccount.getName());
        assertEquals(testController.getAccount(0).getBalance(), testAccount.getBalance());
        assertEquals(testController.getAccount(1).getName(), testCheckingAccount.getName());
        assertEquals(testController.getAccount(1).getBalance(), testCheckingAccount.getBalance());
        assertEquals(testController.getAccount(2).getName(), testSavingsAccount.getName());
        assertEquals(testController.getAccount(2).getBalance(), testSavingsAccount.getBalance());
    }
    @Test
    public void testLoadPayments(){
    	testController.loadData("testXmlOutput.xml");
    	assertEquals(testController.getBill(0).getName(), "Test Bill 1");
    	assertEquals("Test Bill 2", testController.getBill(1).getName());
    	assertEquals("Test Expense 1", testController.getExpense(0).getName());
    	assertEquals("Test Expense 2", testController.getExpense(1).getName());
    	assertEquals("Test Loan 1", testController.getLoan(0).getName());
    	assertEquals("Test Loan 2", testController.getLoan(1).getName());
    	assertEquals("Test Credit Card 1", testController.getCreditCard(0).getName());
    	assertEquals("Test Credit Card 2", testController.getCreditCard(1).getName());
    }
    
    @Test
    public void testSaveData(){
    	testController.addAccount(testAccount);
    	testController.addAccount(testSavingsAccount);
    	testController.addAccount(testCheckingAccount);
    	testController.addPayment(testBillPayment);
    	testController.addPayment(testBillPayment2);
    	testController.addPayment(testLoanPayment);
    	testController.addPayment(testCreditPayment);
    	testController.addPayment(testExpensePayment);
    	testController.addPayment(testExpensePayment2);
    	
    	testController.saveData();
    	testController.loadData("testSaveData.xml");
    	
    	assertEquals(testController.getAccount(0).getName(), testAccount.getName());
    	assertEquals(testController.getAccount(1).getName(), testSavingsAccount.getName());
    	assertEquals(testController.getAccount(2).getName(), testCheckingAccount.getName());
    	assertEquals(testController.getBill(0).getName(), testBillPayment.getName());
    	assertEquals(testController.getBill(1).getName(), testBillPayment2.getName());
    	assertEquals(testController.getLoan(0).getName(), testLoanPayment.getName());
    	assertEquals(testController.getCreditCard(0).getName(), testCreditPayment.getName());
    	assertEquals(testController.getExpense(0).getName(), testExpensePayment.getName());
    	assertEquals(testController.getExpense(1).getName(), testExpensePayment2.getName());
    }

    @Test
    public void testAddAnAccount(){
        testController.loadData("testXmlOutput.xml");
        testController.addAccount(new CheckingAccount("Test Checking Account to Add", 2000.00));
        assertEquals(testController.accountsArray.size(), 4);
        assertEquals(testController.getAccount(3).getName(), "Test Checking Account to Add");
        assertEquals(testController.getAccount(3).getBalance(), 2000.00);
    }

    @Test
    public void testDeleteAnAccount(){
        testController.loadData("testXmlOutput.xml");
        testController.removeAccount(0);
        assertEquals(testController.accountsArray.size(),2);
        assertFalse(testController.getAccount(0).getName() == testAccount.getName());
    }

    @Test
    public void testTranfer(){
        testController.transferMoney(testAccount, testSavingsAccount, 500.00);
        assertEquals(testAccount.getBalance(),500.00);
        assertEquals(testSavingsAccount.getBalance(),1500.00);
    }

    @Test
    public void testTransferWithoutEnoughFunds(){
        assertFalse(testController.transferMoney(testAccount, testCheckingAccount, 20000.00));
        assertEquals(testAccount.getBalance(),1000.00 );
        assertEquals(testSavingsAccount.getBalance(),1000.00 );
    }

    @Test
    public void testTransferToSavingsAndGoOverTheGoal(){
        System.out.println("--------- In the test that is messing up");
        assertFalse(testController.transferMoney(testAccount, testSavingsAccount, 600.00));
        assertEquals(testAccount.getBalance(),1000.00 );
        assertEquals(testSavingsAccount.getBalance(),1000.00 );
    }

    @Test
    public void testTransferToSavingsWentThrough(){
        assertTrue(testController.transferMoney(testAccount, testSavingsAccount, 500.00));
        assertEquals(testAccount.getBalance(), 500.00);
        assertEquals(testSavingsAccount.getBalance(), 1500.00);
    }

    @Test
    public void testAddPaymentWithPaymentClass(){
        testController.addPayment(testBillPayment);
        testController.addPayment(testLoanPayment);
        testController.addPayment(testCreditPayment);
        testController.addPayment(testExpensePayment);


        assertEquals(testController.getBill(0).getName(), "Test Bill");
        assertEquals(testController.getLoan(0).getName(), "Test Loan");
        assertEquals(testController.getCreditCard(0).getName(), "Test Credit");
        assertEquals(testController.getExpense(0).getName(), "Test Expense");
    }

    @Test
    public void testAddPaymentWithProperties(){

        testController.addPayment("Bill", "testBill", 2000.00, 100.00);
        testController.addPayment("Loan", "testLoan", 4000.00, 250.00, .08);
        testController.addPayment("Credit", "testCredit", 1200.00, 120.00, .05);
        testController.addPayment("Expense", "testExpense", 50.00, 50.00);


        assertEquals(testController.getBill(0).getName(), "testBill");
        assertEquals(testController.getLoan(0).getName(), "testLoan");
        assertEquals(testController.getCreditCard(0).getName(), "testCredit");
        assertEquals(testController.getExpense(0).getName(), "testExpense");

    }

    @Test
    public void testDeleteADebt(){
    	assertTrue(false);
    }
    
    @Test
    public void testOrderedDebtList(){
    	testController.addPayment("Credit", "test credit 3",  4000.00, 200.00, .08);
    	testController.addPayment("Credit", "test credit 1",  1000.00, 100.00, .08);
    	testController.addPayment("Credit", "test credit 2",  2500.00, 250.00, .08);
    	testController.addPayment("Loan", "test loan 3", 34000.00, 350.00, .08);
    	testController.addPayment("Loan", "test loan 1",  8500.00, 250.00, .08);
    	testController.addPayment("Loan", "test loan 2",  14000.00, 650.00, .08);
    	
    	testController.createOrderedDebts();
    	
    	assertEquals(testController.orderedDebts.get(0).getBalance(), 1000.00);
    	assertEquals(testController.orderedDebts.get(1).getBalance(), 2500.00);
    	assertEquals(testController.orderedDebts.get(2).getBalance(), 4000.00);
    	assertEquals(testController.orderedDebts.get(3).getBalance(), 8500.00);
    	assertEquals(testController.orderedDebts.get(4).getBalance(), 14000.00);
    	assertEquals(testController.orderedDebts.get(5).getBalance(), 34000.00);
    	
    	assertEquals(testController.orderedDebts.get(0).getName(), "test credit 1");
    	assertEquals(testController.orderedDebts.get(1).getName(),"test credit 2");
    	assertEquals(testController.orderedDebts.get(2).getName(), "test credit 3");
    	assertEquals(testController.orderedDebts.get(3).getName(), "test loan 1");
    	assertEquals(testController.orderedDebts.get(4).getName(), "test loan 2");
    	assertEquals(testController.orderedDebts.get(5).getName(), "test loan 3");
    	
    }
}
