import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class UVA10901 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int x = 1; x<= T; x++) {
			String [] l = sc.nextLine().split(" ");
			int n = Integer.parseInt(l[0]);
			int t = Integer.parseInt(l[1]);
			int m = Integer.parseInt(l[2]);
			Queue<Integer> left = new LinkedList<>();
			Queue<Integer> right = new LinkedList<>();
			for(int i = 0; i< m ; i++) {
				String [] s = sc.nextLine().split(" ");
				int a = Integer.parseInt(s[0]);
				String b = s[1];
				if(b.equals("left")) {
					left.add(a);
				}else {
					right.add(a);
				}
			}
			boolean lside = true;
			int wtime = 0;
			int count = 0;
			while(!(left.isEmpty() && right.isEmpty())) {
				if(lside) {
					if(left.isEmpty()) {
						wtime += t;
						lside = false;
						continue;
					}
					
					while(!left.isEmpty() && left.peek() <= wtime && count <=n) {
						left.poll();
						count++;
					}
					wtime += t;
					while(count > 0) {
						System.out.println(wtime);
						count--;
					}
					lside = false;
				}else {
					if(right.isEmpty()) {
						wtime += t;
						lside = true;
						continue;
					}
					
					while(!right.isEmpty() && right.peek() <= wtime && count <= n) {
						right.poll();
						count++;
					}
					wtime += t;
					while(count > 0) {
						System.out.println(wtime);
						count--;
					}
					lside = true;
				}
			}
			System.out.println();
		}
		sc.close();
	}
}
