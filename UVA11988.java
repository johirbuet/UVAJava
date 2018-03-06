import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class UVA11988 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			List<Character> list = new LinkedList<>();
			int cur = 0;
			for(char c : line.toCharArray()) {
				if( c == '[') {
					cur = 0;
				}else if ( c == ']') {
					cur = list.size();
				}else {
					list.add(cur++, c);
				}
			}
			StringBuilder sb = new StringBuilder();
			for(char c : list) sb.append(c);
			System.out.println(sb.toString());
		}
		sc.close();
	}
	
}
