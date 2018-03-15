import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class UVA11804 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 1; t<= T; t++) {
			PriorityQueue<Player> pq = new PriorityQueue<>();
			for(int i =0; i<10;i++) {
				String [] line = sc.nextLine().split(" ");
				String name = line[0];
				int A = Integer.parseInt(line[1]);
				int D = Integer.parseInt(line[2]);
				Player p = new Player(A, D, name);
				pq.add(p);
			}
			List<String> attackers = new ArrayList<>();
			List<String> defenders = new ArrayList<>();
			for(int i =0; i< 5; i++) {
				Player p = pq.poll();
				attackers.add(p.name);
			}
			for(int i =0; i< 5; i++) {
				Player p = pq.poll();
				defenders.add(p.name);
			}
			System.out.printf("Case %d:\n",t);
			System.out.print("(");
			Collections.sort(attackers);
			Collections.sort(defenders);
			for(int i =0 ; i< 4 ;i++) {
				System.out.print(attackers.get(i)+", ");
			}
			System.out.println(attackers.get(4)+")");
			
			System.out.print("(");
			for(int i =0 ; i< 4 ;i++) {
				System.out.print(defenders.get(i)+", ");
			}
			System.out.println(defenders.get(4)+")");
		}
		sc.close();
	}
	
	static class Player implements Comparable<Player> {
		int A;
		int D;
		String name;
		public Player(int A, int D, String name) {
			this.A  = A;
			this.D = D;
			this.name = name;
		}
		@Override
		public int compareTo(Player o) {
			if(this.A == o.A) {
				if(this.D == o.D) {
					return this.name.compareTo(o.name);
				}
				return this.D - o.D;
			}
			return o.A - this.A;
		}
	}
}
