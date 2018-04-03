import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UVA10282 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, String> map = new HashMap<>();
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			
			String [] uv = line.split(" ");
			if(uv.length == 2) {
				map.put(uv[1], uv[0]);
			}else if(uv[0].length()>0){
				if(map.containsKey(uv[0])) {
					System.out.println(map.get(uv[0]));
				}else {
					System.out.println("eh");
				}
			}
		}
		sc.close();
	}
}
