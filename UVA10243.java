import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UVA10243 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			if( n ==0 ) break;
			List<List<Edge>>  edges = new ArrayList<>();
			for(int i =0; i<=n;i++) {
				edges.add(new ArrayList<>());
			}
			for(int i = 1; i<=n ;i++) {
				int m = sc.nextInt();
				for(int j = 0; j< m; j++) {
					int v = sc.nextInt();
					edges.get(i).add(new Edge(i,v));
				}
			}
			boolean [] used = new boolean[n+1];
			int [][] dp = new int[n + 1][2];
			dfs(1, used, dp, edges);
			int ans = Math.min(dp[1][0], dp[1][1]);
			if( n == 1) {
				System.out.println(1);
			}else {
				System.out.println(ans);
			}
			
		}
		sc.close();
	}
	public static void dfs(int node,boolean [] used, int [][] dp,List<List<Edge>>  edges) {
		used[node] = true;
		dp[node][0] = 0;
		dp[node][1] = 1;
		for(int i =0; i< edges.get(node).size();i++) {
			Edge e = edges.get(node).get(i);
			if(!used[e.to]) {
				dfs(e.to, used, dp, edges);
				dp[node][0] += dp[e.to][1];
				dp[node][1] += Math.min(dp[e.to][0], dp[e.to][1]);
			}
		}
	}
	
	static class Edge {
		int to;
		int from;
		public Edge(int from,int to) {
			this.from = from;
			this.to= to;
		}
		@Override
		public String toString() {
			return "("+to+", "+from+")";
		}
	}
}
