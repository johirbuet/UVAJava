import java.util.Scanner;

public class UVA11614 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt() ;
		for(int i = 0; i< T; i++) {
			long S = 2*sc.nextLong();
			long N = (-1 + (long)Math.sqrt(1+4*S))/2;
			System.out.println(N);
		}
		sc.close();
	}
}
