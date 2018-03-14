import java.util.Scanner;

public class UVA12463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			int e = sc.nextInt();
			if( a == 0 && b ==0 && c == 0 && d == 0 && e ==0) break;
			int total = a * b * c * d*d*e*e;
			System.out.println(total);
		}
		sc.close();
	}
}
