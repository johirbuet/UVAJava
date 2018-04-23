import java.io.*;
import java.util.*;

class Solution {
  
  //arr = ['h','e','l','l','o',' ','w','o','r','l','d']
    //   = ['d','l','r','o','w',' ','o','l','l','e','h'];
  
  static void flip(char [] arr ,int l,int r) {
    while(l < r) {
      System.out.println(l +" "+r);
      char t = arr[l];
      arr[l] = arr[r];
      arr[r] = t;
      l++;
      r--;
    }
  }

  static char[] reverseWords(char[] arr) {
    // your code goes here
    // Flip the whole array
    int l = 0;
    int r = arr.length - 1;
    System.out.println("Entered");
    flip(arr,l,r);
    
    //List<Integer> list = new ArrayList<>();
    // Are you there? I cant hear you or see you
    // .. can you hear me?
    // I am here. Probably the connection is slow. 
    
    // Okay.. you can continue..  Ok
    int nextSpace = 0;
    int nextWordstart = 0;
    while(nextWordstart < arr.length) {
      System.out.println(nextWordstart);
      for(int i = nextSpace;i < arr.length;i++) {
        if(arr[i] ==' ') {
          nextSpace = i - 1;
          break;
        }
        if( i == arr.length - 1) {
          nextSpace = i;
          break;
        }
      } 
      flip(arr,nextWordstart,nextSpace);
      nextWordstart = nextSpace + 1;
    }
    return arr;
  }

  public static void main(String[] args) {
    char [] arr = {'p', 'e', 'r', ' ','m', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' };
    System.out.println("Running started");
    System.out.println(Arrays.toString(reverseWords(arr)));
    
  }

}