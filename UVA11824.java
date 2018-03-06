import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class UVA11824 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int max = 5000000;
		for(int t = 1; t <= T; t++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			while(true) {
				int l = sc.nextInt();
				pq.add(l);
				if(l == 0) {
					break;
				}
			}
			long sum = 0;
			int p = 1;
			while(!pq.isEmpty()) {
				sum = sum + 2*(int)Math.pow(pq.poll(), p++);
				if(sum > max) {
					break;
				}
			}
			if(sum > max) {
				System.out.printf("%s\n","Too expensive");
			}else {
				System.out.printf("%d\n",sum);
			}
		}
		sc.close();
	}
}
