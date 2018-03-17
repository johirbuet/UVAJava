import java.util.Arrays;
import java.util.Scanner;

public class CFB {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] A = new int[N];
		for(int i =0; i< N; i++) {
			A[i] = sc.nextInt();
		}
		Arrays.sort(A);
		int minDiff = Integer.MAX_VALUE;
		for(int i =1;i < N;i++) {
			minDiff = Math.min(minDiff, Math.abs(A[i] - A[i-1]));
		}
		int count = 0;
		for(int i = 1; i <N;i++) {
			int diff = Math.abs(A[i] - A[i-1]);
			count += (diff - minDiff)/minDiff;
		}
		System.out.println(count);
		sc.close();
	}
}
