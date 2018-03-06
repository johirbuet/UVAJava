import java.util.Scanner;

public class UVA11965 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(sc.nextLine());
			String s = "";
			for(int i =0; i<N; i++) {
				s += sc.nextLine();
				if( i < N - 1) {
					s = s + "\n";
				}
			}
			System.out.println("Case "+t+":");
			System.out.println(s.replaceAll(" +", " "));
			if( t < T) {
				System.out.println();
			}
		}
		sc.close();
	}
}
