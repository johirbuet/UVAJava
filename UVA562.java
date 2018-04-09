import java.util.Scanner;

public class UVA562 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t =1; t <= T; t++) {
			int n = sc.nextInt();
			int [] A = new int[n];
			int S = 0;
			for(int i =0; i<n;i++) {
				A[i] = sc.nextInt();
				S += A[i];
			}
			int W = S/2;
			int [][] dp = new int[n+1][W+1];

			for(int i = 1; i<=n;i++) {
				for(int w = 1; w <= W; w++) {
					if(A[i-1] <= w) {
						dp[i][w] = Math.max(dp[i-1][w - A[i-1]] + A[i-1], dp[i-1][w]);
					}else {
						dp[i][w] = dp[i-1][w];
					}
				}
			}
			int S1 = dp[n][W];
			int S2 = Math.abs(S - S1);
			System.out.println(Math.abs(S1 - S2));
			
		}
		sc.close();
	}
}
