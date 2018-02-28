import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UVA489 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			int r = Integer.parseInt(sc.nextLine());
			if(r == -1) {
				break;
			}
			String correct = sc.nextLine();
			String guess = sc.nextLine();
			Set<Character> set = new HashSet<>();
			for(char c : correct.toCharArray()) {
				set.add(c);
			}
			int count = 0;
			Map<Character,Boolean> map = new HashMap<>();
			String ans = "";
			for(char c: guess.toCharArray()) {
				if(map.get(c) != null) {
					continue;
				}
				
				map.put(c, true);
				if(set.size() == 0) {
					break;
				}
				if(set.contains(c)) {
					set.remove(c);
				}else {
					count++;
				}
			}
			if(set.size() == 0 && count < 7) {
				ans = "You win.";
			}else if(set.size()!= 0 && count < 7){
				ans = "You chickened out.";
			} else {
				ans = "You lose.";
			}
			System.out.println("Round "+r);
			System.out.println(ans);
		}
		sc.close();
	}
}
