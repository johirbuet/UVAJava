import java.util.Scanner;

public class UVA10530 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] l = new int[11];
		int [] h = new int[11];
		while(sc.hasNextLine()) {
			int g = Integer.parseInt(sc.nextLine());
			
			if(g == 0) break;
			String decision = sc.nextLine();
			if(decision.equals("right on")) {
				if(h[g] == 0 && l[g] == 0) {
					System.out.println("Stan may be honest");
				}else {
					System.out.println("Stan is dishonest");
				}
				l =  new int[11];
				h =  new int[11];
			}else if(decision.equals("too high")) {
				for(int i =g; i<= 10 ;i++) {
					h[i]++;
				}
			}else {
				for(int i =g;i>= 0 ;i--) {
					l[i]++;
				}
			}
		}
		sc.close();
	}
}
