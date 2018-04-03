import java.util.Scanner;

public class UVA12416 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			if(line.isEmpty()) break;
			int count =0;
			while(line.indexOf("  ")>=0) {
				count++;
				line = line.replaceAll("  ", " ");
			}
			if(line.charAt(0) ==' ') {
				//count++;
			}
			System.out.println(count);
		}
		sc.close();
	}
}
