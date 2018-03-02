import java.util.Scanner;

public class UVA11677 {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int H1 = sc.nextInt();
			int M1 = sc.nextInt();
			int H2 = sc.nextInt();
			int M2 = sc.nextInt();
			if(H1 == 0 && M1 == 0 && H2 == 0 && M2 == 0 ) {
				break;
			}
			if(H2 >= H1) {
				if(H2 == H1 && M2 >= M1) {
					int time = (H2 - H1) * 60 + M2 - M1;
					System.out.println(time);
				} else if (H2 > H1) {
					int time = (H2 - H1) * 60 + M2 - M1;
					System.out.println(time);
				}
				else {
					int time = (H2 + 24 - H1) * 60 + M2 - M1;
					System.out.println(time);
				}
			}
			else {
				int time = (H2 + 24 - H1) * 60 + M2 - M1;
				System.out.println(time);
			}
		}
		sc.close();
	}
}
