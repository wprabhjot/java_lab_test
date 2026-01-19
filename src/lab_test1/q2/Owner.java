package lab_test1.q2;

public class Owner {
	private String name;
	private Date dateOfBirth;
	private String nic;
	
	public Owner(String name, Date dateOfBirth, String nic) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.nic = nic;
	}
	
	public Owner(Owner owner) {
		this.name = owner.name;
		this.dateOfBirth = owner.dateOfBirth;
		this.nic = owner.nic;
	}

	@Override
	public String toString() {
		return "[name= " + name + ", dateOfBirth= " + dateOfBirth + ", nic= " + nic + " ]";
	}
	
}
