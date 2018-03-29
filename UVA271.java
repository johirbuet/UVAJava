import java.util.Scanner;

public class UVA271 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String w = sc.nextLine();
			if(w.isEmpty()) {
				break;
			}
			int n = w.length() - 1;
			int accept = 0;
			boolean ok = true;
			for(int i = n; i >= 0; i--) {
				if("pqrstuvwxyz".indexOf(w.charAt(i)) >= 0) {
					accept++;
				}else if(w.charAt(i) == 'N') {
					if(accept == 0) {
						ok = false;
						accept = 1;
						break;
					}
				}else if("CDEI".indexOf(w.charAt(i)) >=0) {
					if(accept < 2) {
						ok = false;
						accept = 1;
						break;
					}
					accept--;
				}else {
					ok = false;
					accept = 1;
					break;
				}
			}
			if(ok == true && accept != 1) {
				ok = false;
			}
			System.out.println(ok?"YES":"NO");
		}
		sc.close();
	}
}
