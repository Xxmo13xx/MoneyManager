package modelPackage;
import java.util.ArrayList;
import java.util.*;

public class DebtSnowball {
	Controller controller;
	ArrayList<Account> accountArray;
	ArrayList<Debt> debtArray;
	ArrayList<Double[]> resultsArray;
	Double initialPayoff, currentPayoff, count;
	int arraySize;
	
	public DebtSnowball(Controller controller, Double extraPayoff){
		this.controller = controller;
		accountArray = controller.getAccountsArray();
		debtArray = controller.getOrderedDebtsArray();
		resultsArray = new ArrayList<Double[]>();
		arraySize = 2+debtArray.size();
		count = 0.00;
		currentPayoff = extraPayoff;
		// add the first iteration with just the input information.
		createIterationResults();
	}
	public DebtSnowball(Controller controller){
		this.controller = controller;
		accountArray = controller.getAccountsArray();
		debtArray = controller.getOrderedDebtsArray();
		resultsArray = new ArrayList<Double[]>();
		arraySize = 2+debtArray.size();
		count = 0.00;
		currentPayoff = 0.00;
	}
	
	public int getIterationArraySize(){
		return arraySize;
	}
	
	public void createIterationResults(){
		Double[] initialResults = new Double[arraySize];
		initialResults[0] = this.currentPayoff;
		initialResults[1] = count;
		for(int x = 2; x < arraySize; x++){
			initialResults[x] = debtArray.get(x-2).getBalance();
		}
		resultsArray.add(initialResults);
		count++;
	}
	
	
	
	public void runAnIteration(){
		
		Double addToExtraPayoffForNextIteration = 0.00;
		Double tempExtraPayoff = currentPayoff;
		
		for (Debt tempDebt : debtArray){
			if (tempDebt.getBalance() > 0.00){
				if(tempDebt.willBePayedOff()){
					
					// get amount that would be left over and add it to the temp extra payoff amount
					Double leftOverAmount = tempDebt.getMinimumPayment() - tempDebt.getBalance();
					tempExtraPayoff += leftOverAmount;
					// add the minimumPayment to the next payoff amount
					addToExtraPayoffForNextIteration += tempDebt.getMinimumPayment();
					tempDebt.setBalance(0.00);
				// the debt will not get paid off by the minimum payment during this iteration
				} else {
					tempDebt.makeMinimumPayment();
				}
			}
			
			if (tempDebt.getBalance() > 0.00){
				
				if (tempExtraPayoff > 0.00){
					// the extra payment will payoff the debt. 
					if(tempDebt.willBePayedOff(tempExtraPayoff)){
						
						// get the money that would be left over from the extra payment
						Double leftOverAmount = tempExtraPayoff - tempDebt.getBalance();
						// update the tempExtraPayoff
						tempExtraPayoff = leftOverAmount;
						addToExtraPayoffForNextIteration += tempDebt.getMinimumPayment();
						tempDebt.setBalance(0.00);
						// leave the makeExtraPayment boolean true so it can be payed on the next debt.
					// the debt won't get paid off by the extra payment
					} else{
						tempDebt.makeExtraPayment(tempExtraPayoff);
						tempExtraPayoff = 0.00;
						//makeExtraPayment = false;
					}
				}
			}
		}
		currentPayoff += addToExtraPayoffForNextIteration;
		createIterationResults();
	}
	
	public void runXIterations(int numIterations){
		while(numIterations > 0){
			if(! debtArray.isEmpty()){
				runAnIteration();
			}
			numIterations--;
		}
	}
	
	public Double[] getIterationResults(int index){
		return this.resultsArray.get(index);
	}

	public void outputResults() {
		// TODO Auto-generated method stub
		StringBuilder resultsOutput = new StringBuilder();
		for(Double[] results : resultsArray){
			resultsOutput.append("Iteration # " + Math.round(results[1]) + ": ");
			for(int x = 2; x < arraySize; x++){
				resultsOutput.append(results[x] + " || ");
			}
			resultsOutput.append("Initial Payoff: " + results[0]+ "\n");
		}
		System.out.println(resultsOutput.toString());
	}

}
