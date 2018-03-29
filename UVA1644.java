import java.util.Arrays;
import java.util.Scanner;

public class UVA1644 {
	public static void main(String[] args) {
		boolean [] primes = new boolean[1299710];
		Arrays.fill(primes, true);
		primes[0] = false;
		for(int i =2; i< Math.sqrt(1299710);i++) {
			for(int j = i*i;j < 1299710;j+=i) {
				if(primes[i]) {
					primes[j] = false;
				}
			}
		}
		int [] primeNums = new int[100001];
		int k =0;
		for(int i = 2; i < 1299710;i++) {
			if(primes[i]) {
				primeNums[k++] = i;
			}
		}
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			if( n <= 0) {
				break;
			}
			int index = Arrays.binarySearch(primeNums, n);
			if(index >= 0) {
				System.out.println(0);
			}
			else {
				index = -index - 1;
				System.out.println(primeNums[index] - primeNums[index -1]);
			}
		}
		sc.close();
	}
}
