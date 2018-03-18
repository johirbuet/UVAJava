import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVA11565 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(buf.readLine());
		StringBuilder out = new StringBuilder("");

		for (int t = 0; t < test; t++) {
			String[] in = buf.readLine().split(" ");

			long a = Integer.parseInt(in[0]);
			long b = Integer.parseInt(in[1]);
			long c = Integer.parseInt(in[2]);
			boolean check = true;
			for (long i = -5000; i < 10001 && check; i++)
				for (long j = i + 1; j < 10001 && i + j < a && i * j < b && i * i + j * j < c && check; j++)
					for (long k = j + 1; k < 10001 && i + j + k <= a && i * j * k <= b && i * i + j * j + k * k <= c
							&& check; k++) {
						if (i + j + k == a && i * j * k == b && i * i + j * j + k * k == c) {
							check = false;
							out.append(i + " " + j + " " + k + "\n");
						}
					}
			if (check)
				out.append("No solution.\n");
		}
		System.out.print(out);
	}
}
