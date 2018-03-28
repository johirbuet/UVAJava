import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UVA11506 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int M = sc.nextInt();
			int W = sc.nextInt();
			List<Machine> machines = new ArrayList<>();
			machines.add(new Machine(1, 0));
			machines.add(new Machine(M, Integer.MAX_VALUE));
			int [][] graph = new int[M+1][M + M];
			for(int i =0; i< M -2; i++) {
				int m = sc.nextInt();
				int c = sc.nextInt();
				machines.add(new Machine(m, c));
				graph[m][M + m] = c;
			}
			for(int i =0; i < W; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int c = sc.nextInt();
				graph[u][v] = c;
			}
			Collections.sort(machines);
			
		}
		sc.close();
	}
	public static void fordfulkerson(int [][] graph,int s,int t) {
		
	}
	public static void bfs(int [][] graph,int [] parent ) {
		
	}
	
	static class Machine implements Comparable<Machine> {
		int id,c;
		public Machine(int id,int c) {
			this.id = id;
			this.c = c;
		}
		@Override
		public int compareTo(Machine o) {
			return this.id - o.id;
		}
	}
}
