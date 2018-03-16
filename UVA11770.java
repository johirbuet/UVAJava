import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class UVA11770 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i =1; i <= T ; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			HashMap<Integer, Boolean> map = new HashMap<>();
			for(int a =1; a<=N;a++) {
				map.put(a, false);
			}
			int [][] graph = new int[N+1][N+1];
			for(int j = 0; j< M; j++) {
				int s = sc.nextInt();
				int f = sc.nextInt();
				graph[s][f] = 1;
			}
			
			int cn = 0;
			boolean [] visited = new boolean[N+1];
			Stack<Integer> stack = new Stack<>();
			for(int V =1 ; V <= N; V++) {
				if(!visited[V]) {
					dfs(V, graph, visited);
					stack.push(V);
				}
			}
			for(int j =0;j<N+1;j++) visited[j] = false;
			while(!stack.isEmpty()) {
				int u = stack.pop();
				if(!visited[u]) {
					dfs(u, graph, visited);
					cn++;
				}
				
			}
			System.out.printf("Case %d: %d\n",i,cn);
		}
		sc.close();
	}
	public static void dfs(int u,int [][] graph,boolean [] visited) {
		if(visited[u]) return;
		visited[u] = true;
		for(int v =1; v< graph.length;v++) {
			if(graph[u][v] == 1 && !visited[v]) {
				dfs(v, graph, visited);
			}
		}
	}
	
}
