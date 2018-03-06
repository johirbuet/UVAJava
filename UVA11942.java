import java.util.Scanner;

public class UVA11942 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		System.out.println("Lumberjacks:");
		while( T-- > 0) {
			int [] B = new int[10];
			for(int i =0; i< 10;i++) {
				B[i] = sc.nextInt();
			}
			boolean ordered = true;
			boolean inc = B[0] < B[1];
			for(int i = 1; i< 10;i++) {
				if(inc) {
					if(B[i - 1] > B[i]) {
						ordered = false;
					}
				}
				else {
					if(B[i - 1] < B[i]) {
						ordered = false;
					}
				}
			}
			
			if(ordered) {
				System.out.println("Ordered");
			}else {
				System.out.println("Unordered");
			}
		}
		sc.close();
	}
}
