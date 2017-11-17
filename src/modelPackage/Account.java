package modelPackage;
public class Account {

    String type;
    double balance;
    String name;
    double savingsGoal = 0.00;

    /*
    * Constructors
    */

    public Account(){
        balance = 0.00;
        name = "No name given";
        type = "Normal";
    }
    public Account(String name){
        balance = 0.00;
        this.name = name;
        type = "Normal";
    }
    public Account(String name, double balance){
        this.balance = balance;
        this.name = name;
        type = "Normal";
    }
    public Account(String name, double balance, String type){
        this.balance = balance;
        this.name = name;
        this.type = type;
    }
    public double getSavingsGoal(){
        return this.savingsGoal;
    }
    public void setSavingsGoal(double newSavingsGoal){
        this.savingsGoal = newSavingsGoal;
    }

    /*
    * Getters and Setters
    */

    public double getBalance(){
        return this.balance;
    }
    public void setBalance(double newBalance){
        this.balance = newBalance;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String newName){
        this.name = newName;
    }
    public String getType(){
        return this.type;
    }
    
    public void setType(String type){
    	this.type = type;
    }
    /*
    * Regular Methods
    */

    public double withdraw(double amountToWithdraw){
        if (this.balance > amountToWithdraw){
            this.balance =- amountToWithdraw;
            return amountToWithdraw;
        } else {
            return 0.00;
        }
    }

    public double deposit(double amountToDeposit){
        this.balance += amountToDeposit;
        return 0.00;
    }


}
