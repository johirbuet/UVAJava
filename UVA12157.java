import java.util.Scanner;

public class UVA12157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int [] d = new int[N];
			int M = 0;
			int J = 0;
			for(int i = 0; i< N;i++) {
				d[i] = sc.nextInt();
				int x = d[i];
				int y = d[i];
				while(x >= 0) {
					M += 10;
					x = x -30;
					
				}
				while( y >= 0) {
					J += 15;
					y = y - 60;
				}
			}
			if( M > J) {
				System.out.printf("Case %d: %s %d\n",t,"Juice",J);
			}else if (J > M) {
				System.out.printf("Case %d: %s %d\n",t,"Mile",M);
			}else {
				System.out.printf("Case %d: %s %s %d\n",t,"Mile","Juice",M);
			}		
		}
		sc.close();
	}
}
