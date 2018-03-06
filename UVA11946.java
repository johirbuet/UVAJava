import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class UVA11946 {
	public static void main( String args[] ) throws IOException{
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		PrintWriter pw = new PrintWriter( new OutputStreamWriter( System.out ) );
		String a, m = "OIZEASGTBP";
		int n = Integer.parseInt( br.readLine() );
		while( n != 0 ){
			while( (a=br.readLine())!=null ){
				if( a.isEmpty() ) break;
				for( int i=0; i<a.length(); ++i ){
					if( Character.isDigit( a.charAt(i) ) )
						pw.print( m.charAt( a.charAt(i)-'0' ) );
					else
						pw.print( a.charAt(i) );
				}
				pw.print('\n');
			}
			if( --n != 0 ) pw.print('\n');
		}
		pw.close();
	}
}
