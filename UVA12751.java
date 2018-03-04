import java.util.Scanner;

public class UVA12751 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int X = sc.nextInt();
			int sum = N*(N+1)/2;
			int first = (X)*(X-1)/2;
			int last = (X+K -1)*(X+K)/2;
			int rem = sum - last + first;
			System.out.println("Case "+t+": "+rem);
		}
		sc.close();
	}
}
