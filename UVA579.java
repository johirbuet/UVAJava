import java.util.Scanner;

public class UVA579 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
			if(s.equals("0:00")) {
				break;
			}
			String [] hm = s.split(":");
			int h = Integer.parseInt(hm[0]);
			int m = Integer.parseInt(hm[1]);
			double md = m*6;
			double hd = h*30 + 0.5*m;
			double diff = Math.min(Math.abs(md - hd),Math.abs(360 - Math.abs(md - hd)));
			System.out.printf("%.3f\n",diff);
		}
		sc.close();
	}
}
