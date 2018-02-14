
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.Scanner;
 
 public class Calendar {
		static int weekday = 0;
		static boolean leap = false;
		static boolean checkSpace = false;
		static int loopMax = 0;
		static	int year;
		static	String day;
		public static void main (String[] arg){
		Scanner input = new Scanner (System.in);
		System.out.println("Enter year: ");
		year = input.nextInt();
		System.out.println("Enter the day the first of January fell on: ");
		day = input.next();
		//System.out.println(CheckLeapYear(year));
		PrintCalendar();
		input.close();
	}
	
	public static void PrintCalendar () {
		weekday = CheckDayOfWeek(year,1);                    // Variable is used to print spaces to start output on the right day of the week
		for(int i = 1; i <= 12; i++) {
			weekday = CheckDayOfWeek(year,i);
			//System.out.println(weekday+"  "+i);
			System.out.printf("%-15s %-5s\n\n", Month.of(i).name(), year);
			System.out.printf("%3s %s %s %s %s %s %s\n","Su", "Mo", "Tu", "We", "Th", "Fr", "Sa");
			loopMax = NumberDaysMonth(year, i);             //  loop variable -> Function call returns #of days in a month 
			for(int k = 1; k <= loopMax; k++) {
				if (checkSpace == false && weekday != 7) {
				char[] spaces = new char[weekday*3];        // 1 char space*3  = %3s 
				System.out.print(new String(spaces));       // meaning something like printf("%" + weekday+"s")
				checkSpace = true;                          // checkSpace -> false by default, once spaces are printed is set to true, 
				}                                           // set to false before the next month is printed
				System.out.printf("%3s",k);
				if ((k + weekday) % 7 == 0) {              // next line every +7 day
					System.out.println();}
			}
				System.out.println();
				checkSpace = false;
		}
	}
	
	// Returns number of days for a loop variable loopMax
	public static int NumberDaysMonth (int year, int month) {
		YearMonth yearMonthObject = YearMonth.of(year, month);
		int daysInMonth = yearMonthObject.lengthOfMonth();
		return daysInMonth;
	}
	
	// Returns a day of the week as an Integer 
	public static int CheckDayOfWeek (int year, int month){
		LocalDate localDate = LocalDate.of(year, month, 1);  
		java.time.DayOfWeek dayOfWeek = java.time.DayOfWeek.from(localDate);  
		return dayOfWeek.getValue(); 
	}
	
	// Returns Boolean true - a leap year/false - not a leap year 
	public static boolean CheckLeapYear(int year) {
        if  ((year % 4 == 0) && (year % 100 != 0)) return true;
        if  (year % 400 == 0) return true;
        return false;
		}
 	}
