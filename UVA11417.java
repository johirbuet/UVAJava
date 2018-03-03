import java.util.Scanner;

public class UVA11417 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			if(N == 0) {
				break;
			}
			int sum = 0;
			for(int i = 1; i < N;i++) {
				for(int j = i+1; j<= N;j++) {
					sum += gcd(i, j);
				}
			}
			System.out.println(sum);
		}
		sc.close();
	}
	public static int gcd(int a, int b) {
		if (b != 0)
            return gcd(b, a % b);
        else
            return a;
	}
}
