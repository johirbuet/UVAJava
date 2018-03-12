import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UVA445 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		String numbers = "0123456789";
		int num;
		char c;
		while ((line = in.readLine()) != null)
		{
			if (line.equals("")){
				System.out.println();
				num=0;
				continue;
			}
			num=0;
			for(int i=0; i<line.length(); i++){
				c = line.charAt(i);
				if (numbers.indexOf(c) > 0){
					num += Integer.parseInt(""+c);
				} else if (c == '!'){
					System.out.println();
					num=0;
				} else if (c == 'b'){
					for (int j=0; j<num; j++){
						System.out.print(' ');
					}
					num=0;
				} else{
					for (int j=0; j<num; j++){
						System.out.print(c);
					}
					num=0;
				}
			}
			System.out.println();
		}

	}
}
