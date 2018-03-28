import java.util.Arrays;
import java.util.Scanner;

public class UVA10611 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			int [] A = new int[N];
			for(int i=0;i<N;i++) {
				A[i] = sc.nextInt();
			}
			int Q = sc.nextInt();
			for(int i =0; i< Q;i++) {
				int v = sc.nextInt();
				int in = Arrays.binarySearch(A, v);
				int low = -1;
				int hi = -1;
				boolean found =false;
				if( in < 0) {
					in = -in -1;
				}else {
					found = true;
					low = Arrays.binarySearch(A, v - 1);
					if(low < 0) {
						low = -low -1 - 1;
					}
					hi = Arrays.binarySearch(A, v + 1);
					if(hi < 0) {
						hi = -hi - 1;
					}
				}
				
				if(in > 0 && in < N) {
					if(!found) {
						System.out.println(A[in - 1]+" "+A[in]);
					}
					if(found) {
						if(hi < N && low >= 0) {
							System.out.println(A[low]+" "+A[hi]);
						}else if (hi >= N) {
							System.out.println(A[in - 1]+" X");
						}else {
							System.out.println("X "+A[hi]);
						}
					}
				}else if(in == 0){
					if(found) {
						if(hi < N && low >= 0) {
							System.out.println(A[low]+" "+A[hi]);
						}else if (hi >= N) {
							System.out.println(A[in - 1]+" X");
						}else {
							System.out.println("X "+A[hi]);
						}
					}else {
						System.out.println("X "+A[in]);
					}
				}else {
					System.out.println(A[in - 1]+" X");
				}
			}
		}
		sc.close();
	}
}
