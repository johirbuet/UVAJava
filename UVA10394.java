import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UVA10394 {
	public static void main(String[] args) {
		boolean [] prime = new boolean[20000001];
		Arrays.fill(prime, true);
		List<Pair> list = new ArrayList<>();
		for(int i =2;i*i < 20000001;i++) {
			if(prime[i]) {
				for(int j = i*i;j< 20000001;j += i) {
					prime[j] = false;
				}
			}
		}
		for(int i =2;i<20000001 - 2;i++) {
			if(prime[i] == true && prime[i+2] == true) {
				list.add(new Pair(i, i+2));
			}
			if( i > 2) {
				i++;
			}
		}
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			Pair p = list.get(N - 1);
			System.out.printf("(%d, %d)\n",p.x,p.y);

		}
		sc.close();
	}
	static class Pair{
		int x;
		int y;
		public Pair(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}
