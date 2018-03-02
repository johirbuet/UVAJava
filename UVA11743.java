import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UVA11743 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		while(T-- > 0) {
			char [] c = sc.nextLine().toCharArray();
			List<Character> list = new ArrayList<>();
			for(char x : c) {
				if(x >='0' && x <= '9') {
					list.add(x);
				}
			}
			boolean ok = Luhn(list);
			System.out.println(ok?"Valid":"Invalid");
		}
		sc.close();
	}
	public static boolean Luhn(List<Character> list) {
		int sum = 0;
		for(int i = list.size() -2; i>=0;) {
			int x = list.get(i) - '0';
			x = x * 2;
			sum += x/10;
			sum += x%10;
			i = i -2;
		}
		for(int i = list.size() - 1; i>=0;) {
			int x = list.get(i) - '0';
			sum += x;
			i = i -2;
		}
		return sum%10  == 0;
	}
}
