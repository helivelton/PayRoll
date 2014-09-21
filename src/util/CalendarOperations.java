package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Employee;

public class CalendarOperations {
	public static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm:ss");
	
	public static Calendar stringToCalendar(String date)
	{
		Calendar calendarDate = Calendar.getInstance();
		try {
			calendarDate.setTime(dateFormat.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return calendarDate;
	}
	
//	public static List<Employee> copyEmployeeList(List<Employee> lista)
//	{
//		List<Employee> copy = new ArrayList<Employee>();
//		{
//			for(Employee employee: Employee.getEmployees())
//			{
//				
//			}
//		}
//	}
}
