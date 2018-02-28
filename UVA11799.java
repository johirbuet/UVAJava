import java.util.Scanner;

public class UVA11799 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t= 1; t<=T;t++) {
			int N = sc.nextInt();
			int max = Integer.MIN_VALUE;
			for(int i =0; i< N;i++) {
				max = Math.max(max, sc.nextInt());
			}
			System.out.println("Case "+t+": "+max);
		}
		sc.close();
	}
}
