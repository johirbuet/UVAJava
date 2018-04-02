import java.util.Scanner;

public class UVA164 {
	static enum OP{
		NONE,COPY,CHANGE,DELETE, INSERT,
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			if(line.equals("#")) {
				break;
			}
			String [] ST = line.split(" ");
			char [] S = ST[0].toCharArray();
			char [] T = ST[1].toCharArray();
			int [][] dp = new int[24][24];
			OP [][] op  = new OP[24][24];
			for(int i =0; i<= S.length;i++) {
				for(int j =0; j<= T.length;j++) {
					dp[i][j] = 1000;
					op[i][j] = OP.NONE;
				}
			}
			dp[0][0] = 0;
			for(int i =0; i <= S.length;i++) {
				dp[i][0] = i;
				op[i][0] = OP.DELETE;
			}
			for(int j =0; j <= T.length;j++) {
				dp[0][j] = j;
				op[0][j] = OP.INSERT;
			}
			
			for(int i = 1; i <= S.length;i++) {
				for(int j = 1; j<= T.length;j++) {
					if(S[i-1] != T[j -1]) {
						op[i][j] = OP.CHANGE;
						dp[i][j] = dp[i-1][j-1] +1;
					}else {
						op[i][j] = OP.COPY;
						dp[i][j] = dp[i-1][j-1];
					}
					if(dp[i-1][j] + 1 < dp[i][j]) {
						op[i][j] = OP.DELETE;
						dp[i][j] = dp[i-1][j] + 1;
					}
					if(dp[i][j-1] + 1 < dp[i][j]) {
						dp[i][j] = dp[i][j - 1] + 1;
						op[i][j] = OP.INSERT;
					}
				}
			}
			print( S.length, T.length,op, S,T );  
	        System.out.printf("E\n");  
		}
		sc.close();
	}
	public static void print(int i, int j, OP [][] op,char [] S,char [] T) {
		if( i == 0 && j ==0) return;
		if (op[i][j] == OP.INSERT) {
			print(i, j - 1, op, S, T);
			System.out.printf("I%c%02d",T[j-1],j);
		}else if (op[i][j] == OP.DELETE) {
			print(i - 1, j, op, S, T);
			System.out.printf("D%c%02d",S[i-1],j+1);  
		}else if(op[i][j] == OP.CHANGE) {
			print(i - 1, j - 1, op, S, T);
			System.out.printf("C%c%02d",T[j-1],j);  
		}else {
				print(i - 1, j - 1, op, S, T);
		}
	}
}

/*
 * 
 #include <iostream>  
#include <cstdlib>  
#include <cstring>  
#include <cstdio>  
  
char str1[24],str2[24];  
int  dp[24][24],op[24][24];  
  
void output( int i, int j )  
{  
    if ( !i && !j ) return;  
    if ( op[i][j] == 1 ) {  
        output( i-1, j );  
        printf("D%c%02d",str1[i-1],j+1);  
    }else if ( op[i][j] == 2 ) {  
        output( i, j-1 );  
        printf("I%c%02d",str2[j-1],j);  
    }else if ( op[i][j] == 3 ){  
        output( i-1, j-1 );  
        printf("C%c%02d",str2[j-1],j);  
    }else output( i-1, j-1 );  
}  
  
int main()  
{  
    while ( scanf("%s",str1) && str1[0] != '#' ) {  
        scanf("%s",str2);  
        int l1 = strlen(str1);  
        int l2 = strlen(str2);  
        for ( int i = 0 ; i <= l1 ; ++ i )  
        for ( int j = 0 ; j <= l2 ; ++ j ) {  
            dp[i][j] = 400;  
            op[i][j] = 0;  
        }  
          
        for ( int i = 0 ; i <= l1 ; ++ i ) {  
            op[i][0] = 1; dp[i][0] = i;  
        }  
        for ( int i = 0 ; i <= l2 ; ++ i ) {  
            op[0][i] = 2; dp[0][i] = i;  
        }  
          
        for ( int i = 1 ; i <= l1 ; ++ i )  
        for ( int j = 1 ; j <= l2 ; ++ j ) {  
            if ( str1[i-1] != str2[j-1] ) {  
                op[i][j] = 3; dp[i][j] = dp[i-1][j-1]+1;  
            }else dp[i][j] = dp[i-1][j-1];  
            if ( dp[i-1][j]+1 < dp[i][j] ) {  
                op[i][j] = 1; dp[i][j] = dp[i-1][j]+1;  
            }  
            if ( dp[i][j-1]+1 < dp[i][j] ) {  
                op[i][j] = 2; dp[i][j] = dp[i][j-1]+1;  
            }  
        }  
        output( l1, l2 );  
        printf("E\n");  
    }  
    return 0;  
}  

 */
