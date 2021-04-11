import java.sql.SQLException;
import java.util.ArrayList;

public class InsuranceDBAccessor extends DBAccessor {

	String query = null;
	WholeLifeInsurance wholeLifeInsurance;
	AnnuityInsurance annuityInsurance;
	CancerInsurance cancerInsurance;
	ActualExpense actualInsurance;
	Insurance wholelife = new Insurance();
	Insurance annuity = new Insurance();

	public void insert (Insurance insurance) throws SQLException {
	      try{
	         query = "insert into compensation(money,paymentFrquency,paymentTerm) values(" +
	               insurance.getM_Compensation().getMoney() + "," + 
	               insurance.getM_Compensation().getPaymentFrequency() + "," + 
	               insurance.getM_Compensation().getPaymentTerm() + ");";
	         System.out.println(query);
	         super.executeQuery(query);
	         
	      } catch(SQLException e){
	         throw e;
	      }
	      
	      if(insurance.getType().equals(insuranceType.WHOLELIFE)) {
	    	  
	         WholeLifeInsurance wholelifeinsurance = (WholeLifeInsurance) insurance;
	         
	         try {
	            query = "insert into insurance(compensation_id, insuranceType, insuranceName, paymentFrequency, paymentTerm, basicInsurance, isAccepted) values(" +
	            		"last_insert_id(), " + "'WHOLELIFE', " +
	                  "'" + insurance.getInsuranceName() + "'" + ", " +
	                  + insurance.getPaymentFrequency() + ", " +
	                  + insurance.getPaymentTerm() +", " +
	                  + insurance.getBasicInsurance() + ", " +
	                   "0" + ");";
	            
	            System.out.println(query);
	            super.executeQuery(query);

	         }
	         catch(SQLException e) {
	            throw e;
	         }
	         try{
	            query = "insert into wholelifeinsurance(disasterdeath,disasterinjury,disasterfracture, hospitalization, operation, cdisasterdeath,cdisasterinjury, cdisasterfracture, chospitalization, coperation) values(" +
	                  wholelifeinsurance.getDisasterDeath() + "," + 
	                  wholelifeinsurance.getDisasterInjury() + "," + 
	                  wholelifeinsurance.getDisasterFracture() + "," + 
	                  wholelifeinsurance.getHospitalization() + "," +
	                  wholelifeinsurance.getOperation() + "," +
	                  wholelifeinsurance.getCDisasterDeath() + "," +
	                  wholelifeinsurance.getCDisasterInjury() + "," +
	                  wholelifeinsurance.getCDisasterFracture() + "," +
	                  wholelifeinsurance.getCHospitalization() + "," +
	                  wholelifeinsurance.getCOperation() + ");";
	            System.out.println(query);
	            super.executeQuery(query);
	         } catch(SQLException e){
	            throw e;
	         }
	      
	      } else if (insurance.getType().equals(insuranceType.ANNUITY)) {
	    	  
	    	  AnnuityInsurance annuityinsurance = (AnnuityInsurance) insurance;
	    	  
		         try {
		            query = "insert into insurance(compensation_id, insuranceType, insuranceName, paymentFrequency, paymentTerm, basicInsurance, isAccepted) values(" +
		            		"last_insert_id(), " + "'ANNUITY', " +
		                  "'" + insurance.getInsuranceName() + "'" + ", " +
		                  + insurance.getPaymentFrequency() + ", " +
		                  + insurance.getPaymentTerm() +", " +
		                  + insurance.getBasicInsurance() + ", " +
		                   "0" + ");";
		            
		            System.out.println(query);
		            super.executeQuery(query);

		         }
		         catch(SQLException e) {
		            throw e;
		         }
		         try{
		            query = "insert into annuityinsurance(id, amountFee, expiredMaintainFee, expirationFee, surrenderValue) values(" +
		            		annuityinsurance.getAmountFee() + "," + 
		            		annuityinsurance.getExpiredMaintainFee() + "," + 
		            		annuityinsurance.getExpirationFee() + "," + 
		            		annuityinsurance.getSurrenderValue() + ");";
		            System.out.println(query);
		            super.executeQuery(query);
		         } catch(SQLException e){
		            throw e;
		         }
	    	  
	      } else if (insurance.getType().equals(insuranceType.CANCER)) {
	    	  
	      } else if (insurance.getType().equals(insuranceType.ACTUALEXPENSE)) {
	    	  
	      }
	}
	
//	public <wholeLifeInsurance> void insertWInsurance(Insurance insurance) throws SQLException {
//		try {
//			query = "insert into compensation(money, paymentFrquency, paymentTerm) values("
//					+ insurance.getM_Compensation().getMoney() + ", "
//					+ insurance.getM_Compensation().getPaymentFrequency() + ", "
//					+ insurance.getM_Compensation().getPaymentTerm() + ");";
//			System.out.println(query);
//			super.executeQuery(query);
//
//		} catch (SQLException e) {
//			throw e;
//		}
//
//		if (insurance.getType().equals(insuranceType.WHOLELIFE)) {
//
//			wholeLifeInsurance wholelife = (wholeLifeInsurance) insurance;
//
//			try {
//				query = "insert into insurance(Compensation_id, insuranceType, InsuranceName, paymentFrequency, "
//						+ "paymentTerm, Basicinsurance, isAccepted) values("
//						+ "last_insert_id()" + ", " + "'WHOLELIFE', " + " ' " + ((Insurance) wholelife).getInsuranceName() + " ' " + ", " +
//
//						((Insurance) wholelife).getPaymentFrequency() + ", " + ((Insurance) wholelife).getPaymentTerm()
//						+ "," + ((Insurance) wholelife).getBasicInsurance() + "," + "0" + ");";
//				System.out.println(query);
//				super.executeQuery(query);
//
//			} catch (SQLException e) {
//				throw e;
//			}
//
//		}
//	}
//
//	public <annuityInsurance> void insertAInsurance(Insurance insurance) throws SQLException {
//		
//		try {
//			query = "insert into compensation(money, paymentFrquency, paymentTerm) values("
//					+ insurance.getM_Compensation().getMoney() + ", "
//					+ insurance.getM_Compensation().getPaymentFrequency() + ", "
//					+ insurance.getM_Compensation().getPaymentTerm() + ");";
//			System.out.println(query);
//			super.executeQuery(query);
//
//		} catch (SQLException e) {
//			throw e;
//		}
//
//		if (insurance.getType().equals(insuranceType.ANNUITY)) {
//
//			annuityInsurance annuity = (annuityInsurance) insurance;
//
//			try {
//				query = "insert into insurance(Compensation_id, insuranceType, InsuranceName, paymentFrequency, "
//						+ "paymentTerm, Basicinsurance, isAccepted) values("
//						+ "last_insert_id()" + ", " + "'ANNUITY', " + " ' " + ((Insurance) annuity).getInsuranceName() + " ' " + ", " +
//
//						((Insurance) annuity).getPaymentFrequency() + ", " + ((Insurance) annuity).getPaymentTerm()
//						+ "," + ((Insurance) annuity).getBasicInsurance() + "," + "0" + ");";
//				System.out.println(query);
//				super.executeQuery(query);
//
//			} catch (SQLException e) {
//				throw e;
//			}
//
//		}
//	}

