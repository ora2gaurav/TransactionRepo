import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class param {

	int xPoint;
	int yPoint;
	int monkeyCount;
	int treeThreshold;
	int treeNumber;

	public param(int xPoint, int yPoint, int monkeyCount, int treeThreshold, int treeNumber) {
		super();
		this.xPoint = xPoint;
		this.yPoint = yPoint;
		this.monkeyCount = monkeyCount;
		this.treeThreshold = treeThreshold;
		this.treeNumber = treeNumber;
	}

	public param(param param) {
		super();
		this.xPoint = param.xPoint;
		this.yPoint = param.yPoint;
		this.monkeyCount = param.monkeyCount;
		this.treeThreshold = param.treeThreshold;
		this.treeNumber = param.treeNumber;
	}

}

public class FloodInJungleCD2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double C = sc.nextDouble();
		List<param> treeParamList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			param treeParam = new param(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), i);
			treeParamList.add(treeParam);
		}
		List<param> treeParamListType1 = new ArrayList<>();
		List<param> treeParamListType2 = new ArrayList<>();
		divideListinTwo(treeParamListType1, treeParamListType2, treeParamList);
		processConditionsForResult(treeParamListType1, treeParamListType2, C);
		sc.close();
	}

	private static void processConditionsForResult(List<param> treeParamListType1, List<param> treeParamListType2,
			double c) {
		if (treeParamListType1.size() > 1 || treeParamListType2.isEmpty()) {
			System.out.println("-1");
		} else if (treeParamListType2.size() >= 1 && treeParamListType1.isEmpty()) {
			checkEucleadianDistanceForSingle(treeParamListType2, c);
		} else if (treeParamListType2.size() >= 1 && treeParamListType1.size() == 1) {
			checkEucleadianDistanceForDouble(treeParamListType1.get(0), treeParamListType2, c);
		}

	}

	private static void checkEucleadianDistanceForDouble(param paramSingleType1, List<param> treeParamListType2,
			double c) {
		for (param paramObj : treeParamListType2) {
			double x = calculateEucleadinDistance(paramSingleType1, paramObj);
			if (x > c) {
				System.out.println("-1");
				return;
			}

		}
		System.out.println(paramSingleType1.treeNumber);

	}

	private static void checkEucleadianDistanceForSingle(List<param> treeParamListType2, double c) {

		int[][] arrParam = new int[treeParamListType2.size()][treeParamListType2.size()];

		if (treeParamListType2.size() > 1) {
			fetchAdjacencyMatrix(treeParamListType2, c, arrParam);
			calculateEachTurn(treeParamListType2, arrParam);

		} else {
			System.out.println(treeParamListType2.iterator().next().treeNumber);
		}

	}

	private static void calculateEachTurn(List<param> treeParamListType2, int[][] arrParam) {
		List<Integer> result = new ArrayList<>();
		int[] monkeyCountArr = new int[treeParamListType2.size()];
		int[] treeThresholdCountArr = new int[treeParamListType2.size()];
		for (int i = 0; i < treeParamListType2.size(); i++) {
			monkeyCountArr[i] = treeParamListType2.get(i).monkeyCount;
			treeThresholdCountArr[i] = treeParamListType2.get(i).treeThreshold;

		}
		for (int i = 0; i < treeParamListType2.size(); i++) {

			Boolean a = breadthFirstSearchForAllNodes(i, Arrays.copyOf(monkeyCountArr, monkeyCountArr.length),
					Arrays.copyOf(treeThresholdCountArr, treeThresholdCountArr.length), arrParam);
			if (a)
				result.add(treeParamListType2.get(i).treeNumber);

		}
		Collections.sort(result);
		if (result.isEmpty())
			System.out.println("-1");
		else {
			for (Integer a : result)
				System.out.print(a + " ");
		}

	}

	private static Boolean breadthFirstSearchForAllNodes(int u, int[] monkeyCount, int[] thresholdvalue,
			int[][] adjacentMatrix) {

		boolean visited[] = new boolean[monkeyCount.length];
		int levelArray[] = new int[monkeyCount.length];
		boolean isThreholdCalucalated[] = new boolean[monkeyCount.length];
		levelArray[u] = 1;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[u] = true;
		queue.add(u);
		int s = u;
		while (queue.size() != 0) {
			s = queue.poll();
			int[] arrForSource = adjacentMatrix[s];
			calculateNewThreshold(s, thresholdvalue, u, arrForSource, visited, monkeyCount, levelArray,
					isThreholdCalucalated, adjacentMatrix);
			for (int i = 0; i < arrForSource.length; i++) {
				int n = arrForSource[i];
				if (i != s && (!visited[i]) && n == 1) {
					if (s != u) {
						int thresholdOfs = thresholdvalue[s];
						int monkeyCountOfS = monkeyCount[s];
						int monkeyCountofI = monkeyCount[i];
						int monkeyPossible = 0;
						if (monkeyCountofI + monkeyCountOfS <= thresholdOfs) {
							visited[i] = true;
							queue.add(i);
							monkeyPossible = monkeyCountofI;
						} else {
							monkeyPossible = min(thresholdOfs - monkeyCountOfS, monkeyCountofI);
						}
						// monkeyCount[s] += monkeyPossible;
						thresholdvalue[s] -= monkeyPossible;
						monkeyCount[i] -= monkeyPossible;
						thresholdvalue[i] -= monkeyPossible;

					} else {

						thresholdvalue[i] -= monkeyCount[i];
						monkeyCount[i] -= monkeyCount[i];
						queue.add(i);
						visited[i] = true;
					}
					if (levelArray[i] == 0)
						levelArray[i] = levelArray[s] + 1;

				}
			}

		}
		Boolean chk = Boolean.TRUE;
		for (int i = 0; i < visited.length; i++) {
			chk = chk & visited[i];
		}
		return chk;

	}

	private static void calculateNewThreshold(int s, int[] thresholdvalue, int u, int[] arrForSource, boolean[] visited,
			int[] monkeyCount, int[] levelArray, boolean[] isThreholdCalucalated, int[][] adjacentMatrix) {
		if (arrForSource[u] != 1 && !isThreholdCalucalated[s]) {
			int sum = 0;
			for (int i = 0; i < arrForSource.length; i++) {

				if (arrForSource[i] == 1 && visited[i] && i != s) {
					if ((thresholdvalue[i]) >= (thresholdvalue[s] - sum)) {
						thresholdvalue[i] -= (thresholdvalue[s] - sum);
						sum = thresholdvalue[s];
						break;
					} else {
						sum += thresholdvalue[i];
						thresholdvalue[i] = 0;
					}
				}
			}
			thresholdvalue[s] = sum;

		}
		isThreholdCalucalated[s] = true;
	}

	private static int min(int mC, int i) {

		return mC < i ? mC : i;
	}

	private static void fetchAdjacencyMatrix(List<param> treeParamListType2, double c, int[][] arrParam) {
		for (int i = 0; i < treeParamListType2.size(); i++) {
			for (int j = 0; j < treeParamListType2.size(); j++) {
				if (i == j) {
					arrParam[i][j] = 1;
				} else {
					double x = calculateEucleadinDistance(treeParamListType2.get(i), treeParamListType2.get(j));
					if (x <= c) {
						arrParam[i][j] = 1;

					} else
						arrParam[i][j] = 0;
				}

			}

		}
	}

	private static void divideListinTwo(List<param> treeParamListType1, List<param> treeParamListType2,
			List<param> treeParamList) {
		for (param paramObj : treeParamList) {
			if (paramObj.monkeyCount > paramObj.treeThreshold) {
				treeParamListType1.add(paramObj);
			} else {
				treeParamListType2.add(paramObj);
			}
		}

	}

	public static double calculateEucleadinDistance(param p1, param p2) {
		return Math.sqrt(Math.pow((p1.xPoint - p2.xPoint), 2) + Math.pow((p1.yPoint - p2.yPoint), 2));
	}

}
