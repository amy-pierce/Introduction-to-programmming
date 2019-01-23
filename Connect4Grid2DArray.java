

public  class Connect4Grid2DArray implements Connect4Grid {

	public static final char BLANK = ' ';
	public char[][] grid = new char[6][7];

	@Override
	public void emptyGrid() {
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++) {
				grid[row][column] = BLANK;
			}
		}
	}


	public String toString() {
		String Grid = null;
		Grid+=" 1   2   3   4   5   6   7";
		Grid+="\n "+grid[0][0] + " | " + grid[0][1] + " | " + grid[0][2] + " | " + grid[0][3] + " | " + grid[0][4]
				+ " | " + grid[0][5] + " | " + grid[0][6];
		Grid+="\n --------------------------";
		Grid+="\n " + grid[1][0] + " | " + grid[1][1] + " | " + grid[1][2] + " | " + grid[1][3] + " | "
				+ grid[1][4] + " | " + grid[1][5] + " | " + grid[1][6];
		Grid+="\n --------------------------";
		Grid+="\n " + grid[2][0] + " | " + grid[2][1] + " | " + grid[2][2] + " | " + grid[2][3] + " | "
				+ grid[2][4] + " | " + grid[2][5] + " | " + grid[2][6];
		Grid+="\n --------------------------";
		Grid+= "\n " + grid[3][0] + " | " + grid[3][1] + " | " + grid[3][2] + " | " + grid[3][3] + " | "
				+ grid[3][4] + " | " + grid[3][5] + " | " + grid[3][6];
		Grid+="\n --------------------------";
		Grid+="\n " + grid[4][0] + " | " + grid[4][1] + " | " + grid[4][2] + " | " + grid[4][3] + " | "
				+ grid[4][4] + " | " + grid[4][5] + " | " + grid[4][6];
		Grid+="\n --------------------------";
		Grid+= "\n " + grid[5][0] + " | " + grid[5][1] + " | " + grid[5][2] + " | " + grid[5][3] + " | "
				+ grid[5][4] + " | " + grid[5][5] + " | " + grid[5][6];
		return Grid;
	}

	@Override
	public boolean isValidColumn(int column) {
		boolean isValid = true;
		if (column > 6 || column < 0) {
			isValid = false;
		}
		return isValid;
	}

	@Override
	public boolean isColumnFull(int column) {
		boolean fullGrid = true;
		if (grid[0][column] == ' ') {
			fullGrid = false;
		}
		return fullGrid;
	}

	@Override
	public void dropPiece(ConnectPlayer player, int column) {
		boolean moveMade = false;
		for (int row = 0; row < grid.length - 1; row++) {
			if (grid[row + 1][column] != ' ') {
				grid[row][column] = player.getPiece();
				moveMade = true;
				break;
			}
		}
		if (!moveMade) {
			grid[5][column] = player.getPiece();
			
		}

	}

	@Override
	public boolean didLastPieceConnect4() {
		boolean fourInARow = false;
		boolean fourAcross = checkAcross();
		boolean fourDown = checkDown();
		boolean fourDiagonal = checkDiagonal();
		if (fourAcross || fourDown || fourDiagonal) {
			fourInARow = true;
		}
		System.out.println(fourInARow);
		return fourInARow;
	}

	public boolean checkAcross() {
		boolean fourAcross = false;

		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length - 3; column++) {
				if (grid[row][column] == grid[row][column + 1] && grid[row][column + 1] == grid[row][column + 2]
						&& grid[row][column + 2] == grid[row][column + 3] && grid[row][column] != ' ') {
					fourAcross = true;
					break;
				}

			}
		}
		return fourAcross;
	}

	public boolean checkDown() {
		boolean fourDown = false;
		for (int row = 0; row < grid.length - 3; row++) {
			for (int column = 0; column < grid[row].length; column++) {
				if (grid[row][column] == grid[row + 1][column] && grid[row + 1][column] == grid[row + 2][column]
						&& grid[row + 2][column] == grid[row + 3][column] && grid[row][column] != ' ') {
					fourDown = true;
					break;
				}
			}
		}
		return fourDown;
	}

	public boolean checkDiagonal() {
		boolean fourDiagonal = false;
		for (int row = 0; row < grid.length - 3; row++) {
			for (int column = 0; column < grid[row].length - 3; column++) {
				if (grid[row][column] == grid[row + 1][column + 1]
						&& grid[row + 1][column + 1] == grid[row + 2][column + 2]
						&& grid[row + 2][column + 2] == grid[row + 3][column + 3] && grid[row][column] != ' ') {
					fourDiagonal = true;
					break;
				}
			}
		}
		for (int row = 0; row < grid.length - 3; row++) {
			for (int column = 6; column >= 3; column--) {
				if (grid[row][column] == grid[row + 1][column - 1]
						&& grid[row + 1][column - 1] == grid[row + 2][column - 2]
						&& grid[row + 2][column - 2] == grid[row + 3][column - 3] && grid[row][column] != ' ') {
					fourDiagonal = true;
					break;
				}
			}
		}
		return fourDiagonal;
	}

	@Override
	public boolean isGridFull() {
		boolean full = true;
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++) {
				if (grid[row][column] == ' ') {
					full = false;
					break;
				}
			}
		}
		return false;
	}


}
