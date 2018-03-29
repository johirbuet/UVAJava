import java.util.Scanner;

public class UVA12650 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			int R = sc.nextInt();
			
			boolean [] A = new boolean[N+1];
			for(int i =0; i < R;i++) {
				int n = sc.nextInt();
				A[n] = true;
			}
			String ret = "";
			for(int i =1;i<=N;i++) {
				if(!A[i]) {
					ret+= i+" ";
				}
			}
			if( N == R ) {
				System.out.println("*");
			}else {
				System.out.println(ret.substring(0, ret.length()));
			}
		}
		sc.close();
	}
}
