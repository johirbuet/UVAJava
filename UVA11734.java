import java.util.Scanner;

public class UVA11734 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 1; t<= T; t++) {
			String a = sc.nextLine();
			String b = sc.nextLine();
			if(a.length()!= b.length()) {
				a =a.replaceAll(" ", "");
				b = b.replaceAll(" ", "");
				if(a.equals(b)) {
					System.out.printf("Case %d: %s\n",t,"Output Format Error");
				}else {
					System.out.printf("Case %d: %s\n",t,"Wrong Answer");
				}
			}else {
				if(a.equals(b)) {
					System.out.printf("Case %d: %s\n",t,"Yes");
				}else {
					System.out.printf("Case %d: %s\n",t,"Wrong Answer");
				}
			}
		}
		sc.close();
	}
}
