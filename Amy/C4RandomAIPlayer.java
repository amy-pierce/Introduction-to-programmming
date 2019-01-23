import java.util.Random;

public class C4RandomAIPlayer extends ConnectPlayer {
	private char piece;

	C4RandomAIPlayer(char piece) {
		super();
		this.piece = piece;
	}

	@Override
	public int chooseColumn() {
		Random generator = new Random();
		int column = generator.nextInt(7);
		return column;
	}

	public char getPiece() {
		return piece;
	}
}
