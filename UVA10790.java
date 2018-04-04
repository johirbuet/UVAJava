import java.util.Scanner;

public class UVA10790 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = 1;
		while(sc.hasNextLong()) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			if( a == 0 && b == 0) break;
			long res= a*b*(a-1)*(b-1)/4;
			System.out.printf("Case %d: %d\n",c++,res);
		}
		sc.close();
	}
}
