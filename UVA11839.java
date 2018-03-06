import java.util.Scanner;

public class UVA11839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			if( N == 0) break;
			for(int a = 0; a < N; a++) {
				int [] A = new int[5];
				int sum = 0;
				int index = -1;
				for(int i =0; i< 5;i++) {
					int x = sc.nextInt();
					A[i] = x > 127?0:1;
					sum += A[i];
					if(A[i] == 1) {
						index = i;
					}
				} 
				if(sum != 1) {
					System.out.println("*");
				}else {
					switch (index) {
					case 0:
						System.out.println("A");
						break;
					case 1:
						System.out.println("B");
						break;
					case 2:
						System.out.println("C");
						break;
					case 3:
						System.out.println("D");
						break;
					case 4:
						System.out.println("E");
						break;
					default:
						break;
					}
				}
			}
			
		}
		sc.close();
	}
}
