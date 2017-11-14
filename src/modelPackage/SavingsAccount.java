package modelPackage;
public class SavingsAccount extends Account {

    boolean savingsGoalMet;
    double savingsGoal;

    public SavingsAccount(String name, double balance){
        super(name, balance, "Savings");
    }

    public SavingsAccount(String name, double balance, double savingsGoal){
        super(name, balance, "Savings");
        this.savingsGoal = savingsGoal;

        if (balance >= savingsGoal) {
            this.savingsGoalMet = true;
        } else {
            this.savingsGoalMet = false;
        }

    }

    public double getSavingsGoal(){
        return this.savingsGoal;
    }
}
