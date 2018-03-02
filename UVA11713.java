import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UVA11713 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		Set<Character> set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		for(int t = 1; t <= T; t++) {
			String a =sc.nextLine();
			String b = sc.nextLine();
			boolean yes = true;
			if(a.length() != b.length()) {
				yes = false;
			}else {
				for(int i = 0; i< a.length();i++) {
					if(!set.contains(a.charAt(i))) {
						if(a.charAt(i) != b.charAt(i)) {
							yes = false;
							break;
						}
					}else {
						if(!set.contains(b.charAt(i))) {
							yes = false;
							break;
						}
					}
				}
			}
			System.out.println(yes?"Yes":"No");
		}
		sc.close();
	}
}
