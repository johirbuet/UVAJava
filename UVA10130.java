import java.util.Scanner;

public class UVA10130 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t =0; t < T; t++) {
			int N = sc.nextInt();
			int [] P =new int[N];
			int [] W = new int[N];
			int [] dp = new int[31];
			for(int i =0; i< N; i++) {
				P[i] = sc.nextInt();
				W[i] = sc.nextInt();
				for(int w = 30; w>=W[i];w--) {
					dp[w] = Math.max(dp[w], dp[w-W[i]]+P[i]);
				}
				
			}
			int G = sc.nextInt();
			int [] gw = new int[G];
			int sum = 0;
			for(int i=0; i< G;i++) {
				gw[i] = sc.nextInt();
				sum += dp[gw[i]];
			}
			System.out.println(sum);
			
		}
		sc.close();
	}
}
