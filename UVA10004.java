import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class UVA10004 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n  = sc.nextInt();
			if( n == 0) {
				break;
			}
			int l = sc.nextInt();
			int [][] graph = new int[n][n];
			int s = 0;
			boolean sFound = false;
			for(int i =0; i< l;i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				if(!sFound) {
					s = u;
					sFound = true;
				}
				graph[u][v] = graph[v][u] = 1;
			}
			boolean bi = isBipartite(graph, s);
			if(bi) {
				System.out.println("BICOLORABLE.");
			}else {
				System.out.println("NOT BICOLORABLE.");
			}
			
			}
		sc.close();
		}
	public static boolean isBipartite(int [][] graph,int s) {
		int [] color = new int[graph.length];
		for(int i =0; i< color.length;i++) {
			color[i] = -1;
		}
		Queue<Integer> q = new LinkedList<>();
		color[s] = 1;
		q.add(s);
		while(!q.isEmpty()) {
			int u =q.poll();
			if(graph[u][u] == 1) {
				return false; 
			}
			for(int v = 0; v< color.length; v++ ) {
				if(graph[u][v] == 1 && color[v] == -1) {
					color[v] = 1 - color[u];
					q.add(v);
				} else if(graph[u][v] == 1 && color[v] == color[u]) {
					return false;
				}
			}
			
			
		}
		return true;
	}
}