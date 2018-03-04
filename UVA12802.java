import java.util.Scanner;

public class UVA12802 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean [] primes = new boolean[1000001];
		seive(primes);
		while(sc.hasNextLong()) {
			int N = sc.nextInt();
			
			System.out.println(2*N);
			if(primes[N]) {
				String s = N+"";
				if(s.equals(new StringBuilder(s).reverse().toString())) {
					break;
				}
			}
		}
		sc.close();
	}
	public static void seive(boolean [] prime) {
		for(int i = 0; i< prime.length;i++) {
			prime[i] = true;
		}
		for(int i =2; i*i <= prime.length;i++) {
			if(prime[i] == true) {
				for(int j = 2*i;j< prime.length; j+=i) {
					prime[j] =false;
				}
			}
		}
	}
}
