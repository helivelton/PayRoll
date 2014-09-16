package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HourlyEmplyee extends Employee {

	private double hourPrice;
	private List<TimeCard> timeCards = new ArrayList<TimeCard>();
	
	public HourlyEmplyee(String name, String adress,
			PaymentMethod paymentMethod, Calendar admissionDate,
			double hourPrice) {
		super(name, adress, paymentMethod, admissionDate);
		this.hourPrice = hourPrice;
	}

	public double getHourPrice() {
		return hourPrice;
	}

	public void setHourPrice(double hourPrice) {
		this.hourPrice = hourPrice;
	}

	public List<TimeCard> getTimeCards() {
		return timeCards;
	}

	public void setTimeCards(List<TimeCard> timeCards) {
		this.timeCards = timeCards;
	}
	
	public void addTimeCard(TimeCard timeCard)
	{
		timeCards.add(timeCard);
	}

}
