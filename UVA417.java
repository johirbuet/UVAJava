import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UVA417 {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		Map<String,Integer> map = new HashMap<>();
		int count = 1;
		// One digit
		for(int i =0; i< 26;i++) {
			char x = (char)('a' + (i));
			map.put(x+"", count++);
		}
		// Two digit
		for(int i =0; i<26;i++) {
			char cs = (char)('a' + (i));
			String start  = ""+cs;
			for(int j =i+1;j<26;j++) {
				 cs = (char)('a' + (j ));
				 String jstart =start + cs;
				 map.put(jstart, count++);

			}
		}
		//Three digit
		for(int i=0;i<26;i++) {
			char c = (char)('a' + (i ));
			String start = ""+c;
			for(int j=i+1;j<26;j++) {
				c = (char)('a' + (j ));
				String jstart = start + c;
				for(int k=j+1;k<26;k++) {
					c = (char)('a' + (k));
					String kstart = jstart + c;
					map.put(kstart, count++);
				}
			}
		}
		// Four digit
		for(int i =0; i< 26;i++) {
			char c = (char)('a' + (i));
			String start = ""+c;
			for(int j = i +1; j<26;j++) {
				c = (char)('a' + (j));
				String jstart = start + c;
				for(int k = j +1; k< 26;k++) {
					c = (char)('a' + (k));
					String kstart = jstart + c;
					for(int l = k +1; l<26;l++) {
						c = (char)('a' + (l));
						String lstart = kstart + c;
						map.put(lstart, count++);
					}
				}
			}
		}
		// 5 digit
		for(int i=0;i<26;i++) {
			char c = (char)('a' + (i ));
			String start = ""+c;
			for(int j=i+1;j<26;j++) {
				c = (char)('a' + (j ));
				String jstart = start + c;
				for(int k = j +1; k< 26;k++) {
					c = (char)('a' + (k));
					String kstart = jstart + c;
					for(int l = k+1; l<26; l++) {
						c = (char)('a' + (l));
						String lstart = kstart + c;
						for(int m = l +1; m < 26; m++) {
							c = (char)('a' + (m));
							String mstart = lstart + c;
							map.put(mstart, count++);
						}
					}
				}
			}
		}
		//System.out.println(map);
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			if(line.isEmpty()) {
				break;
			}
			if(map.containsKey(line)) {
				System.out.println(map.get(line));
			}else {
				System.out.println(0);
			}
		}
		sc.close();
	}
}
