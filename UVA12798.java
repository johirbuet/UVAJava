import java.util.Scanner;

public class UVA12798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			int M  = sc.nextInt();
			int total =0;
			for(int i =0; i< N; i++) {
				int count = 0;
				for(int j =0; j< M;j++) {
					int x = sc.nextInt();
					if(x > 0) {
						count++;
					}
				}
				if(count == M) {
					total++;
				}
			}
			System.out.println(total);
		}
		sc.close();
	}
}
