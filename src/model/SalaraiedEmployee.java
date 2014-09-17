package model;

import java.util.Calendar;

public class SalaraiedEmployee extends Employee {

	private double salary;

	public SalaraiedEmployee(String name, String adress,
			PaymentMethod paymentMethod, Calendar admissionDate, double salary) {
		super(name, adress, paymentMethod, admissionDate);
		this.salary = salary;

		Calendar nextPayDay = admissionDate;
		System.out.println("here");
		System.out.println(nextPayDay.getActualMaximum(Calendar.DATE));
		nextPayDay.add(Calendar.DAY_OF_MONTH, 10);
		
		int lastWorkDay = nextPayDay.getActualMaximum(Calendar.DATE);
		
		nextPayDay.set(Calendar.DAY_OF_MONTH, lastWorkDay);

		
		while (nextPayDay.get(Calendar.DAY_OF_WEEK) == 7
				|| nextPayDay.get(Calendar.DAY_OF_WEEK) == 1) {
			nextPayDay.add(Calendar.DAY_OF_MONTH, -1);
			
		}

		this.setNextPayDate(nextPayDay);
	}

	public SalaraiedEmployee(String name, String adress, double salary) {
		super(name, adress);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public double getLiquidSalary() {
		double liquidSalary = this.getSalary();

		if (this.isOnSyndicate()) {
			liquidSalary += -this.getMonthlyFee() - this.getDeduction();
		}

		return liquidSalary;
	}

	@Override
	public void pay() {
		this.setLastPayDate(this.getNextPayDate());

		Calendar nextPayDay = this.getNextPayDate();
		nextPayDay.add(Calendar.DATE, 10);
		nextPayDay.set(Calendar.DAY_OF_MONTH, nextPayDay.getActualMaximum(Calendar.DAY_OF_MONTH));
		while (nextPayDay.get(Calendar.DAY_OF_WEEK) == 7
				|| nextPayDay.get(Calendar.DAY_OF_WEEK) == 1) {
			nextPayDay.add(Calendar.DATE, -1);
			
		}

		this.setNextPayDate(nextPayDay);

		this.setDeduction(0);
	}

}
