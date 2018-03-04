import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UVA12896 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer,String> map = new HashMap<>();
		map.put(0, " ");
		map.put(1, ".,?\"");
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		int T = sc.nextInt();
		for(int t = 1; t<= T; t++) {
			int L = sc.nextInt();
			int [] K = new int[L];
			int [] F = new int[L];
			String s = "";
			for(int i =0 ; i < L;i++) {
				K[i] = sc.nextInt();
			}
			for(int i =0 ; i < L;i++) {
				F[i] = sc.nextInt();
			}
			for(int i =0 ; i < L;i++) {
				s = s + map.get(K[i]).charAt(F[i] -1);
			}
			System.out.println(s);
		}
		sc.close();
	}
}
