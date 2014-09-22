package facade;


import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import util.CalendarOperations;
import util.UndoRedo;
import model.CommissionedEmployee;
import model.Employee;
import model.HourlyEmployee;
import model.PayRoll;
import model.PaymentMethod;
import model.SalariedEmployee;
import model.Sale;
import model.TimeCard;

public class Facade {
	private static Scanner scan = new Scanner(System.in);

	public static void addEmployee() {

		Employee employee = null;

		System.out.println("---- Adicionar empregado ----");
		System.out.println("Nome:");
		String name = scan.nextLine();
		System.out.println("Endereço:");
		String adress = scan.nextLine();
		System.out.println("Tipo \n1.Horista \n2.Assalariado \n3.Comissionado");

		int type = 0;
		while (true) {
			try {
				type = scan.nextInt();
				if (type < 1 || type > 3) {
					throw new InputMismatchException();
				}
				break;
			} catch (InputMismatchException e) {
				// TODO: handle exception
				System.out.println("Digite um número válido 1-3");
				scan.nextLine();

			}

		}

		Calendar admissionDate = null;
		while (true) {
			try {
				System.out.println("Data de admissão:");
				scan.nextLine();
				System.out.println("Dia:");
				String date = scan.nextLine();
				System.out.println("Mes:");
				String month = scan.nextLine();
				System.out.println("Ano:");
				String year = scan.nextLine();
				String admDate = date + "/" + month + "/" + year + "00:00:01";

				if (Integer.parseInt(date) > 31 || Integer.parseInt(month) > 12) {
					throw new InputMismatchException();
				}

				admissionDate = CalendarOperations.stringToCalendar(admDate);
				break;
			} catch (Exception e) {
				System.out.println("Data digitada de maneira incorreta.");
				System.out.println("Tente novamente:");
				scan.nextLine();
			}
		}

		PaymentMethod paymentMethod = null;

		while (true) {
			try {
				System.out.println("Método de recebimento:");
				System.out
						.println("1.Depósito\n2.Cheque pelos correios\n3.Cheque em mãos");

				int pm = scan.nextInt();
				if (pm < 1 || pm > 3)
					throw new InputMismatchException();
				paymentMethod = PaymentMethod.getPaymentMethod(pm);
				break;
			} catch (Exception e) {
				System.out
						.println("Tente novamente, digite o número correspondente a uma das opções.");
				scan.nextLine();
			}
		}

		switch (type) {
		case 1:

			double hourPrice = 0;
			while (true) {

				try {
					System.out.println("Salário Horário:");
					hourPrice = scan.nextDouble();

					if (hourPrice <= 0)
						throw new Exception();
					break;
				} catch (Exception e) {
					System.out
							.println("Digite apenas um número real maior que 0");
					scan.nextLine();
				}
			}

			employee = new HourlyEmployee(name, adress, paymentMethod,
					admissionDate, hourPrice);
			break;
		case 2:

			double salary = 0;
			while (true) {

				try {
					System.out.println("Salário Mensal");
					salary = scan.nextDouble();

					if (salary <= 0)
						throw new Exception();
					break;
				} catch (Exception e) {
					System.out.println("Digite um número real maior que 0.");
					scan.nextLine();
				}
			}

			employee = new SalariedEmployee(name, adress, paymentMethod,
					admissionDate, salary);
			break;
		case 3:

			double salary2 = 0;
			while (true) {

				try {
					System.out.println("Salário Mensal");
					salary2 = scan.nextDouble();

					if (salary2 <= 0)
						throw new Exception();
					break;
				} catch (Exception e) {
					System.out.println("Digite um número real maior que 0.");
					scan.nextLine();
				}
			}

			double comission = 0;
			while (true) {
				try {
					System.out.println("Comissão:");
					comission = scan.nextDouble();

					if (comission <= 0)
						throw new Exception();
					break;
				} catch (Exception e) {
					System.out.println("Digite um número real maior que 0.");
					scan.nextLine();
				}

			}

			employee = new CommissionedEmployee(name, adress, paymentMethod,
					admissionDate, salary2, comission);
			break;

		default:
			break;
		}

		UndoRedo.doAction();

		Employee.addEmployee(employee);

	}

