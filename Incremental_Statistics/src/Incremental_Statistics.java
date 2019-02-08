
import java.util.Scanner;

public class Incremental_Statistics {

	public static void main(String[] args) {

		double numberCount = 0;
		double variance = 0;
		double runningAverage = 0;

		boolean finished = false;
		while (!finished) {
			Scanner input = new Scanner(System.in);
			System.out.print("enter a number (or type 'exit')");
			if (input.hasNextDouble()) 
			{
				numberCount++;
				double enteredNumber = input.nextDouble();
				double newAverage = runningAverage +
						(enteredNumber - runningAverage) / numberCount;
				variance = ((variance * (numberCount - 1)) + 
						(enteredNumber - runningAverage) * 
						(enteredNumber - newAverage)) / numberCount;
				runningAverage = newAverage;
				System.out.println("The current average is " + newAverage + "The current variance is " + variance);
			} 
			else if (input.hasNext("exit"))
			{
				finished = true;
				System.out.println("Goodbye");
			}
			else System.out.println("not a valid number, type in digits eg.123");
		}

	}
}