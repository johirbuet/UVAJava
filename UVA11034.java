import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class UVA11034 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t =0; t < T; t++) {
			String [] lm = sc.nextLine().split(" ");
			int l = Integer.parseInt(lm[0])*100;
			int m = Integer.parseInt(lm[1]);
			Queue<Integer> left = new LinkedList<>();
			Queue<Integer> right = new LinkedList<>();
			for(int i = 0; i< m; i++) {
				String [] sb = sc.nextLine().split(" ");
				int s = Integer.parseInt(sb[0]);
	
				if(sb[1].equals("left")) {
					left.add(s);
				}else {
					right.add(s);
				}
			}
			int count = 0;
			
			int b = 0;
			while(!left.isEmpty() || !right.isEmpty()) {
				int c = 0;
				if(!left.isEmpty() && b == 0) {
					while(!left.isEmpty()) {
						if(c+left.peek() <= l) {
							c += left.poll();
						}else {
							break;
						}
					}
				}
				if(!right.isEmpty() && b == 1) {
					while(!right.isEmpty()) {
						if(c+right.peek() <= l) {
							c += right.poll();
						}else {
							break;
						}
					}
				}
				count++;
				b = 1 - b;
			}
			System.out.println(count);
		}
		sc.close();
	}
	

}
