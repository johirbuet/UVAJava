import java.util.Scanner;

public class UVA10703 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int W = sc.nextInt();
			int H = sc.nextInt();
			int N =sc.nextInt();
			if(W == 0 && H ==0 && N ==0 ) {
				break;
			}
			boolean [][] grid = new boolean[W][H];
			for(int i =0; i< N;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				int d = sc.nextInt();
				int x1 = Math.min(a, c);
				int x2 = Math.max(a, c);
				int y1 = Math.min(b, d);
				int y2 = Math.max(b, d);
				for(int x = x1;x<=x2;x++) {
					for(int y=y1;y<=y2;y++) {
						grid[x - 1][y - 1] = true;
					}
				}
			}
			int count = 0;
			for(int i =0; i<W;i++) {
				for(int j =0; j<H;j++) {
					if(!grid[i][j]) count++;
				}
			}
			if(count == 0) {
				System.out.println("There is no empty spots.");
			}else if(count == 1) {
				System.out.println("There is one empty spot.");
			} else {
				System.out.println("There are "+count+" empty spots.");
			}
		}
		sc.close();
	}
}
