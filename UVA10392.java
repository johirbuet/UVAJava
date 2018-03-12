import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA10392 {
	public static void main(String[] args) throws NumberFormatException,
            IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        while (true)
        {
            long n = new Long(bf.readLine());
            if (n <= 0)
                break;
            for (long i = 2l; i * i < n; i++)
                while (n % i == 0l)
                {
                    out.printf("    %d\n", i);
                    n /= i;
                }
            if(n > 1)
                out.printf("    %d\n" , n);
            out.println();
        }
        out.close();
    }
}