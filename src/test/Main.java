package test;

import java.io.ObjectInputStream.GetField;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Scanner;

import util.CalendarOperations;
import model.ComissionedEmployee;
import model.Employee;
import model.HourlyEmplyee;
import model.PaymentMethod;
import model.SalaraiedEmployee;
import model.TimeCard;
import US.PayRoll;
import US.UndoRedo;
import US.UserStore;

public class Main {

	public static void main(String[] args) {

		
//		SalaraiedEmployee emp1 = new SalaraiedEmployee("abc", "adress", PaymentMethod.DESPOSIT, Calendar.getInstance(), 1055);
//		SalaraiedEmployee emp2 = emp1.clone();
//		
//		
//		
//		
//		Calendar c1 = Calendar.getInstance();
//		Calendar c2 = c1;
//		
		
		 HourlyEmplyee employee = new HourlyEmplyee("a", "a",
		 PaymentMethod.DESPOSIT,
		 CalendarOperations.stringToCalendar("09/09/2014 01:41:11"),
		 25.7);
		
		 SalaraiedEmployee employee2 = new SalaraiedEmployee("hgb", "b",
		 PaymentMethod.DESPOSIT,
		 CalendarOperations.stringToCalendar("02/09/2014 01:41:11"),
		 2300);
		
		 TimeCard timeC = new TimeCard("18/09/2014 01:41:11",
		 "18/09/2014 21:41:11");
		 TimeCard timeC2 = new TimeCard("10/09/2014 01:41:11",
		 "10/09/2014 21:41:11");
		 TimeCard timeC3 = new TimeCard("11/09/2014 01:41:11",
		 "11/09/2014 21:41:11");
		 employee.addTimeCard(timeC);
		 employee.addTimeCard(timeC2);
		 employee.addTimeCard(timeC3);
		 employee.setOnSyndicate(true);
		 employee.setMonthlyFee(40);
		 employee.setDeduction(28.2);
		 System.out.println(employee.getLiquidSalary());
		 Employee.addEmployee(employee);
		
//		  System.out.println(employee.getLiquidSalary());
//		  System.out.println(timeC.getWorkHours());
//		  System.out.println(employee.getAdmissionDate().getTime());
//		  System.out.println(cckin.get(Calendar.FRIDAY));
//		  int teste = cckin.get(Calendar.FRIDAY);
//		  cckin.set(Calendar.DAY_OF_YEAR, teste);
//		  System.out.println(cckin.getTime());
//		  employee.pay();
//		  System.out.println(employee.getNextPayDate().getTime());
//		  employee.pay();
//		  System.out.println(employee.getNextPayDate().getTime());
		
		 String payDayStr = "19/09/2014 10:44:10";
		 Calendar payDay = Calendar.getInstance();
		 try {
		 payDay.setTime(CalendarOperations.dateFormat.parse(payDayStr));
		 } catch (ParseException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		 ;
		 employee.setNextPayDate(payDay);
		 PayRoll.printTodaysPayRoll();
		 PayRoll.printPayrollOfDate(payDay);
		
		 System.out.println(employee2.getNextPayDate().getTime());
		 employee2.pay();
		 System.out.println(employee2.getNextPayDate().getTime());
		 employee2.pay();
		 System.out.println(employee2.getNextPayDate().getTime());
		 employee2.pay();
		 System.out.println(employee2.getNextPayDate().getTime());
		 employee2.pay();
		 System.out.println(employee2.getNextPayDate().getTime());
		 employee2.pay();
		 System.out.println(employee2.getNextPayDate().getTime());
		

		while (true) {
			System.out.println("1.Adicionar Empregado");
			System.out.println("2.Remover Empregado");
			System.out.println("3.Adicionar Cartã de ponto");
			System.out.println("4.Adicionar Venda");
			System.out.println("5.Adicionar Dedução");
			System.out.println("6.Alterar nome");
			System.out.println("7.Alterar Endereço");
			System.out.println("8.Alterar Tipo");
			System.out.println("9.Alterar método de pagamento");
			System.out.println("10.Alterar inclusão no sincicato");
			System.out.println("11.Alterar ID do sindicato");
			System.out.println("12.Alterar taxa mensal");
			System.out.println("13.Gerar folha de pagamento");
			System.out.println("14.Desfazer");
			System.out.println("15.Refazer");

			Scanner scan = new Scanner(System.in);
			int opc = scan.nextInt();

			switch (opc) {
			case 1: UserStore.addEmployee();

				break;

			case 2: UserStore.removeEmployeeById();

				break;
			case 3: UserStore.addTimeCard();

				break;
			case 4: UserStore.addSale();

				break;
			case 5: UserStore.addDeduction();

				break;
			case 6: UserStore.setEmployeeName();

				break;
			case 7: UserStore.setEmplyeeAdress();

				break;
			case 8: UserStore.changeEmployeeType();

				break;
			case 9: UserStore.changePaymentMethod();

				break;
			case 10: UserStore.setIsOnSyndicate();

				break;
			case 11: UserStore.setIsOnSyndicate();

				break;
			case 12: UserStore.setFee();

				break;
			case 13: PayRoll.printTodaysPayRoll();

				break;
			case 14: UndoRedo.undoAction();

				break;
			case 15: UndoRedo.redoAction();

				break;
			case 16:
				{
//					int id = scan.nextInt();
//					if(Employee.findEmployeeById(id)!=null)
//					{
//						System.out.println(Employee.findEmployeeById(id).getName());
//					}
					
					for(Employee emp: Employee.getEmployees())
					{
						System.out.println(emp.getName());
					}
					
				}
				break;

			default:
				break;
			}
		}
	}

}
