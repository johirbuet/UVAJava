import java.util.Scanner;

public class UVA12908 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		while(sc.hasNextInt()) {
			int S = sc.nextInt();
			if(S == 0) {
				break;
			}
			double N = Math.ceil((-1 + Math.sqrt(1 + (4*(2*S +1))))/2.0);
			int n = (int)N;
			int X = (n*n + n - 2*S)/2;
			System.out.println(X+" "+n);
		}
		sc.close();
	}

}
