import java.util.Scanner;

public class UVA10003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			if(N == 0) break;
			int [] C = new int[N];
			for(int i =0 ;i<N;i++) {
				C[i] = sc.nextInt();
			}
			
		}
		sc.close();
	}
}
