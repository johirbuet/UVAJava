import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UVA151 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			if (N == 0) {
				break;
			}
			
			int m = 1;
			for(;m<=N;m++) {
				List<Integer> list = new ArrayList<>();
				for(int i = 1;i<=N;i++) {
					list.add(i);
				}
				int c = 0;
				while(list.get(c)!= 13) {
					list.remove(c);
					c = c + (m - 1);
					if(c >= list.size()) {
						c = c%(list.size());
					}
				}
				if(list.size() == 1) {
					System.out.println(m);
					break;
				}
			}
		}
		sc.close();
	}
}
