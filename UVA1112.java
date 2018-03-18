import java.util.Scanner;

public class UVA1112 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t =0; t < T; t++) {
			int N = sc.nextInt();
			int E = sc.nextInt();
			int time = sc.nextInt();
			int M = sc.nextInt();
			int [][] G = new int[N ][N];
			for(int i =0; i< N; i++) {
				for(int j =0; j< N;j++) {
					G[i][j] = Integer.MAX_VALUE/2;
				}
			}
			for(int i =0; i< M; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int w = sc.nextInt();
				G[u-1][v-1] = w;
			}
			floydwarshall(G);
			int count = 0;
			for(int i =0 ; i<N;i++) {
				if((G[i][E-1] <= time) || (i == (E - 1))) {
					count++;
				}
			}
			System.out.println(count);
			if( t < T - 1) {
				System.out.println();
			}
		}
		sc.close();
	}
	
	public static void floydwarshall(int [][] G) {
		int N = G.length;
		for(int k =0; k< N;k++) {
			for(int i =0; i<N;i++) {
				for(int j=0;j<N;j++) {
					G[i][j] = Math.min(G[i][j], G[i][k]+G[k][j]);
				}
			}
		}
	}
}
