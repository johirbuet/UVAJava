import java.math.BigInteger;
import java.util.Scanner;

public class UVA13216 {
	public static void main(String[] args) {
		BigInteger A = new BigInteger("66");
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		while(T-- > 0) {
			BigInteger N = new BigInteger(sc.nextLine());
			BigInteger P = new BigInteger("100");
			
		}
	}
	private static long pow(long a, long n, long p) {
		long ans = a%p;
		for(int i = 2; i <= n; i++) {
			ans = pow1(ans,i,p);
		}
		return ans;
	}

	public static long pow1(long A, long N,long P) {
		if( N == 0 ) return 1;
		long half = pow1(A,N/2,P);
		long half_sq = (half*half)%P;
		if(N%2 == 0) return half_sq;
		return (half_sq*A)%P;
	}
}
