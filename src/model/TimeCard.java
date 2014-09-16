package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TimeCard {

	private Calendar checkin;
	private Calendar checkout;

	public TimeCard(Calendar checkin, Calendar checkout) {
		super();
		this.checkin = checkin;
		this.checkout = checkout;
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

}
