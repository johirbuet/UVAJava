import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class UVA10474 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = 1;
		String [] arrr = {"Ho","World","ABCD"};
		Arrays.sort(arrr,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		System.out.println(arrr[0]);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			int Q = sc.nextInt();
			if( N == 0 && Q == 0) {
				break;
			}
			int [] arr = new int [N];
			
			for(int i =0; i<N;i++) {
				arr[i] =sc.nextInt();
			}
			Arrays.sort(arr);
			System.out.printf("CASE# %d:\n",t++);
			for(int q = 0;q<Q;q++) {
				int x = sc.nextInt();
				int index = -1;
				for(int i =0;i<N;i++) {
					if(arr[i] == x) {
						index = i;
						break;
					}
				}
				if(index == -1) {
					System.out.println(x+" not found");
				}
				else {
					System.out.println(x+" found at "+(index + 1));
				}
			}
		}
		sc.close();
	}
}
