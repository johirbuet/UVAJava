import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class UVA10258 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		sc.nextLine();
		while(T-- > 0) {
			Map<Integer, Contestant> contest = new HashMap<>();
			while(true) {
				String s = sc.nextLine();
				if(s == null || s.equals("")) {
					break;
				}
				String [] row = s.split(" ");
				int team = Integer.parseInt(row[0]);
				int problem = Integer.parseInt(row[1]);
				int time = Integer.parseInt(row[2]);
				String d = row[3];
				if(contest.containsKey(team)) {
					Contestant c = contest.get(team);
					if(d.equals("C")) {
						c.solve(problem, time);
					}else if(d.equals("I")) {
						c.wrong(problem);
					}
					contest.put(team, c);
				}else {
					Contestant c = new Contestant(team);
					if(d.equals("C")) {
						c.solve(problem, time);
					}else if(d.equals("I")) {
						c.wrong(problem);
					}
					contest.put(team, c);
				}
			}
			PriorityQueue<Contestant> pq = new PriorityQueue<>(Collections.reverseOrder());
			for(int cn : contest.keySet()) {
				pq.add(contest.get(cn));
			}
			while(!pq.isEmpty()) {
				Contestant c = pq.poll();
				System.out.println(c);
			}
			System.out.println();
			
		}
		sc.close();
	}
	static class Contestant implements Comparable<Contestant>{
		boolean [] solved;
		int score;
		int count;
		int id;
		int [] attempt;
		public Contestant(int id) {
			this.id = id;
			solved = new boolean[10];
			attempt = new int[10];
			score = 0;
			count = 0;
			
		}
		public void solve(int i,int time) {
			if(solved[i] == false) {
				count++;
				score+= time+ attempt[i]*20;
				solved[i] = true;
			}
		}
		public void wrong(int i) {
			if(!solved[i]) {
				attempt[i]++;
			}
		}
		@Override
		public int compareTo(Contestant o) {
			if(this.count == o.count) {
				if(this.score == o.score) {
					return o.id - this.id;
				}else {
					return o.score - this.score;
				}
				
			}
			else{
				return this.count - o.count;
			}
		}
		@Override
		public String toString() {
			return id+" "+count + " "+score;
		}
	}
}
