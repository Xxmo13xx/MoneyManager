package modelPackage;

import org.junit.*;

import junit.framework.*;
import org.junit.Test;

import org.junit.Before;

public class DebtSnowballTests extends TestCase {
	
	
	Controller controller;
	CreditCard testCard1, testCard2, testCardPayoffNormally;
	Loan testLoan1, testLoan2, testLoanPayoffExtra;
	DebtSnowball testDebtSnowball;
	
	@Before
	public void setUp() throws Exception {
		
		controller = new Controller();
		testCard1 = new CreditCard("Test Card 1", 1000.00, 250.00, .08);
		testLoan1 = new Loan("Test Loan 1", 14000.00, 600.00, .09);
		testCard2 = new CreditCard("Test Card 2", 900.00, 50.00, .07);
		testLoan2 = new Loan("Test Loan 2", 9000.00, 300.00, .06);
		testCardPayoffNormally = new CreditCard("Test Card Payoff Normally", 300.00, 400.00, .05);
		testLoanPayoffExtra = new Loan("Test Loan Pay Off Extra", 550.00, 500.00, .04);
		
		// add everything to the controller.
		controller.addPayment(testCard1);
		controller.addPayment(testCard2);
		controller.addPayment(testCardPayoffNormally);
		controller.addPayment(testLoan1);
		controller.addPayment(testLoan2);
		controller.addPayment(testLoanPayoffExtra);
	}
	

	@Test
	public void testConstructor() {
		testDebtSnowball = new DebtSnowball(controller, 100.00);
		
		Double[] iterationResults = testDebtSnowball.getIterationResults(0);
		
		assertEquals(100.00, iterationResults[0]);
		assertEquals(0.00, iterationResults[1]);
		assertEquals(300.00, iterationResults[2]);
		assertEquals(550.00, iterationResults[3]);
		assertEquals(900.00, iterationResults[4]);
		assertEquals(1000.00, iterationResults[5]);
		assertEquals(9000.00, iterationResults[6]);
		assertEquals(14000.00, iterationResults[7]);
	}
	
	@Test 
	public void testRunningAnIteration(){
		testDebtSnowball = new DebtSnowball(controller, 100.00);
		
		testDebtSnowball.runAnIteration();
		
		Double[] iterationResults = testDebtSnowball.getIterationResults(1);
		
		assertEquals(1000.00, iterationResults[0]);
		assertEquals(1.00, iterationResults[1]);
		assertEquals(0.00, iterationResults[2]);
		assertEquals(0.00, iterationResults[3]);
		assertEquals(700.00, iterationResults[4]);
		assertEquals(750.00, iterationResults[5]);
		assertEquals(8700.00, iterationResults[6]);
		assertEquals(13400.00, iterationResults[7]);
	}
	
	@Test
	public void testIterationPayoffNormally(){
		controller.removeDebtFromIteration(testLoanPayoffExtra);
		
		testDebtSnowball = new DebtSnowball(controller, 100.00);
		testDebtSnowball.runAnIteration();
		
		Double[] iterationResults = testDebtSnowball.getIterationResults(1);
		
		assertEquals(0.00, iterationResults[2]);
		assertEquals(650.00, iterationResults[3]);
	}
	
	@Test 
	public void testIterationPayoffExtra(){
		controller.removeDebtFromIteration(testCardPayoffNormally);
		
		testDebtSnowball = new DebtSnowball(controller, 100.00);
		testDebtSnowball.runAnIteration();
		
		Double[] iterationResults = testDebtSnowball.getIterationResults(1);
		
		assertEquals(0.00, iterationResults[2]);
		assertEquals(800.00, iterationResults[3]);
	}
	
	@Test
	public void testXIterationsFunctionality(){
		controller.removeDebtFromIteration(testCardPayoffNormally);
		controller.removeDebtFromIteration(testLoanPayoffExtra);
		
		testDebtSnowball = new DebtSnowball(controller, 100.00);
		testDebtSnowball.runXIterations(2);
		
		Double[] iterationResults = testDebtSnowball.getIterationResults(2);
		
		assertEquals(600.00, iterationResults[2]);
		assertEquals(500.00, iterationResults[3]);
		assertEquals(8400.00, iterationResults[4]);
		assertEquals(12800.00, iterationResults[5]);
	}
	
	@Test
	public void testXIterationsPayoffNormally(){
		controller.removeDebtFromIteration(testLoanPayoffExtra);
		
		testDebtSnowball = new DebtSnowball(controller, 100.00);
		testDebtSnowball.runXIterations(2);
		
		Double[] iterationResults = testDebtSnowball.getIterationResults(2);
		
		assertEquals(0.00, iterationResults[2]);
		assertEquals(100.00, iterationResults[3]);
	}
	
	@Test
	public void testXIterationsPayoffExtra(){
		controller.removeDebtFromIteration(testCardPayoffNormally);
		
		testDebtSnowball = new DebtSnowball(controller, 100.00);
		testDebtSnowball.runXIterations(2);
		
		Double[] iterationResults = testDebtSnowball.getIterationResults(2);
		
		assertEquals(0.00, iterationResults[2]);
		assertEquals(150.00, iterationResults[3]);
	}
	
	
	@Test 
	public void testThoroughIterationsPayoff(){
		testDebtSnowball = new DebtSnowball(controller, 100.00);
		testDebtSnowball.runXIterations(12);
		
		Double[] oneResults = testDebtSnowball.getIterationResults(1);
		Double[] twoResults = testDebtSnowball.getIterationResults(2);
		Double[] threeResults = testDebtSnowball.getIterationResults(3);
		Double[] fiveResults = testDebtSnowball.getIterationResults(5);
		Double[] sixResults = testDebtSnowball.getIterationResults(6);
		Double[] sevenResults = testDebtSnowball.getIterationResults(7);
		Double[] eightResults = testDebtSnowball.getIterationResults(8);
		Double[] tenResults = testDebtSnowball.getIterationResults(10);
		Double[] twelveResults = testDebtSnowball.getIterationResults(12);
		
		//Iteration 1
		assertEquals(0.00, oneResults[2]);
		assertEquals(0.00, oneResults[3]);
		assertEquals(700.00, oneResults[4]);
		assertEquals(750.00, oneResults[5]);
		assertEquals(8700.00, oneResults[6]);
		assertEquals(13400.00, oneResults[7]);
		
		//Iteration 2
		assertEquals(0.00, twoResults[4]);
		assertEquals(150.00, twoResults[5]);
		assertEquals(8400.00, twoResults[6]);
		assertEquals(12800.00, twoResults[7]);
		
		//Iteration 3
		assertEquals(0.00, threeResults[5]);
		assertEquals(6950.00, threeResults[6]);
		assertEquals(12200.00, threeResults[7]);
		
		//Iteration 5
		assertEquals(3750.00, fiveResults[6]);
		assertEquals(11000.00, fiveResults[7]);
		
		//Iteration 7
		assertEquals(550.00, sevenResults[6]);
		assertEquals(9800.00, sevenResults[7]);
		
		//Iteration 8
		assertEquals(0.00, eightResults[6]);
		assertEquals(8150.00, eightResults[7]);
		
		//Iteration 10
		assertEquals(3750.00, tenResults[7]);
		
		//Iteration 12
		assertEquals(0.00, twelveResults[7]);
	}
	
	@Test
	public void testIterationArrayOutput(){
		testDebtSnowball = new DebtSnowball(controller, 100.00);
		testDebtSnowball.runXIterations(12);
		
		testDebtSnowball.outputResults();
	}
	
	
	
	
	
	
	
	
	
	
	

}
