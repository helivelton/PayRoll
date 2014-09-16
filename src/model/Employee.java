package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public abstract class Employee {
	
	private static List<Employee> employees = new ArrayList<Employee>();
	private static int nextId = 0;
	
	private int id;
	private String name;
	private String adress;
	private PaymentMethod paymentMethod;
	private Calendar admissionDate;
	private Calendar lastPayDate;
	
	public Employee(String name, String adress,
			PaymentMethod paymentMethod, Calendar admissionDate) {
		super();
		this.id = Employee.getNextId();
		this.name = name;
		this.adress = adress;
		this.paymentMethod = paymentMethod;
		this.admissionDate = admissionDate;
		this.lastPayDate = admissionDate;
	}

	public static List<Employee> getEmployees() {
		return employees;
	}

	public static void setEmployees(List<Employee> employees) {
		Employee.employees = employees;
	}

	public static int getNextId() {
		int current = nextId;
		nextId++;
		return current;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Calendar getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Calendar admissionDate) {
		this.admissionDate = admissionDate;
	}

	public Calendar getLastPayDate() {
		return lastPayDate;
	}

	public void setLastPayDate(Calendar lastPayDate) {
		this.lastPayDate = lastPayDate;
	}
	
	
}
