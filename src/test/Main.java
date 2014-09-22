package test;

import java.util.Scanner;

import facade.Facade;

public class Main {

	public static void main(String[] args) {

		while (true) {
			System.out.println("1.Adicionar Empregado");
			System.out.println("2.Remover Empregado");
			System.out.println("3.Adicionar Cartã de ponto");
			System.out.println("4.Adicionar Venda");
			System.out.println("5.Adicionar Dedução");
			System.out.println("6.Alterar Atributos");
			System.out.println("7.Gerar folha de pagamento");
			System.out.println("8.Desfazer");
			System.out.println("9.Refazer");

			int opc = 0;
			while (true) {
				try {
					opc = new Scanner(System.in).nextInt();
					if (opc < 1 || opc > 9)
						throw new Exception();
					break;
				} catch (Exception e) {
					System.out.println("Escolha uma opção válida!");
				}
			}

			switch (opc) {
			case 1:
				Facade.addEmployee();

				break;

			case 2:
				Facade.removeEmployeeById();

				break;
			case 3:
				Facade.addTimeCard();

				break;
			case 4:
				Facade.addSale();

				break;
			case 5:
				Facade.addDeduction();

				break;
			case 6:
				Facade.chageEmployeeAttribute();

				break;
			case 7:
				Facade.todayPayRoll();

				break;
			case 8:
				Facade.undo();

				break;
			case 9:
				Facade.redo();

				break;

			default:
				break;
			}
		}
	}
}
