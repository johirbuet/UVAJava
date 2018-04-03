import java.util.Arrays;
import java.util.Scanner;

public class UVA10235 {
	public static void main(String[] args) {
		boolean [] prime = new boolean[1000001];
		Arrays.fill(prime, true);
		prime[1] = false;
		prime[2] = true;
		for(int i = 2;i*i <= 1000000; i++) {
			if(prime[i]) {
				for(int j = i*i;j< 1000000;j+=i) {
					prime[j] = false;
				}
			}
		}
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			String sn = new StringBuffer(n+"").reverse().toString();
			int nrev = Integer.parseInt(sn);
			if(prime[n]) {
				if(prime[nrev] && n != nrev) {
					System.out.printf("%d is emirp.\n",n);
				}else {
					System.out.printf("%d is prime.\n",n);
				}
			}else {
				System.out.printf("%d is not prime.\n",n);
			}
		}
		sc.close();
	}
}
