package US;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import model.ComissionedEmployee;
import model.Employee;
import model.HourlyEmplyee;
import model.SalaraiedEmployee;

public class UndoRedo {

	private static Stack<List<Employee>> doneStack = new Stack<List<Employee>>();
	private static Stack<List<Employee>> undoStack = new Stack<List<Employee>>();

	public static void doAction() {

		
		doneStack.push(getCloneEmployeesList());
		undoStack.clear();
	}

	public static void undoAction() {
		if (!doneStack.isEmpty()) {
			undoStack.push(getCloneEmployeesList());
			Employee.setEmployees(doneStack.pop());
		} else {
			System.out.println("Sem ações para desfazer");
		}
	}

	public static void redoAction() {
		if (!undoStack.isEmpty()) {
			doneStack.push(getCloneEmployeesList());
			Employee.setEmployees(undoStack.pop());

		} else {
			System.out.println("Sem ações para refazer");
		}

	}

	public static List<Employee> getCloneEmployeesList() {
		List<Employee> clonedList = new ArrayList<Employee>();

		for (Employee emp : Employee.getEmployees()) {
			Employee emp2 = null;
			if (emp instanceof HourlyEmplyee) {
				emp2 = ((HourlyEmplyee) emp).clone();
			}
			if (emp instanceof ComissionedEmployee) {
				emp2 = ((ComissionedEmployee) emp).clone();
			}
			if (emp instanceof SalaraiedEmployee) {
				emp2 = ((SalaraiedEmployee) emp).clone();
			}

			clonedList.add(emp2);

		}
		return clonedList;
	}

}
