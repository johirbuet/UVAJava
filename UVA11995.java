import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
/*
 *

 */

public class UVA11995 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			Stack<Integer> stack = new Stack<>();
			Queue<Integer> qu = new ArrayDeque<Integer>();
			boolean bpq = true;
			boolean bstack  = true;
			boolean bqu = true;
			int N  = sc.nextInt();
			for(int i =0; i< N; i++) {
				int c = sc.nextInt();
				int x = sc.nextInt();
				if( c  == 1) {
					if(bpq) {
						pq.offer(x);					
						}
					if(bqu) {
						qu.offer(x);
					}
					if(bstack) {
						stack.add(x);
					}
				}else {
					
					if(bpq && !pq.isEmpty()) {
						int y1 = pq.poll();
						if( y1 != x) {
							bpq = false;
						}
					}else {
						bpq = false;
					}
					
					if(bstack && !stack.isEmpty()) {
						int y2 = stack.pop();
						if( x != y2) {
							bstack = false;
						}
					}else {
						bstack = false;
					}
					
					if(bqu && !qu.isEmpty()) {
						int y3 = qu.poll();
						if( y3 != x) {
							bqu = false;
						}
					}else {
						bqu = false;
					}
				}
			}
			if(!bpq && ! bqu && !bstack) {
				System.out.println("impossible");
			}else if(!bpq &&  bqu && !bstack) {
				System.out.println("queue");
			}
			else if(bpq &&  !bqu && !bstack) {
				System.out.println("priority queue");
			}else if(!bpq && ! bqu && bstack) {
				System.out.println("stack");
			}else {
				System.out.println("not sure");
			}
		}
		sc.close();
	}
}
