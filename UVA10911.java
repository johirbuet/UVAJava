import java.util.PriorityQueue;
import java.util.Scanner;

public class UVA10911 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = 1;
		while(sc.hasNextLine()) {
			int T = Integer.parseInt(sc.nextLine());
			if ( T == 0) {
				break;
			}
			PriorityQueue<Member> pq = new PriorityQueue<>();
			for(int i =0; i< 2*T; i++) {
				String [] strs = sc.nextLine().split(" ");
				int x = Integer.parseInt(strs[1]);
				int y = Integer.parseInt(strs[2]);
				Member m = new Member(x, y);
				pq.add(m);
			}
			double sum = 0;
			while(!pq.isEmpty()) {
				Member a = pq.poll();
				Member b = pq.poll();
				sum += Math.abs(Math.sqrt((b.x - a.x)*(b.x - a.x) + (b.y - a.y)*(b.y - a.y)));
			}
			System.out.println("Case "+t+": "+sum);
			t++;
		}
		sc.close();
	}
	static class Member implements Comparable<Member>{
		int x;
		int y;
		double distance;
		public Member(int x, int y) {
			this.x = x;
			this.y = y;
			distance = Math.sqrt(this.x*this.x + this.y*this.y);
		}
		@Override
		public int compareTo(Member m) {
			return Double.compare(this.distance, m.distance);
		}
	}
}
