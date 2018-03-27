import java.util.PriorityQueue;
import java.util.Scanner;

public class UVA837 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i =0; i< N;i++) {
			int nl = sc.nextInt();
			PriorityQueue<Point> pq = new PriorityQueue<>();
			for(int j =0; j< nl;j++) {
				double x1 = sc.nextDouble();
				double y1 = sc.nextDouble();
				double x2 = sc.nextDouble();
				double y2 = sc.nextDouble();
				double r = sc.nextDouble();
				if(x1 > x2) {
					double temp = x1;
					x1 = x2;
					x2 = temp;
				}
				Point l = new Point(x1,r, true);
				Point e = new Point(x2, r, false);
				pq.add(l);
				pq.add(e);
			}
			double now = pq.peek().x;
			double r = 1.000;
			System.out.printf( "%d\n", nl * 2 + 1 );
			System.out.printf( "-inf %.3f %.3f\n", now, r );
			
			for(int x = 0; x < 2*nl;x++) {
				Point l = pq.poll();
				if(now != l.x) {
					System.out.printf( "%.3f %.3f %.3f\n", now, l.x, r );
				}
				if(l.start == true) {
					r = r * l.r;
				}else {
					r = r / l.r;
				}
				now = l.x;
			}
			System.out.printf( "%.3f +inf %.3f\n", now,r );
			if( i < N -1) {
				System.out.println();
			}

		}
		sc.close();
	}
	
	static class Point implements Comparable<Point>{
		double x;
		double r;
		boolean start;
		public Point(double x,double r,boolean start) {
			this.x = x;
			this.r = r;
			this.start = start;
		}
		@Override
		public int compareTo(Point o) {
			return Double.compare(this.x, o.x);
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return x + " "+r+" "+start;
		}
	}
}
