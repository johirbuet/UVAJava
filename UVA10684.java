import java.util.Scanner;

public class UVA10684 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			if( N == 0) {
				break;
			}
			int sum = 0;
			int max = -1;
			for(int i =0; i< N; i++) {
				sum += sc.nextInt();
				if(sum > max) {
					max = sum;
				}
				if(sum < 0) {
					sum = 0;
				}
			}
			 if(sum > 0)
		            System.out.printf("The maximum winning streak is %d.\n", max);
		        else
		        	System.out.printf("Losing streak.\n");
		}
		sc.close();
	}
}
