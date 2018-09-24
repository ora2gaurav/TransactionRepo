import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Sudoku {
	private static final int SIZE = 9;

	public int emptyRow = 0;
	public int emptyCol = 0;

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 0, 0, 0, 2, 6, 0, 7, 0, 1 }, { 6, 8, 0, 0, 7, 0, 0, 9, 0 },
				{ 1, 9, 0, 0, 0, 4, 5, 0, 0 }, { 8, 2, 0, 1, 0, 0, 0, 4, 0 }, { 0, 0, 4, 6, 0, 2, 9, 0, 0 },
				{ 0, 5, 0, 0, 0, 3, 0, 2, 8 }, { 0, 0, 9, 3, 0, 0, 0, 7, 4 }, { 0, 4, 0, 0, 5, 0, 0, 3, 6 },
				{ 7, 0, 3, 0, 1, 8, 0, 0, 0 } };
				
				

				int[][] arr2 = new int[][] { { 0, 0, 0, 6, 0, 0, 4, 0, 0 }, { 7, 0, 0, 0, 0, 3, 6, 0, 0 },
						{ 0, 0, 0, 0, 9, 1, 0, 8, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 5, 0, 1, 8, 0, 0, 0, 3 },
						{ 0, 0, 0, 3, 0, 6, 0, 4, 5 }, { 0, 4, 0, 2, 0, 0, 0, 6, 0 }, { 9, 0, 3, 0, 0, 0, 0, 0, 0 },
						{ 0, 2, 0, 0, 0, 0, 1, 0, 0 } };
						
						int[][] arr3 = new int[][] { { 0, 0, 5, 0, 2, 0, 0, 8, 0 }, { 0, 9, 0, 0, 0, 1, 0, 0, 4 },
							{ 0, 0, 0, 6, 0, 5, 1, 0, 2 }, { 0, 0, 3, 1, 0, 6, 0, 0, 0 }, { 0, 2, 0, 0, 8, 0, 0, 1, 0 },
							{ 0, 0, 0, 3, 0, 2, 7, 0, 0 }, { 8, 0, 9, 2, 0, 4, 0, 0, 0 }, { 4, 0, 0, 9, 0, 0, 0, 6, 0 },
							{ 0, 6, 0, 0, 7, 0, 4, 0, 0 } };
		Sudoku su = findEmptyRowAndCol(arr3);

		solveSudokuUtil(arr3, su);
	}

	private static void solveSudokuUtil(int[][] arr, Sudoku su) {
		if (su == null) {
			printArr(arr);
			
			return;
		}

		int r = su.emptyRow;
		int c = su.emptyCol;

		for (int j = 1; j <= SIZE; j++) {
			arr[r][c] = j;
			Boolean checker = checkForConflict(arr, r, c);
			if (!checker) {
				arr[r][c]=0;
				continue;
			} else {
				Sudoku su1 = findEmptyRowAndCol(arr);
				solveSudokuUtil(arr, su1);
			}
			
			arr[r][c] =0;	
		}
		

	}

	private static void printArr(int[][] arr) {
		for (int i =0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
			System.out.print(arr[i][j]+" ");
			}
			System.out.println();
			}
	}

	private static Sudoku findEmptyRowAndCol(int[][] arr) {
		Sudoku sudoku = new Sudoku();
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (arr[i][j] == 0) {
					sudoku.emptyCol = j;
					sudoku.emptyRow = i;
					return sudoku;
				}
			}
		}
		return null;
	}

	private static Boolean checkForConflict(int[][] arr, int row, int col) {
		Set<Integer> setOfRowNumbers = new HashSet<>();
		ArrayList<Integer> listofRowNumber = new ArrayList<Integer>();
		Set<Integer> setOfColNumbers = new HashSet<>();
		ArrayList<Integer> listofColNumber = new ArrayList<Integer>();
		// TRAVERSE HORIZONTALLY and vertic
		for (int i = 0; i < SIZE; i++) {
			if (arr[row][i] != 0) {
				setOfRowNumbers.add(arr[row][i]);
				listofRowNumber.add(arr[row][i]);
			}
			if (arr[i][col] != 0) {
				setOfColNumbers.add(arr[i][col]);
				listofColNumber.add(arr[i][col]);
			}
			if (setOfRowNumbers.size() != listofRowNumber.size() || setOfColNumbers.size() != listofColNumber.size()) {
				return Boolean.FALSE;
			}

		}
		listofRowNumber.clear();
		setOfRowNumbers.clear();
		// getting the sub array for the element
		int r1 = 0;
		int r2 = 0;
		int c1 = 0;
		int c2 = 0;
		if (row < 3) {
			r1 = 0;
			r2 = 3;
		} else if (row < 6) {
			r1 = 3;
			r2 = 6;
		} else if (row < 9) {
			r1 = 6;
			r2 = 9;
		}
		if (col < 3) {
			c1 = 0;
			c2 = 3;
		} else if (col < 6) {
			c1 = 3;
			c2 = 6;
		} else if (col < 9) {
			c1 = 6;
			c2 = 9;
		}
		listofRowNumber.clear();
		setOfRowNumbers.clear();
		// checking the inner array
		for (int i = r1; i < r2; i++) {
			for (int j = c1; j < c2; j++) {
				if (arr[i][j] != 0) {
					listofRowNumber.add(arr[i][j]);
					setOfRowNumbers.add(arr[i][j]);
				}
				if (setOfRowNumbers.size() != listofRowNumber.size()) {
					return Boolean.FALSE;
				}

			}
		}

		return Boolean.TRUE;
	}

}
