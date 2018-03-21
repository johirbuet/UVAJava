import java.util.PriorityQueue;
import java.util.Scanner;

public class UVA612 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int t = 0; t < T; t++) {
			sc.nextLine();
			String line = sc.nextLine();
			String[] lm = line.split(" ");
			int L = Integer.parseInt(lm[0]);
			int M = Integer.parseInt(lm[1]);
			PriorityQueue<DNA> pq = new PriorityQueue<>();
			for (int i = 0; i < M; i++) {
				String dna = sc.nextLine();
				char[] D = dna.toCharArray();
				int count = mergeSort(D, new char[D.length], 0, D.length - 1);
				pq.add(new DNA(dna, count, i));
			}
			while (!pq.isEmpty()) {
				System.out.println(pq.poll().dna);
			}
			if (t < T - 1) {
				System.out.println();
			}
		}
		sc.close();
	}

	public static int mergeSort(char[] D, char[] temp, int L, int R) {
		int i = L;
		int j = R;
		int inv = 0;
		if (i < j) {
			int mid = (i + j) / 2;
			inv += mergeSort(D, temp, i, mid);
			inv += mergeSort(D, temp, mid + 1, j);
			inv += merge(D, temp, i, j, mid + 1);
		}
		return inv;
	}

	public static int merge(char[] D, char[] temp, int L, int R, int mid) {
		int i = L;
		int j = mid;
		int inv = 0;
		int k = L;
		while (i < mid && j <= R) {
			if (D[i] <= D[j]) {
				temp[k++] = D[i++];
			} else {
				temp[k++] = D[j++];
				inv += mid - i;
			}
		}
		while (i < mid) {
			temp[k++] = D[i++];
		}
		while (j <= R) {
			temp[k++] = D[j++];
		}
		for (i = L; i <= R; i++) {
			D[i] = temp[i];
		}
		return inv;
	}

	static class DNA implements Comparable<DNA> {
		String dna;
		int inv;
		int index;

		public DNA(String dna, int inv, int index) {
			this.dna = dna;
			this.inv = inv;
			this.index = index;
		}

		@Override
		public int compareTo(DNA d) {
			if (this.inv == d.inv) {
				return this.index - d.index;
			}
			return this.inv - d.inv;
		}
	}
}
