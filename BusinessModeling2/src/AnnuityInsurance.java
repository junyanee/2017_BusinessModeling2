import java.util.Scanner;

public class AnnuityInsurance extends Insurance {
	private Insurance annuity;

	private static int amountFee;
	private static int expiredMaintainFee;
	private static int expirationFee;
	private static int surrenderValue;

	public int getAmountFee() {
		return amountFee;
	}

	public static void setAmountFee(int amountFee) {
		AnnuityInsurance.amountFee = amountFee;
	}
	
	public int getExpiredMaintainFee() {
		return expiredMaintainFee;
	}

	public static void setExpiredMaintainFee(int expiredMaintainFee) {
		AnnuityInsurance.expiredMaintainFee = expiredMaintainFee;
	}

	public int getExpirationFee() {
		return expirationFee;
	}

	public static void setExpirationFee(int expirationFee) {
		AnnuityInsurance.expirationFee = expirationFee;
	}

	public int getSurrenderValue() {
		return surrenderValue;
	}

	public static void setSurrenderValue(int surrenderValue) {
		AnnuityInsurance.surrenderValue = surrenderValue;
	}
	
	public Insurance getAnnuity() {
		return annuity;
	}

	public void setAnnuity(Insurance annuity) {
		this.annuity = annuity;
	}


	public AnnuityInsurance() {

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
		this.setBasicInsurance(50000);
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