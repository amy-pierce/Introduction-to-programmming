
/* SELF ASSESSMENT 

1. ResolveBet

I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7: 7].
Comment:I correctly defined ResolveBet that takes the bet type(String) and the wallet object and has a void return type
My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8:s].
Comment:
My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5: 5].
Comment:my program makes sure that the bet amount is less than cash in wallet by calling wallet.get
My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15:15 ]..
Comment:my program creates and rolls the 3 dice objects and makes a total variable of the sum of all the top-sides when dice are rolled
My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20: 20].
Comment:my program determines the amount won by comparing the bet type with the total and the bet type with the 3 dice faces
My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10:10 ].
Comment:my program will print if the user wins or loses and adds or removes the appropriate winnings to the wallet

2. Main

I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15:15 ]
Comment:I ask the user for the amount of cash they have, create a wallet object and put the cash in
My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5: 5]
Comment:my program loops through continuously until the user runs out of money or enters quit
I ask the user to enter any of the four bet types or quit [Mark out of 5:5 ].
Comment:I ask the user to enter which  type of bet they want to make or to type quit
My program calls resolveBet for each bet type entered [Mark out of 5: 5].
Comment:for each bet type entered, my program calls resolve bet
At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5:5]
Comment:my program will print the total amount of money the user wins or loses depending on whether or not they have more money at the end than when they stared

 Total Mark out of 100 (Add all the previous marks):100
*/
import java.util.Scanner;

public class chuckaluck {
	public static void main(String[] args) {
		Wallet wallet = new Wallet();
		boolean finished = false;
		boolean start = false;
		double money;
		String bet;
		while (!start) {
			System.out.print("Enter how much money you have in your wallet (or type 'quit')");
			Scanner input = new Scanner(System.in);
			if (input.hasNextInt()) {
				money = input.nextDouble();
				wallet.put(money);
				System.out.println(wallet.toString());
				while (!finished) {
					Scanner inputBet = new Scanner(System.in);
					if (wallet.check() <= 0) {
						System.out.print("Your wallet is empty. Goodbye");
						start=true; 
						finished=true;
					} else {
						System.out.println("which bet would you like to make?(or type'quit')");
						if (input.hasNext("quit") || wallet.check() <= 0) {
							if (wallet.check() <= 0) {
								System.out.println("You are out of money");
							}
							if (wallet.check() > money) {
								double totalWinnings = (wallet.check() - money);
								System.out.println("you won a total of:" + totalWinnings);
							} else if (wallet.check() < money) {
								double totalLoss = (money - wallet.check());
								System.out.println("you lost a total of: -" + totalLoss);
							} else if (wallet.check() == money) {
								System.out.println("You didn't win or lose any money");
							}
							System.out.println("Goodbye");
							finished = true;
							start = true;
						} else if (input.hasNext("high") || input.hasNext("low") || input.hasNext("triple")
								|| input.hasNext("field")) {
							bet = input.next();
							ResolveBet(bet, wallet);
						} else {
							System.err.println("Invalid bet.Please enter 'high', 'low, 'field' or 'triple'");
							input.next();
						}
					}
				}
			} else if (input.hasNext("quit")) {
				System.out.println("You gave up before you started!!");
				start = true;
			} else {
				System.err.println(" (Please eneter an in eg.123)");

			}
		}

	}

	public static void ResolveBet(String bet, Wallet wallet) {
		Dice dice = new Dice();
		int firstDice = (dice.roll());
		int secondDice = (dice.roll());
		int thirdDice = (dice.roll());
		int total = (firstDice + secondDice + thirdDice);
		boolean finished = false;
		Scanner input = new Scanner(System.in);
		while (!finished) {
			System.out.println(wallet.toString());
			System.out.print("How much do you wish to bet?");
			double betAmount = input.nextDouble();
			if (wallet.get(betAmount) == true) {
				if (bet.equals("high") && total > 10 && (firstDice != secondDice) && (secondDice != thirdDice)
						&& firstDice != thirdDice) {
					System.out.println("WINNER");
					double winnings = betAmount + (1 * betAmount);
					wallet.put(winnings);
					System.out.println(wallet.toString());
					finished = true;
				} else if (bet.equals("low") && total < 11
						&& ((firstDice != secondDice) && (secondDice != thirdDice) && (firstDice != thirdDice))) {
					System.out.println("WINNER");
					double winnings = betAmount + (1 * betAmount);
					wallet.put(winnings);
					System.out.println(wallet.toString());
					finished = true;
				} else if (bet.equals("triple") && (firstDice == secondDice) && (secondDice == thirdDice)
						&& (thirdDice == firstDice) && firstDice != 1 && firstDice != 6) {
					System.out.println("WINNER");
					double winnings = betAmount + (30 * betAmount);
					wallet.put(winnings);
					System.out.println(wallet.toString());
					finished = true;
				} else if (bet.equals("field") && ((total < 8) || (total > 12))) {
					System.out.println("WINNER");
					double winnings = betAmount + (1 * betAmount);
					wallet.put(winnings);
					System.out.println(wallet.toString());

					finished = true;
				} else {
					System.out.println("loser");
					System.out.println(wallet.toString());

					finished = true;
				}

			} else {
				System.err.print("You don't have enough in your wallet to make that bet");
				finished = false;
			}
		}
	}
}
