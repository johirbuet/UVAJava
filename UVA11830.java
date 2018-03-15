import java.util.Scanner;

public class UVA11830 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			if(line.equals("0 0") || line.startsWith("0 0")) {
				break;
			}
			String [] bn = line.split(" ");
			String fin = bn[1].replaceAll(bn[0], "");
			if(fin.equals("")) {
				System.out.println(0);
			}else if(fin.startsWith("0")) {
				while(fin.startsWith("0")) {
					fin = fin.substring(1);
				}
				
				if(fin.equals("")) {
					System.out.println(0);
				}else {
					System.out.println(fin);
				}
			}else {
				System.out.println(fin);
			}
		}
		sc.close();
	}
}