	public static void removeEmployeeById() {

		try {
			System.out.println("Digite o número do empregado:");
			int id = scan.nextInt();

			if (Employee.findEmployeeById(id).equals(null))
				throw new Exception();

			UndoRedo.doAction();
			Employee.removeEmployeeById(id);
		} catch (Exception e) {
			if (e instanceof InputMismatchException) {
				System.out
						.println("O código do empregado é um número inteiro.");
			} else
				System.out.println("Empregado não encontrado.");

			scan.nextLine();
		}

	}

	public static void addTimeCard() {

		int id;
		try {
			System.out.println("Digite o número do empregado");
			id = scan.nextInt();
			if (Employee.findEmployeeById(id).equals(null))
				throw new Exception();
		} catch (Exception e) {
			if (e instanceof InputMismatchException) {
				System.out.println("Código digitado incorretamente");
			} else
				System.out.println("Empregado não encontrado.");
			return;

		}

		Employee employee = Employee.findEmployeeById(id);

		if (employee != null) {
			if (employee instanceof HourlyEmployee) {
				HourlyEmployee employee1 = (HourlyEmployee) employee;

				Calendar checkin = null;
				Calendar checkout = null;

				while (true) {
					try {
						System.out.println("Checkin:");
						scan.nextLine();
						System.out.println("Dia:");
						String date = scan.nextLine();
						System.out.println("Mes:");
						String month = scan.nextLine();
						System.out.println("Ano:");
						String year = scan.nextLine();
						System.out.println("Horas:");
						String hours = scan.nextLine();
						System.out.println("Minutos:");
						String minutes = scan.nextLine();
						String admDate = date + "/" + month + "/" + year
								+ hours + ":" + minutes + ":" + "00";

						if (Integer.parseInt(date) > 31
								|| Integer.parseInt(month) > 12
								|| Integer.parseInt(hours) > 23
								|| Integer.parseInt(minutes) > 59) {
							throw new InputMismatchException();
						}

						checkin = CalendarOperations.stringToCalendar(admDate);
						break;
					} catch (Exception e) {
						System.out
								.println("Data digitada de maneira incorreta.");
						System.out.println("Tente novamente:");
						scan.nextLine();
					}
				}

				while (true) {
					try {
						System.out.println("Checkout:");
						scan.nextLine();
						System.out.println("Dia:");
						String date = scan.nextLine();
						System.out.println("Mes:");
						String month = scan.nextLine();
						System.out.println("Ano:");
						String year = scan.nextLine();
						System.out.println("Horas:");
						String hours = scan.nextLine();
						System.out.println("Minutos:");
						String minutes = scan.nextLine();
						String admDate = date + "/" + month + "/" + year
								+ hours + ":" + minutes + ":" + "00";

						if (Integer.parseInt(date) > 31
								|| Integer.parseInt(month) > 12
								|| Integer.parseInt(hours) > 23
								|| Integer.parseInt(minutes) > 59) {
							throw new InputMismatchException();
						}

						checkout = CalendarOperations.stringToCalendar(admDate);
						break;
					} catch (Exception e) {
						System.out
								.println("Data digitada de maneira incorreta.");
						System.out.println("Tente novamente:");
						scan.nextLine();
					}
				}

				TimeCard currentTimeCard = new TimeCard(checkin, checkout);

				UndoRedo.doAction();
				employee1.addTimeCard(currentTimeCard);

			}
		}

	}

