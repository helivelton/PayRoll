package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarOperations {
	public static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"dd/MM/yyyyHH:mm:ss");

	public static Calendar stringToCalendar(String date) throws ParseException {
		Calendar calendarDate = Calendar.getInstance();
		try {
			calendarDate.setTime(dateFormat.parse(date));
		} catch (ParseException e) {
			throw e;
			// e.printStackTrace();
		}

		return calendarDate;
	}

	// public static List<Employee> copyEmployeeList(List<Employee> lista)
	// {
	// List<Employee> copy = new ArrayList<Employee>();
	// {
	// for(Employee employee: Employee.getEmployees())
	// {
	//
	// }
	// }
	// }
}
