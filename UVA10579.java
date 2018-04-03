import java.math.BigInteger;
import java.util.Scanner;

public class UVA10579 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger[] f = new BigInteger[5000];
		f[1] = BigInteger.ONE;
		f[2] = BigInteger.ONE;
		for (int i = 3; i < 5000; i++)
			f[i] = f[i - 1].add(f[i - 2]);
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			System.out.println(f[n]);
		}
		
		sc.close();
	}
}