	public static void addSale() {
		int id;
		try {
			System.out.println("Digite o número do empregado");
			id = scan.nextInt();
			if (Employee.findEmployeeById(id).equals(null))
				throw new Exception();
		} catch (Exception e) {
			if (e instanceof InputMismatchException) {
				System.out.println("Código digitado incorretamente");
			} else
				System.out.println("Empregado não encontrado.");
			return;

		}

		Employee employee = Employee.findEmployeeById(id);

		double value = 0;
		if (employee != null) {
			if (employee instanceof CommissionedEmployee) {
				CommissionedEmployee employee2 = (CommissionedEmployee) employee;

				while (true) {
					try {
						System.out.println("Valor da venda:");
						value = scan.nextDouble();
						if (value <= 0)
							throw new Exception();
						break;
					} catch (Exception e) {
						System.out
								.println("Digite apenas um número real maior que zero.");
						scan.nextLine();
					}
				}

				Calendar saleDate = null;
				while (true) {
					try {
						System.out.println("Data da venda:");
						scan.nextLine();
						System.out.println("Dia:");
						String date = scan.nextLine();
						System.out.println("Mes:");
						String month = scan.nextLine();
						System.out.println("Ano:");
						String year = scan.nextLine();
						System.out.println("Horas:");
						String hours = scan.nextLine();
						System.out.println("Minutos:");
						String minutes = scan.nextLine();
						String admDate = date + "/" + month + "/" + year
								+ hours + ":" + minutes + ":" + "00";

						if (Integer.parseInt(date) > 31
								|| Integer.parseInt(month) > 12
								|| Integer.parseInt(hours) > 23
								|| Integer.parseInt(minutes) > 59) {
							throw new InputMismatchException();
						}

						saleDate = CalendarOperations.stringToCalendar(admDate);
						break;
					} catch (Exception e) {
						System.out
								.println("Data digitada de maneira incorreta.");
						System.out.println("Tente novamente:");
						scan.nextLine();
					}
				}

				Sale sale = new Sale(value, saleDate);

				UndoRedo.doAction();
				employee2.addSale(sale);
			}
		}
	}

	public static void addDeduction() {
		int id;
		try {
			System.out.println("Digite o número do empregado");
			id = scan.nextInt();
			if (Employee.findEmployeeById(id).equals(null))
				throw new Exception();
		} catch (Exception e) {
			if (e instanceof InputMismatchException) {
				System.out.println("Código digitado incorretamente");
			} else
				System.out.println("Empregado não encontrado.");
			return;

		}

		double deduction = 0;

		while (true) {
			try {
				System.out.println("Valor da taxa:");
				deduction = scan.nextDouble();
				if (deduction <= 0)
					throw new Exception();
				break;
			} catch (Exception e) {
				System.out
						.println("Digite apenas um número real maior que zero.");
				scan.nextLine();

			}
		}

		UndoRedo.doAction();
		Employee.findEmployeeById(id).setDeduction(
				Employee.findEmployeeById(id).getDeduction() + deduction);

	}

	public static void chageEmployeeAttribute() {
		int id;
		try {
			System.out.println("Digite o número do empregado");
			id = scan.nextInt();
			if (Employee.findEmployeeById(id).equals(null))
				throw new Exception();
		} catch (Exception e) {
			if (e instanceof InputMismatchException) {
				System.out.println("Código digitado incorretamente");
			} else
				System.out.println("Empregado não encontrado.");
			return;

		}

		System.out.println("Selecione um atributo para modificar:");
		System.out.println("1.Nome");
		System.out.println("2.Endereço");
		System.out.println("3.Tipo");
		System.out.println("4.Método de Pagamento");
		System.out.println("5.Pertence ao Sindicato");
		System.out.println("6.ID do Sindicato");
		System.out.println("7.Taxa Sindical");

		int key = 0;
		try {
			key = scan.nextInt();
		} catch (Exception e) {
			System.out.println("opção inválida!");
			return;
		}

		UndoRedo.doAction();
		switch (key) {
		case 1:
			try {
				System.out.println("Novo nome:");
				String name = scan.nextLine();
				Employee.findEmployeeById(id).setName(name);
			} catch (Exception e) {
				// TODO: handle exception
			}

			break;
		case 2:
			try {
				System.out.println("Novo endereço:");
				String adress = scan.nextLine();
				Employee.findEmployeeById(id).setAdress(adress);
			} catch (Exception e) {
				// TODO: handle exception
			}

			break;
		case 3:
			changeEmployeeType(id);

			break;
		case 4:
			PaymentMethod paymentMethod = null;

			while (true) {
				try {
					System.out.println("Método de recebimento:");
					System.out
							.println("1.Depósito\n2.Cheque pelos correios\n3.Cheque em mãos");

					int pm = scan.nextInt();
					if (pm < 1 || pm > 3)
						throw new Exception();
					paymentMethod = PaymentMethod.getPaymentMethod(pm);
					Employee.findEmployeeById(id).setPaymentMethod(
							paymentMethod);
					break;
				} catch (Exception e) {
					System.out
							.println("Tente novamente, digite o número correspondente a uma das opções.");
					scan.nextLine();
				}
			}

			break;
		case 5:

			while (true) {
				try {
					System.out
							.println("1.Adiciona ao sindicato\n 2.Remove do sindicato");
					int value = scan.nextInt();

					if (value == 1)
						Employee.findEmployeeById(id).setOnSyndicate(true);

					if (value == 2)
						Employee.findEmployeeById(id).setOnSyndicate(false);
					if (value != 1 || value != 0)
						throw new Exception();
					break;
				} catch (Exception e) {
					System.out.println("Digite apenas uma das duas opções");
				}
			}
			break;
		case 6:

			int syndId = 0;
			while (true) {
				try {
					System.out.println("Nova identificação no sindicato:");
					syndId = scan.nextInt();
					break;
				} catch (Exception e) {
					System.out.println("Digite um númeor inteiro.");
					scan.nextLine();
				}
			}

			Employee.findEmployeeById(id).setSyndicateId(syndId);

			break;
		case 7:
			while (true) {
				try {
					System.out.println("Nova Taxa mensal:");
					double fee = scan.nextDouble();
					if (fee <= 0)
						throw new Exception();
					Employee.findEmployeeById(id).setMonthlyFee(fee);
					break;
				} catch (Exception e) {
					System.out.println("Digite um número real mairo que zero.");
				}
			}

			break;

		default:
			break;
		}

	}

