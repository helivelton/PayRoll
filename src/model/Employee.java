package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public abstract class Employee implements Cloneable {
	
	private static List<Employee> employees = new ArrayList<Employee>();
	private static int nextId = 0;
	private static int nextSyndicateId = 0;
	//public static SimpleDateFormat dateFormat = new SimpleDateFormat(
	//		"dd/MM/yyyy HH:mm:ss");
	
	private int id;
	private int syndicateId;
	private String name;
	private String adress;
	private PaymentMethod paymentMethod;
	private Calendar admissionDate;
	private Calendar lastPayDate;
	private Calendar nextPayDate;
	private boolean isOnSyndicate = false; 	
	private double monthlyFee=0;
	private double deduction=0;
	
	
	public Employee(int id, int syndicateId, String name, String adress,
			PaymentMethod paymentMethod, Calendar admissionDate,
			Calendar lastPayDate, Calendar nextPayDate, boolean isOnSyndicate,
			double monthlyFee, double deduction) {
		super();
		
		
		this.id = id;
		this.syndicateId = syndicateId;
		this.name = name;
		this.adress = adress;
		this.paymentMethod = paymentMethod;
		this.admissionDate = admissionDate;
		this.lastPayDate = lastPayDate;
		this.nextPayDate = nextPayDate;
		this.isOnSyndicate = isOnSyndicate;
		this.monthlyFee = monthlyFee;
		this.deduction = deduction;
		
	}


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

	
	public Employee(String name, String adress) {
		super();
		this.name = name;
		this.adress = adress;
		this.paymentMethod = PaymentMethod.DESPOSIT;
		this.admissionDate = Calendar.getInstance();
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
	
	public static void addEmployee(Employee employee)
	{
		employees.add(employee);
	}
	
	public static void removeEmployee(Employee employee)
	{
		employees.remove(employee);
	}
	
	public static void removeEmployeeById(int id)
	{
		Employee employee = findEmployeeById(id);
		employees.remove(employee);
	}
	
	public static Employee findEmployeeById(int id)
	{
		for(Employee employee: employees)
		{
			if(employee.id == id) return employee;
		}
		return null;
		
		
	}


	public Calendar getNextPayDate() {
		return nextPayDate;
	}


	public void setNextPayDate(Calendar nextPayDate) {
		this.nextPayDate = nextPayDate;
	}


	public boolean isOnSyndicate() {
		return isOnSyndicate;
	}


	public void setOnSyndicate(boolean isOnSyndicate) {
		if(!this.isOnSyndicate() && isOnSyndicate)
		{
			this.syndicateId = getNextSyndicateId();
		}
		if(!isOnSyndicate)
		{
			setMonthlyFee(0);
		}
		this.isOnSyndicate = isOnSyndicate;
	}


	public double getMonthlyFee() {
		return monthlyFee;
	}


	public void setMonthlyFee(double monthlyFee) {
		this.monthlyFee = monthlyFee;
	}


	public double getDeduction() {
		return deduction;
	}


	public void setDeduction(double deduction) {
		this.deduction = deduction;
	}


	public int getSyndicateId() {
		return syndicateId;
	}


	public void setSyndicateId(int syndicateId) {
		this.syndicateId = syndicateId;
	}


	public static int getNextSyndicateId() {
		int current = nextSyndicateId;
		nextSyndicateId++;
		return current;
	}
	
	
	public abstract double getLiquidSalary();
	
	public abstract void pay();
	

}
