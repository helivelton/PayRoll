package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ComissionedEmployee extends SalaraiedEmployee {

	private List<Sale> sales = new ArrayList<Sale>();
	private double comission;
	public ComissionedEmployee(String name, String adress,
			PaymentMethod paymentMethod, Calendar admissionDate, double salary) {
		super(name, adress, paymentMethod, admissionDate, salary);
		// TODO Auto-generated constructor stub
	}
	public List<Sale> getSales() {
		return sales;
	}
	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}
	public double getComission() {
		return comission;
	}
	public void setComission(double comission) {
		this.comission = comission;
	}
	public void addSale(Sale sale)
	{
		this.sales.add(sale);
	}
	
	
}
