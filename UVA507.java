import java.util.Scanner;

public class UVA507 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t<= T; t++) {
			int N = sc.nextInt();
			int [] A = new int[N - 1];
			for(int i =0; i< N - 1; i++) {
				A[i] = sc.nextInt();
			}
			int maxEdningHere = 0;
			int max = 0;
			int iHere = 0;
			int max_i =0;
			int max_j = 0;
			for(int i =0; i< N - 1; i++) {
				maxEdningHere += A[i];
				if(maxEdningHere < 0) {
					maxEdningHere = 0;
					iHere = i + 1;
				}
				if(maxEdningHere > max || (maxEdningHere == max && (max_j - max_i < i - iHere))) {
					max = maxEdningHere;
					max_i = iHere;
					max_j = i;
				}
			}
			if(max == 0 ) {
				System.out.printf("Route %d has no nice parts\n",t);
			}else {
				System.out.printf("The nicest part of route %d is between stops %d and %d\n",t,max_i + 1 ,max_j + 2);
			}
		}
		sc.close();
	}
}
