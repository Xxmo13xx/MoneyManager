package modelPackage;

import org.junit.*;

import junit.framework.*;
import org.junit.Test;

import org.junit.Before;


public class IterationTests extends TestCase {
	Iteration testIteration;
	Controller controller;
	CreditCard testCard1, testCard2, testCardPayoffNormally;
	Loan testLoan1, testLoan2, testLoanPayoffExtra;
	
	@Before
	public void setUp() throws Exception {
		
		controller = new Controller();
		testIteration = new Iteration(controller);
		testCard1 = new CreditCard("Test Card 1", 1000.00, 250.00, .08);
		testLoan1 = new Loan("Test Loan 1", 14000.00, 600.00, .09);
		testCard2 = new CreditCard("Test Card 2", 900.00, 50.00, .07);
		testLoan2 = new Loan("Test Loan 2", 9000.00, 300.00, .06);
		testCardPayoffNormally = new CreditCard("Test Card Payoff Normally", 300.00, 400.00, .05);
		testLoanPayoffExtra = new Loan("Test Loan Pay Off Extra", 550.00, 500.00, .04);
	}

	@Test
	public void testIterationBasicFunctionality() {
		// add all the payments
		controller.addPayment(testCard1);
		controller.addPayment(testCard2);
		controller.addPayment(testLoan1);
		controller.addPayment(testLoan2);
		// order the array on the controller
		controller.createOrderedDebts();
		// get the ordered debt array from controller
		testIteration.getOrderedDebtsArray();
		testIteration.runAnIteration(100.00);
		
		assertEquals(testIteration.getDebt(0).getBalance(), 750.00);
		assertEquals(testIteration.getDebt(1).getBalance(), 750.00);
		assertEquals(testIteration.getDebt(2).getBalance(), 8700.00);
		assertEquals(testIteration.getDebt(3).getBalance(), 13400.00);
	}
	

	
	@Test 
	public void testIterationPayoffNormally(){
		controller.addPayment(testCard1);
		controller.addPayment(testCard2);
		controller.addPayment(testLoan1);
		controller.addPayment(testLoan2);
		controller.addPayment(testCardPayoffNormally);
		
		controller.createOrderedDebts();
		
		testIteration.getOrderedDebtsArray();
		testIteration.runAnIteration(100.00);
		
		assertEquals(testIteration.getDebt(0).getBalance(),0.00);
		assertEquals(testIteration.getDebt(1).getBalance(), 650.00);

	}
	
	@Test 
	public void testIterationPayoffExtra(){
		controller.addPayment(testCard1);
		controller.addPayment(testCard2);
		controller.addPayment(testLoan1);
		controller.addPayment(testLoan2);
		controller.addPayment(testLoanPayoffExtra);
		
		controller.createOrderedDebts();
		
		testIteration.getOrderedDebtsArray();
		testIteration.runAnIteration(100.00);
		
		assertEquals(testIteration.getDebt(0).getBalance(), 0.00);
		assertEquals(testIteration.getDebt(1).getBalance(), 800.00);
		

	}
	
	
	
	@Test 
	public void testXIterationsFunctionality(){

		controller.addPayment(testCard1);
		controller.addPayment(testCard2);
		controller.addPayment(testLoan1);
		controller.addPayment(testLoan2);
		// order the array on the controller
		controller.createOrderedDebts();
		// get the ordered debt array from controller
		testIteration.getOrderedDebtsArray();
		testIteration.runXIterations(2, 100.00);
		
		assertEquals(testIteration.getDebt(0).getBalance(), 600.00);
		assertEquals(testIteration.getDebt(1).getBalance(), 500.00);
		assertEquals(testIteration.getDebt(2).getBalance(), 8400.00);
		assertEquals(testIteration.getDebt(3).getBalance(), 12800.00);
		
	}
	
