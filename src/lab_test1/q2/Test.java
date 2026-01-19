package lab_test1.q2;

public class Test {

    public static void main(String[] args) {

        Date dob = new Date(15, 8, 1998);
        Owner owner = new Owner("John Doe", dob, "981234567V");

        SavingsAccount sa = new SavingsAccount(
            owner, 
            10000f, 
            "SA001", 
            5.0f
        );

        System.out.println(sa);
        sa.deposit(2000);
        sa.withdraw(3000);
        System.out.println("Balance with interest: " + sa.getBalanceWithInterest());
        System.out.println();

        CurrentAccount ca = new CurrentAccount(
            owner, 
            15000f, 
            "CA001", 
            5000f
        );

        System.out.println(ca);
        ca.withdraw(12000);
        ca.withdraw(8000);
        ca.deposit(3000);
        System.out.println(ca);
    }
}

