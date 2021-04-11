import java.util.Scanner;

public class ActualExpense extends Insurance {
	
	private Insurance actual;

	public Insurance getActual() {
		return actual;
	}

	public void setActual(Insurance actual) {
		this.actual = actual;
	}



	public int hospitalizationFee,outpatientFee,outpatientMedicineFee;

	public int getHospitalizationFee() {
		return hospitalizationFee;
	}

	public void setHospitalizationFee(int hospitalizationFee) {
		this.hospitalizationFee = hospitalizationFee;
	}

	public int getOutpatientFee() {
		return outpatientFee;
	}

	public void setOutpatientFee(int outpatientFee) {
		this.outpatientFee = outpatientFee;
	}

	public int getOutpatientMedicineFee() {
		return outpatientMedicineFee;
	}

	public void setOutpatientMedicineFee(int outpatientMedicineFee) {
		this.outpatientMedicineFee = outpatientMedicineFee;
	}



	public float selfBurdenFee;
	
	public ActualExpense(){

	}

	public boolean setABasicInsurance() {
		System.out.println("나이를 입력해주세요.");
		Scanner scanner = new Scanner(System.in);
		int age = scanner.nextInt();
		if (age < 5 || age > 69) {
			System.out.println("가입할 수 없는 나이입니다.");
			System.out.println("초기메뉴로 돌아갑니다.");
			return false;
		}
		this.setBasicInsurance(40000);
		return true;
	}

	public float getSelfBurdenFee() {
		return selfBurdenFee;
	}



	public void setSelfBurdenFee(float selfBurdenFee) {
		this.selfBurdenFee = selfBurdenFee;
		
	}

	   public double calculate(UserInformation userinfo){
		      int money = this.getBasicInsurance();
		      
		      switch (userinfo.getAge()) {
		         case FIRST: money *= 0.95;
		         case SECOND: money *= 1.1;
		         case THIRD: money *= 1.15;
		         }
		      
		      if(userinfo.isGender()) money *= 1.05;
		      else money *= 0.95;
		      
		      switch (userinfo.getJob()) {
		         case SALESMAN: money *= 0.95;
		         case JOBLESS: money *= 1.1;
		         case DAILYWORKER: money *= 1.1;
		         case FIELDWORKER: money *= 1.1;
		         case OWNER: money *= 1.0;
		         case PRESCHOOL: money *= 0.9;
		         case STUDENT: money *= 0.9;
		         case ETC: money *= 1.05;
		      }
			return money;
		   }
	
}