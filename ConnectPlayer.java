
public abstract class ConnectPlayer {

	private char piece;

	ConnectPlayer() {
	}

	public abstract int chooseColumn();

	public char getPiece() {
		return piece;
	}
}
