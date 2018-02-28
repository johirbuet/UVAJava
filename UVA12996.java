import java.util.Scanner;

public class UVA12996 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t =1;t<=T;t++) {
			int N = sc.nextInt();
			int L = sc.nextInt();
			int [] M = new int[N];
			int [] C = new int[N];
			int sum = 0;
			for(int i =0; i< N; i++) {
				M[i] = sc.nextInt();
				sum += M[i];
			}
			for(int i = 0;i < N ; i++) {
				C[i] = sc.nextInt();
			}
			boolean possible = true;
			for(int i =0; i < N; i++) {
				if(M[i] > C[i]) {
					possible = false;
					break;
				}
			}
			possible = possible && (sum <= L);
			System.out.println("Case "+t+": "+(possible?"Yes":"No"));
		}
		sc.close();
	}
}
