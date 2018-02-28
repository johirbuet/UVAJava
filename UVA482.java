import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UVA482 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 0 ; t < T ;t++) {
			sc.nextLine();
			List<Integer> list = new ArrayList<>();
			String line = sc.nextLine();
			String [] idxs = line.split(" ");
			for(String s: idxs) {
				list.add(Integer.parseInt(s));
			}
			String [] strs = sc.nextLine().split(" ");
			String [] res = new String [list.size()];
			for(int i = 0; i<list.size();i++) {
				res[list.get(i) - 1] = strs[i];
			}
			for(String s : res) {
				System.out.println(s);
			}
			if(t < T - 1) System.out.println();	
		}
		sc.close();
	}
}
