import java.util.Scanner;

public class UVA13244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0) {
			long D = sc.nextLong();
			long n = (D  + 1)/2;
			long sum = n*n + (n-1)*(n-1);
			System.out.println(sum);
		}
		sc.close();
	}
}
