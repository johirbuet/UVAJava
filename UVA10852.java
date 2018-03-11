import java.util.Scanner;

public class UVA10852 {
	public static void main(String[] args) {
		int [] prime = new int [10001];
		
		for(int i = 2; i*i <10001;i++) {
			  if(prime[i] == 0) {
				  for(int j = i*i; j<10001;j += i) {
					  prime[j] = 1;
				  }
			  }
		}
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while( T-->0) {
			int N = sc.nextInt();
			int x = N;
			int max = -1;
			int P = -1;
			while( x-- > 1) {
				if(prime[x] == 0) {
					if(N%x > max) {
						max = N%x;
						P = x;
					}
				}
			}
			System.out.println(P);
		}
		sc.close();
	}
}
