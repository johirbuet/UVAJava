import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class UVA10065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = 1;
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			if (n == 0) {
				break;
			}
			Point[] points = new Point[n + 1];
			for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				Point p = new Point(x, y);
				points[i] = p;
			}
			points[n] = new Point(points[0].x, points[0].y);
			double A = calc_area(points);
			Point [] hull = convex_hull(points);
			double Ac = calc_area(hull);
	        System.out.printf("Tile #%d\n", cases++);
	        System.out.printf("Wasted Space = %.2f %%\n\n", (Ac-A)*100/Ac);
		}
		sc.close();
	}

	public static Point [] convex_hull(Point[] points) {
		int n = points.length;
		if (n < 3)
			return null;

		// Initialize Result
		List<Point> hull = new ArrayList<Point>();

		// Find the leftmost point
		int l = 0;
		for (int i = 1; i < n; i++)
			if (points[i].x < points[l].x)
				l = i;
		int p = l, q;
		do {
			hull.add(points[p]);
			q = (p + 1) % n;

			for (int i = 0; i < n; i++) {
				if (orientation(points[p], points[i], points[q]) == 2)
					q = i;
			}
			p = q;

		} while (p != l); 
		hull.add(points[l]);
		Point [] P = new Point[hull.size()];
		for(int i =0; i< hull.size();i++) {
			P[i] = hull.get(i);
		}
		return P;
	}

	public static int orientation(Point p, Point q, Point r)
    {
        int val = (q.y - p.y) * (r.x - q.x) -
                  (q.x - p.x) * (r.y - q.y);
      
        if (val == 0) return 0;  // collinear
        return (val > 0)? 1: 2; // clock or counterclock wise
    }

	static double calc_area(Point P[]) {
		double ans = 0;
		int i;
		for (i = 0; i < P.length - 1; i++)
			ans += P[i].x * P[i + 1].y - P[i].y * P[i + 1].x;
		return Math.abs(ans) / 2;
	}
}
