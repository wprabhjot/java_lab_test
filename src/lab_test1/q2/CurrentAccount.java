package lab_test1.q2;

public class CurrentAccount extends Account {
	private float minimumBalance;

	
	public CurrentAccount() {
		super();
	}

	public CurrentAccount(Account account) {
		super(account);
	}
	
	public CurrentAccount(Owner owner, float balance, String accountNumber, float minimumBalance) {
		super(owner, balance, accountNumber);
		this.minimumBalance = minimumBalance;
	}

	@Override
	public String toString() {
		return "CurrentAccount [Owner= "+ getOwner() + ", Account Number" + getAccountNumber() + ", Balance: "+ getBalance()+ ", Minimum Balance: "+ getMinimumBalance()+ " ]";

	}

	@Override
	public void deposit(float amount) {
		this.setBalance(this.getBalance() + amount);
	}

	@Override
	public void withdraw(float amount) {
		// TODO Auto-generated method stub
		if(this.getBalance() - amount < this.getMinimumBalance()) {
			System.out.println("Unable to withdraw. Minimum account balanc should be; "+ this.getMinimumBalance());
		} else {
			
			System.out.println("Amount withdrawn successfully");
			this.setBalance(this.getBalance() - amount);
		}
	}

	public float getMinimumBalance() {
		return minimumBalance;
	}
	
}
