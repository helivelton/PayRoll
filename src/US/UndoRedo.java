package US;

import java.util.List;
import java.util.Stack;

import model.Employee;

public class UndoRedo {

	private static Stack<List<Employee>> doneStack = new Stack<List<Employee>>();
	private static Stack<List<Employee>> undoStack = new Stack<List<Employee>>();
	
	
	public static void doAction()
	{
		doneStack.push(Employee.getEmployees());
		undoStack.clear();
	}
	
	public static void undoAction()
	{
		if(!undoStack.isEmpty())
		{
		undoStack.push(Employee.getEmployees());
		Employee.setEmployees(doneStack.pop());
		}else
		{
			System.out.println("Sem ações para desfazer");
		}
	}
	
	public static void redoAction()
	 {
		if(!doneStack.isEmpty())
		{
			doneStack.push(Employee.getEmployees());
			Employee.setEmployees(undoStack.pop());
			
		}else
		{
			System.out.println("Sem ações para refazer");
		}
		
	 }
	
	
}
