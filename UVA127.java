import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class UVA127 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String A = sc.nextLine();
			if (A.equals("#")) {
				break;
			}
			String B = sc.nextLine();
			// System.out.println(A);
			List<Stack<String>> piles = new ArrayList<>();
			for (int i = 0; i < 52; i++) {
				piles.add(new Stack<String>());
			}
			String[] a = A.split(" ");
			String[] b = B.split(" ");
			for (int i = 0; i < 26; i++) {
				piles.get(i).push(a[i]);
			}
			for (int j = 0; j < 26; j++) {
				piles.get(j + 26).push(b[j]);
			}
			while (true) {
				if (piles.size() == 1) {
					break;
				}
				boolean ended = false;
				for (int i = 1; i < piles.size(); i++) {
					if (i >= 3) {
						if (match(piles.get(i).peek(), piles.get(i - 3).peek())) {
							piles.get(i - 3).push(piles.get(i).pop());
							if(piles.get(i).size() == 0) {
								piles.remove(i);
							}
							i = i - 3;
						} else if (match(piles.get(i - 1).peek(), piles.get(i).peek())) {
							piles.get(i - 1).push(piles.get(i).pop());
							if(piles.get(i).size() == 0) {
								piles.remove(i);
							}
							i = i - 1;
						}
					} else {
						if (match(piles.get(i - 1).peek(), piles.get(i).peek())) {
							piles.get(i - 1).push(piles.get(i).pop());
							if(piles.get(i).size() == 0) {
								piles.remove(i);
							}
							i = i - 1;
						}
					}
					if (piles.get(i).size() == 0) {
						piles.remove(i);
						//i = i - 1;
					} else {
						if ((i >= 1 && match(piles.get(i).peek(), piles.get(i - 1).peek()))
								|| (i >= 3 && match(piles.get(i).peek(), piles.get(i - 3).peek()))) {
							i--;
						}
					}
					if (i == piles.size() - 1) {
						ended = true;
						break;
					}
				}
				if (ended) {
					break;
				}
			}
			if(piles.size() == 1) {
				System.out.printf("%d pile remaining: ", piles.size());
			}else {
				System.out.printf("%d piles remaining: ", piles.size());
			}
			for (int i = 0; i < piles.size(); i++) {
				System.out.print(piles.get(i).size());
				if (i < piles.size() - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();

		}
		sc.close();
	}

	public static boolean match(String a, String b) {
		return a.charAt(0) == b.charAt(0) || a.charAt(1) == b.charAt(1);
	}
}
