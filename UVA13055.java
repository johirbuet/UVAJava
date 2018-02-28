import java.util.Scanner;
import java.util.Stack;

public class UVA13055 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<String> stack = new Stack<>();
		int T = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < T; i++) {
			String s = sc.nextLine();
			if(s.startsWith("Sleep")) {
				String name = s.split(" ")[1];
				stack.push(name);
			} else if(s.startsWith("Test")) {
				if(stack.isEmpty()) {
					System.out.println("Not in a dream");
				} else {
					System.out.println(stack.peek());
				}
			} else if(s.startsWith("Kick")) {
				if(!stack.isEmpty()) {
					stack.pop();
				}
			}
		}
		sc.close();
	}

}
