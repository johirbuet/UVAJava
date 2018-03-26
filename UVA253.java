import java.util.PriorityQueue;
import java.util.Scanner;

public class UVA253 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			if(line.isEmpty()) {
				break;
			}
			char [] A = line.substring(0, 6).toCharArray();
			char [] B = line.substring(6).toCharArray();
			PriorityQueue<Side> apq = new PriorityQueue<>();
			PriorityQueue<Side> bpq = new PriorityQueue<>();
			apq.add(new Side(A[0], A[5]));
			apq.add(new Side(A[1], A[4]));
			apq.add(new Side(A[2], A[3]));
			bpq.add(new Side(B[0], B[5]));
			bpq.add(new Side(B[1], B[4]));
			bpq.add(new Side(B[2], B[3]));
			String a = "";
			while(!apq.isEmpty()) {
				a += apq.poll().side;
			}
			String b = "";
			while(!bpq.isEmpty()) {
				b += bpq.poll().side;
			}
			if(a.equals(b)) {
				System.out.println("TRUE");
			}else {
				System.out.println("FALSE");
			}
			
		}
		sc.close();
	}
	public static class Side implements Comparable<Side> {
		String side;

		public Side(char a,char b) {
			if(a > b) {
				side = b+""+a;
			}else {
				side = a+""+b;
			}
		}
		@Override
		public int compareTo(Side other) {
			return this.side.compareTo(other.side);
		}
		
	}
}
