
public class daysOfChristmas {
	public static final int FIRST_DAY=1;
	public static final int LAST_DAY=12;
	public static void main(String[] args) {
		for(int day=FIRST_DAY; day<=LAST_DAY; day++)
		{
			System.out.print("\nOn the "+day);
			switch(day)
			{
			case 1:
				System.out.print("st");
				break;
			case 2:
				System.out.print("nd");
				break;
			case 3:
				System.out.print("rd");
				break;
			default:
				System.out.print("th");
				break;
			}
			System.out.println(" day of Christmas, my true-love gave to me");
			switch(day) {
			
			case 12:
				System.out.println("Twelve drummers drumming");
			case 11:
				System.out.println("Eleven pipers piping");
			case 10:
				System.out.println("Ten lords a leaping");
			case 9:
				System.out.println("Nine ladies dancing");
			case 8:
				System.out.println("Eight maids a milking");
			case 7:
				System.out.println("Seven swans a swimming");
			case 6:
				System.out.println("Six geese a laying");
			case 5:
				System.out.println("FIVE GOLDEN RINGS");
			case 4:
				System.out.println("Four calling bird");
			case 3:
				System.out.println("Three French hens");
			case 2:
				System.out.println("Two turtle doves, and a");
			case 1:
				System.out.println("A patridge in a pear tree");	
			}
		}
	}
}
