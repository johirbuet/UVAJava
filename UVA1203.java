import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class UVA1203 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Query> pq = new PriorityQueue<>();
		int K  = 0;
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			StringTokenizer st = new StringTokenizer(line);
			if(line.equals("#")) {
				K = Integer.parseInt(sc.nextLine());
				break;
			}
			String name = st.nextToken();
			Query q = new Query(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			pq.add(q);
		}
		while(K-- > 0) {
			Query q = pq.poll();
			System.out.println(q.id);
			q.period += q.c;
			pq.add(q);
		}
		sc.close();
	}
	
	public static class Query implements Comparable<Query>{
		int id, period, c;
		Query(int x, int y)
		{
			id = x;
			period = c = y;
		}
		@Override
		public int compareTo(Query x)
		{
			if(period!=x.period)
				return period - x.period;
			return id - x.id;
		}
	}
}
