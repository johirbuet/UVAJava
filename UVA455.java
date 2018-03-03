import java.util.Scanner;

public class UVA455 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		while(T-- > 0) {
			sc.nextLine();
			String s = sc.nextLine();
			int N = s.length();
			int count = 0;
			for(int i = 1;  i <= N; i++) {
				String part = s.substring(0, i);
				int parlen = part.length();
				String r = "";
				for(int j = 0; j<N/parlen;j++) {
					r = r + part;
				}
				if(s.equals(r)) {
					count = parlen;
					break;
				}
			}
			System.out.println(count);
			if( T > 0) {
				System.out.println();
			}
		}
		sc.close();
	}
}
