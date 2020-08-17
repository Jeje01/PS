/**
 * 오늘 날짜 - B5
 * 구현, Date
 * 14,644 kb
 * 128 ms
 */
 
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
	public static void main(String[] args) {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, 9);
		DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
		System.out.println(df.format(cal.getTime()));
	}
}
