import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class UVA11947 {
	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
	        int nTC = scan.nextInt();
	        Calendar cal = Calendar.getInstance();
	        for (int TC=1; TC<=nTC; TC++){
	            char[] s = scan.next().toCharArray();
	            int MM = (s[0]-'0') * 10 + s[1]-'0';
	            int DD = (s[2]-'0') * 10 + s[3]-'0';
	            int YY = (((s[4]-'0') * 10 + s[5]-'0') * 10 + s[6]-'0') * 10 + s[7]-'0';
	 
	            cal.set(YY,MM-1,DD);
	            cal.add(Calendar.DATE, 40*7);
	            MM = cal.get(Calendar.MONTH)+1;
	            DD = cal.get(Calendar.DATE);
	            YY = cal.get(Calendar.YEAR);
	 
	            String ZZ = "capricorn"; // starts from capricorn's zodiac
	            if (cal.compareTo(new GregorianCalendar(YY,0,21))>=0) ZZ = "aquarius";
	            if (cal.compareTo(new GregorianCalendar(YY,1,20))>=0) ZZ = "pisces";
	            if (cal.compareTo(new GregorianCalendar(YY,2,21))>=0) ZZ = "aries";
	            if (cal.compareTo(new GregorianCalendar(YY,3,21))>=0) ZZ = "taurus";
	            if (cal.compareTo(new GregorianCalendar(YY,4,22))>=0) ZZ = "gemini";
	            if (cal.compareTo(new GregorianCalendar(YY,5,22))>=0) ZZ = "cancer";
	            if (cal.compareTo(new GregorianCalendar(YY,6,23))>=0) ZZ = "leo";
	            if (cal.compareTo(new GregorianCalendar(YY,7,22))>=0) ZZ = "virgo";
	            if (cal.compareTo(new GregorianCalendar(YY,8,24))>=0) ZZ = "libra";
	            if (cal.compareTo(new GregorianCalendar(YY,9,24))>=0) ZZ = "scorpio";
	            if (cal.compareTo(new GregorianCalendar(YY,10,23))>=0) ZZ = "sagittarius";
	            if (cal.compareTo(new GregorianCalendar(YY,11,23))>=0) ZZ = "capricorn";
	 
	            System.out.printf("%d %02d/%02d/%04d %s\n",TC,MM,DD,YY,ZZ);
	        }
	        scan.close();
	}
}
