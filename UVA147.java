import java.util.Scanner;

public class UVA147 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] C = {5,10,20,50,100,200,500,1000,2000,5000,10000};
		long [] dp = new long[30001];
		dp[0] = 1;
		for(int j =0; j<C.length;j++) {
			for(int i = C[j];i<30001;i++) {
				dp[i] += dp[i-C[j]];
			}
		}
		
		while(sc.hasNextDouble()) {
			double d = sc.nextDouble();
			if( d == 0) {
				break;
			}
			int T = (int)(d*10000/100.0);
			System.out.printf("%3.2f%17d\n",d,dp[T]);
		}
		sc.close();
	}
}
