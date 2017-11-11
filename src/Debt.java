public class Debt extends Payment {
	
	double interestRate;
	
	public Debt(String name, double amount, double minimumPayment, double interestRate){
		super(name, amount, minimumPayment);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	
	
}
