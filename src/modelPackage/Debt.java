package modelPackage;
public class Debt extends Payment {
	
	double interestRate;
	String type;
	
	public Debt(String name, double amount, double minimumPayment, double interestRate, String type){
		super(name, amount, minimumPayment);
		this.interestRate = interestRate;
		this.type = type;
	}

	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public String getType(){
		return type;
	}
	
	public void makeMinimumPayment(){
		this.balance = this.balance - this.minimumPayment;
	}
	
	public Boolean willBePayedOff(){
		if( (this.balance - this.minimumPayment) <= 0.00){
			return true;
		} else {
			return false;
		}
	}
	
	public void setBalance(Double amount){
		this.balance = amount;
	}
	
	public Boolean willBePayedOff(Double extraPayment){
		if( (this.balance - extraPayment) <= 0.00){
			return true;
		} else {
			return false;
		}
	}

	public void makeExtraPayment(Double tempExtraPayoff) {
		// TODO Auto-generated method stub
		this.balance = this.balance - tempExtraPayoff;
	}

	
	
}
