import java.util.Scanner;

public interface CFA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long [][] dp = new long[2000000001][2000000001];
		dp[0][0] = 1;
		dp[1][1] = 6;
		sc.close();
	}
}
