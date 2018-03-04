import java.util.Scanner;

public class UVA12704 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while( T--> 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int r = sc.nextInt();
			double pr = Math.sqrt(x*x+y*y);
			double min =  r - pr;
			double max = r + pr;
			System.out.printf("%.2f %.2f\n",min,max);
		}
		sc.close();
	}
}
