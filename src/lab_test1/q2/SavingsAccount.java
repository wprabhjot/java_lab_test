package lab_test1.q2;

public class SavingsAccount extends Account{

	private float interestRate;
	
	public SavingsAccount() {
		super();
	}

	public SavingsAccount(Account account) {
		super(account);
	}

	public SavingsAccount(Owner owner, float balance, String accountNumber, float interestRate) {
		super(owner, balance, accountNumber);
		this.interestRate = interestRate;
	}

	@Override
	public String toString() {
		return "SavingsAccount [Owner= "+ getOwner() + ", Account Number" + getAccountNumber() + ", Balance: "+ getBalance()+ ", Interest Rate: "+ getInterestRate()+ " ]";
	}

	@Override
	public void deposit(float amount) {
		this.setBalance(this.getBalance() + amount);
	}
	
	public float getBalanceWithInterest() {
		return this.getBalance() + (this.getBalance()*this.interestRate/100);
	}

	@Override
	public void withdraw(float amount) {
		if(amount>this.getBalance()) {
			System.out.println("Insufficient Balance in Account");
		} else {
			this.setBalance(this.getBalance() - amount);
			System.out.println("Amount withdrawn successfully");
		}
	}

	public float getInterestRate() {
		return interestRate;
	}		

}
