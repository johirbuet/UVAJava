import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UVA10252 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String a = sc.nextLine();
			String b = sc.nextLine();
			Map<Character, Integer> A = new HashMap<>();
			Map<Character, Integer> B = new HashMap<>();
			for (char c : a.toCharArray()) {
				A.put(c, A.getOrDefault(c, 0) + 1);
			}
			for (char c : b.toCharArray()) {
				B.put(c, B.getOrDefault(c, 0) + 1);
			}
			List<Character> list = new ArrayList<>();
			for (char c : A.keySet()) {
				if (B.containsKey(c)) {
					int min = Math.min(A.get(c), B.get(c));
					while (min-- > 0) {
						list.add(c);
					}
				}
			}
			Collections.sort(list);
			StringBuilder builder = new StringBuilder(list.size());
			for (Character ch : list) {
				builder.append(ch);
			}
			System.out.println(builder.toString());
		}
		sc.close();
	}
}
