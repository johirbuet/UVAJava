import java.util.Scanner;

public class UVA12952 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			if(A == B) {
				System.out.println(A);
			}else {
				System.out.println(Math.max(A, B));
			}
		}
		sc.close();
	}

}
