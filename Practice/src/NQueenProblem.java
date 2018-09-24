
public class NQueenProblem {

	private final static int N = 4;

	public static void main(String[] args) {

		NQueenProblem Queen = new NQueenProblem();
		Queen.solveNQ();

	}

	void solveNQ() {

		int board[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

		if (solveNQUtil(board, 0) == false) {
			System.out.print("Solution does not exist");

		}

		printSolution(board);

	}

	boolean solveNQUtil(int[][] board, int col) {

		return false;
	}

	void printSolution(int[][] board) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; i < N; j++)
				System.out.println(board[i][j] + " ");
			System.out.println("");
		}
	}
}
