
import java.util.Scanner;
import java.util.Random;

public class hi_lo_card_game {
	public static final int NEEDED_CORRECT = 4;
	public static final int NUMBER_ADJUSTER = 2;
	private static final String Jack = "Jack";
	private static final String Queen = "Queen";
	private static final String King = "King";
	private static final String Ace = "Ace";

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random generator = new Random();
		int correctCount = 0;
		int startingCard = (generator.nextInt(13) + NUMBER_ADJUSTER);
		if (startingCard >= 11) 
		{
			String faceCard = (startingCard == 11) ? Jack:
							  (startingCard == 12) ? Queen :
							  (startingCard == 13) ? King :
								Ace;
			System.out.print("The first card is " + faceCard + ".");
		}
		else System.out.print("The first card is " + startingCard + ".");
		boolean finished = false;
		while (!finished)
		{
			int nextCard = (generator.nextInt(13) + NUMBER_ADJUSTER);
			System.out.println(" Will the next card be higher, lower or equal?(or type 'exit')");
			if (((input.hasNext("lower")) && (nextCard < startingCard))
				|| ((input.hasNext("higher")) && (nextCard > startingCard))
				|| ((input.hasNext("equal")) && (nextCard == startingCard)))
			{
				correctCount++;
				if (nextCard >= 11)
				{
					String faceCard = (nextCard == 11) ? Jack:
									  (nextCard == 12) ? Queen :
									  (nextCard == 13) ? King :
									  Ace;
					System.out.println("The card was a " + faceCard + ". Congratulations, you guessed correct "
										+ correctCount + " times in a row!");
				} 
				else System.out.println("The card was a " + nextCard + ". Congratulations. you guessed correct "
										+ correctCount + " times in a row!");

				if (correctCount == NEEDED_CORRECT) 
				{
					finished = true;
					System.out.println("WOOOOO!! You have WON!!");
				}
				startingCard = nextCard;
				
			} 
			else if (((input.hasNext("lower")) && (nextCard > startingCard))
					|| ((input.hasNext("higher")) && (nextCard < startingCard))
					|| ((input.hasNext("equal")) && (nextCard != startingCard))) 
			{
				if (nextCard >= 11) 
				{
					String faceCard = (nextCard == 11) ? Jack:
									  (nextCard == 12) ? Queen :
									  (nextCard == 13) ? King :
									  Ace;
					System.out.println("The card was a " + faceCard + ". Sorry, you guessed wrong. " + "Lets start over.");
				} 
				else System.out.println("The card was a " + nextCard + ". Sorry, you guessed wrong. " + "Lets start over");
				correctCount = 0;
				int restartCard = (generator.nextInt(13) + NUMBER_ADJUSTER);
				if (restartCard >= 11)
				{
					String faceCard = (restartCard == 11) ? Jack:
									  (restartCard == 12) ? Queen :
									  (restartCard == 13) ? King :
									  Ace;
					System.out.println("Lets take " + faceCard + " as the new card.");
				} 
				else System.out.println("Lets take " + restartCard + " as the new card.");
				startingCard = restartCard;
			}
			else if (input.hasNext("exit")) 
			{
				finished = true;
				System.out.println("Goodbye");
			} 
			else
			{
				finished = false;
				System.out.println("not a valid guess, plese enter higher, lower or equal. Type 'exit' to stop the game. ");
				if (nextCard >= 11) 
				{
					correctCount=0;
					String faceCard = (nextCard == 11) ? Jack:
									  (nextCard == 12) ? Queen : 
									  (nextCard == 13) ? King :
									  Ace;
					System.out.println("So let's try this again. The number is " + faceCard);
				}
				else System.out.println("So let's try this again. The number is " + nextCard);
				startingCard=nextCard;
			}
			input = new Scanner(System.in);
			
		}
	}
}