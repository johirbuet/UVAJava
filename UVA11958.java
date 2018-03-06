import java.util.PriorityQueue;
import java.util.Scanner;

public class UVA11958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 1; t <= T; t++) {
			String line = sc.nextLine();
			String [] kct = line.split(" ");
			int K = Integer.parseInt(kct[0]);
			String[] hm = kct[1].split(":");
			int h = Integer.parseInt(hm[0]);
			int m = Integer.parseInt(hm[1]);
			int ct = h*60+m;
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for(int i =0; i< K;i++) {
				line = sc.nextLine();
				String [] tT = line.split(" ");
				String [] hmb = tT[0].split(":");
				int tn = Integer.parseInt(tT[1]);
				int hb = Integer.parseInt(hmb[0]);
				int mb = Integer.parseInt(hmb[1]);
				int at = hb * 60 + mb;
				if(at < ct) at = at + 1440;
				pq.add(at - ct + tn);
			}
			System.out.printf("Case %d: %d\n",t,pq.poll());
		}
		sc.close();
	}
}
