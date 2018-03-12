import java.util.Scanner;

public class UVA10003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int l = sc.nextInt();
			if(l == 0) break;
			int N = sc.nextInt();
			int [] C = new int[N + 2];
			for(int i = 1 ;i<=N;i++) {
				C[i] = sc.nextInt();
			}
			C[N+1] = l;
			int [][] cost = new int[N+2][N+2];
			for(int j = 1; j<= N+1; j++) {
				for(int i = j-1; i >= 0; i--) {
					if( i + 1 == j) {
						cost[i][j] = 0;
					}else {
						cost[i][j] = Integer.MAX_VALUE;
						for(int k = i + 1; k< j; k++) {
							if(cost[i][k] + cost[k][j] < cost[i][j]) {
								cost[i][j] = cost[i][k] + cost[k][j];
							}
						}
						cost[i][j] += C[j] - C[i];
					}
				}
			}
			System.out.println("The minimum cutting is "+cost[0][N+1]+".");
			
		}
		sc.close();
	}
}
