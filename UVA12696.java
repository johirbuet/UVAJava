import java.util.Scanner;

public class UVA12696 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int total = 0;
		while(T-->0) {
			double l = sc.nextDouble();
			double w = sc.nextDouble();
			double d = sc.nextDouble();
			double m = sc.nextDouble();
			boolean allowed = (l+w+d) <=125.0 && m <=7.0;
			allowed = (allowed) || ((l <= 56.0) && (w <= 45.0) && (d <= 25.0) && (m <= 7.0));
			if(allowed) {
				System.out.println(1);
				total++;
			}
			else {
				System.out.println(0);
			}
		}
		System.out.println(total);
		sc.close();
	}
}
