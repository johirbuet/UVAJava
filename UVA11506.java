import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UVA11506 {
	static boolean [] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int M = sc.nextInt();
			int W = sc.nextInt();
			if( M == 0 && W ==0) break;
			int[][] graph = new int[M + M ][M + M ];
			visited = new boolean[2*M];
			graph[0][M] = graph[M - 1] [M + M -1] = Integer.MAX_VALUE;
			for (int i = 0; i < M - 2; i++) {
				int m = sc.nextInt() - 1;
				int c = sc.nextInt();
				graph[m][M + m] = c;
			}
			for (int i = 0; i < W; i++) {
				int u = sc.nextInt() - 1;
				int v = sc.nextInt() - 1;
				int c = sc.nextInt();
				graph[u + M][v] = graph[v + M][u] = c;
			}
			int f = fordfulkerson(graph, 0, 2*M - 1);
			System.out.println(f);
		}
		sc.close();
	}
	
	public static int augpath(int [][] graph,int s,int t,int mf) {
		visited[s] = true;
		if(s == t) return mf;
		for(int i =0; i < graph.length;i++) {
			if(!visited[i] && graph[s][i] > 0) {
				int flow = augpath(graph, i, t, mf < graph[s][i]?mf: graph[s][i]);
				if(flow > 0) {
					graph[s][i] -= flow;
					graph[i][s] += flow;
					return flow;
				}
			}
		}
		return 0;
	}
	public static int fordfulkerson(int[][] graph, int s, int t) {
		int ret = 0;
		while(true) {
			for(int i =0; i< graph.length;i++) visited[i] = false;
			int flow = augpath(graph, s, t, Integer.MAX_VALUE);
			if(flow == 0) return ret;
			ret += flow;
		}
	}

	
}
