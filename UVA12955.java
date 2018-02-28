import java.util.Scanner;

public class UVA12955 {
	public static void main(String[] args) {
		int [] fact =new int[12];
		fact[0] = fact[1] = 1;
		for(int i=2;i<=10;i++) {
			fact[i] = i*fact[i-1];
		}
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			int ans = 0;
			for(int i = 10;i>=0;i--) {
				while(fact[i] <= N) {
					N -= fact[i];
					ans++;
				}
			}
			System.out.println(ans);
		}
		sc.close();
	}
}
