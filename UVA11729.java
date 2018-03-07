import java.util.PriorityQueue;
import java.util.Scanner;

public class UVA11729 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = 1;
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			if( N ==0 ) break;
			PriorityQueue<Commando> pq = new PriorityQueue<>();
			for(int i =0; i< N; i++) {
				int b = sc.nextInt();
				int j = sc.nextInt();
				Commando cm = new Commando(b, j);
				pq.add(cm);
			}
			int sum = 0;
			int ans = 0;
			while(!pq.isEmpty()) {
				Commando cm = pq.poll();
				ans = Math.max(ans, sum+cm.b + cm.j);
				sum += cm.b;
			}
			System.out.printf("Case %d: %d\n",c++,ans);
		}
		sc.close();
	}
	
	static class Commando implements Comparable<Commando>{
		int b;
		int j;
		public Commando(int b, int j) {
			this.b = b;
			this.j = j;
		}
		@Override
		public int compareTo(Commando o) {
			return o.j - this.j;
		}
	}
}
