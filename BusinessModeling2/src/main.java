import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
	
	public static InsuranceDBAccessor insurancedbAccessor = new InsuranceDBAccessor();

	public static ArrayList<WholeLifeInsurance> designedWInsuranceList = new ArrayList<WholeLifeInsurance>();
	public static ArrayList<AnnuityInsurance> designedAInsuranceList = new ArrayList<AnnuityInsurance>();
	public static ArrayList<CancerInsurance> designedCInsuranceList = new ArrayList<CancerInsurance>();
	public static ArrayList<ActualExpense> designedEInsuranceList = new ArrayList<ActualExpense>();

	public static ArrayList<WholeLifeInsurance> acceptedWInsuranceList = new ArrayList<WholeLifeInsurance>();
	public static ArrayList<AnnuityInsurance> acceptedAInsuranceList = new ArrayList<AnnuityInsurance>();
	public static ArrayList<CancerInsurance> acceptedCInsuranceList = new ArrayList<CancerInsurance>();
	public static ArrayList<ActualExpense> acceptedEInsuranceList = new ArrayList<ActualExpense>();

	public static ArrayList<UserInformation> nominatedWUserList = new ArrayList<UserInformation>();
	public static ArrayList<UserInformation> nominatedAUserList = new ArrayList<UserInformation>();
	public static ArrayList<UserInformation> nominatedCUserList = new ArrayList<UserInformation>();
	public static ArrayList<UserInformation> nominatedEUserList = new ArrayList<UserInformation>();

	public static ArrayList<UserInformation> acceptedWUserList = new ArrayList<UserInformation>();
	public static ArrayList<UserInformation> acceptedAUserList = new ArrayList<UserInformation>();
	public static ArrayList<UserInformation> acceptedCUserList = new ArrayList<UserInformation>();
	public static ArrayList<UserInformation> acceptedEUserList = new ArrayList<UserInformation>();

	public static void main(String[] args) {
		
		try {
			insurancedbAccessor.connect();
			System.out.println("DB Connection Success!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			
			//delete

			//insert
//			insurancedbAccessor.executeQuery("insert into userinformation values (0, 1, 'park', '9608091111111', '01012345678',"
//					+ "'grssa@naver.com', 'Seoul', 'STUDENT', 'SECOND');");
			
			//update
	
			//select
//			ResultSet result = insurancedbAccessor.executeQuery("select * from userinformation;");
//			while (result.next()) {
//		            System.out.println(result.getBoolean("gender") + "\t" + result.getString("name") +
//		                               "\t" + result.getString("phoneNumber") + "\t" + result.getString("residentRegistrationNumber") 
//		            );
//		     }
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		AnnuityInsurance annuityInsurance = new AnnuityInsurance();
		CancerInsurance cancerInsurance = new CancerInsurance();
		ActualExpense actualInsurance = new ActualExpense();

		Compensation WCompensation = new Compensation();
		Compensation ACompensation = new Compensation();
		Compensation CCompensation = new Compensation();
		Compensation ECompensation = new Compensation();

		Scanner scanner = new Scanner(System.in);
		int typeNumber;

		while (true) {
			System.out.println("\n" + "*********보험사 메뉴*********");
			System.out.println("1. 보험설계하기");
			System.out.println("2. 보험확정하기");
			System.out.println("3. 보험가입하기");
			System.out.println("4. UW하기");
			System.out.println("5. 계약체결하기");
			System.out.println("6. 보상처리하기");
			System.out.println("번호를 선택하시오: ");

			int number = scanner.nextInt();

			switch (number) {
			case 1:
				// 보험 설계하기
				System.out.println("\n" + "*********보험 종류 선택*********: ");
				System.out.println("1. 종신보험 ");
				System.out.println("2. 연금보험 ");
				System.out.println("3. 암보험 ");
				System.out.println("4. 실비보험 ");
				System.out.println("보험 종류를 선택하시오. ");

				typeNumber = scanner.nextInt();

				// 종신보험
	            if (typeNumber == 1) {
	               // 종신보험 생성
	               System.out.println("보험 생성절차를 시작합니다.");
	               Insurance wholelifeinsurance = new WholeLifeInsurance();
	               
	               // < 기본정보 입력 >
	               
	               wholelifeinsurance.setType(insuranceType.WHOLELIFE);
	               // ID입력
	               wholelifeinsurance.setID(10);
	               // 상품명 설정
	               System.out.println("생성할 보험명을 설정하세요.");
	               String InsuranceName = scanner.next();
	               // 제한나이 & 기본보험료 설정
	               wholelifeinsurance.setInsuranceName(InsuranceName);
	               if (((WholeLifeInsurance)wholelifeinsurance).setWBasicInsurance() == false) {
	                  break;
	               }
	               // 납입주기 설정
	               wholelifeinsurance.setPaymentFrequency(3);
	               // 납입기간 설정
	               wholelifeinsurance.setPaymentTerm(1);


	               // 설계내용 띄우기
	               System.out.println(" *****모든 설정이 완료되었습니다.***** ");
	               System.out.println("보험명 : " + wholelifeinsurance.getInsuranceName());
	               System.out.println("기본보험료 : " + wholelifeinsurance.getBasicInsurance());
	               System.out.println("납입주기 : " + wholelifeinsurance.getPaymentFrequency() + "개월");
	               System.out.println("납입기간 : " + wholelifeinsurance.getPaymentTerm() + "년");

	               // 보상 금액 셋팅
	               WCompensation.setMoney(100000000);
	               WCompensation.setPaymentFrequency(wholelifeinsurance.getPaymentFrequency());
	               WCompensation.setPaymentTerm(wholelifeinsurance.getPaymentTerm());
	               wholelifeinsurance.setM_Compensation(WCompensation);
	               
	               wholelifeinsurance.setBasicInsurance(wholelifeinsurance.getBasicInsurance());
	               
	               // 특약 금액 셋팅
	               wholelifeinsurance.setDisasterDeath(5000);
	               wholelifeinsurance.setDisasterInjury(500);
	               wholelifeinsurance.setDisasterFracture(500);
	               wholelifeinsurance.setHospitalization(600);
	               wholelifeinsurance.setOperation(800);

	               // 특약 보상 금액 셋팅
	               wholelifeinsurance.setCDisasterDeath(5000000);
	               wholelifeinsurance.setCDisasterFracture(1000000);
	               wholelifeinsurance.setCDisasterInjury(1000000);
	               wholelifeinsurance.setCHospitalization(5000000);
	               wholelifeinsurance.setCOperation(5000000);

	               //designedWInsuranceList.add(wholeLifeInsurance);
	               
	               try {
	                  insurancedbAccessor.insert(wholelifeinsurance);
	               } catch (SQLException e) {
	                  // TODO Auto-generated catch block
	                  e.printStackTrace();
	               }
	               
	               break;
	            }
				// 연금 보험 생성
				else if (typeNumber == 2) {
					// 연금보험 생성
					System.out.println("보험 생성절차를 시작합니다.");
					Insurance annuity = new Insurance();

					annuityInsurance.setAnnuity(annuity);

					// < 기본정보 입력 >

					// ID입력
					annuity.setID(20);
					annuity.setType(insuranceType.ANNUITY);
					// 상품명 설정
					System.out.println("생성할 보험명을 설정하세요.");
					String InsuranceName = scanner.next();
					// 제한나이 & 기본보험료 설정
					annuity.setInsuranceName(InsuranceName);
					if (annuityInsurance.setABasicInsurance() == false) {
						break;
					}

					// 납입주기 설정
					annuity.setPaymentFrequency(3);
					// 납입기간 설정
					annuity.setPaymentTerm(1);


					// 설계내용 띄우기
					System.out.println("설계된 보험내용입니다.");
					System.out.println("보험명 : " + annuity.getInsuranceName());
					System.out.println("기본보험료 : " + annuityInsurance.getBasicInsurance());
					System.out.println("납입주기 : " + annuity.getPaymentFrequency() + "개월");
					System.out.println("납입기간 : " + annuity.getPaymentTerm() + "년");

					// 보상 금액 셋팅

					ACompensation.setPaymentFrequency(annuity.getPaymentFrequency());
					ACompensation.setPaymentTerm(annuity.getPaymentTerm());
					AnnuityInsurance.setAmountFee(annuityInsurance.getBasicInsurance() * 12
							/ annuity.getPaymentFrequency() * annuity.getPaymentTerm());
					AnnuityInsurance.setExpiredMaintainFee((int) (annuityInsurance.getAmountFee() * 0.1));
					AnnuityInsurance.setExpirationFee(annuityInsurance.getAmountFee() + annuityInsurance.getExpiredMaintainFee());
					AnnuityInsurance.setSurrenderValue((int) (annuityInsurance.getAmountFee() * 0.5));
					System.out.println("원금 : " + annuityInsurance.getAmountFee());
					System.out.println("만기금 : " + annuityInsurance.getExpirationFee());
					System.out.println("만기유지이자금: " + annuityInsurance.getExpiredMaintainFee());
					System.out.println("중도해지환급금: " + annuityInsurance.getSurrenderValue());

					// designedAInsuranceList.add(annuityInsurance);
//					try {
//						insurancedbAccessor.insertInsurance(annuityInsurance);
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}

					break;

				} else if (typeNumber == 3) {
					// 암보험 생성
					System.out.println("보험 생성절차를 시작합니다.");
					Insurance cancer = new CancerInsurance();

					cancerInsurance.setCancer(cancer);

					// < 기본정보 입력 >

					// ID입력
					cancer.setID(30);
					cancer.setType(insuranceType.CANCER);
					// 상품명 설정
					System.out.println("생성할 보험명을 설정하세요.");
					String InsuranceName = scanner.next();
					// 제한나이 & 기본보험료 설정
					cancer.setInsuranceName(InsuranceName);
					if (cancerInsurance.setCBasicInsurance() == false) {
						break;
					}
					// 납입주기 설정
					cancer.setPaymentFrequency(3);
					// 납입기간 설정
					cancer.setPaymentTerm(1);

					InsuranceGradeInformation igi = new InsuranceGradeInformation();
					System.out.println("과거 10년 내 암 병력이 있습니까");

					System.out.println("1. 네");
					System.out.println("2. 아니오");

					int typeNumber1 = scanner.nextInt();
					if (typeNumber1 == 1) {
		                  System.out.println("해당질문에 대답해주세요.");
		                  System.out.println("1. 최근 5년 내 암을 앓았다.");
		                  System.out.println("2. 최근 10년 내 암을 앓았다.");

		                  int number1 = scanner.nextInt();
		                  if (number1 == 1) {
		                     System.out.println("거절체 판별");
		                     igi.setI(grade.REFUSAL);
		                     break;
		                  } else if (number1 == 2) {
		                     System.out.println("표준체 판별");
		                     igi.setI(grade.STANDARD);
		                  } else {
		                     System.out.println("올바르지 않은 입력입니다.");
		                     break;
		                  }
		               } else if (typeNumber1 == 2) {
		                  System.out.println("우량체 판별");
		                  igi.setI(grade.SUPER);
		               } else{
		                  System.out.println("올바르지 않은 입력입니다.");
		                  break;
		               }


					// 설계내용 띄우기
					System.out.println("설계된 보험내용입니다.");
					System.out.println("보험명 : " + cancer.getInsuranceName());
					System.out.println("기본보험료 : " + cancerInsurance.getBasicInsurance());
					System.out.println("납입주기 : " + cancer.getPaymentFrequency() + "개월");
					System.out.println("납입기간 : " + cancer.getPaymentTerm() + "년");

					// 보상 금액 셋팅

					CCompensation.setPaymentFrequency(cancer.getPaymentFrequency() / 12);
					CCompensation.setPaymentTerm(cancer.getPaymentTerm());
					cancerInsurance.cancerDiagnosisFee = 30000000;
					cancerInsurance.drugTreatmentFee = 500000;
					cancerInsurance.radiationTherapyFee = 500000;
					cancerInsurance.operationFee = 10000000;
					cancerInsurance.hospitalizationFee = 5000000;

					// designedCInsuranceList.add(cancerInsurance);
//					try {
//						insurancedbAccessor.insertCInsurance(cancerInsurance);
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}

				} else if (typeNumber == 4) {
					// 실비보험 생성
					System.out.println("보험 생성절차를 시작합니다.");
					Insurance actual = new Insurance();

					actualInsurance.setActual(actual);

					// < 기본정보 입력 >

					// ID입력
					actual.setID(40);
					actual.setType(insuranceType.ACTUALEXPENSE);
					// 상품명 설정
					System.out.println("생성할 보험명을 설정하세요.");
					String InsuranceName = scanner.next();
					// 제한나이 & 기본보험료 설정
					actual.setInsuranceName(InsuranceName);
					if (actualInsurance.setABasicInsurance() == false) {
						break;
					}
					// 납입주기 설정
					actual.setPaymentFrequency(3);
					// 납입기간 설정
					actual.setPaymentTerm(1);
					// 자기부담금 설정
					System.out.println("자기부담금은 10%로 설정됩니다.");
					((ActualExpense) actualInsurance).setSelfBurdenFee((float) 0.1);

					// 설계내용 띄우기
					System.out.println(" *****모든 설정이 완료되었습니다.***** ");
					System.out.println("보험명 : " + actual.getInsuranceName());
					System.out.println("기본보험료 : " + actualInsurance.getBasicInsurance());
					System.out.println("납입주기 : " + actual.getPaymentFrequency() + "개월");
					System.out.println("납입기간 : " + actual.getPaymentTerm() + "년");

					// 보상 금액 셋팅

					ECompensation.setPaymentFrequency(actual.getPaymentFrequency());
					ECompensation.setPaymentTerm(actual.getPaymentTerm());

					// 가입 금액 셋팅
					actualInsurance.hospitalizationFee = 300000000;
					actualInsurance.outpatientFee = 1000000;
					actualInsurance.outpatientMedicineFee = 300000;

					
					// designedEInsuranceList.add(actualInsurance);
//					try {
//						insurancedbAccessor.insertEInsurance(actualInsurance);
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}

				}

				break;

			case 2:
				// 보험 확정하기
				System.out.println("확정할 보험 종류를 선택하세요");
				System.out.println("1. 종신보험");
				System.out.println("2. 연금보험");
				System.out.println("3. 암보험");
				System.out.println("4. 실비보험");

				int num = scanner.nextInt();

				if (num == 1) {
					// 설계완료된 상품 출력
					System.out.println("\n" + "********설계된 보험 상품*********");
					if (designedWInsuranceList.size() == 0)
						System.out.println("설계된 보험이 없습니다.");
					else if (designedWInsuranceList.size() > 0) {
						for (int i = 0; i < designedWInsuranceList.size(); i++) {
							System.out.println("[" + (i + 1) + "]번 보험의 이름 : "
									+ designedWInsuranceList.get(i).getWholelife().getInsuranceName());
							System.out.println("[" + (i + 1) + "]번 보험의 기본보험료 : "
									+ designedWInsuranceList.get(i).getBasicInsurance());
							System.out.println("[" + (i + 1) + "]번 보험의 납입 주기 : "
									+ designedWInsuranceList.get(i).getWholelife().getPaymentFrequency() + "개월");
							System.out.println("[" + (i + 1) + "]번 보험의 납입 기간 : "
									+ designedWInsuranceList.get(i).getWholelife().getPaymentTerm() + "년");
							UserInformation userInfo = new UserInformation(false, ageSegment.SECOND,
									jobTitle.DAILYWORKER);
							int money = (int) designedWInsuranceList.get(i).calculate(userInfo);
							System.out.println("월 보험료 = " + money + "\n");

							System.out.println("확정하시겠습니까? 1.확정, 2.거부");
							int acceptance = scanner.nextInt();
							if (acceptance == 1) {
								acceptedWInsuranceList.add(designedWInsuranceList.get(i));
								designedWInsuranceList.remove(i);

								System.out.println("보험 상품이 개설되었습니다.");
							} else if (acceptance == 2) {

								designedWInsuranceList.remove(i);
								System.out.println("보험 상품을 취소합니다.");
							}

						}
					}
					// 설계된 보험 상품 정보 가지고 오기

				} else if (num == 2) {
					System.out.println("\n" + "********설계된 보험 상품*********");
					if (designedAInsuranceList.size() == 0)
						System.out.println("설계된 보험이 없습니다.");
					else if (designedAInsuranceList.size() > 0) {
						for (int i = 0; i < designedAInsuranceList.size(); i++) {
							System.out.println("[" + (i + 1) + "]번 보험의 이름 : "
									+ designedAInsuranceList.get(i).getAnnuity().getInsuranceName());
							System.out.println("[" + (i + 1) + "]번 보험의 기본보험료 : "
									+ designedAInsuranceList.get(i).getBasicInsurance());
							System.out.println("[" + (i + 1) + "]번 보험의 납입 주기 : "
									+ designedAInsuranceList.get(i).getAnnuity().getPaymentFrequency() + "개월");
							System.out.println("[" + (i + 1) + "]번 보험의 납입 기간 :  "
									+ designedAInsuranceList.get(i).getAnnuity().getPaymentTerm() + "년");

							UserInformation userInfo = new UserInformation(false, ageSegment.SECOND,
									jobTitle.DAILYWORKER);

							System.out.println("월 보험료 = " + designedAInsuranceList.get(i).getBasicInsurance() + "\n");
							System.out.println("원금 : " + annuityInsurance.getAmountFee());
							System.out.println("만기금 : " + annuityInsurance.getExpirationFee());
							System.out.println("만기유지이자금: " + annuityInsurance.getExpiredMaintainFee());
							System.out.println("중도해지환급금: " + annuityInsurance.getSurrenderValue());

							System.out.println("확정하시겠습니까? 1.확정, 2.거부");
							int acceptance = scanner.nextInt();
							if (acceptance == 1) {
								acceptedAInsuranceList.add(designedAInsuranceList.get(i));
								designedAInsuranceList.remove(i);

								System.out.println("보험 상품이 개설되었습니다.");
							} else if (acceptance == 2) {

								designedAInsuranceList.remove(i);
								System.out.println("보험 상품을 취소합니다.");
							}
						}

					}
				} else if (num == 3) {
					System.out.println("\n" + "********설계된 보험 상품*********");
					if (designedCInsuranceList.size() == 0)
						System.out.println("설계된 보험이 없습니다.");
					else if (designedCInsuranceList.size() > 0) {
						for (int i = 0; i < designedCInsuranceList.size(); i++) {
							System.out.println("[" + (i + 1) + "]번 보험의 이름 : "
									+ designedCInsuranceList.get(i).getCancer().getInsuranceName());
							System.out.println("[" + (i + 1) + "]번 보험의 기본보험료 : "
									+ designedCInsuranceList.get(i).getBasicInsurance());
							System.out.println("[" + (i + 1) + "]번 보험의 납입 주기 : "
									+ designedCInsuranceList.get(i).getCancer().getPaymentFrequency() + "개월");
							System.out.println("[" + (i + 1) + "]번 보험의 납입 기간 : "
									+ designedCInsuranceList.get(i).getCancer().getPaymentTerm() + "년");

							UserInformation userInfo = new UserInformation(false, ageSegment.SECOND,
									jobTitle.DAILYWORKER);
							int money = (int) designedCInsuranceList.get(i).calculate(userInfo);
							System.out.println("월 보험료 = " + money + "\n");

							System.out.println("확정하시겠습니까? 1.확정, 2.거부");
							int acceptance = scanner.nextInt();
							if (acceptance == 1) {
								acceptedCInsuranceList.add(designedCInsuranceList.get(i));
								designedCInsuranceList.remove(i);

								System.out.println("보험 상품이 개설되었습니다.");
							} else if (acceptance == 2) {

								designedCInsuranceList.remove(i);
								System.out.println("보험 상품을 취소합니다.");
							}
						}
					}
				} else if (num == 4) {
					System.out.println("\n" + "********확정된 보험 상품*********");
					if (designedEInsuranceList.size() == 0)
						System.out.println("설계된 보험이 없습니다.");
					else if (designedEInsuranceList.size() > 0) {
						for (int i = 0; i < designedEInsuranceList.size(); i++) {
							System.out.println("[" + (i + 1) + "]번 보험의 이름 : "
									+ designedEInsuranceList.get(i).getActual().getInsuranceName());
							System.out.println("[" + (i + 1) + "]번 보험의 기본보험료 : "
									+ designedEInsuranceList.get(i).getBasicInsurance());
							System.out.println("[" + (i + 1) + "]번 보험의 납입 주기 : "
									+ designedEInsuranceList.get(i).getActual().getPaymentFrequency() + "개월");
							System.out.println("[" + (i + 1) + "]번 보험의 납입 기간 : "
									+ designedEInsuranceList.get(i).getActual().getPaymentTerm() + "년");

							UserInformation userInfo = new UserInformation(false, ageSegment.SECOND,
									jobTitle.DAILYWORKER);
							int money = (int) designedEInsuranceList.get(i).calculate(userInfo);
							System.out.println("월 보험료 = " + money + "\n");

							System.out.println("확정하시겠습니까? 1.확정, 2.거부");
							int acceptance = scanner.nextInt();
							if (acceptance == 1) {
								acceptedEInsuranceList.add(designedEInsuranceList.get(i));
								designedEInsuranceList.remove(i);

								System.out.println("보험 상품이 개설되었습니다.");
							} else if (acceptance == 2) {

								designedEInsuranceList.remove(i);
								System.out.println("보험 상품을 취소합니다.");
							}
						}
					}
				}

				break;
			case 3:
				// 보험가입하기

				UserInformation userInformation = new UserInformation(false, null, null);
				userInformation.setName("에이쁠조");
				userInformation.setAge(ageSegment.FIRST);
				userInformation.setGender(true);
				userInformation.setJob(jobTitle.STUDENT);
				userInformation.setResidentRegistrationNumber("971111-2111111");
				userInformation.setPhoneNumber("010-1234-5678");
				userInformation.setEmail("Aplus@naver.com");
				userInformation.setAddress("서울");

				// 영업할 보험 상품 선택하기
				System.out.println("가입할 보험을 선택하세요.");
				System.out.println("1. 종신보험");
				System.out.println("2. 연금보험");
				System.out.println("3. 암보험");
				System.out.println("4. 실비보험");

				int numb = scanner.nextInt();

				if (numb == 1) {

		               Insurance wholelifeinsurance = new WholeLifeInsurance();
		               
					// 개설완료된 상품 출력
					System.out.println("\n" + "********설계된 보험 상품*********");
					if (acceptedWInsuranceList.size() == 0)
						System.out.println("개설된 보험이 없습니다.");

					else if (acceptedWInsuranceList.size() > 0) {
						for (int i = 0; i < acceptedWInsuranceList.size(); i++) {
							System.out.println("[" + (i + 1) + "]번 보험의 이름 : "
									+ acceptedWInsuranceList.get(i).getWholelife().getInsuranceName());

							// 가입자 정보 가지고 오기
							System.out.println("가입자 이름: " + userInformation.getName());
							System.out.println("가입자 연령군: " + userInformation.getAge());
							System.out.println("가입자 직업군: " + userInformation.getJob());
							System.out.println("가입자 주민번호: " + userInformation.getResidentRegistrationNumber());
							System.out.println("가입자 전화번호: " + userInformation.getPhoneNumber());
							System.out.println("가입자 이메일: " + userInformation.getEmail());
							System.out.println("가입자 주소: " + userInformation.getAddress());

							// 보험 상품 정보 가지고 오기
							System.out
									.println("이름: " + acceptedWInsuranceList.get(i).getWholelife().getInsuranceName());
							System.out.println("기본보험료: " + acceptedWInsuranceList.get(i).getBasicInsurance());
							System.out.println("재해사망보험비(특약)= " + wholelifeinsurance.getDisasterDeath());
							System.out.println("재해골절보험비(특약)= " + wholelifeinsurance.getDisasterFracture());
							System.out.println("재해상해보험비(특약)= " + wholelifeinsurance.getDisasterInjury());
							System.out.println("입원보험비(특약)= " + wholelifeinsurance.getHospitalization());
							System.out.println("수술보험비(특약)= " + wholelifeinsurance.getOperation());
							System.out.println(
									"납입 주기(개월): " + acceptedWInsuranceList.get(i).getWholelife().getPaymentFrequency());
							System.out.println(
									"납입 기간(년): " + acceptedWInsuranceList.get(i).getWholelife().getPaymentTerm());

							UserInformation userInfo = new UserInformation(false, ageSegment.SECOND,
									jobTitle.DAILYWORKER);
							int money = (int) acceptedWInsuranceList.get(i).calculate(userInfo);
							System.out.println("월 보험료 = " + (money + wholelifeinsurance.getDisasterDeath()
									+ wholelifeinsurance.getDisasterFracture() + wholelifeinsurance.getDisasterInjury()
									+ wholelifeinsurance.getHospitalization() + wholelifeinsurance.getOperation()));
							System.out.println("가입금액= " + WCompensation.getMoney());
							System.out.println("재해사망(특약)= " + wholelifeinsurance.getCDisasterDeath());
							System.out.println("재해골절(특약)= " + wholelifeinsurance.getCDisasterFracture());
							System.out.println("재해상해(특약)= " + wholelifeinsurance.getCDisasterInjury());
							System.out.println("입원(특약)= " + wholelifeinsurance.getCHospitalization());
							System.out.println("수술(특약)= " + wholelifeinsurance.getCOperation());

							System.out.println("가입하시겠습니까? 1.가입, 2.취소");
							int acceptance = scanner.nextInt();
							if (acceptance == 1) {
								userInformation.joinWInsuranceList.add(acceptedWInsuranceList.get(i));
								nominatedWUserList.add(userInformation);
								System.out.println("******** 축하합니다. 보험 가입이 완료되었습니다.********* ");
							} else if (acceptance == 2) {

								System.out.println("보험 상품을 취소합니다.");
							}
						}
					}

				} else if (numb == 2) {
					System.out.println("\n" + "********설계된 보험 상품*********");
					if (acceptedAInsuranceList.size() == 0)
						System.out.println("개설된 보험이 없습니다.");

					else if (acceptedAInsuranceList.size() > 0) {
						for (int i = 0; i < acceptedAInsuranceList.size(); i++) {
							System.out.println("[" + (i + 1) + "]번 보험의 이름 : "
									+ acceptedAInsuranceList.get(i).getAnnuity().getInsuranceName());

							// 가입자 정보 가지고 오기
							System.out.println("가입자 이름: " + userInformation.getName());
							System.out.println("가입자 연령군: " + userInformation.getAge());
							System.out.println("가입자 직업군: " + userInformation.getJob());
							System.out.println("가입자 주민번호: " + userInformation.getResidentRegistrationNumber());
							System.out.println("가입자 전화번호: " + userInformation.getPhoneNumber());
							System.out.println("가입자 이메일: " + userInformation.getEmail());
							System.out.println("가입자 주소: " + userInformation.getAddress());

							// 보험 상품 정보 가지고 오기
							System.out.println("이름: " + acceptedAInsuranceList.get(i).getAnnuity().getInsuranceName());
							System.out.println("기본보험료: " + acceptedAInsuranceList.get(i).getBasicInsurance());
							System.out.println(
									"납입 주기(개월): " + acceptedAInsuranceList.get(i).getAnnuity().getPaymentFrequency());
							System.out.println(
									"납입 기간(년): " + acceptedAInsuranceList.get(i).getAnnuity().getPaymentTerm());

							System.out.println("만기금 = " + annuityInsurance.getExpirationFee());
							System.out.println("만기유지이자금 = " + annuityInsurance.getExpiredMaintainFee());
							System.out.println("중도해지환급금 = " + annuityInsurance.getSurrenderValue());

							UserInformation userInfo = new UserInformation(false, ageSegment.SECOND,
									jobTitle.DAILYWORKER);
							int money = (int) acceptedAInsuranceList.get(i).calculate(userInfo);
							System.out.println("월 보험료 = " + money + "\n");

							System.out.println("가입하시겠습니까? 1.가입, 2.취소");
							int acceptance = scanner.nextInt();
							if (acceptance == 1) {
								userInformation.joinAInsuranceList.add(acceptedAInsuranceList.get(i));
								nominatedAUserList.add(userInformation);
								System.out.println("******** 축하합니다. 보험 가입이 완료되었습니다.********* ");
							} else if (acceptance == 2) {

								System.out.println("보험 상품을 취소합니다.");
							}

						}
					}

				} else if (numb == 3) {
					System.out.println("\n" + "********설계된 보험 상품*********");
					if (acceptedCInsuranceList.size() == 0)
						System.out.println("개설된 보험이 없습니다.");

					else if (acceptedCInsuranceList.size() > 0) {
						for (int i = 0; i < acceptedCInsuranceList.size(); i++) {
							System.out.println("[" + (i + 1) + "]번 보험의 이름 : "
									+ acceptedCInsuranceList.get(i).getCancer().getInsuranceName());

							// 가입자 정보 가지고 오기
							System.out.println("가입자 이름: " + userInformation.getName());
							System.out.println("가입자 연령군: " + userInformation.getAge());
							System.out.println("가입자 직업군: " + userInformation.getJob());
							System.out.println("가입자 주민번호: " + userInformation.getResidentRegistrationNumber());
							System.out.println("가입자 전화번호: " + userInformation.getPhoneNumber());
							System.out.println("가입자 이메일: " + userInformation.getEmail());
							System.out.println("가입자 주소: " + userInformation.getAddress());

							// 보험 상품 정보 가지고 오기
							System.out.println("이름: " + acceptedCInsuranceList.get(i).getCancer().getInsuranceName());
							System.out.println("기본보험료: " + acceptedCInsuranceList.get(i).getBasicInsurance());
							System.out.println(
									"납입 주기(개월): " + acceptedCInsuranceList.get(i).getCancer().getPaymentFrequency());
							System.out
									.println("납입 기간(년): " + acceptedCInsuranceList.get(i).getCancer().getPaymentTerm());

							System.out.println("암 진단금 =" + cancerInsurance.cancerDiagnosisFee);
							System.out.println("약물 치료비 =" + cancerInsurance.drugTreatmentFee);
							System.out.println("방사선 치료비 =" + cancerInsurance.radiationTherapyFee);
							System.out.println("수술비 =" + cancerInsurance.operationFee);
							System.out.println("입원비 =" + cancerInsurance.hospitalizationFee);

							UserInformation userInfo = new UserInformation(false, ageSegment.SECOND,
									jobTitle.DAILYWORKER);
							int money = (int) acceptedCInsuranceList.get(i).calculate(userInfo);
							System.out.println("월 보험료 = " + money + "\n");

							System.out.println("가입하시겠습니까? 1.가입, 2.취소");
							int acceptance = scanner.nextInt();
							if (acceptance == 1) {
								userInformation.joinCInsuranceList.add(acceptedCInsuranceList.get(i));
								nominatedCUserList.add(userInformation);
								System.out.println("******** 축하합니다. 보험 가입이 완료되었습니다.********* ");
							} else if (acceptance == 2) {

								System.out.println("보험 상품을 취소합니다.");
							}
						}
					}
				} else if (numb == 4) {
					System.out.println("\n" + "********설계된 보험 상품*********");
					if (acceptedEInsuranceList.size() == 0)
						System.out.println("개설된 보험이 없습니다.");

					else if (acceptedEInsuranceList.size() > 0) {
						for (int i = 0; i < acceptedEInsuranceList.size(); i++) {
							System.out.println("[" + (i + 1) + "]번 보험의 이름 : "
									+ acceptedEInsuranceList.get(i).getActual().getInsuranceName());

							// 가입자 정보 가지고 오기
							System.out.println("가입자 이름: " + userInformation.getName());
							System.out.println("가입자 연령군: " + userInformation.getAge());
							System.out.println("가입자 직업군: " + userInformation.getJob());
							System.out.println("가입자 주민번호: " + userInformation.getResidentRegistrationNumber());
							System.out.println("가입자 전화번호: " + userInformation.getPhoneNumber());
							System.out.println("가입자 이메일: " + userInformation.getEmail());
							System.out.println("가입자 주소: " + userInformation.getAddress());

							// 보험 상품 정보 가지고 오기
							System.out.println("이름: " + acceptedEInsuranceList.get(i).getActual().getInsuranceName());
							System.out.println("기본보험료: " + acceptedEInsuranceList.get(i).getBasicInsurance());
							System.out.println("자기부담금= " + actualInsurance.selfBurdenFee);
							System.out.println(
									"납입 주기(개월): " + acceptedEInsuranceList.get(i).getActual().getPaymentFrequency());
							System.out
									.println("납입 기간(년): " + acceptedEInsuranceList.get(i).getActual().getPaymentTerm());

							System.out.println("입원비= " + actualInsurance.hospitalizationFee);
							System.out.println("통원외래비= " + actualInsurance.outpatientFee);
							System.out.println("통원약제비= " + actualInsurance.outpatientMedicineFee);

							UserInformation userInfo = new UserInformation(false, ageSegment.SECOND,
									jobTitle.DAILYWORKER);
							int money = (int) acceptedEInsuranceList.get(i).calculate(userInfo);
							System.out.println("월 보험료 = " + money + "\n");

							System.out.println("가입하시겠습니까? 1.가입, 2.취소");
							int acceptance = scanner.nextInt();
							if (acceptance == 1) {
								userInformation.joinEInsuranceList.add(acceptedEInsuranceList.get(i));
								nominatedEUserList.add(userInformation);
								System.out.println("******** 축하합니다. 보험 가입이 완료되었습니다.********* ");
							} else if (acceptance == 2) {

								System.out.println("보험 상품을 취소합니다.");
							}

						}
					}
				}

				break;

			case 4:

				// U/W할 상품 선택하기
				System.out.println("U/W할 보험을 선택하세요.");
				System.out.println("1. 종신보험");
				System.out.println("2. 연금보험");
				System.out.println("3. 암보험");
				System.out.println("4. 실비보험");

				int numbe = scanner.nextInt();

				if (numbe == 1) {
					System.out.println("\n" + "********가입된 보험 상품*********");
					if (nominatedWUserList.size() == 0)
						System.out.println("가입된 보험이 없습니다.");
					else if (nominatedWUserList.size() > 0) {
						for (int i = 0; i < nominatedWUserList.size(); i++) {
							System.out.println("[" + i + "] 이름: " + nominatedWUserList.get(i).getName());
						}
						System.out.println("가입자를 선택하시오: ");
						int userNum = scanner.nextInt();

						// 설계된 보험 상품 정보 가지고 오기
						System.out.println("가입자 이름 = " + nominatedWUserList.get(userNum).getName());
						System.out.println("가입자 연령군 = " + nominatedWUserList.get(userNum).getAge());
						System.out.println("가입자 직업군 = " + nominatedWUserList.get(userNum).getJob());
						System.out.println(
								"가입자 주민번호 = " + nominatedWUserList.get(userNum).getResidentRegistrationNumber());
						System.out.println("가입자 전화번호 = " + nominatedWUserList.get(userNum).getPhoneNumber());
						System.out.println("가입자 이메일 = " + nominatedWUserList.get(userNum).getEmail());
						System.out.println("가입자 주소 = " + nominatedWUserList.get(userNum).getAddress());

						// 가입된 보험 상품 선택하여 정보 가지고 오기
						for (int i = 0; i < nominatedWUserList.size(); i++) {
							System.out.println(
									"\n[" + i + "] 가입된 보험 이름: " + nominatedWUserList.get(userNum).joinWInsuranceList
											.get(i).getWholelife().getInsuranceName());
						}
						System.out.println("가입된 보험 상품을 선택하시오: ");
						int insuranceNum = scanner.nextInt();

						// 보험 상품 정보 가지고 오기
						System.out.println("보험명: " + nominatedWUserList.get(userNum).joinWInsuranceList
								.get(insuranceNum).getWholelife().getInsuranceName());
						System.out.println("기본보험료: " + nominatedWUserList.get(userNum).joinWInsuranceList
								.get(insuranceNum).getBasicInsurance());
						System.out.println("납입 주기(월): " + nominatedWUserList.get(userNum).joinWInsuranceList
								.get(insuranceNum).getWholelife().getPaymentFrequency());
						System.out.println("납입 기간(년): " + nominatedWUserList.get(userNum).joinWInsuranceList
								.get(insuranceNum).getWholelife().getPaymentTerm());

						System.out.println("타보험 가입 여부 확인: 1.있음 , 2.없음 ");
						int confirmNum = scanner.nextInt();

						if (confirmNum == 1) {
							System.out.println("보험을 가입할 수 없습니다.");
						} else if (confirmNum == 2) {
							System.out.println("가입승인 하시겠습니까? 1.승인, 2.거부");
							int acceptanceNum = scanner.nextInt();
							if (acceptanceNum == 1) {
								acceptedWUserList.add(nominatedWUserList.get(userNum));
								nominatedWUserList.remove(userNum);

								System.out.println("보험상품 가입이 승인되었습니다.");
							} else if (acceptanceNum == 2) {

								nominatedWUserList.remove(userNum);
								System.out.println("보험상품 가입이 취소되었습니다.");
							}
						}

					} else if (numbe == 2) {
						System.out.println("\n" + "********가입된 보험 상품*********");
						if (nominatedAUserList.size() == 0)
							System.out.println("가입된 보험이 없습니다.");
						else if (nominatedAUserList.size() > 0) {
							for (int i = 0; i < nominatedAUserList.size(); i++) {
								System.out.println("[" + i + "] 이름: " + nominatedAUserList.get(i).getName());
							}
							System.out.println("가입자를 선택하시오: ");
							int userNum = scanner.nextInt();

							// 설계된 보험 상품 정보 가지고 오기
							System.out.println("가입자 이름 = " + nominatedAUserList.get(userNum).getName());
							System.out.println("가입자 연령군 = " + nominatedAUserList.get(userNum).getAge());
							System.out.println("가입자 직업군 = " + nominatedAUserList.get(userNum).getJob());
							System.out.println(
									"가입자 주민번호 = " + nominatedAUserList.get(userNum).getResidentRegistrationNumber());
							System.out.println("가입자 전화번호 = " + nominatedAUserList.get(userNum).getPhoneNumber());
							System.out.println("가입자 이메일 = " + nominatedAUserList.get(userNum).getEmail());
							System.out.println("가입자 주소 = " + nominatedAUserList.get(userNum).getAddress());

							// 가입된 보험 상품 선택하여 정보 가지고 오기
							for (int i = 0; i < nominatedAUserList.size(); i++) {
								System.out.println(
										"\n[" + i + "] 가입된 보험 이름: " + nominatedAUserList.get(userNum).joinAInsuranceList
												.get(i).getAnnuity().getInsuranceName());
							}
							System.out.println("가입된 보험 상품을 선택하시오: ");
							int insuranceNum = scanner.nextInt();

							// 보험 상품 정보 가지고 오기
							System.out.println("보험명: " + nominatedAUserList.get(userNum).joinAInsuranceList
									.get(insuranceNum).getAnnuity().getInsuranceName());
							System.out.println("기본보험료: " + nominatedAUserList.get(userNum).joinAInsuranceList
									.get(insuranceNum).getBasicInsurance());
							System.out.println("납입 주기(월): " + nominatedAUserList.get(userNum).joinAInsuranceList
									.get(insuranceNum).getAnnuity().getPaymentFrequency());
							System.out.println("납입 기간(년): " + nominatedAUserList.get(userNum).joinAInsuranceList
									.get(insuranceNum).getAnnuity().getPaymentTerm());

							System.out.println("타보험 가입 여부 확인: 1.있음 , 2.없음 ");
							int confirmNum = scanner.nextInt();

							if (confirmNum == 1) {
								System.out.println("보험을 가입할 수 없습니다.");
							} else if (confirmNum == 2) {
								System.out.println("가입승인 하시겠습니까? 1.승인, 2.거부");
								int acceptanceNum = scanner.nextInt();
								if (acceptanceNum == 1) {
									acceptedAUserList.add(nominatedAUserList.get(userNum));
									nominatedAUserList.remove(userNum);

									System.out.println("보험상품 가입이 승인되었습니다.");
								} else if (acceptanceNum == 2) {

									nominatedAUserList.remove(userNum);
									System.out.println("보험상품 가입이 취소되었습니다.");
								}
							}
						}
					} else if (numbe == 3) {
						System.out.println("\n" + "********가입된 보험 상품*********");
						if (nominatedCUserList.size() == 0)
							System.out.println("가입된 보험이 없습니다.");
						else if (nominatedCUserList.size() > 0) {
							for (int i = 0; i < nominatedCUserList.size(); i++) {
								System.out.println("[" + i + "] 이름: " + nominatedCUserList.get(i).getName());
							}
							System.out.println("가입자를 선택하시오: ");
							int userNum = scanner.nextInt();

							// 설계된 보험 상품 정보 가지고 오기
							System.out.println("가입자 이름 = " + nominatedCUserList.get(userNum).getName());
							System.out.println("가입자 연령군 = " + nominatedCUserList.get(userNum).getAge());
							System.out.println("가입자 직업군 = " + nominatedCUserList.get(userNum).getJob());
							System.out.println(
									"가입자 주민번호 = " + nominatedCUserList.get(userNum).getResidentRegistrationNumber());
							System.out.println("가입자 전화번호 = " + nominatedCUserList.get(userNum).getPhoneNumber());
							System.out.println("가입자 이메일 = " + nominatedCUserList.get(userNum).getEmail());
							System.out.println("가입자 주소 = " + nominatedCUserList.get(userNum).getAddress());

							// 가입된 보험 상품 선택하여 정보 가지고 오기
							for (int i = 0; i < nominatedCUserList.size(); i++) {
								System.out.println(
										"\n[" + i + "] 가입된 보험 이름: " + nominatedCUserList.get(userNum).joinCInsuranceList
												.get(i).getCancer().getInsuranceName());
							}
							System.out.println("가입된 보험 상품을 선택하시오: ");
							int insuranceNum = scanner.nextInt();

							// 보험 상품 정보 가지고 오기
							System.out.println("보험명: " + nominatedCUserList.get(userNum).joinCInsuranceList
									.get(insuranceNum).getCancer().getInsuranceName());
							System.out.println("기본보험료: " + nominatedCUserList.get(userNum).joinCInsuranceList
									.get(insuranceNum).getBasicInsurance());
							System.out.println("납입 주기(월): " + nominatedCUserList.get(userNum).joinCInsuranceList
									.get(insuranceNum).getCancer().getPaymentFrequency());
							System.out.println("납입 기간(년): " + nominatedCUserList.get(userNum).joinCInsuranceList
									.get(insuranceNum).getCancer().getPaymentTerm());

							System.out.println("타보험 가입 여부 확인: 1.있음 , 2.없음 ");
							int confirmNum = scanner.nextInt();

							if (confirmNum == 1) {
								System.out.println("보험을 가입할 수 없습니다.");
							} else if (confirmNum == 2) {
								System.out.println("가입승인 하시겠습니까? 1.승인, 2.거부");
								int acceptanceNum = scanner.nextInt();
								if (acceptanceNum == 1) {
									acceptedCUserList.add(nominatedCUserList.get(userNum));
									nominatedCUserList.remove(userNum);

									System.out.println("보험상품 가입이 승인되었습니다.");
								} else if (acceptanceNum == 2) {

									nominatedCUserList.remove(userNum);
									System.out.println("보험상품 가입이 취소되었습니다.");
								}
							}
						}
					} else if (numbe == 4) {
						System.out.println("\n" + "********가입된 보험 상품*********");
						if (nominatedEUserList.size() == 0)
							System.out.println("가입된 보험이 없습니다.");
						else if (nominatedEUserList.size() > 0) {
							for (int i = 0; i < nominatedEUserList.size(); i++) {
								System.out.println("[" + i + "] 이름: " + nominatedEUserList.get(i).getName());
							}
							System.out.println("가입자를 선택하시오: ");
							int userNum = scanner.nextInt();

							// 설계된 보험 상품 정보 가지고 오기
							System.out.println("가입자 이름 = " + nominatedEUserList.get(userNum).getName());
							System.out.println("가입자 연령군 = " + nominatedEUserList.get(userNum).getAge());
							System.out.println("가입자 직업군 = " + nominatedEUserList.get(userNum).getJob());
							System.out.println(
									"가입자 주민번호 = " + nominatedEUserList.get(userNum).getResidentRegistrationNumber());
							System.out.println("가입자 전화번호 = " + nominatedEUserList.get(userNum).getPhoneNumber());
							System.out.println("가입자 이메일 = " + nominatedEUserList.get(userNum).getEmail());
							System.out.println("가입자 주소 = " + nominatedEUserList.get(userNum).getAddress());

							// 가입된 보험 상품 선택하여 정보 가지고 오기
							for (int i = 0; i < nominatedEUserList.size(); i++) {
								System.out.println(
										"\n[" + i + "] 가입된 보험 이름: " + nominatedEUserList.get(userNum).joinEInsuranceList
												.get(i).getActual().getInsuranceName());
							}
							System.out.println("가입된 보험 상품을 선택하시오: ");
							int insuranceNum = scanner.nextInt();

							// 보험 상품 정보 가지고 오기
							System.out.println("보험명: " + nominatedEUserList.get(userNum).joinEInsuranceList
									.get(insuranceNum).getActual().getInsuranceName());
							System.out.println("기본보험료: " + nominatedEUserList.get(userNum).joinEInsuranceList
									.get(insuranceNum).getBasicInsurance());
							System.out.println("납입 주기(월): " + nominatedEUserList.get(userNum).joinEInsuranceList
									.get(insuranceNum).getActual().getPaymentFrequency());
							System.out.println("납입 기간(년): " + nominatedEUserList.get(userNum).joinEInsuranceList
									.get(insuranceNum).getActual().getPaymentTerm());

							System.out.println("타보험 가입 여부 확인: 1.있음 , 2.없음 ");
							int confirmNum = scanner.nextInt();

							if (confirmNum == 1) {
								System.out.println("보험을 가입할 수 없습니다.");
							} else if (confirmNum == 2) {
								System.out.println("가입승인 하시겠습니까? 1.승인, 2.거부");
								int acceptanceNum = scanner.nextInt();
								if (acceptanceNum == 1) {
									acceptedEUserList.add(nominatedEUserList.get(userNum));
									nominatedEUserList.remove(userNum);

									System.out.println("보험상품 가입이 승인되었습니다.");
								} else if (acceptanceNum == 2) {

									nominatedEUserList.remove(userNum);
									System.out.println("보험상품 가입이 취소되었습니다.");
								}
							}
						}
					}

				}break;
				case 5:
					
					
					UserInformation userInformation1 = new UserInformation(false, null, null);
					userInformation1.setName("에이쁠조");
					userInformation1.setAge(ageSegment.FIRST);
					userInformation1.setGender(true);
					userInformation1.setJob(jobTitle.STUDENT);
					userInformation1.setResidentRegistrationNumber("971111-2111111");
					userInformation1.setPhoneNumber("010-1234-5678");
					userInformation1.setEmail("Aplus@naver.com");
					userInformation1.setAddress("서울");
					
					//계약 체결하기
					System.out.println("계약 체결할 보험을 선택하세요.");
					System.out.println("1. 종신보험");
					System.out.println("2. 연금보험");
					System.out.println("3. 암보험");
					System.out.println("4. 실비보험");
					
					int numberr = scanner.nextInt();

					if (numberr == 1) {

			               Insurance wholelifeinsurance = new WholeLifeInsurance();
			               
						System.out.println("\n" + "********가입된 보험 상품*********");
						if (acceptedWUserList.size() == 0)
							System.out.println("가입된 보험이 없습니다.");
						else if (acceptedWUserList.size() > 0) {
							for (int i = 0; i < acceptedWUserList.size(); i++) {
								System.out.println("[" + i + "] 이름: " + acceptedWUserList.get(i).getName());
							}
							System.out.println("가입자를 선택하시오: ");
							int userNum = scanner.nextInt();


							// 가입된 보험 상품 선택하여 정보 가지고 오기
							for (int i = 0; i < acceptedWUserList.size(); i++) {
								System.out.println(
										"\n[" + i + "] 가입된 보험 이름: " + acceptedWUserList.get(userNum).joinWInsuranceList
												.get(i).getWholelife().getInsuranceName());
							
							System.out.println("가입된 보험 상품을 선택하시오: ");
							int insuranceNum = scanner.nextInt();
							//가입 금액 정보 띄우기
							
							System.out.println("가입금액= " + WCompensation.getMoney());
							System.out.println("재해사망(특약)= " + wholelifeinsurance.getCDisasterDeath());
							System.out.println("재해골절(특약)= " + wholelifeinsurance.getCDisasterFracture());
							System.out.println("재해상해(특약)= " + wholelifeinsurance.getCDisasterInjury());
							System.out.println("입원(특약)= " + wholelifeinsurance.getCHospitalization());
							System.out.println("수술(특약)= " + wholelifeinsurance.getCOperation());
							
							
							UserInformation userInfo = new UserInformation(false, ageSegment.SECOND,
									jobTitle.DAILYWORKER);
							int money = (int) acceptedWInsuranceList.get(i).calculate(userInfo);
							System.out.println("월 보험료 = " + (money + wholelifeinsurance.getDisasterDeath()
									+ wholelifeinsurance.getDisasterFracture() + wholelifeinsurance.getDisasterInjury()
									+ wholelifeinsurance.getHospitalization() + wholelifeinsurance.getOperation()));
							
							System.out.println("계약을 체결하시겠습니까? 1.체결, 2.취소");
							int acceptance = scanner.nextInt();
							if (acceptance == 1) {
								System.out.println("******** 계약이 체결되었습니다.******** ");
							} else if (acceptance == 2) {

								System.out.println("계약 체결을 취소합니다.");
							}
			}
		}
					}else if (numberr == 2) {
						System.out.println("\n" + "********가입된 보험 상품*********");
						if (acceptedAUserList.size() == 0)
							System.out.println("가입된 보험이 없습니다.");
						else if (acceptedAUserList.size() > 0) {
							for (int i = 0; i < acceptedAUserList.size(); i++) {
								System.out.println("[" + i + "] 이름: " + acceptedAUserList.get(i).getName());
							}
							System.out.println("가입자를 선택하시오: ");
							int userNum = scanner.nextInt();

							// 가입된 보험 상품 선택하여 정보 가지고 오기
							for (int i = 0; i < acceptedAUserList.size(); i++) {
								System.out.println(
										"\n[" + i + "] 가입된 보험 이름: " + acceptedAUserList.get(userNum).joinAInsuranceList
												.get(i).getAnnuity().getInsuranceName());
							
							System.out.println("가입된 보험 상품을 선택하시오: ");
							int insuranceNum = scanner.nextInt();
							
							//가입 금액 정보 띄우기
							
							System.out.println("월 보험료 = " + designedAInsuranceList.get(i).getBasicInsurance() + "\n");
							System.out.println("원금 : " + annuityInsurance.getAmountFee());
							System.out.println("만기금 : " + annuityInsurance.getExpirationFee());
							System.out.println("만기유지이자금: " + annuityInsurance.getExpiredMaintainFee());
							System.out.println("중도해지환급금: " + annuityInsurance.getSurrenderValue());			
							
							UserInformation userInfo = new UserInformation(false, ageSegment.SECOND,
									jobTitle.DAILYWORKER);
							
							System.out.println("계약을 체결하시겠습니까? 1.체결, 2.취소");
							int acceptance = scanner.nextInt();
							if (acceptance == 1) {
								System.out.println("******** 계약이 체결되었습니다.******** ");
							} else if (acceptance == 2) {

								System.out.println("계약 체결을 취소합니다.");
							}
			}
		}
					}else if (numberr == 3) {
						System.out.println("\n" + "********가입된 보험 상품*********");
						if (acceptedCUserList.size() == 0)
							System.out.println("가입된 보험이 없습니다.");
						else if (acceptedCUserList.size() > 0) {
							for (int i = 0; i < acceptedCUserList.size(); i++) {
								System.out.println("[" + i + "] 이름: " + acceptedCUserList.get(i).getName());
							}
							System.out.println("가입자를 선택하시오: ");
							int userNum = scanner.nextInt();
						
							// 가입된 보험 상품 선택하여 정보 가지고 오기
							for (int i = 0; i < acceptedCUserList.size(); i++) {
								System.out.println(
										"\n[" + i + "] 가입된 보험 이름: " + acceptedCUserList.get(userNum).joinCInsuranceList
												.get(i).getCancer().getInsuranceName());
							
							System.out.println("가입된 보험 상품을 선택하시오: ");
							int insuranceNum = scanner.nextInt();
							
							
							
							//가입 금액 정보 띄우기
							
					System.out.println("암 진단금 =" + cancerInsurance.cancerDiagnosisFee);
					System.out.println("약물 치료비 =" + cancerInsurance.drugTreatmentFee);
					System.out.println("방사선 치료비 =" + cancerInsurance.radiationTherapyFee);
					System.out.println("수술비 =" + cancerInsurance.operationFee);
					System.out.println("입원비 =" + cancerInsurance.hospitalizationFee);
					
					UserInformation userInfo = new UserInformation(false, ageSegment.SECOND,
							jobTitle.DAILYWORKER);
					int money = (int) acceptedCInsuranceList.get(i).calculate(userInfo);
					System.out.println("월 보험료 = " + money + "\n");
					
					System.out.println("계약을 체결하시겠습니까? 1.체결, 2.취소");
					int acceptance = scanner.nextInt();
					if (acceptance == 1) {
						System.out.println("******** 계약이 체결되었습니다.******** ");
					} else if (acceptance == 2) {

						System.out.println("계약 체결을 취소합니다.");
					}
			}
		}
					}else if (numberr == 4) {
						System.out.println("\n" + "********가입된 보험 상품*********");
						if (acceptedEUserList.size() == 0)
							System.out.println("가입된 보험이 없습니다.");
						else if (acceptedEUserList.size() > 0) {
							for (int i = 0; i < acceptedEUserList.size(); i++) {
								System.out.println("[" + i + "] 이름: " + acceptedEUserList.get(i).getName());
							}
							System.out.println("가입자를 선택하시오: ");
							int userNum = scanner.nextInt();
						
							// 가입된 보험 상품 선택하여 정보 가지고 오기
							for (int i = 0; i < acceptedEUserList.size(); i++) {
								System.out.println(
										"\n[" + i + "] 가입된 보험 이름: " + acceptedEUserList.get(userNum).joinWInsuranceList
												.get(i).getWholelife().getInsuranceName());
							
							System.out.println("가입된 보험 상품을 선택하시오: ");
							int insuranceNum = scanner.nextInt();
							
							System.out.println("입원비= " + actualInsurance.hospitalizationFee);
							System.out.println("통원외래비= " + actualInsurance.outpatientFee);
							System.out.println("통원약제비= " + actualInsurance.outpatientMedicineFee);

							UserInformation userInfo = new UserInformation(false, ageSegment.SECOND,
									jobTitle.DAILYWORKER);
							int money = (int) acceptedEInsuranceList.get(i).calculate(userInfo);
							System.out.println("월 보험료 = " + money + "\n");
							
							System.out.println("계약을 체결하시겠습니까? 1.체결, 2.취소");
							int acceptance = scanner.nextInt();
							if (acceptance == 1) {
								System.out.println("******** 계약이 체결되었습니다.******** ");
							} else if (acceptance == 2) {

								System.out.println("계약 체결을 취소합니다.");
							}
							
							
						
				
			}
		}
						
					
					}
					break;
				case 6:
					
					UserInformation userInformation2 = new UserInformation(false, null, null);
					userInformation2.setName("에이쁠조");
					userInformation2.setResidentRegistrationNumber("971111-2111111");

					
					//계약 체결하기
					System.out.println("보상처리할 보험을 선택하세요.");
					System.out.println("1. 종신보험");
					System.out.println("2. 연금보험");
					System.out.println("3. 암보험");
					System.out.println("4. 실비보험");
					
					int numberrr = scanner.nextInt();
					
					if (numberrr == 1) {

			               Insurance wholelifeinsurance = new WholeLifeInsurance();
			               
						System.out.println("\n" + "********가입된 보험 상품*********");
						if (acceptedWUserList.size() == 0)
							System.out.println("가입된 보험이 없습니다.");
						else if (acceptedWUserList.size() > 0) {
							for (int i = 0; i < acceptedWUserList.size(); i++) {
								System.out.println("[" + i + "] 이름: " + acceptedWUserList.get(i).getName());
							
							System.out.println("가입자를 선택하시오: ");}
							int userNum = scanner.nextInt();
							
							// 가입된 보험 상품 선택하여 정보 가지고 오기
							for (int i = 0; i < acceptedWUserList.size(); i++) {
								System.out.println(
										"\n[" + i + "] 가입된 보험 이름: " + acceptedWUserList.get(userNum).joinWInsuranceList
												.get(i).getWholelife().getInsuranceName());
							
							System.out.println("가입된 보험 상품을 선택하시오: ");
							int insuranceNum = scanner.nextInt();
							//가입 금액 정보 띄우기
							System.out.println("보험명: " + acceptedWUserList.get(userNum).joinWInsuranceList
									.get(insuranceNum).getWholelife().getInsuranceName());
							System.out.println("납입 주기(월): " + acceptedWUserList.get(userNum).joinWInsuranceList
									.get(insuranceNum).getWholelife().getPaymentFrequency());
							System.out.println("납입 기간(년): " + acceptedWUserList.get(userNum).joinWInsuranceList
									.get(insuranceNum).getWholelife().getPaymentTerm());			
							System.out.println("가입금액= " + WCompensation.getMoney());
							System.out.println("재해사망(특약)= " + wholelifeinsurance.getCDisasterDeath());
							System.out.println("재해골절(특약)= " + wholelifeinsurance.getCDisasterFracture());
							System.out.println("재해상해(특약)= " + wholelifeinsurance.getCDisasterInjury());
							System.out.println("입원(특약)= " + wholelifeinsurance.getCHospitalization());
							System.out.println("수술(특약)= " + wholelifeinsurance.getCOperation());

							
							System.out.println("보험금을 지급하시겠습니까? 1.지급, 2.취소");
							int acceptance = scanner.nextInt();
							if (acceptance == 1) {
								System.out.println("******** 보험금이 지급되었습니다.******** ");
							} else if (acceptance == 2) {

								System.out.println("보험금 지급을 취소합니다.");
							}
							
							}				
							}
			}else if (numberrr == 2) {
				System.out.println("\n" + "********가입된 보험 상품*********");
				if (acceptedAUserList.size() == 0)
					System.out.println("가입된 보험이 없습니다.");
				else if (acceptedAUserList.size() > 0) {
					for (int i = 0; i < acceptedAUserList.size(); i++) {
						System.out.println("[" + i + "] 이름: " + acceptedAUserList.get(i).getName());
					
					System.out.println("가입자를 선택하시오: ");}
					int userNum = scanner.nextInt();
					
					// 가입된 보험 상품 선택하여 정보 가지고 오기
					for (int i = 0; i < acceptedAUserList.size(); i++) {
						System.out.println(
								"\n[" + i + "] 가입된 보험 이름: " + acceptedAUserList.get(userNum).joinAInsuranceList
										.get(i).getAnnuity().getInsuranceName());
					
					System.out.println("가입된 보험 상품을 선택하시오: ");
					int insuranceNum = scanner.nextInt();
					//가입 금액 정보 띄우기
					System.out.println("보험명: " + acceptedAUserList.get(userNum).joinAInsuranceList
							.get(insuranceNum).getAnnuity().getInsuranceName());
					System.out.println("납입 주기(월): " + acceptedAUserList.get(userNum).joinAInsuranceList
							.get(insuranceNum).getAnnuity().getPaymentFrequency());
					System.out.println("납입 기간(년): " + acceptedAUserList.get(userNum).joinAInsuranceList
							.get(insuranceNum).getAnnuity().getPaymentTerm());			
					System.out.println("만기금 = " + annuityInsurance.getExpirationFee());
					System.out.println("만기유지이자금 = " + annuityInsurance.getExpiredMaintainFee());
					System.out.println("중도해지환급금 = " + annuityInsurance.getSurrenderValue());
					
					System.out.println("보험금을 지급하시겠습니까? 1.지급, 2.취소");
					int acceptance = scanner.nextInt();
					if (acceptance == 1) {
						System.out.println("******** 보험금이 지급되었습니다.******** ");
					} else if (acceptance == 2) {

						System.out.println("보험금 지급을 취소합니다.");
					}
					
					}				
					}
			}else if(numberrr == 3) {
				System.out.println("\n" + "********가입된 보험 상품*********");
				if (acceptedCUserList.size() == 0)
					System.out.println("가입된 보험이 없습니다.");
				else if (acceptedCUserList.size() > 0) {
					for (int i = 0; i < acceptedCUserList.size(); i++) {
						System.out.println("[" + i + "] 이름: " + acceptedCUserList.get(i).getName());
					
					System.out.println("가입자를 선택하시오: ");}
					int userNum = scanner.nextInt();
					
					// 가입된 보험 상품 선택하여 정보 가지고 오기
					for (int i = 0; i < acceptedCUserList.size(); i++) {
						System.out.println(
								"\n[" + i + "] 가입된 보험 이름: " + acceptedCUserList.get(userNum).joinCInsuranceList
										.get(i).getCancer().getInsuranceName());
					
					System.out.println("가입된 보험 상품을 선택하시오: ");
					int insuranceNum = scanner.nextInt();
					//가입 금액 정보 띄우기
					System.out.println("보험명: " + acceptedCUserList.get(userNum).joinCInsuranceList
							.get(insuranceNum).getCancer().getInsuranceName());
					System.out.println("납입 주기(월): " + acceptedCUserList.get(userNum).joinCInsuranceList
							.get(insuranceNum).getCancer().getPaymentFrequency());
					System.out.println("납입 기간(년): " + acceptedCUserList.get(userNum).joinCInsuranceList
							.get(insuranceNum).getCancer().getPaymentTerm());		
					
					System.out.println("암 진단금 =" + cancerInsurance.cancerDiagnosisFee);
					System.out.println("약물 치료비 =" + cancerInsurance.drugTreatmentFee);
					System.out.println("방사선 치료비 =" + cancerInsurance.radiationTherapyFee);
					System.out.println("수술비 =" + cancerInsurance.operationFee);
					System.out.println("입원비 =" + cancerInsurance.hospitalizationFee);

					
					System.out.println("보험금을 지급하시겠습니까? 1.지급, 2.취소");
					int acceptance = scanner.nextInt();
					if (acceptance == 1) {
						System.out.println("******** 보험금이 지급되었습니다.******** ");
					} else if (acceptance == 2) {

						System.out.println("보험금 지급을 취소합니다.");
					}
					
					}				
					}
			}else if(numberrr == 4) {
				System.out.println("\n" + "********가입된 보험 상품*********");
				if (acceptedEUserList.size() == 0)
					System.out.println("가입된 보험이 없습니다.");
				else if (acceptedEUserList.size() > 0) {
					for (int i = 0; i < acceptedEUserList.size(); i++) {
						System.out.println("[" + i + "] 이름: " + acceptedEUserList.get(i).getName());
					
					System.out.println("가입자를 선택하시오: ");}
					int userNum = scanner.nextInt();
					
					// 가입된 보험 상품 선택하여 정보 가지고 오기
					for (int i = 0; i < acceptedEUserList.size(); i++) {
						System.out.println(
								"\n[" + i + "] 가입된 보험 이름: " + acceptedEUserList.get(userNum).joinEInsuranceList
										.get(i).getActual().getInsuranceName());
					
					System.out.println("가입된 보험 상품을 선택하시오: ");
					int insuranceNum = scanner.nextInt();
					//가입 금액 정보 띄우기
					System.out.println("보험명: " + acceptedEUserList.get(userNum).joinEInsuranceList
							.get(insuranceNum).getActual().getInsuranceName());
					System.out.println("납입 주기(월): " + acceptedEUserList.get(userNum).joinEInsuranceList
							.get(insuranceNum).getActual().getPaymentFrequency());
					System.out.println("납입 기간(년): " + acceptedEUserList.get(userNum).joinEInsuranceList
							.get(insuranceNum).getActual().getPaymentTerm());		
					
					System.out.println("입원비= " + actualInsurance.hospitalizationFee);
					System.out.println("통원외래비= " + actualInsurance.outpatientFee);
					System.out.println("통원약제비= " + actualInsurance.outpatientMedicineFee);
					
					System.out.println("보험금을 지급하시겠습니까? 1.지급, 2.취소");
					int acceptance = scanner.nextInt();
					if (acceptance == 1) {
						System.out.println("******** 보험금이 지급되었습니다.******** ");
					} else if (acceptance == 2) {

						System.out.println("보험금 지급을 취소합니다.");
					}
					
					}				
					}
			}
		}
						}
					
}
}