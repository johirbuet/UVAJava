import java.util.Scanner;

public class UVA1727 {

	static String[] day_str = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
	static String[] mon_str = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
	static int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int i =0; i < T; i++) {
			String [] md = sc.nextLine().split(" ");
			int d = -1;
			for(int x =0; x < day_str.length; x++) {
				if(day_str[x].equals(md[1])) {
					d = x;
					break;
				}
			}
			int m = -1;
			for(int x =0; x < mon_str.length; x++) {
				if(mon_str[x].equals(md[0])) {
					m = x;
					break;
				}
			}
			int ret = 0;
			for(int x =0; x < days[m];x++) {
				if((d+x)%7 == 5 || (d + x)%7 ==6) {
					ret++;
				}
			}
			System.out.println(ret);
		}
		sc.close();
	}
}
