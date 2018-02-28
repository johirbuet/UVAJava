import java.util.Scanner;

public class UVA12918 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0) {
			int n  = sc.nextInt();
			int m = sc.nextInt();
			int extra = m - n;
			int sum = n * extra;
			sum = sum + (n-1)*n/2;
			System.out.println(sum);
		}
		sc.close();
	}
}
