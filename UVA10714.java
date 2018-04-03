import java.util.Scanner;

public class UVA10714 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int l = sc.nextInt();
			int n = sc.nextInt();
			int min = 0;
			int max = 0;
			for(int i =0; i< n;i++) {
				int x = sc.nextInt();
				min = Math.max(min, Math.min(x, l - x));
				max = Math.max(max, Math.max(x, l - x));
			}
			System.out.printf("%d %d\n", min, max);

			
		}
		sc.close();
	}
}
