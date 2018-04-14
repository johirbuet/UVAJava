import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVA10298 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");
        StringBuilder str = new StringBuilder("");
        while ((str = new StringBuilder(br.readLine())) != null) {
            if (str.charAt(0) == '.') {
                break;
            }
            int power = 1;
            for (int i = 2; i <str.length()+1; i++) {
                if (str.length() % i == 0) {
                    int period = str.length() / i;
                    boolean found = true;
                    for (int j = period; j < str.length(); j++) {
                        if (str.charAt(j) != str.charAt(j % period)) {
                            found = false;                            
                            break;                            
                        }
                    }
                    
                    if (found) {                        
                        power = Math.max(power, i);                        
                    }
                }
            }
            sb.append(power).append("\n");
        }
        System.out.print(sb);
    }
}