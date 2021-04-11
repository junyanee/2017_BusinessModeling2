import java.util.Scanner;

enum insuranceType {
	WHOLELIFE, ANNUITY, CANCER, ACTUALEXPENSE
}

public class Insurance {

	private insuranceType type;
	private String insuranceName;
	private int paymentFrequency;
	private int paymentTerm;
	private int ID;

	private int Basicinsurance;
	private Compensation m_Compensation;

	public Insurance() {

	}

	public void finalize() throws Throwable {

	}

	public double calculate(UserInformation userinfo) {
		return 0;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public void setPaymentTerm(int paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public int getPaymentTerm() {
		return this.paymentTerm = paymentTerm;
	}

	public void setPaymentFrequency(int paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
	}

	public int getPaymentFrequency() {
		return this.paymentFrequency = paymentFrequency;
	}

	public void setBasicInsurance(int basicInsurance) {
		Basicinsurance = basicInsurance;
	}

	public int getBasicInsurance() {
		return Basicinsurance;
	}

	public boolean setLimitAge() {
		System.out.println(" 나이를 입력해주세요.");
		Scanner scanner = new Scanner(System.in);
		int age = scanner.nextInt();
		if (age < 5 || age > 69) {
			System.out.println("가입할 수 없는 나이입니다.");
			System.out.println(" 초기메뉴로 돌아갑니다.");
			return false;
		} else {
			return true;
		}
	}

	public Compensation getM_Compensation() {
		return m_Compensation;
	}

	public void setM_Compensation(Compensation m_Compensation) {
		this.m_Compensation = m_Compensation;
	}

	public void getLimitAge() {

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public insuranceType getType() {
		return type;
	}

	public void setType(insuranceType type) {
		this.type = type;
	}


	//wholelife
	   private int disasterDeath;
	   private int disasterInjury;
	   private int disasterFracture;
	   private int hospitalization;
	   private int operation;
	   private int CDisasterDeath;
	   private int CDisasterInjury;
	   private int CDisasterFracture;
	   private int CHospitalization;
	   private int COperation;
	   
	   public int getDisasterDeath() {return disasterDeath;}
	   public void setDisasterDeath(int disasterDeath) {this.disasterDeath = disasterDeath;}
	   public int getDisasterInjury() {return disasterInjury;}
	   public void setDisasterInjury(int disasterInjury) {this.disasterInjury = disasterInjury;}
	   public int getDisasterFracture() {return disasterFracture;}
	   public void setDisasterFracture(int disasterFracture) {this.disasterFracture = disasterFracture;}
	   public int getHospitalization() {return hospitalization;}
	   public void setHospitalization(int hospitalization) {this.hospitalization = hospitalization;}
	   public int getOperation() {return operation;}
	   public void setOperation(int operation) {this.operation = operation;}   
	   public int getCDisasterDeath() {return CDisasterDeath;}
	   public void setCDisasterDeath(int cDisasterDeath) {CDisasterDeath = cDisasterDeath;}
	   public int getCDisasterInjury() {return CDisasterInjury;}
	   public void setCDisasterInjury(int cDisasterInjury) {CDisasterInjury = cDisasterInjury;}
	   public int getCDisasterFracture() {return CDisasterFracture;}
	   public void setCDisasterFracture(int cDisasterFracture) {CDisasterFracture = cDisasterFracture;}
	   public int getCHospitalization() {return CHospitalization;}
	   public void setCHospitalization(int cHospitalization) {CHospitalization = cHospitalization;}
	   public int getCOperation() {return COperation;}
	   public void setCOperation(int cOperation) {COperation = cOperation;}

	   //annuity
	   
	   
	   
}