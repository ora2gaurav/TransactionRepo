
public class FLoydWarhall {
	final static int INF = Integer.MAX_VALUE, V = 4;

	void floydWarshall(int graph[][],int v) {
		int dist[][] = new int[V][V];
		int i, j, k;

		for (i = 0; i < V; i++)
			for (j = 0; j < V; j++)
				dist[i][j] = graph[i][j];

		for (k = 0; k < V; k++) {
			// Pick all vertices as source one by one
			for (i = 0; i < V; i++) {
				for (j = 0; j < V; j++) {

					if (dist[i][k] + dist[k][j] < dist[i][j])
						dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}

		printSolution(dist);
	}

	void printSolution(int dist[][]) {
		System.out.println("Following matrix shows the shortest " + "distances between every pair of vertices");
		for (int i = 0; i < V; ++i) {
			for (int j = 0; j < V; ++j) {
				if (dist[i][j] == INF)
					System.out.print("INF ");
				else
					System.out.print(dist[i][j] + "   ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int graph[][] = { { 0, INF, 6, INF },
				{ INF, 0, 10, 10 }, { 8, 8, 0, 8 }, { INF, 7, 7, 0 } };
		FLoydWarhall a = new FLoydWarhall();

		// Print the solution
		//a.floydWarshall(graph);
	}
}
