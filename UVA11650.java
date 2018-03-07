import java.util.Scanner;

public class UVA11650 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 1; t <= T; t++) {
			String [] hm = sc.nextLine().split(":");
			int h = Integer.parseInt(hm[0]);
			int m = Integer.parseInt(hm[1]);
			h = (11 - h);
			if( m == 0) {
				h++;
			}
			if( h <= 0) h = h + 12;
			if(m != 0) {
				m =  60 - m;
			}
			System.out.printf("%02d:%02d\n",h,m);
		}
		sc.close();
	}
}
