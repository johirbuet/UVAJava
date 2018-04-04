import java.util.Scanner;
import java.util.Stack;

public class UVA10700 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		while(T-->0) {
			String line = sc.nextLine();
			String mod = line.replaceAll("\\+", " ");
			mod = mod.replaceAll("\\*", " ");
			String [] nums = mod.split(" ");
			Stack<Long> stack = new Stack<>();
			int i =0;
			stack.push(Long.parseLong(nums[i++]));
			for(int j =0; j< line.length();j++) {
				if(line.charAt(j) == '*') {
					stack.push(Long.parseLong(nums[i++]));
				}else if(line.charAt(j) == '+') {
					long x = stack.pop()  + Long.parseLong(nums[i++]);
					stack.push(x);
				}
			}
			long max = 1;
			while(!stack.isEmpty()) {
				max *= stack.pop();
			}
			i = 0;
			stack.push(Long.parseLong(nums[i++]));
			for(int j =0; j< line.length();j++) {
				if(line.charAt(j) == '+') {
					stack.push(Long.parseLong(nums[i++]));
				}else if(line.charAt(j) == '*') {
					long x = stack.pop() * Long.parseLong(nums[i++]);
					stack.push(x);
				}
			}
			long min = 0;
			while(!stack.isEmpty()) {
				min += stack.pop();
			}
			System.out.printf("The maximum and minimum are %d and %d.\n",max,min);
		}
		sc.close();
	}
}
