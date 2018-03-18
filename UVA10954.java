import java.util.PriorityQueue;
import java.util.Scanner;

public class UVA10954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			if( N == 0) break;
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			int cost = 0;
			for(int i =0; i<N; i++) {
				pq.add(sc.nextInt());
			}
			
			while(!pq.isEmpty()) {
				if(pq.size() <= 1) {
					//cost += pq.poll();
					break;
				}
				int c = pq.poll() + pq.poll();
				cost += c;
				pq.add(c);
			}
			//cost = pq.poll();
			System.out.println(cost);
			//System.out.println(pq.size());
		}
		sc.close();
	}
}
