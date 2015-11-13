package models;

public class Person extends User {
	
	private int id;
	private String firstName;
	private String lastName;
	private String middleInitial;
	private String address;
	private int phoneNumber;
	private int emergencyContact;
	
	public Person(){ super(); } //inherits User fields
	
	public Person(int id, String firstName, String lastName, String middleInitial, String address, int phoneNumber,
			int emergencyContact) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleInitial = middleInitial;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emergencyContact = emergencyContact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(int emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	
	
}
