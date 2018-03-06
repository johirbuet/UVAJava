import java.util.PriorityQueue;
import java.util.Scanner;

public class UVA11900 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t =1; t <= T; t++) {
			int n = sc.nextInt();
			int p = sc.nextInt();
			int q = sc.nextInt();
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for(int i =0; i< n; i++) {
				pq.add(sc.nextInt());
			}
			int count = 0;
			while(!pq.isEmpty()) {
				int w = pq.poll();
				if( w <= q) {
					count++;
					q = q - w;
				}
				if(count == p) {
					break;
				}
			}
			System.out.printf("Case %d: %d\n",t,count);
		}
		sc.close();
	}
}
