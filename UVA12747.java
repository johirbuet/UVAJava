import java.util.Scanner;

public class UVA12747 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int [] A = new int[N];
			int [] B = new int[N];
			for(int i =0; i< N; i++) {
				A[i]  = sc.nextInt();
			}
			for(int i =0; i< N; i++) {
				B[i]  = sc.nextInt();
			}
			
			int [][] dp = new int[N+1][N+1];
			for(int i = 0; i<= N; i++) {
				for(int j =0; j<= N; j++) {
					if( i == 0) {
						dp[i][j] = j;
					}
					else if(j == 0) {
						dp[i][j] = i;
					}
					else if(A[i - 1] == B[j-1]) {
						dp[i][j] = dp[i-1][j-1];
					}
					else {
						dp[i][j] = 1 + Math.min(dp[i][j-1], dp[i-1][j]);
					}
				}
			}
			System.out.printf("Case %d: %d\n",t,dp[N][N]);
			
		}
		sc.close();
	}
}
