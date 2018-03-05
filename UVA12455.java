import java.util.Arrays;
import java.util.Scanner;

public class UVA12455 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0) {
			int N = sc.nextInt();
			boolean [] dp = new boolean[N+1];
			dp[0] =true;
			int p = sc.nextInt();
			int [] ps = new int[p];
			for(int i =0; i< p; i++) {
				ps[i] = sc.nextInt();
			}
			Arrays.sort(ps);
			for(int x : ps) {
				for(int i = N -x; i >= 0; i--) {
					if(dp[i] && !dp[i+x]) {
						dp[i+x] = true;
					}
				}
			}
			System.out.println(dp[N]?"YES":"NO");
		}
		sc.close();
	}
}
