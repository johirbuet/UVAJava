import java.util.Scanner;

public class UVA12342 {
	public static void main(String[] args) {
		int k;
		Scanner sc = new Scanner(System.in);
		int test_cases = sc.nextInt();

		for (int i = 1; i <= test_cases; i++) {
			System.out.print("Case " + i + ": ");

			double tax = 0;
			k = sc.nextInt();

			if (k <= 180000) {
				System.out.println(0);
				continue;
			}

			k -= 180000;

			if (k <= 300000) {
				tax += k * 0.10;
				if (tax < 2000)
					System.out.println(2000);
				else
					System.out.println((int) Math.ceil(tax));
				continue;
			}

			tax += 300000 * 0.10;
			k -= 300000;

			if (k <= 400000) {
				tax += k * 0.15;
				System.out.println((int) Math.ceil(tax));
				continue;
			}

			tax += 400000 * 0.15;
			k -= 400000;

			if (k <= 300000) {
				tax += k * 0.20;
				System.out.println((int) Math.ceil(tax));
				continue;
			}

			tax += 300000 * 0.20;
			k -= 300000;

			tax += k * 0.25;
			System.out.println((int) Math.ceil(tax));
		}
		sc.close();
	}
}
