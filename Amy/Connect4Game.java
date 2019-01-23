/* SELF ASSESSMENT

 Connect4Game class (35 marks)35
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to play/quit inside a loop. If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 2. the two players are initialised - must specify the type to be ConnectPlayer, and 3. the game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win. 
Comment:the class creates references to Connect4Grid and to Connect4Players. It repeatedly asks if user wants to play or quit. If play selected, the program creates a 2D array grid in Connect4Grid2DArray sing the interface, the human and computer player are initialised and the game starts. The user is asked to select a column to drop their piece in and is called to check if that is a valid move by clling methods in the interface. If it is valid then the program checks if the player has won.                                                                                                                                                                                                                                                   

 Connect4Grid interface (10 marks)10
I define all 7 methods within this interface.
Comment: all 7 methods are defined in the interface

 Connect4Grid2DArray class (25 marks) 25
 My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid. It provides as implementation of the method to check whether the column to drop the piece is full. It provides as implementation of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.
Comment: the class implements the conect4FGrid interface and it creates the grid iusing a 2d array which checks if column is valid place to drop piece or if column is full. It has a method which will drop the piece if column is valid and a method to check for a win

 ConnectPlayer abstract class (10 marks)5
My class provides at lest one non-abstract method and at least one abstract method. 
Comment:the class has abstract  method

 C4HumanPlayer class  (10 marks)10
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides the Human player functionality.
Comment:  class extends ConnectPlayer and overRides the abstract methods. an it handles the human player

 C4RandomAIPlayer class  (10 marks)10
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides AI player functionality. 
Comment: class extends ConnectPlayer and overrides abstract cmethods and handles the computer player.

Total Marks out of 100:95

*/
import java.util.Scanner;

public class Connect4Game {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("please enter 'play' to start, if not enter 'quit'");
		String response = input.next();
		if (response.equals("quit")) {
			System.out.print("Goodbye");
		} else if (response.equals("play")) {
			Connect4Grid2DArray board = new Connect4Grid2DArray();

			board.emptyGrid();

			System.out.println(board.toString());
			board.didLastPieceConnect4();
			C4HumanPlayer user = new C4HumanPlayer('x');
			C4RandomAIPlayer computer = new C4RandomAIPlayer('o');
			ConnectPlayer currentPlayer = user;
			boolean finished = false;
			while (!finished) {
				int columnChosen = currentPlayer.chooseColumn();
				if (board.isValidColumn(columnChosen) && !board.isColumnFull(columnChosen)) {
					board.dropPiece(currentPlayer, columnChosen);
					if (board.didLastPieceConnect4()) {
						finished = true;
						System.out.println(board.toString());
						System.out.println("winner");
						break;
					} else if (board.isGridFull()) {
						finished = true;
						System.out.println(board.toString());
						System.out.println("Draw");
						break;
					} else {
						if (currentPlayer.equals(user)) {
							currentPlayer = computer;
						} else {
							currentPlayer = user;
						}
						System.out.println(board.toString());
					}
				}

			}

		}
	}
}
