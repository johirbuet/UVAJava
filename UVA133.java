
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UVA133 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			int k =sc.nextInt();
			int m = sc.nextInt();
			if( N == 0 && m == 0 && k ==0 ) {
				break;
			}
			int a = N - 1;
			int b = 0;
			boolean first =true;
			List<Integer> list = new ArrayList<>();
			for(int i = 1; i<= N; i++) {
				list.add(i);
			}
			while(list.size() > 0) {
				N = list.size();
				a = (a + k)% N;
				b = (b  -  m + N) % N;
				if(!first) {
					System.out.print(",");
				}else {
					first = false;
				}
				if(a!=b) {
					System.out.printf("%3d%3d",list.get(a),list.get(b));
					list.remove(a);
					a--;
					if(a < b) {
						b--;
						//a++;
					}
					list.remove(b);
					if(a > b ) {
						a--;
						//b--;
					}
				} else {
					System.out.printf("%3d",list.get(b));
					list.remove(b);
					//b--;
					a--;
				}
				
				System.out.println(list+" "+a+" "+b);
			}
			System.out.println();
		}
		sc.close();
	}
}
