package model;

import java.util.ArrayList;
import java.util.List;

public class SyndicateEmployee {

	private static List<SyndicateEmployee> syndicateEmployees = new ArrayList<SyndicateEmployee>();
	private static int nextId = 0;
	
	private int id;
	private int EmployeeId;
	private double monthlyfee;
	private double deduction;
	public static List<SyndicateEmployee> getSyndicateEmployees() {
		return syndicateEmployees;
	}
	public static void setSyndicateEmployees(
			List<SyndicateEmployee> syndicateEmployees) {
		SyndicateEmployee.syndicateEmployees = syndicateEmployees;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}
	public double getMonthlyfee() {
		return monthlyfee;
	}
	public void setMonthlyfee(double monthlyfee) {
		this.monthlyfee = monthlyfee;
	}
	public double getDeduction() {
		return deduction;
	}
	public void setDeduction(double deduction) {
		this.deduction = deduction;
	}
	public static int getNextId() {
		int current = nextId;
		nextId++;
		return current;
	}
	
	
}
