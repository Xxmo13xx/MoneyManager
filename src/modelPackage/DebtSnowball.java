package modelPackage;
import java.util.*;

public class DebtSnowball {
	Controller controller;
	ArrayList<Account> accountArray;
	ArrayList<Debt> debtArray;
	ArrayList<Double[]> resultsArray;
	Double initialPayoff, currentPayoff, count;
	boolean payoffAmountSet;
	int arraySize;
	
	public DebtSnowball(Controller controller, Double extraPayoff){
		this.controller = controller;
		accountArray = controller.getAccountsArray();
		debtArray = controller.getOrderedDebtsArray();
		resultsArray = new ArrayList<Double[]>();
		arraySize = 2+debtArray.size();
		count = 0.00;
		initialPayoff = extraPayoff;
		currentPayoff = extraPayoff;
		payoffAmountSet = true;
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
		initialPayoff = 0.00;
		currentPayoff = 0.00;
		payoffAmountSet = false;
	}
	
	public int getIterationArraySize(){
		return arraySize;
	}
	
	public void createIterationResults(){
		Double[] initialResults = new Double[arraySize];
		initialResults[0] = count;
		initialResults[1] = this.currentPayoff;
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
	
	public String[] getDebtNames() {
		String[] debtNames = new String[debtArray.size()];
		int count = 0;
		for(Debt tempDebt : debtArray) {
			debtNames[count] = tempDebt.getName();
			count++;
		}
		return debtNames;
	}
	public void setPayoffAmount(double payoffAmount) {
		// TODO Auto-generated method stub
		if(! payoffAmountSet){
			this.initialPayoff = payoffAmount;
			this.currentPayoff = payoffAmount;
			payoffAmountSet = true;
		}
		
	}
	public String[] getInitialValues() {
		// TODO Auto-generated method stub
		String[] tempArray = new String[debtArray.size()+2];
		int count = 2;
		tempArray[0] = "Inititial";
		tempArray[1] = "Balance";
		for(Debt tempDebt: debtArray){
			tempArray[count] = Double.toString(tempDebt.getBalance());
			count++;
		}
		return tempArray;
	}
	public String[] getMinimumPayments() {
		// TODO Auto-generated method stub
		String[] tempArray = new String[debtArray.size()+2];
		int count = 2; 
		tempArray[0] = "Minimum";
		tempArray[1] = "Payments";
		for(Debt tempDebt : debtArray){
			tempArray[count] = Double.toString(tempDebt.getMinimumPayment());
			count++;
		}
		return tempArray;
	}

}
