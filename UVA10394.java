import java.util.Arrays;
import java.util.Scanner;

public class UVA10394 {
	public static void main(String[] args) {
		boolean [] prime = new boolean[20000001];
		Arrays.fill(prime, true);
		for(int i =2;i*i < 20000001;i++) {
			if(prime[i]) {
				for(int j = i*i;j< 20000001;j += i) {
					prime[j] = false;
				}
			}
		}
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			int c = 0;
			for(int i = 2;i < 20000001;i++) {
				if(prime[i] && prime[i+2]) {
					c++;
					if(c == N) {
						System.out.printf("(%d, %d)\n",i,i+2);
						break;
					}
				}
			}
		}
		sc.close();
	}
}
