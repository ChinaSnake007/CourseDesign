package CourseDesign;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 使用正则表达式对各个变量进行校验
 * 
 * */
public class ValidationUtil {
	public static boolean validateTestTimeFormat(String memotime) {
		String regx = "([123]\\d{3}-(([0][1-9])|([1][0-2]))-(([0][1-9])|([12]\\d)|([3][01])))";
		Pattern pattern = Pattern.compile(regx);
		Matcher matcher = pattern.matcher(memotime);
		if(!matcher.matches()) {
			return false;
		}else {
			String[] times = memotime.split("-");
			Integer year = Integer.parseInt(times[0]);
			Integer month = Integer.parseInt(times[1]);
			Integer day = Integer.parseInt(times[2]);
			GregorianCalendar calendar = new GregorianCalendar();
			if(calendar.isLeapYear(year)&&(month==2)&&(day>29)) {
				return false;
			}else if((!calendar.isLeapYear(year))&&(month==2)&&(day>28)) {
				return false;
			}else {
				switch(month) {
				case 4:	
				case 6:
				case 9:
					if(day>30) {
						return false;
					}else {
						return true;
					}
				default:
					return true;
				}
			}
			
			
		}
	}
	
	public static boolean validateStudentClassFormat(String StudentClass) {
		String regx="\\d\\d\\s";
		Pattern pattern = Pattern.compile(regx);
		Matcher matcher = pattern.matcher(StudentClass);
		if(!matcher.matches()) {
			return true;
		}else {
			return true;
		}
	}
	
	
	
	
}
