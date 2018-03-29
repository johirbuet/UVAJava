import java.util.Arrays;
import java.util.Scanner;

public class UVA11512 {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		for(int i =0; i < N; i++) {
			String line = sc.nextLine();
			String [] arr =new String[line.length()];
			for(int l = 0; l < line.length();l++) {
				arr[l] = line.substring(l);
			}
			Arrays.sort(arr);
			String max = "";
			int count = 0;
			for(int j =0; j < arr.length - 1;j++) {
				String res = "";
				String a = arr[j];
				String b = arr[j + 1];
				for(int x =0,y =0; x < a.length() && y < b.length();x++,y++) {
					if(a.charAt(x) != b.charAt(y)) break;
					res = res + a.charAt(x);
				}
				if(res.length() > max.length()) {
					max = res;
				}
			}
			for(int j =0; j < arr.length && max.length() > 0;j++) {
				if(arr[j].startsWith(max)) {
					count++;
				}
			}
			if( count > 0) {
				System.out.println(max+" "+count);
			}else {
				System.out.println("No repetitions found!");
			}
			
		}
		sc.close();
	}
}
