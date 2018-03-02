import java.util.Scanner;

public class UVA11689 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0) {
			int e  = sc.nextInt();
			int f = sc.nextInt();
			int r = sc.nextInt();
			int t = e + f;
			int res = 0;
			while(t >= r) {
				res += t/r;
				t = t % r + t/r;
			}
			System.out.println(res);
		}
		sc.close();
	}
}
