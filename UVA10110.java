import java.util.Scanner;

public class UVA10110 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		while(sc.hasNextLong()) {
			long n = sc.nextLong();
			if(n == 0) {
				break;
			}
			if((long)Math.ceil(Math.sqrt(n))== (long)Math.floor(Math.sqrt(n))) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
		sc.close();
	}
}
