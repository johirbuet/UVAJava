import java.util.Scanner;
import java.util.Stack;

public class UVA514 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			if( N == 0) {
				break;
			}
			solve(sc, N);
			System.out.println();
		}
		sc.close();
	}
	public static void solve(Scanner sc,int N) {
		Stack<Integer> stack = new Stack<>();
		while(sc.hasNextInt()) {
			
			int j =0;
			while(stack.size() > 0) stack.pop();
			for(int i =0; i<N;i++) {
				int c = sc.nextInt();
				if(c == 0) {
					return;
				}
				while( j < N && j != c) {
					if(stack.size() > 0 && stack.peek() == c) {
						break;
					}
					j++;
					stack.push(j);
				}
				if(stack.size() > 0 && stack.peek() == c) {
					stack.pop();
				}
			}
			if(stack.size() == 0) {
				System.out.println("Yes");
			}else {
				System.out.println("No");
			}
		}
	}
}
