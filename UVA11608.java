import java.util.Scanner;

public class UVA11608 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = 1;
		while(sc.hasNextInt()) {
			int p = sc.nextInt();
			if( p == -1) {
				break;
			}
			int [] P = new int[13];
			P[0] = p;
			for(int i = 1 ;i <= 12; i++) {
				P[i] = sc.nextInt();
			}
			for(int i = 0;i< 12 ;i++) {
				int x = sc.nextInt();
				int r = 0;
				if(x <= P[i]) {
					P[i] = P[i] - x;
					r = P[i];
				}else {
					r = P[i];
					P[i] = -1;
				}
				
				
				if(r > 0) {
					P[i+1] += r;
				}
			}
			System.out.println("Case "+c+":");
			for(int i = 0 ; i < 12 ; i++) {
				if(P[i] >= 0) {
					System.out.println("No problem! :D");
				}else {
					System.out.println("No problem. :(");
				}
			}
			c++;
		}
		sc.close();
		
	}
}
