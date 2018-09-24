
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

		int j = 0;
		for (int i = 0; i < N; i++) {
			if (isSafe(board, i, col)) {

				board[i][col] = 1;

				if (solveNQUtil(board, col + 1))
					return true;

				board[i][col] = 0; // BACKTRACK
			}
			

		}
		return false;

	}

	private boolean isSafe(int[][] board, int i, int col) {
		
		//check vertical
		for(int i=0;i<N;i++) {
			if(board[][])
		}
		return true;
	}

	void printSolution(int[][] board) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; i < N; j++)
				System.out.println(board[i][j] + " ");
			System.out.println("");
		}
	}
}