	public ArrayList<WholeLifeInsurance> selectInsurance(boolean isAccepted) throws SQLException {
		ArrayList<WholeLifeInsurance> insurancelist = new ArrayList<WholeLifeInsurance>();

		query = "select type, insuranceName, insurance.id, " + "from insurance, compensation "
				+ "where insurance.Compensation_id = compensation.id and "
				+ "insurance.id = wholelifeinsurance.id  and ";

		if (!isAccepted)
			query += "insurance.isAccepted = 0;";
		else
			query += "insurance.isAccepted = 1;";

		// System.out.println(query);
		resultSet = super.executeQuery(query);

		// Query 결과 ArrayList에 셋팅
		while (resultSet.next()) {

			// Insurance 객체 생성
			Insurance insurance = new WholeLifeInsurance();
			// 기본 보험 내용 셋팅

			insurance.setID(Integer.parseInt(resultSet.getString("insurance.id")));
			insurance.setInsuranceName(resultSet.getString("Name"));

			insurance.setPaymentFrequency(Integer.parseInt(resultSet.getString("PaymentFrequency")));
			insurance.setPaymentTerm(Integer.parseInt(resultSet.getString("PaymentTerm")));
			insurance.setBasicInsurance(Integer.parseInt(resultSet.getString("BasicInsurance")));

			// 보상 금액 셋팅
			Compensation compensation = new Compensation();
			compensation.setMoney(Integer.parseInt(resultSet.getString("money")));
			compensation.setPaymentFrequency(Integer.parseInt(resultSet.getString("PaymentFrequency")));
			compensation.setPaymentTerm(Integer.parseInt(resultSet.getString("PaymentTerm")));

			insurance.setM_Compensation(compensation);

			insurance.setType(insuranceType.WHOLELIFE);

			insurancelist.add((WholeLifeInsurance) wholelife);

		}

		return insurancelist;

	}

//	public void insertInsurance(WholeLifeInsurance wholeLifeInsurance) throws SQLException {
//
//		try {
//
//			query = "insert into wholeLifeInsurance(disasterDeath,disasterInjury,disasterFracture, "
//					+ "hospitalization, operation, CDisasterDeath, CDisasterInjury,CDisasterFracture, CHospitalization, "
//					+ "COperation, id ) " + "values(" + wholeLifeInsurance.getDisasterDeath() + ","
//					+ wholeLifeInsurance.getDisasterInjury() + "," + wholeLifeInsurance.getDisasterFracture() + ","
//					+ wholeLifeInsurance.getHospitalization() + "," + wholeLifeInsurance.getOperation() + ","
//					+ wholeLifeInsurance.getCDisasterDeath() + "," + wholeLifeInsurance.getCDisasterInjury() + ","
//					+ wholeLifeInsurance.getCDisasterFracture() + "," + wholeLifeInsurance.getCHospitalization() + ","
//					+ wholeLifeInsurance.getCOperation() + "," + "last_insert_id()" + ");";
//
//			System.out.println(query);
//			super.executeQuery(query);
//
//		} catch (SQLException e) {
//			throw e;
//		}
//	}

