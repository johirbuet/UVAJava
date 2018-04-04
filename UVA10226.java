import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UVA10226 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		sc.nextLine();
		String out = "";
		for(int i =0; i<T;i++) {
			Map<String,Double> map = new TreeMap<>();
			double count  = 0;
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				if(line.length() == 0) {
					break;
				}
				map.put(line, map.getOrDefault(line, 0.0)+1.0);
				count  = count +1.0;
			}
			for(String name: map.keySet()) {
				out += String.format("%s %.4f\n",name,100*map.get(name)/count);
			}
			out+="\n";
		}
		System.out.println(out.substring(0, out.length()-2));
		sc.close();
	}
}
