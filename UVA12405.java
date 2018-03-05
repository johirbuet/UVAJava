import java.util.Scanner;

public class UVA12405 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 1; t<= T; t++) {
			int N = Integer.parseInt(sc.nextLine());
			String s = sc.nextLine();
			int ans = 0;
			for(int i = 0; i<N;i++) {
				if(s.charAt(i) == '.') {
					ans++;
					i= i+2;
				}
			}
			System.out.println("Case "+t+": "+ans);
		}
		sc.close();
	}
}
