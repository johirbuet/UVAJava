import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UVA200 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<>();
		int max = 0;
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			if(line.equals("#")) break;
			list.add(line);
			max = Math.max(max, line.length());
		}
		List<Character> chars = new ArrayList<>();
		for(int i = 0; i<max;i++) {
			for(String s : list) {
				if(s.length() > i) {
					if(!chars.contains(s.charAt(i))) {
						chars.add(s.charAt(i));
					}
				}
			}
		}
		String res = "";
		for(char c : chars) {
			res += c;
		}
		System.out.println(res);
		sc.close();
	}
}
