import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UVA12442 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t =1; t <= T; t++) {
			int ans = 0;
			int n = sc.nextInt();
			int [] parent = new int[n+1];
			for(int i =0; i<= n; i++) parent[i] = i;
			int [] graph = new int[n+1];
			Arrays.fill(graph, -1);
			int [] S = new int[n+1];
			Arrays.fill(S, -1);
			for(int i =0; i < n;i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				graph[u] = v;
			}
			boolean [] visited = new boolean[n+1];
			int max = 0;
			for(int i = 1; i <= n; i++) {
				if(S[i] == -1) {
					visit(i, visited, graph, S);
				}
				if(S[i] > max) {
					max = S[i];
					ans = i;
				}
			}
			System.out.printf("Case %d: %d\n",t,ans);
		}
		sc.close();
	}
	
	public static int visit(int u,boolean [] visited,int [] graph,int [] S) {
		visited[u] = true;
		int total = 0;
		if(graph[u] != -1 && !visited[graph[u]]) {
			total = 1 + visit(graph[u], visited, graph, S);
		}
		visited[u] = false;
		S[u] = total;
		return S[u];
	}
	
}
