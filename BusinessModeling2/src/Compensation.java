
public class Compensation extends Insurance {

	
	private int money;
	private int paymentFrequency;
	private int paymentTerm;
	
	public int getPaymentFrequency() {
		return paymentFrequency;
	}





	public void setPaymentFrequency(int paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
	}





	public int getPaymentTerm() {
		return paymentTerm;
	}





	public void setPaymentTerm(int paymentTerm) {
		this.paymentTerm = paymentTerm;
	}





	public Compensation(){

	}

	



	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


}