import java.util.Scanner;
import java.util.StringTokenizer;

public class UVA11192 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			if(line.equals("0")) {
				break;
			}
			StringTokenizer st = new StringTokenizer(line);
			int G = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			char [] arr = s.toCharArray();
			int N = s.length()/G;
			for(int i =0; i < s.length();) {
				int l = i;
				int r = i +N - 1;
				while( l < r) {
					char t = arr[l];
					arr[l++] = arr[r];
					arr[r--] = t;
				}
				i = i + N;
			}
			System.out.println(new String(arr));
		}
		sc.close();
	}
}
