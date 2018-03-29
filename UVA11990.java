import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UVA11990 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int [] A = new int[n];
			Map<Integer,Integer> map = new HashMap<>();
			for(int i =0; i< n; i++) {
				A[i] = sc.nextInt();
			}
			/*for(int i =0; i< n;i++) {
				System.out.print(A[i]+" ");
			}
			System.out.println();*/
			for(int i = 0; i< n; i++) {
				map.put(A[i], map.getOrDefault(A[i], 0));
				for(int j = i+1;j < n;j++) {
					if(A[j] < A[i]) {
						map.put(A[i], map.get(A[i]) + 1);
					}
				}
			}
			
			int inv = mergeSort(A, new int[A.length], 0, n - 1);
			/*for(int i =0; i< n;i++) {
				System.out.print(A[i]+" ");
			}
			System.out.println();*/
			
			for(int i = 0; i< m;i++) {
				System.out.println(inv);
				int x = sc.nextInt();
				inv = inv - map.get(x);
			}
		}
		sc.close();
	}
	
	class TreeNode {
		
	}
	public static int mergeSort(int [] A, int [] temp, int l,int r) {
		int inv = 0;
		if( l < r) {
			int mid = (l +r )/2;
			inv += mergeSort(A, temp, l, mid);
			inv += mergeSort(A, temp, mid + 1 , r);
			inv += merge(A, temp, l, r, mid +1);
		}
		return inv;
	}
	
	public static int merge(int [] A, int [] temp,int l,int r,int mid) {
		int inv = 0;
		int k = l;
		int i = l;
		int j = mid;
		while( i < mid && j <= r) {
			if(A[i] <= A[j]) {
				temp[k++] = A[i++];
			}
			else {
				temp[k++] = A[j++];
				inv += mid - i;
			}
		}
		while(i < mid ) {
			temp[k++] = A[i++];
		}
		while( j <= r) {
			temp[k++] = A[j++];
		}
		for(i = l; i<=r;i++) {
			A[i] = temp[i];
		}
		return inv;
	}
}
