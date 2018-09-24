

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Problem1 {

	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseRun = Integer.parseInt(br.readLine());
		while (testCaseRun != 0) {
			int n = Integer.parseInt(br.readLine());
			String[] plates = br.readLine().split(" ");

			int turns = Integer.parseInt(br.readLine());
			int index = 0;
			while (turns > 0) {
				String[] numbs = br.readLine().split(" ");
				int a = Integer.parseInt(numbs[0]);
				int b = Integer.parseInt(numbs[1]);
				switch (a) {
				case 1:
					index = (index + b) % n;
					break;

				case 2:
					index = (index - b);
					if (index < 0) {
						index = n + index;
					}
					break;

				case 3:

					System.out.println(plates[(index + b) % n]);
					break;
				default:
					break;
				}
				turns--;

			}
			testCaseRun--;
		}
	}

	
	

}