import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
 
public class UVA1246 {
}
/*
#include<stdio.h>
#define max 100
char prime[max+1];
void sieve();
int main()
{
    sieve();
    int t,a,b,i,j,check;
    scanf("%d",&t);
    while(t--){
    scanf("%d %d",&a,&b);
    check=1;
    int k=0;
    for(i=a;i<=b;i++){
            int div=0;
        for(j=1;j<=i;j++){
            if(i%j==0)
            div++;
        }
    if(prime[div]==0){
            k++;
            check=0;
        if(k==1)
        printf("%d",i);
        else  printf(" %d",i);
    }
    }
    if(check==1)
    printf("-1\n");
    else
    printf("\n");
    }
}
void sieve()
{
    int i,j;
    for(i=0;i<max;i++)
        prime[i]=0;
    prime[0]=prime[1]=1;
    for(i=4;i<=max;i+=2)
        prime[i]=1;
    for(i=3;i<=sqrt(max);i+=2){
        for(j=i*i;j<max;j+=i)
            prime[j]=1;
    }
}
*/