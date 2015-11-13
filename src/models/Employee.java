package models;

public class Employee extends Person {
	
	private int id;
	private int personID;
	private double salary; //salary is currently stored as an int in the database
	private int title; //a foreign key in the database, pointing to title table;
	
	public Employee() { super(); } //inherits both user and person

	public Employee(int id, int personID, double salary, int title) {
		super();
		this.id = id;
		this.personID = personID;
		this.salary = salary;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getTitle() {
		return title;
	}

	public void setTitle(int title) {
		this.title = title;
	};
	
	
}
