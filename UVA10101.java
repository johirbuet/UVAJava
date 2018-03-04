import java.util.Scanner;

public class UVA10101 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t =1;
		while (sc.hasNextLong()) {
			long N = sc.nextLong();
			System.out.printf("%4d.", t++);
			if (N == 0)
				System.out.printf(" 0");
			bangla(N);
			System.out.printf("\n");
		}
		sc.close();
	}

	public static void bangla(long n) {
		if (n >= 10000000) {
			bangla(n / 10000000);
			System.out.printf(" kuti");
			n %= 10000000;
		}
		if (n >= 100000) {
			bangla(n / 100000);
			System.out.printf(" lakh");
			n %= 100000;
		}
		if (n >= 1000) {
			bangla(n / 1000);
			System.out.printf(" hajar");
			n %= 1000;
		}
		if (n >= 100) {
			bangla(n / 100);
			System.out.printf(" shata");
			n %= 100;
		}
		if (n > 0)
			System.out.printf(" %d", n);
	}
}
