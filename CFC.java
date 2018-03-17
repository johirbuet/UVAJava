import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CFC {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] A = new int[N];
		for(int i =0;i<N;i++) {
			A[i] = sc.nextInt();
		}
		Set<Integer> set = new HashSet<>();
		int total = 0;
		for(int i =0;i<N;i++) {
			int count = 0;
			while(i < N - 1 && A[i] == A[i+1] ) {
				count++;
				i++;
			}
			if(!set.contains(count)) {
				total++;
				set.add(count);
			}
		}
		if(total == 1) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		sc.close();
	}
}
