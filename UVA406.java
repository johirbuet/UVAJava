import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UVA406 {
	public static void main(String[] args) {
		boolean [] prime = new boolean[1001];
		Arrays.fill(prime, true);
		for(int i = 2; i*i < 1001;i++) {
			if(prime[i]) {
				for(int j = i*i;j <1001;j+=i) {
					prime[j] = false;
				}
			}
		}
		
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			List<Integer> primes = new ArrayList<>();
			for(int i =2; i <= N;i++) {
				if(prime[i]) {
					primes.add(i);
				}
			}
			int C = sc.nextInt();
			if(primes.size()%2 == 0) {
				int start = primes.size()/2 - C;
				System.out.printf("%d %d:",N,C);
				for(int i = start;i< primes.size()/2+C;i++) {
					System.out.print(" ");
					System.out.print(primes.get(i));
				}
			}else {
				int start = primes.size()/2 - C;
				System.out.printf("%d %d:",N,C);
				for(int i = start;i< primes.size()/2+C -1;i++) {
					System.out.print(" ");
					System.out.print(primes.get(i));
				}
			}
			System.out.println();
		}
		sc.close();
	}
}
