package US;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Employee;

public class PayRoll {

	public static void printPayrollOfDate(Calendar payDay) {
		List<Employee> employessToPay = new ArrayList<Employee>();

		for (Employee employee : Employee.getEmployees()) {

			if (employee.getNextPayDate().get(Calendar.DAY_OF_YEAR) == payDay
					.get(Calendar.DAY_OF_YEAR)) {

				employessToPay.add(employee);
			}
		}

		for (Employee employee : employessToPay) {
			System.out.println(employee.getName() + " "
					+ employee.getLiquidSalary() + " "
					+ employee.getPaymentMethod());
			employee.pay();
		}
	}

	public static void printTodaysPayRoll() {

		Calendar payDay = Calendar.getInstance();
		List<Employee> employessToPay = new ArrayList<Employee>();

		for (Employee employee : Employee.getEmployees()) {
			if (employee.getNextPayDate().get(Calendar.DATE) == payDay
					.get(Calendar.DATE)) {
				System.out.println("teste");
				employessToPay.add(employee);
			}
		}

		for (Employee employee : employessToPay) {
			System.out.println(employee.getName() + " "
					+ employee.getLiquidSalary() + " "
					+ employee.getPaymentMethod());
			employee.pay();
		}

	}
}
