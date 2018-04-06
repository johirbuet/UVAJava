// UVa 727 - Equation

import java.util.Scanner;

public class UVA727 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		if (cases > 0) {
			scanner.nextLine();
			scanner.nextLine();
			for (; cases > 0; cases--) {

				char[] operators = new char[50];
				int[] priorities = new int[50];
				int top = 0;

				int basePriority = 0;
				StringBuilder output = new StringBuilder();

				String line = scanner.nextLine();
				do {
					char ch = line.charAt(0);
					if (ch >= '0' && ch <= '9')
						output.append(ch);
					else if (ch == '(' || ch == ')')
						basePriority += 2 * (ch == '(' ? 1 : -1);
					else {
						int thisPriority = basePriority
								+ (ch == '+' || ch == '-' ? 0 : 1);
						while (top > 0 && priorities[top - 1] >= thisPriority)
							output.append(operators[--top]);
						operators[top] = ch;
						priorities[top++] = thisPriority;
					}
					if (!scanner.hasNextLine())
						break;
					line = scanner.nextLine();
				} while (line.length() > 0);

				while (top > 0)
					output.append(operators[--top]);

				System.out.println(output.toString());
				if (cases > 1)
					System.out.println();

			}
		}
		scanner.close();
	}
}