import java.util.Scanner;

public class UVA11470 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = 1;
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			if( N == 0) break;
			int [][] grid = new int[N][N];
			for(int i =0; i< N; i++) {
				for(int j =0; j< N; j++) {
					grid[i][j] = sc.nextInt();
				}
			}
			
			System.out.printf("Case %d:",c++);
			for(int i =0; i< N/2;i++) {
				int sum = 0;
				for(int j = i; j < N - i -1;j++) {
					sum += grid[i][j] + grid[N - i - 1][N - j -1] + grid[N- j - 1][i] + grid[j][N- i - 1];
				}
				System.out.printf(" %d",sum);
			}
			if( N%2 == 1) {
				System.out.printf(" %d",grid[N/2][N/2]);
			}
			System.out.println();
		}
		sc.close();
	}
}
