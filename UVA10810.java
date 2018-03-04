import java.util.Scanner;

public class UVA10810 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			if( N == 0) {
				break;
			}
			int [] arr = new int[N];
			for(int i = 0; i< N; i++) {
				arr[i] = sc.nextInt();
			}
			long count = mergesort(arr, new int[N], 0, N - 1);
			System.out.println(count);
		}
		sc.close();
	}
	public static long mergesort(int [] A,int [] temp,int l,int r) {
		long inv = 0;
		if(l < r) {
			int mid = (l + r) /2;
			inv += mergesort(A, temp, l, mid);
			inv += mergesort(A, temp, mid + 1, r);
			inv += merge(A, temp, l, mid + 1, r);
		}
		
		return inv;
		
	}
	
	public static long merge(int [] A,int [] temp,int l,int mid,int h) {
		int i = l;
		int j = mid;
		long inv = 0;
		int k = l;
		while( (i <= (mid - 1)) &&  (j <= h)) {
			if(A[i]<= A[j]) {
				temp[k++] = A[i++];
			}else {
				temp[k++] = A[j++];
				inv += mid - i;
			}
		}
		while(i <= mid - 1) {
			temp[k++] = A[i++];
		}
		while(j <= h) {
			temp[k++] = A[j++];
		}
		for(i = l; i<=h; i++) {
			A[i] = temp[i];
		}
		return inv;
	}
}
