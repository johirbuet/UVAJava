import java.util.Scanner;

public class UVA12149 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			if(n == 0) {
				break;
			}
			int total = n*(n+1)*(2*n+1)/6;
			System.out.println(total);
		}
		sc.close();
	}
}