	public static void changeEmployeeType(int id) {

		int type = 0;
		while (true) {
			try {
				System.out
						.println("Novo tipo \n1.Horista \n2.Assalariado \n3.Comissionado");
				type = scan.nextInt();
				if (type < 1 || type > 3)
					throw new Exception();
				break;
			} catch (Exception e) {
				System.out.println("Digite um número válido 1-3");
				scan.nextLine();
			}
		}

		Employee employee = Employee.findEmployeeById(id);
		switch (type) {
		case 1:

			double hourPrice = 0;
			while (true) {
				try {
					System.out.println("Salário Horário:");
					hourPrice = scan.nextDouble();
					if (hourPrice <= 0)
						throw new Exception();
					break;
				} catch (Exception e) {
					System.out.println("Digite um número real maior que zero.");
				}
			}
			employee = new HourlyEmployee(employee.getName(),
					employee.getAdress(), employee.getPaymentMethod(),
					employee.getAdmissionDate(), hourPrice);
			employee.setId(id);
			break;
		case 2:
			double salary = 0;

			while (true) {
				try {
					System.out.println("Salário Mensal:");
					salary = scan.nextDouble();
					if (salary <= 0)
						throw new Exception();
					break;
				} catch (Exception e) {
					System.out.println("Digite um número real maior que zero.");
				}
			}

			employee = new SalariedEmployee(employee.getName(),
					employee.getAdress(), employee.getPaymentMethod(),
					employee.getAdmissionDate(), salary);
			employee.setId(id);

			break;
		case 3:

			double salary2 = 0;

			while (true) {
				try {
					System.out.println("Salário Mensal:");
					salary2 = scan.nextDouble();
					if (salary2 <= 0)
						throw new Exception();
					break;
				} catch (Exception e) {
					System.out.println("Digite um número real maior que zero.");
				}
			}
			System.out.println("Comissão:");
			double comission = 0;

			while (true) {
				try {
					System.out.println("Comissão:");
					comission = scan.nextDouble();
					if (comission <= 0)
						throw new Exception();
					break;
				} catch (Exception e) {
					System.out.println("Digite um número real maior que zero.");
				}
			}

			employee = new CommissionedEmployee(employee.getName(),
					employee.getAdress(), employee.getPaymentMethod(),
					employee.getAdmissionDate(), salary2, comission);
			employee.setId(id);
			break;

		default:
			break;
		}

	}
	
	public static void todayPayRoll()
	{
		UndoRedo.doAction();
		PayRoll.printTodaysPayRoll();
	}
	
	public static void undo()
	{
		UndoRedo.undoAction();
	}
	
	public static void redo()
	{
		UndoRedo.redoAction();
	}
}
