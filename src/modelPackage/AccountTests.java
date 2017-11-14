package modelPackage;
import org.junit.*;
import junit.framework.*;
import org.junit.Test;


public class AccountTests extends TestCase {

    protected Account testAccount, testCheckingAccount, testSavingsAccount;

    @Before
    protected void setup(){
        testAccount = new Account("Test Checking Account", 1000.00);
        testCheckingAccount = new CheckingAccount("Test Checking Account", 1000.00);
        testSavingsAccount = new SavingsAccount("Test Savings Account", 1000.00, 1500.00);
    }

    @Test
    public void testWithdrawalFunctionality(){
        double amountWithdrawn = testAccount.withdraw(100.00);
        // Ensure the amount was taken from the test account
        assertEquals(testAccount.getBalance(),900.00);
        // Ensure the amountWithdrawn is the correct amount.
        assertEquals(amountWithdrawn,100);
    }

    @Test
    public void testWithdrawalOverDraft(){
        double amountWithdrawn = testCheckingAccount.withdraw(1200.00);
        assertEquals(testCheckingAccount.getBalance(),1000.00);
        assertEquals(amountWithdrawn,0.0);
    }

    @Test
    public void testDepositFunctionality(){
        testAccount.deposit(50.00);
        assertEquals(testAccount.getBalance(), 1050.00);
    }

    @Test
    public void testDepositNotAllowedSavingsGoalHasBeenReached(){
        double depositAmount = 600.00;
        depositAmount = testSavingsAccount.deposit(600.00);
        // When you try to deposit moeny if the amount you are trying to deposit goes over the amount of the savings goal then it will return
        // the amount of money over the budget.
        assertEquals(testSavingsAccount.getBalance(),1500.00);
        assertEquals(depositAmount, 100.00);
    }







}
