import java.util.Scanner;

public class UVA12243 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
			if(s.equals("*")) {
				break;
			}
			s = s.toLowerCase();
			String [] strs = s.split(" ");
			char c = strs[0].charAt(0);
			int total = 0;
			for (String string : strs) {
				if(string.charAt(0) == c) {
					total++;
				}
			}
			if(total == strs.length) {
				System.out.println("Y");
			}else {
				System.out.println("N");
			}
		}
		sc.close();
	}
}
