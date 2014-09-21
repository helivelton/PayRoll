package model;

import java.util.Calendar;

public class SalaraiedEmployee extends Employee {

	private double salary;

	public SalaraiedEmployee(int id, int syndicateId, String name,
			String adress, PaymentMethod paymentMethod, Calendar admissionDate,
			Calendar lastPayDate, Calendar nextPayDate, boolean isOnSyndicate,
			double monthlyFee, double deduction, double salary) {
		super(id, syndicateId, name, adress, paymentMethod, admissionDate,
				lastPayDate, nextPayDate, isOnSyndicate, monthlyFee, deduction);
		this.salary = salary;
	}

	public SalaraiedEmployee(String name, String adress,
			PaymentMethod paymentMethod, Calendar admissionDate, double salary) {
		super(name, adress, paymentMethod, admissionDate);
		
		this.salary = salary;
		Calendar nextPayDay = (Calendar)admissionDate.clone();
		
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
		nextPayDay.set(Calendar.DAY_OF_MONTH,
				nextPayDay.getActualMaximum(Calendar.DAY_OF_MONTH));
		while (nextPayDay.get(Calendar.DAY_OF_WEEK) == 7
				|| nextPayDay.get(Calendar.DAY_OF_WEEK) == 1) {
			nextPayDay.add(Calendar.DATE, -1);

		}

		this.setNextPayDate(nextPayDay);

		this.setDeduction(0);
	}

	public SalaraiedEmployee clone() {
		SalaraiedEmployee cloned;

		cloned = new SalaraiedEmployee(this.getId(), this.getSyndicateId(),
				this.getName(), this.getAdress(), this.getPaymentMethod(),
				(Calendar) this.getAdmissionDate().clone(), (Calendar) this
						.getLastPayDate().clone(), (Calendar) this
						.getNextPayDate().clone(), this.isOnSyndicate(),
				this.getMonthlyFee(), this.getDeduction(), this.getSalary());

		return cloned;
	}
}
