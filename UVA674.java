import java.util.Scanner;

public class UVA674 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] coins = {1,5,10,25,50};
		int [] dp = new int[7490];
		dp[0] = 1;
		for(int j =0; j<5;j++) {
			for(int i = coins[j];i<7490;i++) {
				dp[i]  += dp[i - coins[j]];
			}
		}
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			System.out.println(dp[N]);
		}
		sc.close();
	}
}