	// @SuppressWarnings("static-access")
	// public void insertInsurance (AnnuityInsurance annuityInsurance) throws
	// SQLException {
	//
	// try{
	//
	// query = "insert into
	// annuityInsurance(amountFee,expiredMaintainFee,expirationFee,surrenderValue)
	// values(" +
	// annuityInsurance.getAmountFee() + "," +
	// annuityInsurance.getExpiredMaintainFee() + "," +
	// annuityInsurance.getExpirationFee() + "," +
	// annuityInsurance.getSurrenderValue()+ "," +
	// "last_insert_id()"+
	// ");";
	//
	//
	// System.out.println(query);
	// super.executeQuery(query, false);
	//
	// }
	// catch(SQLException e) {
	// throw e;
	// }
	// }

	public void insertInsurance(CancerInsurance cancerInsurance) throws SQLException {
		try {
			query = "insert into annuityInsurance (amountFee, expiredMaintainFee, expirationFee , surrenderValue) "
					+ "values (10, 10, 10, 10);";

			query = "insert into cancerInsurance(cancerHistory,cancerDiagnosisFee,drugTreatmentFee, radiationTherapyFee, operationFee, hospitalizationFee) values("
					+ cancerInsurance.isCancerHistory() + "," + cancerInsurance.getCancerDiagnosisFee() + ","
					+ cancerInsurance.getDrugTreatmentFee() + "," + cancerInsurance.getRadiationTherapyFee() + ","
					+ cancerInsurance.getOperationFee() + "," + cancerInsurance.getHospitalizationFee() + ");";

			System.out.println(query);
			super.executeQuery(query);

		} catch (SQLException e) {
			throw e;
		}

	}

	public void insertInsurance(ActualExpense actualInsurance) throws SQLException {
		try {
			query = "insert into actualexpense(hospitalizationFee,outpatientFee,outpatientMedicineFee,selfBurdenFee) values("
					+ actualInsurance.getHospitalizationFee() + "," + actualInsurance.getOutpatientFee() + ","
					+ actualInsurance.getOutpatientMedicineFee() + "," + actualInsurance.getSelfBurdenFee() + ");";

			System.out.println(query);
			super.executeQuery(query);
		} catch (SQLException e) {
			throw e;
		}

	}

	public void updateAcceptance(String table, int id, boolean isAccepted) throws SQLException {
		query = "update " + table + " set isAccepted = " + isAccepted + " where id = " + id + ";";
		try {
			System.out.println(query);

			super.executeQuery(query);
		} catch (SQLException e) {
			throw e;
		}
	}

}