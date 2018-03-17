import java.util.Scanner;

public class UVA12897 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 0; t < T; t++) {
			String line = sc.nextLine();
			int N = Integer.parseInt(sc.nextLine());
			for(int i = 0; i< N; i++) {
				String [] s = sc.nextLine().split(" ");
				line = line.replaceAll(s[1], s[0]);
			}
			
			System.out.println(line);
		}
		sc.close();
	}
}
