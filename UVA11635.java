import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class UVA11635 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			if(N == 0 ) {
				break;
			}
			int h = sc.nextInt();
			boolean [] H = new boolean[N];
			for(int i = 0; i< h; i++) {
				H[sc.nextInt() - 1] = true;
			}
			H[0] = true;
			H[N -1] = true;
			
			int R = sc.nextInt();
			int [][] W = new int[N][N];
			for(int i = 0; i < N;i++) {
				for(int j =0; j< N;j++) {
					if(i==j) {
						W[i][j] = 0;
					}
					else {
						W[i][j] = Integer.MAX_VALUE;
					}
				}
			}
			
			for(int i = 0; i< R; i++) {
				int s = sc.nextInt();
				int d = sc.nextInt();
				int t = sc.nextInt();
				W[s-1][d-1] = t;
				W[d-1][s-1] = t;
			}
			int [] d =new int[N];
			dikstra(0, d, W);
			for(int i = 0; i< N; i++) {
				System.out.print(d[i]+ " ");
			}
		}
		sc.close();
	}
	
	static class Vertex implements Comparable<Vertex> {
		int V;
		int d;
		public Vertex(int V,int d) {
			this.V = V;
			this.d = d;
		}
		@Override
		public int compareTo(Vertex o) {
			return this.d - o.d;
		}
		
	}
	public static void dikstra(int s,int [] d, int [][] W) {
		d[s] = 0;
		for(int i =0; i<d.length;i++) {
			if( i == s) continue;
			d[i] = Integer.MAX_VALUE;
		}
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.add(new Vertex(s,0));
		while(!pq.isEmpty()) {
			Vertex u = pq.poll();
			for(int i= 0; i<d.length;i++) {
				if(W[u.V][i] != Integer.MAX_VALUE) {
					int w = W[u.V][i] + d[u.V];
					if(w < d[i]) {
						d[i] = w;
						pq.add(new Vertex(i, w));
					}
				}
			}
		}
		
	}
	
}
