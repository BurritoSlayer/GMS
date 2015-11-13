package models;

public class Member extends Person {
	
	private int id;
	private int qrCode; //qr code might have to be changed to a non integer data type
	private int personID;
	private int planID;
	private int weeklyAttended; //how many classes this user attended so far this week
	private boolean loggedIn;
	private int submitter; //employee id that submitted member
	
	public Member(){ super(); } //inherits both user and person
	
	public Member(int id, int qrCode, int personID, boolean loggedIn, int planID, int weeklyAttended) {
		super();
		this.id = id;
		this.qrCode = qrCode;
		this.personID = personID;
		this.loggedIn = loggedIn;
		this.planID = planID;
		this.weeklyAttended = weeklyAttended;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQrCode() {
		return qrCode;
	}

	public void setQrCode(int qrCode) {
		this.qrCode = qrCode;
	}

	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public int getPlanID() {
		return planID;
	}

	public void setPlanID(int planID) {
		this.planID = planID;
	}

	public int getWeeklyAttended() {
		return weeklyAttended;
	}

	public void setWeeklyAttended(int weeklyAttended) {
		this.weeklyAttended = weeklyAttended;
	}
	public int getSubmitter() {
		return submitter;
	}

	public void setSubmitter(int submitter) {
		this.submitter = submitter;
	}
	
}
