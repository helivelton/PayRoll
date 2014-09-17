package model;

import java.text.ParseException;

import java.util.Calendar;

public class TimeCard {

	private Calendar checkin;
	private Calendar checkout;

	public TimeCard(Calendar checkin, Calendar checkout) {
		super();
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public TimeCard(String checkinStr, String checkoutStr) {
		Calendar cckin = Calendar.getInstance();
		try {
			cckin.setTime(Employee.dateFormat.parse(checkinStr));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Calendar cckout = Calendar.getInstance();
		try {
			cckout.setTime(Employee.dateFormat.parse(checkoutStr));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.checkin = cckin;
		this.checkout = cckout;
	}

	public Calendar getCheckin() {
		return checkin;
	}

	public void setCheckin(Calendar checkin) {
		this.checkin = checkin;
	}

	public Calendar getCheckout() {
		return checkout;
	}

	public void setCheckout(Calendar checkout) {
		this.checkout = checkout;
	}

	public double getWorkHours() {
		double milliseconds = checkout.getTimeInMillis()
				- checkin.getTimeInMillis();
		double hours = ((milliseconds / (1000 * 60 * 60)));
		return hours;
	}

}
