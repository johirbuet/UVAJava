import java.util.Scanner;

public class UVA12992 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int r = (N - 1) * 2 + + 1 ;
			System.out.println("Case #"+t+": "+r);
		}
		sc.close();
	}
}
