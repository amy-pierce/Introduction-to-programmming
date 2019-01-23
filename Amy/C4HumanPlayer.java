import java.util.Scanner;

public class C4HumanPlayer extends ConnectPlayer {
	private char piece;

	C4HumanPlayer(char piece) {
		super();
		this.piece = piece;
	}

	@Override
	public int chooseColumn() {
		System.out.println("Enter a column (0-6) to drop a piece");
		Scanner inputScanner = new Scanner(System.in);
		int column = inputScanner.nextInt();
		return column;

	}

	public char getPiece() {
		return piece;
	}
}
