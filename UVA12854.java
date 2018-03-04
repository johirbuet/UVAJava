import java.util.Scanner;

public class UVA12854 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int [] A = new int[5];
			int [] B = new int[5];
			for(int i =0; i< 5; i++) {
				A[i] = sc.nextInt();
			}
			for(int i =0; i< 5; i++) {
				B[i] = sc.nextInt();
			}
			int c = 0;
			for(int i =0; i<5;i++) {
				c  += A[i]^B[i];
			}
			System.out.println((c==5)?"Y":"N");
		}
		sc.close();
	}
}
