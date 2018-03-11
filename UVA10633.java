import java.util.Scanner;

public class UVA10633 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLong()) {
			long n_m = sc.nextLong();
			if(n_m == 0) break;
			boolean first = false;
			for(int i =9;i>=0;i--) {
				if((n_m-i)%9 == 0) {
					if(first) System.out.print(" ");
					first = true;
					System.out.printf("%d",(n_m - i)/9*10 + i);
				}
			}
			System.out.println();
		}
		sc.close();
	}
}
