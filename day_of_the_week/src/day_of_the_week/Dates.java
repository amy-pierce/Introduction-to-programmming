package day_of_the_week;

import java.util.Scanner;
public class Dates {
	public static final int DAYS_IN_APRIL_JUNE_SEPT_NOV = 30;
	public static final int DAYS_IN_FEBRUARY_NORMALLY = 28;
	public static final int DAYS_IN_FEBRUARY_IN_LEAP_YEAR = 29;
	public static final int DAYS_IN_MOST_MONTHS = 31;
	public static final int MAX_NUMBER_OF_MONTHS = 12;
	public static final int MIN_NUMBER_OF_MONTHS = 1;
	public static final int MIN_DAYS_IN_MONTH= 1;
	public static final int NEGATIVE_ADJUSTER=7;
	public static void main(String[] args) {
		try 
		{
			Scanner inputScanner=new Scanner(System.in);
			System.out.print("enter a date (DD/MM/YYYY)");
			inputScanner.useDelimiter("/|\r");
			int day = inputScanner.nextInt();
			int month = inputScanner.nextInt();
			int year = inputScanner.nextInt();
			if (isValidDate(day, month, year))
			{
				System.out.print(dayOfWeek(day, month, year )+", "+ day +(numberEnding(day)) 
						+monthName(month)+" "+year);
			}
			else System.out.print(day + "/" + month + "/" + year + " is not a valid date.Sorry");
			inputScanner.close();
		}
		catch (NullPointerException exception)
		{
		}
		catch (java.util.NoSuchElementException exception)
		{
			System.out.println( "No number entered.Error");
		}

	}
	public static String dayOfWeek (int day, int month, int year)
	{
		if (month == 1 | month == 2)
		{
			int dayValue = ((int)(day + Math.floor(2.6 * (((month + 9) % 12) + 1) - 0.2) + ((year % 100)-1) + Math.floor(((year % 100)-1)/4) + 
					Math.floor((year / 100)/4) - 2*(year / 100)) % 7);
		}
		int dayValue = ((int)(day + Math.floor(2.6 * (((month + 9) % 12) + 1) - 0.2) + (year % 100) + Math.floor((year % 100)/4) + 
				Math.floor((year / 100)/4) - 2*(year / 100)) % 7);
		if(dayValue<0)
		{
			dayValue=dayValue+NEGATIVE_ADJUSTER;
		}
		String dayOfTheWeek = "";
		switch(dayValue)
		{
		case 1:             	
			dayOfTheWeek = "Monday";
			break;
		case 2: 
			dayOfTheWeek = "Tuesday";
			break;
		case 3: 
			dayOfTheWeek = "Wednesday";
			break;
		case 4: 
			dayOfTheWeek = "Thursday";
			break;
		case 5: 
			dayOfTheWeek = "Friday";
			break;
		case 6: 
			dayOfTheWeek = "Saturday";
			break;
		default: 
			dayOfTheWeek = "Sunday";
			break;
		}
		return (dayOfTheWeek);
	}

	public static String numberEnding (int day)
	{
		String numberEnding ="";
		switch(day)
		{
		case 1:
		case 21:
		case 31:
			numberEnding ="st ";
			break;
		case 2:
		case 22:
			numberEnding ="nd ";
			break;
		case 3:
		case 23:
			numberEnding="rd ";
			break;
		default:
			numberEnding="th ";
			break;
		}
		return (numberEnding);
	}
		/* an alternative way to find endings is. The %100 just ensures it would work 
		 for numbers over 100 eg.213 (as a precaution so could be used for things other
		 than dates
		int dayRemainder=day%10;
		String numberEnding="";
		switch(dayRemainder)
		{
		case 1:
			if (day%100==11) numberEnding= "th";
			 numberEnding="st";
			 break;
		case 2:
			if (day%100==12) numberEnding= "th";
			numberEnding="nd";
			break;
		case 3:
			numberEnding="rd";
			if (day%100==13) numberEnding= "th";
			break;
		default:
			numberEnding="th";
			break;
		}*/


	public static String monthName (int month)
	{
		String monthName=(month==1)?"January":
						 (month==2)?"February":
				         (month==3)?"March":
				         (month==4)?"April":
			  			 (month==5)?"May":
					     (month==6)?"June":
						 (month==7)?"July":
						 (month==8)?"August":
						 (month==9)?"September":
						 (month==10)?"October":
						 (month==11)?"November":
		      			 "December";
		return (monthName);
	}
	public static boolean isValidDate (int day, int month, int year) // adapted/based on Valid date on blackboard
	{
		return((year>=0)&&(month>= MIN_NUMBER_OF_MONTHS)&&(month<= MAX_NUMBER_OF_MONTHS)&&
				(day>=MIN_DAYS_IN_MONTH)&&(day<=maxDaysInMonth(month,year)));
	}
	public static int maxDaysInMonth (int month, int year)
	{
		int numberOfDaysInMonth=0;
		switch(month)
		{
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			numberOfDaysInMonth=DAYS_IN_MOST_MONTHS;
			break;
		case 2:
			if(((year%4==0)&&(year%100!=0))||(year%400==0))
			{
				numberOfDaysInMonth=DAYS_IN_FEBRUARY_IN_LEAP_YEAR;
			}
			else numberOfDaysInMonth=DAYS_IN_FEBRUARY_NORMALLY;
			break;
		default: numberOfDaysInMonth=DAYS_IN_APRIL_JUNE_SEPT_NOV;
		}
		return numberOfDaysInMonth;

	}

}

