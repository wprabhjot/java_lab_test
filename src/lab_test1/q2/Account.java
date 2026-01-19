package lab_test1.q2;

public abstract class Account {
	private Owner owner;
	private float balance;
	private String accountNumber;
	
	public Account() {
		
	}
	
	Account(Owner owner, float balance, String accountNumber) {
		this.owner = owner;
		this.balance = balance;
		this.accountNumber = accountNumber;
	}

	Account(Account account){
		this.owner = account.owner;
		this.balance = account.balance;
		this.accountNumber = account.accountNumber;
	}

	@Override
	public String toString() {
		return "Account [owner=" + owner + ", balance=" + balance + ", accountNumber=" + accountNumber + "]";
	}

	public abstract void deposit(float amount);
	public abstract void withdraw(float amount);

	public Owner getOwner() {
		return owner;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	
	public float getBalance() {
		return this.balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
	
}
