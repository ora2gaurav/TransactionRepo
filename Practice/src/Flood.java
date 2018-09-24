import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Flood {
	
	final static int INF = Integer.MAX_VALUE;

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
			int [][] floydArr=floydWarshall(arrParam, treeParamListType2.size(),treeParamListType2);
			calculateEachTurn(treeParamListType2, floydArr,arrParam);

		} else {
			System.out.println(treeParamListType2.iterator().next().treeNumber);
		}

	}

	private static void calculateEachTurn(List<param> treeParamListType2, int[][] arrParam, int[][] arrParam2) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < treeParamListType2.size(); i++) {
			int cnt = 0;
			for (int j = 0; j < treeParamListType2.size(); j++) {

				if (arrParam[i][j] == INF||arrParam[i][j] <0) {
					
						break;
					}
				 else {
					 
					if(checkCapacityOfNeighbours(i,j,arrParam,arrParam2,treeParamListType2)){
						cnt++;
					}
					else {break;}
				}
			}
		
			if (cnt == treeParamListType2.size()) {
				result.add(treeParamListType2.get(i).treeNumber);
			}
		}
		if (result.isEmpty())
			System.out.println("-1");
		else {
			for (Integer a : result)
				System.out.print(a + " ");
		}

	}

	
		private static boolean checkCapacityOfNeighbours(int i, int j, int[][] arrParam, int[][] arrParam2, List<param> treeParamListType2) {

			if(arrParam2[i][j]==1) {return true;}
			else {
				int cost=arrParam[i][j];
				for(int k=0;k<arrParam.length;k++) {
					if(cost<=treeParamListType2.get(k).treeThreshold) {
						return true;
					}
				}
				return false;
			}
		
	}

		private static void fetchAdjacencyMatrix(List<param> treeParamListType2, double c, int[][] arrParam) {
		for (int i = 0; i < treeParamListType2.size(); i++) {
			int mC= treeParamListType2.get(i).monkeyCount;
			for (int j = 0; j < treeParamListType2.size(); j++) {
				
				if (i == j) {
					arrParam[i][j] = 0;
				} else {
					double x = calculateEucleadinDistance(treeParamListType2.get(i), treeParamListType2.get(j));
					if (x <= c) {
						arrParam[i][j] =mC;

					} else
						arrParam[i][j] = INF;
				}

			}

		}
	}
	
	static int[][] floydWarshall(int graph[][],int v, List<param> treeParamListType2) {
		int dist[][] = new int[v][v];
		int i, j, k;

		for (i = 0; i < v; i++)
			for (j = 0; j < v; j++)
				dist[i][j] = graph[i][j];

		for (k = 0; k < v; k++) {
			// Pick all vertices as source one by one
			for (i = 0; i < v; i++) {
				for (j = 0; j < v; j++) {

					if (dist[i][k] + dist[k][j] < dist[i][j]&&(treeParamListType2.get(i).monkeyCount+treeParamListType2.get(k).monkeyCount<=treeParamListType2.get(k).treeThreshold))
						dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}

		
		return dist;
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
