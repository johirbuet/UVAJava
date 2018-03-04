import java.util.Scanner;

public class UVA12646 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(a+b+c == 3 || a+b+c == 0) {
				System.out.println("*");
			}else if(a != b && a!=c) {
				System.out.println("A");
			}else if(b!=a && b!=c) {
				System.out.println("B");
			}else {
				System.out.println("C");
			}
		}
		sc.close();
	}
}
