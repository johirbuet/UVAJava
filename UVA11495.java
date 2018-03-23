import java.util.Scanner;

public class UVA11495 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			if( N ==0) break;
			int [] A = new int[N];
			for(int i =0; i< N; i++) {
				A[i] = sc.nextInt();
			}
			int inv = mergeSort(0, N-1, A, new int[N]);
			if(inv %2 == 1) {
				System.out.println("Marcelo");
			}else {
				System.out.println("Carlos");
			}
		}
		sc.close();
	}
	
	public static int mergeSort(int L,int R,int [] A,int[] temp) {
		int inv = 0;
		if(L < R) {
			int mid = (L + R)/2;
			inv += mergeSort(L, mid, A, temp);
			inv += mergeSort(mid + 1, R, A, temp);
			inv += merge(L, R, mid + 1, A, temp);
		}
		return inv;
	}
	
	public static int merge(int L, int R, int mid, int [] A,int [] temp) {
		int inv = 0;
		int i = L;
		int j = mid;
		int k = L;
		while( i < mid && j <= R) {
			if(A[i] <= A[j]) {
				temp[k++] = A[i++];
			}else {
				temp[k++] = A[j++];
				inv += mid - i;
			}
		}
		while( i < mid) {
			A[k++] =temp[i++];
		}
		while( j <= R) {
			A[k++] = temp[j++];
		}
		for(i =L; i<= R; i++) {
			A[i] = temp[i];
		}
		return inv;
	}
}
