package US;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import util.CalendarOperations;
import model.ComissionedEmployee;
import model.Employee;
import model.HourlyEmplyee;
import model.PaymentMethod;
import model.SalaraiedEmployee;
import model.Sale;
import model.TimeCard;

public class UserStore {

	private static Scanner scan = new Scanner(System.in);
	private static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat scannerFormat = new SimpleDateFormat(
			"dd/MM/yyyyHH:mm:ss");

	public static void addEmployee() {

		System.out.println("---- Adicionar empregado ----\n Nome:");
		String name = scan.nextLine();
		System.out.println("Endereço:");
		String adress = scan.nextLine();
		System.out.println("Tipo \n1.Horista \n2.Assalariado \n3.Comissionado");
		int type = scan.nextInt();

		System.out.println("Data de admissão:");

		String admDate = scan.next();
		Calendar admissionDate = Calendar.getInstance();
		try {
			admissionDate.setTime(scannerFormat.parse(admDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Calendar admissionDate =
		// CalendarOperations.stringToCalendar(admDate);
		System.out.println("Método de recebimento:");
		System.out.println("1.Depósito\n2.Cheque pelos correios\n3.Cheque em mãos");
		PaymentMethod paymentMethod = PaymentMethod.getPaymentMethod(scan
				.nextInt());
		Employee employee = null;

		switch (type) {
		case 1:

			System.out.println("Salário Horário:");
			double hourPrice = scan.nextDouble();

			employee = new HourlyEmplyee(name, adress, paymentMethod,
					admissionDate, hourPrice);
			break;
		case 2:

			System.out.println("Salário Mensal");
			double salary = scan.nextDouble();

			employee = new SalaraiedEmployee(name, adress, paymentMethod,
					admissionDate, salary);
			break;
		case 3:

			System.out.println("Salário Mensal:");
			double salary2 = scan.nextDouble();
			System.out.println("Comissão:");
			double comission = scan.nextDouble();

			employee = new ComissionedEmployee(name, adress, paymentMethod,
					admissionDate, salary2, comission);
			break;

		default:
			break;
		}

		UndoRedo.doAction();
		Employee.addEmployee(employee);

	}

	public static void removeEmployeeById() {
		System.out.println("Digite o número do empregado:");
		int id = scan.nextInt();

		UndoRedo.doAction();
		Employee.removeEmployeeById(id);

	}

	public static void addTimeCard() {
		System.out.println("Digite o número do empregado");
		int id = scan.nextInt();
		Employee employee = Employee.findEmployeeById(id);

		if (employee != null) {
			if (employee instanceof HourlyEmplyee) {
				HourlyEmplyee employee1 = (HourlyEmplyee) employee;

				System.out.println("checkin:");
				String checkinStr = scan.next();
				System.out.println("checkout:");
				String checkoutStr = scan.next();

				Calendar checkin = Calendar.getInstance();
				Calendar checkout = Calendar.getInstance();

				

				try {

					checkin.setTime(scannerFormat.parse(checkinStr));

				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					checkout.setTime(scannerFormat.parse(checkoutStr));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				TimeCard currentTimeCard = new TimeCard(checkin, checkout);

				UndoRedo.doAction();
				employee1.addTimeCard(currentTimeCard);

			}
		}

	}

	public static void addSale() {
		System.out.println("Digite o id do empregado");
		int id = scan.nextInt();
		Employee employee = Employee.findEmployeeById(id);

		if (employee != null) {
			if (employee instanceof ComissionedEmployee) {
				ComissionedEmployee employee2 = (ComissionedEmployee) employee;

				System.out.println("Valor da venda:");
				double value = scan.nextDouble();
				System.out.println("Data da venda:");
				String saleDateStr = scan.nextLine();
				Calendar saleDate = Calendar.getInstance();

				try {
					saleDate.setTime(dateFormat.parse(saleDateStr));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Sale sale = new Sale(value, saleDate);

				UndoRedo.doAction();
				employee2.addSale(sale);
			}
		}
	}

	// public static void addDeduction() {
	// System.out.println("Id do empregado:");
	// int id = scan.nextInt();
	// SyndicateEmployee sEmployee = SyndicateEmployee.getByEmployeeId(id);
	//
	// if (sEmployee != null) {
	// System.out.println("Valor da taxa:");
	// double deduction = scan.nextDouble();
	// sEmployee.setDeduction(sEmployee.getDeduction() + deduction);
	// }
	// }

	public static void addDeduction() {
		System.out.println("Id do empregado:");
		int id = scan.nextInt();

		System.out.println("Valor da taxa:");
		double deduction = scan.nextDouble();

		UndoRedo.doAction();
		Employee.findEmployeeById(id).setDeduction(
				Employee.findEmployeeById(id).getDeduction() + deduction);

	}

	public static void setEmployeeName() {

		UndoRedo.doAction();
		System.out.println("Id do empregado:");
		int id = scan.nextInt();
		System.out.println("Novo nome");
		String name = scan.nextLine();
		Employee.findEmployeeById(id).setName(name);
	}

	public static void setEmplyeeAdress() {
		UndoRedo.doAction();
		System.out.println("Id do empregado:");
		int id = scan.nextInt();
		System.out.println("Novo endereço");
		String adress = scan.nextLine();
		Employee.findEmployeeById(id).setAdress(adress);
	}

	public static void changeEmployeeType() {
		UndoRedo.doAction();
		System.out.println("Id do empregado:");
		int id = scan.nextInt();

		System.out
				.println("Novo tipo \n1.Horista \n2.Assalariado \n3.Comissionado");
		int type = scan.nextInt();

		Employee employee = Employee.findEmployeeById(id);
		switch (type) {
		case 1:

			System.out.println("Salário Horário:");
			double hourPrice = scan.nextDouble();

			employee = new HourlyEmplyee(employee.getName(),
					employee.getAdress(), employee.getPaymentMethod(),
					employee.getAdmissionDate(), hourPrice);
			employee.setId(id);
			break;
		case 2:

			System.out.println("Salário Mensal");
			double salary = scan.nextDouble();

			employee = new SalaraiedEmployee(employee.getName(),
					employee.getAdress(), employee.getPaymentMethod(),
					employee.getAdmissionDate(), salary);
			employee.setId(id);

			break;
		case 3:

			System.out.println("Salário Mensal:");
			double salary2 = scan.nextDouble();
			System.out.println("Comissão:");
			double comission = scan.nextDouble();

			employee = new ComissionedEmployee(employee.getName(),
					employee.getAdress(), employee.getPaymentMethod(),
					employee.getAdmissionDate(), salary2, comission);
			employee.setId(id);
			break;

		default:
			break;
		}

	}

	public static void changePaymentMethod() {

		UndoRedo.doAction();
		System.out.println("Id do empregado:");
		int id = scan.nextInt();

		System.out
				.println("Novo Método de Pagamento: \n1.Depódito\n2.Cheque por correio\n3.Cheque em mãos");

		PaymentMethod payMethod = PaymentMethod
				.getPaymentMethod(scan.nextInt());
		Employee.findEmployeeById(id).setPaymentMethod(payMethod);

	}

	public static void setIsOnSyndicate() {

		UndoRedo.doAction();
		System.out.println("Id do empregado:");
		int id = scan.nextInt();
		System.out.println("1.Adiciona ao sindicato\n 2.Remove do sindicato");
		int value = scan.nextInt();

		if (value == 1)
			Employee.findEmployeeById(id).setOnSyndicate(true);

		if (value == 2)
			Employee.findEmployeeById(id).setOnSyndicate(false);

	}

	public static void setSyndicateId() {
		UndoRedo.doAction();
		System.out.println("Id do empregado:");
		int id = scan.nextInt();

		System.out.println("Nova identificação no sindicato:");
		int syndId = scan.nextInt();

		Employee.findEmployeeById(id).setSyndicateId(syndId);
	}

	public static void setFee() {
		UndoRedo.doAction();
		System.out.println("Id do empregado:");
		int id = scan.nextInt();

		System.out.println("Nova Taxa mensal:");
		double fee = scan.nextDouble();

		Employee.findEmployeeById(id).setMonthlyFee(fee);
	}

}
