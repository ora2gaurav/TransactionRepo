
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;



public class flood5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double C = sc.nextDouble();
		List<param> treeParamList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			param treeParam = new param(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), i);
			treeParamList.add(treeParam);
		}
		checkEucleadianDistanceForSingle(treeParamList,C);
		sc.close();
	}



	private static void checkEucleadianDistanceForSingle(List<param> treeParamListType2, double c) {

		int[][] arrParam = new int[treeParamListType2.size()][treeParamListType2.size()];
			fetchAdjacencyMatrix(treeParamListType2, c, arrParam);
			calculateEachTurn(treeParamListType2, arrParam);

		

	}

	
	private static void calculateEachTurn(List<param> treeParamListType2, int[][] arrParam) {
		List<Integer> result = new ArrayList<>();
		int []monkeyCountArr=new int [treeParamListType2.size()];
		int []treeThresholdCountArr=new int [treeParamListType2.size()];
		for(int i = 0; i < treeParamListType2.size(); i++) {
			monkeyCountArr[i]=treeParamListType2.get(i).monkeyCount;
			treeThresholdCountArr[i]=treeParamListType2.get(i).treeThreshold;
			
		}
		int [][] NewarrParam=new int [treeParamListType2.size()][treeParamListType2.size()]; 
		for (int i = 0; i < treeParamListType2.size(); i++) {
			
			for(int ai=0; ai<arrParam.length; ai++)
				  for(int j=0; j<arrParam[i].length; j++)
				  {	  NewarrParam[ai][j]=arrParam[ai][j];}
			
			
		Boolean a=breadthFirstSearchForAllNodes(i,
				Arrays.copyOf(monkeyCountArr, monkeyCountArr.length),Arrays.copyOf(treeThresholdCountArr, treeThresholdCountArr.length),NewarrParam);
				if(a)
				result.add(treeParamListType2.get(i).treeNumber);
			
		}
		
		if (result.size()==0)
			System.out.println("-1");
		else {
			Collections.sort(result);
			for (Integer a : result)
				System.out.print(a + " ");
		}

	}

	private static Boolean breadthFirstSearchForAllNodes(int u, int[] monkeyCount, int[] thresholdvalue,
			int[][] adjacentMatrix) {

		int levelArray[]=new int [monkeyCount.length];
		Map<Integer,List<Integer>> mapOfLevels=new TreeMap<>(Collections.reverseOrder());
				if(!calculateLevelArray(adjacentMatrix,u,levelArray,mapOfLevels,monkeyCount)) {
					return false;
				}
		for(Map.Entry<Integer, List<Integer>>  mapEntry:mapOfLevels.entrySet()) {
			
			List<Integer> nodesLevel=mapEntry.getValue();
			LinkedList<Integer> reprocessList=new LinkedList<>();
			Integer currentLevel=mapEntry.getKey();
			if(currentLevel==1) {
				return true;
			}
			
			for(int k=0;k<nodesLevel.size();k++) {
				if(monkeyCount[nodesLevel.get(k)]>thresholdvalue[nodesLevel.get(k)]) { return false;}
			
				
					Boolean saa= checkForUpperThresholdValues(nodesLevel.get(k),adjacentMatrix,currentLevel,monkeyCount,thresholdvalue,mapOfLevels,reprocessList);
					if(!saa) return false;
			
					
			
			}
			while(reprocessList.size()!=0) {
				int k=reprocessList.poll();
				Boolean saa= checkForUpperThresholdValues(k,adjacentMatrix,currentLevel,monkeyCount,thresholdvalue,mapOfLevels,reprocessList);
				if(!saa) return false;
			}
			
		}
		
		return true;

	}

	
	private static Boolean checkForUpperThresholdValues(int k, int[][] adjacentMatrix, Integer currentLevel,
			int[] monkeyCount, int[] thresholdvalue, Map<Integer, List<Integer>> mapOfLevels, List<Integer> reprocessList) {
		int prevLevel=currentLevel-1;
		List<Integer> prevLevelNode=mapOfLevels.get(prevLevel);
		int mC=monkeyCount[k];
		int tV=thresholdvalue[k];
		if(mC<=tV) {
			if(prevLevel==1) return true;
		for(int i=0;i<prevLevelNode.size();i++) {
			if(adjacentMatrix[k][prevLevelNode.get(i)]==1) {
				int prev=prevLevelNode.get(i);
				int monkeyCountOfPrevLevel=monkeyCount[prev];
				int tvPrev=thresholdvalue[prev];
				int monkeyPossible=tvPrev>monkeyCountOfPrevLevel?min(mC, tvPrev-monkeyCountOfPrevLevel):0;
				mC-=monkeyPossible;
				tV-=monkeyPossible;
				monkeyCount[prevLevelNode.get(i)]+=monkeyPossible;
			}
			
		}
		}
		
		if(mC!=0) {
			thresholdvalue[k]-=mC;monkeyCount[k]-=mC;
			return combineSameLevelNodes(k,currentLevel,adjacentMatrix,monkeyCount,thresholdvalue,mapOfLevels,reprocessList);
			
		}
		if(mC==0) {thresholdvalue[k]-=monkeyCount[k];monkeyCount[k]=0;return true;}
		
		return false;
	}

	private static boolean combineSameLevelNodes(int k, Integer currentLevel, int[][] adjacentMatrix, int[] monkeyCount,
			int[] thresholdvalue, Map<Integer, List<Integer>> mapOfLevels, List<Integer> reprocessList) {
		List<Integer> levelSame=mapOfLevels.get(currentLevel);
		int mC=monkeyCount[k];
		for(Integer i:levelSame) {
			
		
			int n = adjacentMatrix[k][i];
			if (i != k && n == 1&&mC>0&&thresholdvalue[i]>0) {
				int monkeyPossible=thresholdvalue[i]>monkeyCount[i]?min(mC, thresholdvalue[i]-monkeyCount[i]):0;
				monkeyCount[i]+=monkeyPossible;
				mC-=monkeyPossible;
				if(monkeyPossible>0)
				reprocessList.add(i);
			}
			
		
	}
		if(mC==0) {thresholdvalue[k]=-1;monkeyCount[k]=0;return true;}
		return false;
		
	}

	
	
	private static Boolean calculateLevelArray(int[][] adjacentMatrix, int u, int[] levelArray,Map<Integer,List<Integer>> mapOfLevels, int[] monkeyCount) {
		boolean visited[] = new boolean[levelArray.length];
		int s;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		levelArray[u]=1;
		visited[u]=true;
		queue.add(u);
		while (queue.size() != 0) {
			s = queue.poll();
			int[] arrForSource = adjacentMatrix[s];
			for (int i = 0; i < arrForSource.length; i++) {
				int n = arrForSource[i];
				if (i != s && (!visited[i]) && n == 1) {
					levelArray[i]=levelArray[s]+1;
					queue.add(i);
					visited[i]=true;
				}
			
			}
		}
		for(int i=0;i<levelArray.length;i++) {
			if(mapOfLevels.containsKey(levelArray[i])) {
				mapOfLevels.get(levelArray[i]).add(i);
			}
			else{
				mapOfLevels.put(levelArray[i], new ArrayList<Integer>(Arrays.asList(i)));
			}
		}
		Boolean chk=Boolean.TRUE;
		for(int i=0;i<visited.length;i++) {
			if(monkeyCount[i]!=0)
			chk=chk&visited[i];
		}
return chk;
		
	}

	

	private static int min(int mC, int i) {
		
		return mC<i?mC:i;
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

	public static double calculateEucleadinDistance(param p1, param p2) {
		return Math.sqrt(Math.pow((p2.xPoint - p1.xPoint), 2) + Math.pow((p2.yPoint - p1.yPoint), 2));
	}

}

