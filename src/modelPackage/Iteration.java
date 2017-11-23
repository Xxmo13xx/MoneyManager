package modelPackage;
import java.util.ArrayList;

public class Iteration {
	
	Controller controller;
	ArrayList<Debt> debtsArray;
	Double extraPayoffAmount;
	
	public Iteration (Controller controller){
		this.controller = controller;
		debtsArray = controller.getOrderedDebtsArray();
	}
	
	public Iteration (ArrayList<Debt> orderedDebtArray, Double extraPayoffAmount){
		this.debtsArray = orderedDebtArray;
		this.extraPayoffAmount = extraPayoffAmount;
	}
	


	public void getOrderedDebtsArray() {
		// TODO Auto-generated method stub
		this.debtsArray = controller.getOrderedDebtsArray();
	}
	
	public Debt getDebt(int index){
		return this.debtsArray.get(index);
	}
	
	// returns the amount to add to the extra payoff amount if we pay something off during this iteration. 
	public Double runAnIteration(Double extraPayoffAmount) {
		// TODO Auto-generated method stub
		Double addToExtraPayoffForNextIteration = 0.00;
		Double tempExtraPayoff = extraPayoffAmount;

		for(Debt tempDebt : debtsArray){
			// temp debt will get paid off by the minimum payment
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
		return addToExtraPayoffForNextIteration;
		
	}



	public Double runXIterations(int numberOfIterations, double extraPayoffAmount) {
		// TODO Auto-generated method stub
		Double addToExtraPayoff = extraPayoffAmount;
		while(numberOfIterations > 0){
			if(! debtsArray.isEmpty()){
				addToExtraPayoff += runAnIteration(addToExtraPayoff);
			}
			numberOfIterations--;	
		}
		return addToExtraPayoff;
		
	}
	
	public String generateIterationOutput(Debt iterationDebt){
		StringBuilder output = new StringBuilder();
		output.append("Debt: " + iterationDebt.getName() + "\n");
		output.append("Balance: " + iterationDebt.getBalance() + "\n");
		
		return output.toString();
	}
	
		
	
	public void output(int iteration){
		System.out.println("\tIteration Number " + iteration);
		//System.out.println("Debt: " + )
	}
	
}
