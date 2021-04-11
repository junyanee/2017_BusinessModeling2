import java.util.Scanner;

public class CancerInsurance extends Insurance {
	
	private Insurance cancer;

	public Insurance getCancer() {
		return cancer;
	}

	public void setCancer(Insurance cancer) {
		this.cancer = cancer;
	}

	private boolean cancerHistory;
	public int cancerDiagnosisFee, drugTreatmentFee, radiationTherapyFee, operationFee, hospitalizationFee;
	public int getCancerDiagnosisFee() {
		return cancerDiagnosisFee;
	}

	public boolean isCancerHistory() {
		return cancerHistory;
	}

	public void setCancerHistory(boolean cancerHistory) {
		this.cancerHistory = cancerHistory;
	}
	
	public void setCancerDiagnosisFee(int cancerDiagnosisFee) {
		this.cancerDiagnosisFee = cancerDiagnosisFee;
	}

	public int getDrugTreatmentFee() {
		return drugTreatmentFee;
	}

	public void setDrugTreatmentFee(int drugTreatmentFee) {
		this.drugTreatmentFee = drugTreatmentFee;
	}

	public int getRadiationTherapyFee() {
		return radiationTherapyFee;
	}

	public void setRadiationTherapyFee(int radiationTherapyFee) {
		this.radiationTherapyFee = radiationTherapyFee;
	}

	public int getOperationFee() {
		return operationFee;
	}

	public void setOperationFee(int operationFee) {
		this.operationFee = operationFee;
	}

	public int getHospitalizationFee() {
		return hospitalizationFee;
	}

	public void setHospitalizationFee(int hospitalizationFee) {
		this.hospitalizationFee = hospitalizationFee;
	}

	public InsuranceGradeInformation getInsuranceGradeInformation() {
		return InsuranceGradeInformation;
	}

	public void setInsuranceGradeInformation(InsuranceGradeInformation insuranceGradeInformation) {
		InsuranceGradeInformation = insuranceGradeInformation;
	}

	public InsuranceGradeInformation InsuranceGradeInformation;
	InsuranceGradeInformation igi;

	public CancerInsurance(){

	}

	public boolean setCBasicInsurance() {
		System.out.println("나이를 입력해주세요.");
		Scanner scanner = new Scanner(System.in);
		int age = scanner.nextInt();
		if (age < 5 || age > 69) {
			System.out.println("가입할 수 없는 나이입니다.");
			System.out.println("초기메뉴로 돌아갑니다.");
			return false;
		}
		this.setBasicInsurance(35000);
		return true;
	}
	
	public double calculate(UserInformation userinfo){
	      int money = this.getBasicInsurance();
	      
	      switch (userinfo.getAge()) {
	         case FIRST: money *= 0.95;
	         break;
	         case SECOND: money *= 1.1;
	         break;
	         case THIRD: money *= 1.15;
	         break;
	         }
	      
	      if(userinfo.isGender()) money *= 1.05;
	      else money *= 0.95;
	      
	      switch (userinfo.getJob()) {
	         case SALESMAN: money *= 0.95;
	         break;
	         case JOBLESS: money *= 1.1;
	         break;
	         case DAILYWORKER: money *= 1.1;
	         break;
	         case FIELDWORKER: money *= 1.1;
	         break;
	         case OWNER: money *= 1.0;
	         break;
	         case PRESCHOOL: money *= 0.9;
	         break;
	         case STUDENT: money *= 0.9;
	         break;
	         case ETC: money *= 1.05;
	         break;
	      }
	      
		return money;
	      
	      }


}