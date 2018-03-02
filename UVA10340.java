import java.util.Scanner;

public class UVA10340 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext())
		{
			String s=sc.next();
			String t=sc.next();
			int index=0;
			boolean yes = true;
			for(int i=0;i<s.length();i++)
			{
				char c=s.charAt(i);
				index = t.indexOf(c, index);
				if(index<0)
				{
					yes = false;
					break;
				}
				index++;
			}
			if(yes)
			{
				System.out.println("Yes");
			}
			else
			{
				System.out.println("No");
			}
		}
		sc.close();
	}
}
