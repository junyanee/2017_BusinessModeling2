import java.util.Scanner;

public class WholeLifeInsurance extends Insurance {
	public WholeLifeInsurance() {

	}

	public Insurance wholelife;

	private SpecialContract specialContract;
	private int disasterDeath, disasterInjury, disasterFracture, hospitalization, operation;
	private int CDisasterDeath, CDisasterInjury, CDisasterFracture, CHospitalization, COperation;

	public Insurance getWholelife() {
		return wholelife;
	}

	public void setWholelife(Insurance wholelife) {
		this.wholelife = wholelife;
	}

	public SpecialContract getSpecialContract() {
		return specialContract;
	}

	public void setSpecialContract(SpecialContract specialContract) {
		this.specialContract = specialContract;
	}

	public int getCDisasterDeath() {
		return CDisasterDeath;
	}

	public void setCDisasterDeath(int cDisasterDeath) {
		CDisasterDeath = cDisasterDeath;
	}

	public int getCDisasterInjury() {
		return CDisasterInjury;
	}

	public void setCDisasterInjury(int cDisasterInjury) {
		CDisasterInjury = cDisasterInjury;
	}

	public int getCDisasterFracture() {
		return CDisasterFracture;
	}

	public void setCDisasterFracture(int cDisasterFracture) {
		CDisasterFracture = cDisasterFracture;
	}

	public int getCHospitalization() {
		return CHospitalization;
	}

	public void setCHospitalization(int cHospitalization) {
		CHospitalization = cHospitalization;
	}

	public int getCOperation() {
		return COperation;
	}

	public void setCOperation(int cOperation) {
		COperation = cOperation;
	}

	public int getDisasterDeath() {
		return disasterDeath;
	}

	public void setDisasterDeath(int disasterDeath) {
		this.disasterDeath = disasterDeath;
	}

	public int getDisasterInjury() {
		return disasterInjury;
	}

	public void setDisasterInjury(int disasterInjury) {
		this.disasterInjury = disasterInjury;
	}

	public int getDisasterFracture() {
		return disasterFracture;
	}

	public void setDisasterFracture(int disasterFracture) {
		this.disasterFracture = disasterFracture;
	}

	public int getHospitalization() {
		return hospitalization;
	}

	public void setHospitalization(int hospitalization) {
		this.hospitalization = hospitalization;
	}

	public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

	public void specialContractfee() {

	}

	public boolean setWBasicInsurance() {
		System.out.println("나이를 입력해주세요. ");
		Scanner scanner = new Scanner(System.in);
		int age = scanner.nextInt();
		if (age < 5 || age > 69) {
			System.out.println("가입할 수 없는 나이입니다.");
			System.out.println("초기메뉴로 돌아갑니다.");
			return false;
		}
		if (age >= 5 && age <= 69) {
			this.setBasicInsurance(100000);
			System.out.println("기본보험료는 " + getBasicInsurance() + "원 으로 설정됩니다.");
		}
		return true;

	}

	public double calculate(UserInformation userinfo) {
		int money = this.getBasicInsurance();

		switch (userinfo.getAge()) {
		case FIRST:
			money *= 0.95;
			break;
		case SECOND:
			money *= 1.1;
			break;
		case THIRD:
			money *= 1.15;
			break;
		}

		if (userinfo.isGender())
			money *= 1.05;
		else
			money *= 0.95;

		switch (userinfo.getJob()) {
		case SALESMAN:
			money *= 0.95;
			break;
		case JOBLESS:
			money *= 1.1;
			break;
		case DAILYWORKER:
			money *= 1.1;
			break;
		case FIELDWORKER:
			money *= 1.1;
			break;
		case OWNER:
			money *= 1.0;
			break;
		case PRESCHOOL:
			money *= 0.9;
			break;
		case STUDENT:
			money *= 0.9;
			break;
		case ETC:
			money *= 1.05;
			break;
		}
		return money;

	}

}