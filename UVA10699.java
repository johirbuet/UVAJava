import java.util.Scanner;

public class UVA10699 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] primes = new int [500001];
		for(int i =2; i < 500001;i++) {
			if( primes[i] == 0) {
				for(int j = i*i;j< 500001;j+=i) {
					primes[j] = 1;
				}
			}
		}
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			if( N == 0) {
				break;
			}
			int count = 0;
			for(int i =2; i< Math.sqrt(N);i++) {
				if(primes[i] == 0 && N%i==0) {
					count++;
					if(primes[N/i] == 0 && N/i != i) {
						count++;
					}
				}
			}
			System.out.println(N+" : "+count);
		}
		sc.close();
	}
}
