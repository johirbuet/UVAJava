import java.util.Scanner;

public class UVA12808 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t<= T; t++) {
			double L = sc.nextDouble()/1000;
			double D = sc.nextDouble()/1000;
			double H = sc.nextDouble()/1000;
			double V = sc.nextDouble()/1000;
			double g = 9.81;
			double time = Math.sqrt(2*H/g);
			double d = time*V;
			if(Math.abs(d - D) < 0.5 || Math.abs(L+ D - d) < 0.5) {
				System.out.println("EDGE");
			}else if(d < D || d > D + L) {
				System.out.println("FLOOR");
			}else {
				System.out.println("POOL");
			}
		}
		sc.close();
	}
}
