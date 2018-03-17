import java.util.Scanner;

public class UVA12897 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 0; t < T; t++) {
			String line = sc.nextLine();
			int N = Integer.parseInt(sc.nextLine());
			int [] chars = new int[26];
			for(int i = 0; i<26;i++) {
				chars[i] = i;
			}
			for(int i = 0; i< N; i++) {
				String [] s = sc.nextLine().split(" ");
				chars[s[1].toCharArray()[0] - 'A'] = s[0].toCharArray()[0] - 'A';
				for(int j =0; j < 26;j++) {
					if(chars[j] == s[0].toCharArray()[0] - 'A') {
						chars[j] = s[1].toCharArray()[0] - 'A';
					}
				}
			}
			char [] arr = line.toCharArray();
			for(int i =0; i< arr.length; i++) {
				if(arr[i]!='_') {
					arr[i] = (char) (chars[arr[i]-'A'] + 'A');
				}
			}
			
			System.out.println(new String(arr));
		}
		sc.close();
	}
}
