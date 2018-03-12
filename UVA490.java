import java.util.Scanner;

class UVA490 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[][] chars = new char[100][100];
		int index = 0;
		int maxLength = 0;

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				chars[i][j] = ' ';
			}
		}

		while (scanner.hasNextLine()) {
			String string = scanner.nextLine();
			if (string.length() == 0)
				break;
			char[] temp=string.toCharArray();
			for(int i=0;i<temp.length;i++){
				chars[index][i]=temp[i];
			}
			if (string.length() > maxLength) {
				maxLength = string.length();
			}
			index++;
		}
		for (int j = 0; j < maxLength; j++) {
			for (int i = index - 1; i >= 0; i--) {
				System.out.print(chars[i][j]);
			}
			System.out.println();
		}
		scanner.close();
	}
}
