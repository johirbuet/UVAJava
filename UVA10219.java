import java.math.BigInteger;
import java.util.Scanner;

public class UVA10219 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int p = fact(n)/(fact(k)*fact(n-k));
			String s = p+"";
			System.out.println(s.length());
		}
		sc.close();
	}
	
	static int fact(int n) {
		if( n== 1) {
			return 1;
		}
		return n * fact(n-1);
	}
}
