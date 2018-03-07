import java.util.Scanner;

public class UVA11957 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = 1;
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			int max = n/2;
			System.out.printf("Case %d: %d\n",c++,max);
		}
		sc.close();
	}
}
