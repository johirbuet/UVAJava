import java.util.HashMap;
import java.util.Scanner;

public class UVA12700 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		int c = 1;
		while(T-- > 0) {
			int N = Integer.parseInt(sc.nextLine());
			String res = sc.nextLine();
			char [] r = res.toCharArray();
			int A = 0;
			int B =0;
			int W = 0;
			int t = 0;
			for(char x : r) {
				switch (x) {
				case 'A':
					A++;
					break;
				case 'B':
					B++;
					break;
				case 'W':
					W++;
					break;
				case 'T':
					t++;
				default:
					break;
				}
			}
			if(A == N) {
				System.out.printf("Case %d: ABANDONED\n",c++);
			}else if (A + B == N) {
				System.out.printf("Case %d: BANGLAWASH\n",c++);
			}else if( A + W == N) {
				System.out.printf("Case %d: WHITEWASH\n",c++);
			}else if(B == W) {
				System.out.printf("Case %d: DRAW %d %d\n",c++,B,t);
			}else if ( B > W) {
				System.out.printf("Case %d: BANGLADESH %d - %d\n",c++,B,W);
			}else if( W > B) {
				System.out.printf("Case %d: WWW %d - %d\n",c++,W,B);
			}
		}
		sc.close();
		
	}
}
