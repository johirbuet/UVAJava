import java.util.Scanner;

public class UVA10222 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String keyboard = "`1234567890-=qwertyuiop[]\\asdfghjkl;'zxcvbnm,./";
		while(sc.hasNextLine()) {
			String str = sc.nextLine();
			int len = str.length();
			str = str.toLowerCase();
			for(int i = 0;i<len;i++ ){
				if(str.charAt(i)==' ')System.out.print(" ");
				else{
				System.out.print(keyboard.charAt(keyboard.indexOf(str.charAt(i))-2));
				}
			}
			System.out.println();
		}
		sc.close();
	}
}
