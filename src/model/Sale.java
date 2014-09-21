package model;

import java.util.Calendar;

public class Sale {

	private double value;
	private Calendar saleDate;

	public Sale(double value, Calendar saleDate) {
		super();
		this.value = value;
		this.saleDate = saleDate;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Calendar getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Calendar saleDate) {
		this.saleDate = saleDate;
	}

	public Sale clone() {
		double value = this.getValue();
		Calendar saleDate = (Calendar) this.getSaleDate().clone();

		Sale cloned = new Sale(value, saleDate);

		return cloned;
	}

}
