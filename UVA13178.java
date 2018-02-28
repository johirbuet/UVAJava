import java.util.Scanner;

public class UVA13178 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			long n = sc.nextLong();
			long sum = n*(n+1)/2;
			if(sum%3 == 0) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
		sc.close();
	}

}
