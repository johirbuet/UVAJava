import java.util.Scanner;

public class UVA12032 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int [] A = new int[N + 1];
			int K = -1;
			for(int i = 1; i<= N; i++) {
				A[i] = sc.nextInt();
				K = Math.max(K, A[i] - A[i-1]);
			}
			int ans = K;
			for(int i = 1; i<= N; i++) {
				if(A[i] - A[i - 1] == K) {
					K--;
				}else if(A[i] - A[i - 1] > K) {
					ans++;
					break;
				}
			}
			
			
			System.out.printf("Case %d: %d\n",t,ans);
		}
		sc.close();
	}
	
}
