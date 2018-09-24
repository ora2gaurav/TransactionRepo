import java.util.Scanner;

public class NQUENN {

	public static void main(String[] args) {
		int N;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				arr[i][j] = 0;
		}

		populateNQueen(arr, 0);
		
		
	}

	private static void populateNQueen(int[][] arr, int curr) {
	if(curr==arr.length) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		
		}
		System.exit(0);
		return;
	}
		
		for(int i=0;i<arr.length;i++) {
		arr[curr][i]=1;
		Boolean checker=checkForConflict(arr, curr, i);
		if(!checker) {
			arr[curr][i]=0;
		}
		else {
			populateNQueen(arr,curr+1);
		}
		
		arr[curr][i]=0;
	}
		
	}

	private static Boolean checkForConflict(int[][] arr, int row, int col) {
		/* Check for horizontal */
		Boolean check = Boolean.TRUE;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i][col];
		}
		if (sum > 1)
			return Boolean.FALSE;
		/* check for diagonal */
		// upper left
		int i = row, j = col;
		sum = 0;
		while (i >= 0 && j >= 0) {
			sum += arr[i][j];
			i = i - 1;
			j = j - 1;
		}
		if (sum > 1)
			return Boolean.FALSE;
		// lower left
		sum = 0;
		i = row;
		j = col;
		while (i < arr.length && j < arr.length) {
			sum += arr[i][j];
			i = i + 1;
			j = j + 1;
		}
		if (sum > 1)
			return Boolean.FALSE;
		// upper right r-- c++
		sum = 0;
		i = row;
		j = col;
		while (i < arr.length && j < arr.length && i >= 0 && j >= 0) {
			sum += arr[i][j];
			i--;
			j++;
		}
		if (sum > 1)
			return Boolean.FALSE;
		// lower right opp
		sum = 0;
		i = row;
		j = col;
		while (i < arr.length && j < arr.length && i >= 0 && j >= 0) {
			sum += arr[i][j];
			i++;
			j--;
		}
		if (sum > 1)
			return Boolean.FALSE;
		return check;
	}

}
