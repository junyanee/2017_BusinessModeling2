import java.util.ArrayList;
import java.util.Scanner;

enum jobTitle {
	SALESMAN, JOBLESS, DAILYWORKER, FIELDWORKER, OWNER, PRESCHOOL, STUDENT, ETC
};

enum ageSegment {
	FIRST, SECOND, THIRD
};

public class UserInformation {

	protected boolean gender;
	protected String name;
	protected String residentRegistrationNumber;
	protected String phoneNumber;
	protected String email;
	protected String address;
	protected jobTitle job;
	protected ageSegment age;

	public ArrayList<WholeLifeInsurance> joinWInsuranceList = new ArrayList<WholeLifeInsurance>();
	public ArrayList<AnnuityInsurance> joinAInsuranceList = new ArrayList<AnnuityInsurance>();
	public ArrayList<CancerInsurance> joinCInsuranceList = new ArrayList<CancerInsurance>();
	public ArrayList<ActualExpense> joinEInsuranceList = new ArrayList<ActualExpense>();

	public UserInformation ui;

	public UserInformation(boolean gender, ageSegment age, jobTitle job) {
		this.setGender(gender);
		this.setAge(age);
		this.setJob(job);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResidentRegistrationNumber() {
		return residentRegistrationNumber;
	}

	public void setResidentRegistrationNumber(String residentRegistrationNumber) {
		this.residentRegistrationNumber = residentRegistrationNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void finalize() throws Throwable {

	}

	public ageSegment getAge() {
		return age;
	}

	public void setAge(ageSegment age) {
		this.age = age;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public jobTitle getJob() {
		return job;
	}

	public void setJob(jobTitle job) {
		this.job = job;
	}
}