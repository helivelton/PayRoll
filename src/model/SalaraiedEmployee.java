package model;

import java.util.Calendar;

public class SalaraiedEmployee extends Employee {

	private double salary;

	public SalaraiedEmployee(String name, String adress,
			PaymentMethod paymentMethod, Calendar admissionDate, double salary) {
		super(name, adress, paymentMethod, admissionDate);
		this.salary = salary;
	}
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
