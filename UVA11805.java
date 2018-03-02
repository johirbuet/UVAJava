import java.util.Scanner;

public class UVA11805 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t =1 ; t <= T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int P = sc.nextInt();
			int R = (K + P )%(N);
			if(R == 0) {
				R = N;
			}
			System.out.printf("Case %d: %d\n",t,R);
		}
		sc.close();
	}
}
