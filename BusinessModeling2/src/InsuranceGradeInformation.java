
enum grade {SUPER, STANDARD, REFUSAL};

public class InsuranceGradeInformation {

	private grade i;

	public InsuranceGradeInformation(){

	}

	public void finalize() throws Throwable {

	}

	public grade getI() {
		return i;
	}

	public void setI(grade i) {
		this.i = i;
	}

//	/**
//	 * 
//	 * @param 보험등급
//	 */
//	public void setRating(int 보험등급){
//			InsuranceGradeInformation igi = new InsuranceGradeInformation();
//			System.out.println("과거 10년 내 암 병력이 있습니까");
//			
//			System.out.println("1. 네");
//			System.out.println("2. 아니오");
//			
//			Scanner scanner = new Scanner(System.in);
//			int typeNumber = scanner.nextInt();
//			if (typeNumber == 1) {
//				System.out.println("1. 최근 5년 내 암을 앓았다.");
//				System.out.println("2. 최근 10년 내 암을 앓았다.");
//				
//				int number = scanner.nextInt();
//				if (number == 1) {
//					System.out.println("거절체 판별");
//					igi.getRating(Refusal);
//				} else if (number == 2) {
//					System.out.println("표준체 판별");
//				} else {
//					System.out.println("올바르지 않은 입력입니다.");
//				}
//			} else if (typeNumber == 2) {
//				System.out.println("우량체 판별");
//			}
//			
//			return cancerHistory;
//		}
//
//	}
//
//	/**
//	 * 
//	 * @param 보험등급
//	 */
//	public void getRating(int 보험등급){
//
//	}

}