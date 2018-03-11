import java.util.Scanner;

public class UVA13212 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		sc.close();
	}
	
	public static int mergeSort(int [] arr, int [] temp,int l, int r) {
		int c = 0;
		if( l < r) {
			int m = ( l + r) / 2;
			c += mergeSort(arr, temp, l, m);
			c += mergeSort(arr, temp, m + 1, r);
			c += merge(arr, temp, l, m, r);
		}
		return c;
	}
	
	public static int merge(int [] arr,int [] temp,int l,int m,int r) {
		int i = l;
		int j =m;
		int k = 0;
		int c = 0;
		while( i <= (m -1) && j <= r) {
			if(arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			}else {
				temp[k++] = arr[j++];
				c += m - i;
			}
		}
		while( i<= m -1) {
			temp[k] =arr[i++];
		}
		while( j < r) {
			temp[k++] = arr[j++];
		}
		for(int f = l;f<= r; f++) {
			arr[f] = temp[f];
		}
		return c;
	}
}
