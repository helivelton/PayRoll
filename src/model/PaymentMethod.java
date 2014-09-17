package model;

public enum PaymentMethod {

	DESPOSIT(1), MAIL(2), INHANDS(3);
	
	public int value;

	PaymentMethod(int value) {
		this.value = value;
	}
	
	public static PaymentMethod getPaymentMethod(int value)
	{
		if(value==1) return DESPOSIT;
		if(value==2) return MAIL;
		if(value==3) return INHANDS;
		return null;
	}
	
	
}
