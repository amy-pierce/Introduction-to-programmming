

import java.util.Scanner;
public class High_scores {
	public static void main(String[] args) {
		boolean finishedGettingLength=false;
		boolean finishedGettingScore=false;

		Scanner inputScanner=new Scanner(System.in);
		System.out.println("Please enter how many High Scores you want the list to hold(or type'quit'");
		while(!finishedGettingLength) {
			if (inputScanner.hasNextInt()) 
			{
				int amountOfHighScores=inputScanner.nextInt();
				int[]highScoresArray=new int[ amountOfHighScores];
				initialiseHighScores(highScoresArray);
				System.out.print("\rOh, looks like you have a fresh start. Here's the starting list:\r");
				printHighScore(highScoresArray);
				System.out.println("\rEnter the first Score you would like to add to the list. ");
				while(!finishedGettingScore) {
					if (inputScanner.hasNextInt()) 
					{
						System.out.print("\rThe running list of HighScores include: ");
						int nextHighScore=inputScanner.nextInt();
						if(higherThan(highScoresArray, nextHighScore)) {
							insertScore(highScoresArray, nextHighScore);}
						printHighScore(highScoresArray);
						System.out.println("\rEnter the next Score you would like to add to the list. ");
						finishedGettingScore=false;
					}
					else if(inputScanner.hasNext("quit"))
					{
						finishedGettingScore=true;
						finishedGettingLength=true;
						System.out.println("\rThe final list of High Scores include:");
						printHighScore(highScoresArray);
					}
					else
					{
						System.err.printf ( "\rError, please enter number(eg.123)or type 'quit'");
						System.out.print("\rThe running list of HighScores is still: ");
						printHighScore(highScoresArray);
						System.out.print("\rPlease re-enter the next Score you would like to add to the list. ");
						inputScanner.next();
						finishedGettingScore=false;
					}
				}
			}
			else if(inputScanner.hasNext("quit"))
			{
				finishedGettingLength=true;
				System.out.println("\rAw you're giving up already, what a pity");
			}
			else
			{
				System.err.print ( "\nError, please enter number(eg.123)or type 'quit' ");
				inputScanner.next();
				finishedGettingLength=false;
			}
		}
	}
	public static int[] initialiseHighScores(int []arrayToIntialise) {
		for(int index=0;index<arrayToIntialise.length;index++)
		{
			arrayToIntialise[index]=0;
		}
		return (arrayToIntialise);
	}
	public static boolean higherThan(int []arrayPassed, int scoreToCheck) {
		boolean isHigher=false;
		for(int index=0; index<arrayPassed.length; index++){
			if (scoreToCheck>arrayPassed[index])
			{
				isHigher=true;
			}
		}
		return isHigher;
	}

	public static void insertScore (int []arrayToUpdate, int newHighScore) {
		arrayToUpdate[arrayToUpdate.length-1]=newHighScore;
		for (int index=arrayToUpdate.length-1; index>=0; index--)
		{
			int maximumIndex = index;
			for (int index2=index-1; index2>=0; index2--)
			{
				if (arrayToUpdate[index2] < arrayToUpdate[maximumIndex])
					maximumIndex = index2;
			}
			int temp = arrayToUpdate[index];
			arrayToUpdate[index] = arrayToUpdate[maximumIndex];
			arrayToUpdate[maximumIndex] = temp;
		}
	}
	public static void printHighScore (int []arrayToPrint) {
		for(int index=0; index < arrayToPrint.length; index++)
		{
			System.out.print(arrayToPrint[index] + " ");
		}
	}
}

