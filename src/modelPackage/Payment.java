package modelPackage;
public class Payment {
    String name;
    double balance;
    double minimumPayment;
    //Date dueDate;
    boolean isPayed;

    public Payment(String name, double amountOwed, double minimumPayment){
        this.name = name;
        this.balance = amountOwed;
        this.minimumPayment = minimumPayment;
        this.isPayed = false;
    }
    
    /*
     * Getters and Setters
     */
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setAmountOwed(double amountOwed) {
		this.balance = amountOwed;
	}
	public boolean isPayed() {
		return isPayed;
	}
	public void setPayed(boolean isPayed) {
		this.isPayed = isPayed;
	}
	public double getMinimumPayment(){
		return minimumPayment;
	}
    
}
