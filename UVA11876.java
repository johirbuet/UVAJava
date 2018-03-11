import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UVA11876 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int c = 1;
		int [] NOD = new int[1000001];
		NOD[0] = 1;
		//int [] arr = {1,2,5,6};
		//int index = Arrays.binarySearch(arr, 3);
		//System.out.println("Index "+index);
		for(int i =1; i< 65000;i++) {
			NOD[i] = NOD[i-1] + NOD(i - 1);
		}
		while( T-->0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int first = Arrays.binarySearch(NOD, a);
			if(first < 0) first = -first -1;
			int last = Arrays.binarySearch(NOD, b);
			if(last < 0) last = -last - 1;
			int count = last - first + 1;
			System.out.printf("Case %d: %d\n",c++,count);
		}
		sc.close();
	}
	public static int NOD(int x) {
		Set<Integer> set = new HashSet<>();
		for(int i =1; i<= Math.sqrt(x);i++) {
			if(x % i == 0) {
				set.add(i);
				set.add(x/i);
			}
		}
		return set.size();
	}
}
