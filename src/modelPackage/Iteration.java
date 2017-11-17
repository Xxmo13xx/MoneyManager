package modelPackage;
import java.util.ArrayList;

public class Iteration {
	
	Controller controller;
	ArrayList<Debt> iterationArray;
	
	public Iteration (Controller controller){
		this.controller = controller;
		iterationArray = controller.getOrderedDebtsArray();
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}


	public void getOrderedDebtsArray() {
		// TODO Auto-generated method stub
		this.iterationArray = controller.getOrderedDebtsArray();
	}
	
	public Debt getDebt(int index){
		return this.iterationArray.get(index);
	}
	// returns the amount to add to the extra payoff amount if we pay something off during this iteration. 
	public Double runAnIteration(Double extraPayoffAmount) {
		// TODO Auto-generated method stub
		Double addToExtraPayoffForNextIteration = 0.00;
		Double tempExtraPayoff = extraPayoffAmount;
		Boolean makeExtraPayment = true;
		for(Debt tempDebt : iterationArray){
			// temp debt will get paid off by the minimum payment
			if(tempDebt.willBePayedOff()){
				
				// get amount that would be left over and add it to the temp extra payoff amount
				Double leftOverAmount = tempDebt.getMinimumPayment() - tempDebt.getBalance();
				tempExtraPayoff += leftOverAmount;
				// add the minimumPayment to the next payoff amount
				addToExtraPayoffForNextIteration = tempDebt.getMinimumPayment();
				tempDebt.setBalance(0.00);
			// the debt will not get paid off by the minimum payment during this iteration
			} else {
				tempDebt.makeMinimumPayment();
			}
			
			if (tempExtraPayoff > 0.00){
				// the extra payment will payoff the debt. 
				if(tempDebt.willBePayedOff(tempExtraPayoff)){
					
					// get the money that would be left over from the extra payment
					Double leftOverAmount = tempExtraPayoff - tempDebt.getBalance();
					// update the tempExtraPayoff
					tempExtraPayoff = leftOverAmount;
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
		return addToExtraPayoffForNextIteration;
		
	}



	public void runXIterations(int i, double d) {
		// TODO Auto-generated method stub
		
	}

}
