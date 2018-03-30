import java.util.Scanner;
import java.awt.geom.*;
import java.io.*;

public class UVA11800 {

	public static Point2D.Double readPointy(String line) {
		String b, b2;
		int j = 0;
		while (line.charAt(j) != ' ') {
			j++;
		}
		b = line.substring(0, j);
		b2 = line.substring(j + 1);
		return new Point2D.Double(Integer.parseInt(b), Integer.parseInt(b2));
	}

	public static double distance(Line2D s) {
		return s.getP1().distance(s.getP2());
	}

	public static double angle(Line2D s1, Line2D s2) {
		double d1, d2, d3;
		d1 = distance(s1);
		d2 = distance(s2);
		Point2D p1, p2;
		p1 = s1.getP1();
		p2 = s1.getP2();
		if (s2.getP1().equals(p1)) {
			p1 = s2.getP2();
		} else if (s2.getP2().equals(p1)) {
			p1 = s2.getP1();
		} else if (s2.getP1().equals(p2)) {
			p2 = s2.getP2();
		} else {
			p2 = s2.getP1();
		}
		d3 = distance(new Line2D.Double(p1, p2));
		return (d1 * d1 + d2 * d2 - (d3 * d3)) / (2 * d1 * d2);
	}

	public static double slope(Line2D s) {
		return (s.getY2() - s.getY1()) / (s.getX2() - s.getX1());
	}

	public static boolean parallel(Line2D s1, Line2D s2) {
		if (s1.getX2() == s1.getX1()) {
			return (s2.getX2() == s2.getX1());
		}
		return (slope(s1) == slope(s2));
	}

	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		int count = 0;
		try {// line = in.readLine();
			count = Integer.parseInt(in.readLine());
		} catch (IOException e) {
		}
		for (int casenum = 1; casenum <= count; casenum++) {
			Point2D.Double p[] = new Point2D.Double[4];
			for (int j = 0; j < 4; j++) {
				try {
					p[j] = readPointy(in.readLine());
				} catch (IOException e) {
				}
			}
			Line2D.Double l[] = new Line2D.Double[6];
			l[0] = new Line2D.Double(p[0], p[1]);
			l[1] = new Line2D.Double(p[0], p[2]);
			l[2] = new Line2D.Double(p[0], p[3]);
			l[3] = new Line2D.Double(p[1], p[2]);
			l[4] = new Line2D.Double(p[1], p[3]);
			l[5] = new Line2D.Double(p[2], p[3]);
			Line2D.Double s[] = new Line2D.Double[4];
			if (l[0].intersectsLine(l[5])) {
				s[0] = l[1];
				s[1] = l[2];
				s[2] = l[4];
				s[3] = l[3];
			} else if (l[1].intersectsLine(l[4])) {
				s[0] = l[0];
				s[1] = l[2];
				s[2] = l[5];
				s[3] = l[3];
			} else {
				s[0] = l[0];
				s[1] = l[1];
				s[2] = l[5];
				s[3] = l[4];
			}
			if (distance(s[0]) == distance(s[2]) && distance(s[1]) == distance(s[3])) {
				if (distance(s[1]) == distance(s[0])) {
					if ((angle(s[0], s[1])) == angle(s[1], s[2]))
						out.append("Case " + casenum + ": Square\n");
					else
						out.append("Case " + casenum + ": Rhombus\n");
				} else {
					if ((angle(s[0], s[1])) == angle(s[1], s[2]))
						out.append("Case " + casenum + ": Rectangle\n");
					else
						out.append("Case " + casenum + ": Parallelogram\n");
				}
			} else if (parallel(s[0], s[2]) || parallel(s[1], s[3])) {
				out.append("Case " + casenum + ": Trapezium\n");
			} else {
				out.append("Case " + casenum + ": Ordinary Quadrilateral\n");
			}
		}
		System.out.print(out);
	}
}