	@Test 
	public void testXIterationsPayoffNormally(){

		controller.addPayment(testCard1);
		controller.addPayment(testCard2);
		controller.addPayment(testLoan1);
		controller.addPayment(testLoan2);
		controller.addPayment(testCardPayoffNormally);
		
		controller.createOrderedDebts();
		
		testIteration.getOrderedDebtsArray();
		testIteration.runXIterations(2,100.00);
		
		assertEquals(testIteration.getDebt(0).getBalance(), 0.00);
		assertEquals(testIteration.getDebt(1).getBalance(), 100.00);
	}
	
	@Test
	public void testXIterationsPayoffExtra(){

		controller.addPayment(testCard1);
		controller.addPayment(testCard2);
		controller.addPayment(testLoan1);
		controller.addPayment(testLoan2);
		controller.addPayment(testLoanPayoffExtra);
		
		controller.createOrderedDebts();
		
		testIteration.getOrderedDebtsArray();
		testIteration.runXIterations(2,100.00);

		
		assertEquals(testIteration.getDebt(0).getBalance(), 0.00);
		assertEquals(testIteration.getDebt(1).getBalance(), 150.00);
	}
	
	@Test
	public void testThoroughIterationsPayoff(){
		
		controller.addPayment(testCard1);
		controller.addPayment(testCard2);
		controller.addPayment(testLoan1);
		controller.addPayment(testLoan2);
		controller.addPayment(testLoanPayoffExtra);
		controller.addPayment(testCardPayoffNormally);
		
		controller.createOrderedDebts();
		
		testIteration.getOrderedDebtsArray();
		Double extraPayoff = 100.00;
		
		extraPayoff = testIteration.runXIterations(1,extraPayoff);
		//Iteration 1
		assertEquals(controller.getDebt(0).getBalance(),0.00);
		assertEquals(controller.getDebt(1).getBalance(),0.00);
		assertEquals(controller.getDebt(2).getBalance(),700.00);
		assertEquals(controller.getDebt(3).getBalance(),750.00);
		assertEquals(controller.getDebt(4).getBalance(),8700.00);
		assertEquals(controller.getDebt(5).getBalance(),13400.00);
		
		extraPayoff = testIteration.runXIterations(1,extraPayoff);

		//Iteration 2
		assertEquals(controller.getDebt(2).getBalance(),0.00);
		assertEquals(controller.getDebt(3).getBalance(),150.00);
		assertEquals(controller.getDebt(4).getBalance(),8400.00);
		assertEquals(controller.getDebt(5).getBalance(),12800.00);
		
		extraPayoff = testIteration.runXIterations(1,extraPayoff);
		
		//Iteration 3
		assertEquals(controller.getDebt(3).getBalance(),0.00);
		assertEquals(controller.getDebt(4).getBalance(),6950.00);
		assertEquals(controller.getDebt(5).getBalance(),12200.00);

		extraPayoff = testIteration.runXIterations(2,extraPayoff);
		//Iteration 5
		assertEquals(controller.getDebt(4).getBalance(),3750.00);
		assertEquals(controller.getDebt(5).getBalance(),11000.00);
		
		extraPayoff = testIteration.runXIterations(2,extraPayoff);
		
		//Iteration 7
		assertEquals(controller.getDebt(4).getBalance(),550.00);
		assertEquals(controller.getDebt(5).getBalance(),9800.00);
		
		extraPayoff = testIteration.runXIterations(1,extraPayoff);

		//Iteration 8
		assertEquals(controller.getDebt(4).getBalance(),0.00);
		assertEquals(controller.getDebt(5).getBalance(),8150.00);
		
		extraPayoff = testIteration.runXIterations(2,extraPayoff);
		
		//Iteration 10
		assertEquals(controller.getDebt(5).getBalance(),3750.00);

		extraPayoff = testIteration.runXIterations(2,extraPayoff);
		
		//Iteration 12
		assertEquals(controller.getDebt(5).getBalance(),0.00);
	}
	


	
	@Test 
	public void testIterationOutput(){
		fail("Not yet implemented");
	}
	
	@Test
	public void testIterationUpdatesController(){
		fail("Not yet implemented");
	}

}
