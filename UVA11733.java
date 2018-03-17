import java.util.PriorityQueue;
import java.util.Scanner;

public class UVA11733 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t<= T;t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int A = sc.nextInt();
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			int [] parent = new int[N + 1];
			for(int i =0;i<M;i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int w = sc.nextInt();
				Edge e = new Edge(u, v, w);
				pq.add(e);
			}
			for(int i = 0; i<=N;i++) {
				parent[i] = i;
			}
			int cost = 0;
			int total_airport = 0;
			int cc = 0;
			while(!pq.isEmpty()) {
				Edge e = pq.poll();
				int ru = find(e.u, parent);
				int rv = find(e.v,parent);
				if(e.w > A) {
					break;
				}
				if(ru != rv) {
					parent[ru] = rv;
					cost += e.w;
					cc++;
				}
			}
			int cn = 0;
			for(int i =1;i<=N;i++) {
				if(parent[i] == i) {
					cn++;
				}
			}
			cost = cost + cn*A;
			total_airport = cn;
			System.out.printf("Case #%d: %d %d\n",t,cost,total_airport);
			
		}
		sc.close();
	}
	public static int find(int u,int [] parent) {
		if(parent[u] != u) {
			parent[u] = find(parent[u],parent);
		}
		return parent[u];
	}
	public static void union(int u,int v,int [] parent) {
		int i = parent[u];
		int j = parent[v];
		if(i != j) {
			parent[i] = j;
		}
	}
	public static class Edge implements Comparable<Edge> {
		int u;
		int v;
		int w;
		public Edge(int u,int v,int w) {
			this.u = u;
			this.v = v;
			this.w= w;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
}
