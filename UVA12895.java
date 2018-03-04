import java.util.Scanner;

public class UVA12895 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while( T-- > 0) {
			String SN = sc.next();
			int n = SN.length();
			long N =Long.parseLong(SN);
			long s = 0;
			for(int i =0; i< n;i++) {
				s += Math.pow(1.0*(SN.charAt(i)-'0'), 1.0*n);
			}
			if(s == N ) {
				System.out.println("Armstrong");
			}else {
				System.out.println("Not Armstrong");
			}
		}
		sc.close();
	}
}
