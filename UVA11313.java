import java.util.Scanner;

public class UVA11313 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i< T; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if((n-1)%(m-1) != 0) {
				System.out.println("cannot do this");
			}else {
				System.out.println((n-1)/(m-1));
			}
		}
		sc.close();
	}
}
