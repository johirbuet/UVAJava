import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class UVA1062 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = 1;
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			if(line.equals("end")) break;
			List<Stack<Character>> containers = new ArrayList<>();
			char [] A = line.toCharArray();
			int ans = 0;
			for(int i =0; i< A.length;i++) {
				boolean added = false;
				for(int j =0; j<containers.size();j++) {
					if(containers.get(j).peek() >= A[i]) {
						containers.get(j).push(A[i]);
						added = true;
						break;
					}
				}
				if(!added) {
					Stack<Character> stack = new Stack<>();
					stack.push(A[i]);
					containers.add(stack);
					ans++;
				}
			}
			System.out.printf("Case %d: %d\n",c++,ans);
		}
		sc.close();
	}
}
