import java.util.Scanner;

public class UVA414 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String sN = sc.nextLine();
			int N = Integer.parseInt(sN);
			if( N == 0) break;
			char [][] I = new char[N][25];
			int min = Integer.MAX_VALUE;
			int [] Bs = new int[N];
			for(int i =0; i< N;i++) {
				int B = 0;
				String line = sc.nextLine();
				int k = 0;
				for(char c: line.toCharArray()) {
					if(c == ' ') {
						B++;
					}
					I[i][k++] = c;
				}
				Bs[i] = B;
				min = Math.min(B, min);
			}
			int sum = 0;
			for(int b : Bs) {
				sum += b -min;
			}
			System.out.println(sum);
		}
		sc.close();
	}
}
