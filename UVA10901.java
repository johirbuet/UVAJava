import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class UVA10901 {
	static class Car {
		int id;
		int t;
		public Car(int id,int t) {
			this.id = id;
			this.t= t;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int x = 1; x<= T; x++) {
			String [] l = sc.nextLine().split(" ");
			int n = Integer.parseInt(l[0]);
			int t = Integer.parseInt(l[1]);
			int m = Integer.parseInt(l[2]);
			Queue<Car> left = new LinkedList<>();
			Queue<Car> right = new LinkedList<>();
			int maxt = 0;
			for(int i = 0; i< m ; i++) {
				String [] s = sc.nextLine().split(" ");
				int a = Integer.parseInt(s[0]);
				maxt = Math.max(a, maxt);
				String b = s[1];
				if(b.equals("left")) {
					left.add(new Car(i,a));
				}else {
					right.add(new Car(i,a));
				}
			}
			boolean lside = true;
			int wt = 0;
			int [] res = new int[m];
			while(true) {
				int count = 0;
				if(left.size() == 0 && right.size() == 0) {
					break;
				}
				if((left.size() > 0 && wt < left.peek().t)) {
					if(right.size() > 0 && wt < right.peek().t) {
						wt += Math.min(left.peek().t - wt, right.peek().t - wt);
						continue;
					}
					else if (right.size() == 0) {
						wt += left.peek().t - wt;
						continue;
					}
				}
				if((right.size() > 0 && wt < right.peek().t)) {
					if(left.size() > 0 && wt < left.peek().t) {
						wt += Math.min(left.peek().t - wt, right.peek().t - wt);
						continue;
					}
					else if (left.size() == 0) {
						wt += right.peek().t - wt;
						continue;
					}
				}
				if(lside) {
					
					if(left.size() > 0 && left.peek().t <= wt && count < n) {
						
						int temp = wt  + t;
						while(left.size() > 0 && left.peek().t <= wt && count < n) {
							res[left.poll().id] = temp;
							//left.poll();
							count++;
						}
						
					}
					wt += t;
					lside = !lside;
				}else {
					if(right.size() > 0 && right.peek().t <= wt) {
						int temp = wt  + t;
						while(right.size() > 0 && right.peek().t <= wt && count < n) {
							//System.out.println(temp);
							res[right.poll().id] = temp;
							//right.poll();
							count++;
						}
					}
					wt += t;
					lside = !lside;
				}
			}
			for(int i =0; i < m;i++) System.out.println(res[i]);
			if(x < T) {
				System.out.println();
			}
		}
		sc.close();
	}
}
