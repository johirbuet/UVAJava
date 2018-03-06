import java.util.Scanner;

public class UVA1230 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			long x = sc.nextLong();
			long y = sc.nextLong();
			long n = sc.nextLong();
			x = x % n;
			long mod = pow(x, y, n);
			System.out.println(mod);
		}
		sc.close();
	}
	
	public static long pow(long A, long N,long P) {
		if( N == 0 ) return 1;
		long half = pow(A,N/2,P);
		long half_sq = (half*half)%P;
		if(N%2 == 0) return half_sq;
		return (half_sq*A)%P;
	}
}
