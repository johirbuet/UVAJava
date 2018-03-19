import java.util.Scanner;

public class UVA541 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			if(N == 0) break;
			boolean parity = true;
			int [][] M = new int[N][N];
			int [] rows = new int[N];
			int [] cols = new int[N];
			for(int i =0; i<N;i++) {
				for(int j =0; j<N;j++) {
					M[i][j] = sc.nextInt();
					rows[i] += M[i][j];
					cols[j] += M[i][j];
				}
			}
			int oddrow = 0;
			int oddcol =0;
			int r = -1;
			int c = -1;
			for(int i =0;i<N;i++) {
				if(rows[i] %2 != 0) {
					oddrow++;
					r = i;
					parity = false;
				}
				if(cols[i]%2 != 0) {
					oddcol++;
					c = i;
					parity = false;
				}
			}
			if(parity) {
				System.out.println("OK");
			}else {
				if(oddcol == 1 && oddrow == 1) {
					System.out.printf("Change bit (%d,%d)\n",r+1,c+1);
				}else {
					System.out.println("Corrupt");
				}
			}
		
			
		}
		sc.close();
	}
}
