import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
 

public class UVA11559 {
 
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
 
    while (sc.hasNextInt()) {
      int N = sc.nextInt();
      int B = sc.nextInt();
      int H = sc.nextInt();
      int W = sc.nextInt();
 
      Hotel[] hotels = new Hotel[H];
      for (int i = 0; i < H; i++) {
        hotels[i] = new Hotel();
        hotels[i].price = sc.nextInt();
        for (int j = 0; j < W; j++) {
          hotels[i].maxBeds = Math.max(hotels[i].maxBeds,
              sc.nextInt());
        }
      }
      Arrays.sort(hotels);
      boolean found = false;
      for (int i = 0; i < H; i++) {
        if (hotels[i].price * N <= B && hotels[i].maxBeds >= N) {
          out.println(hotels[i].price * N);
          found = true;
          break;
        }
      }
      if (!found)
        out.println("stay home");
    }
    out.close();
    sc.close();
  }
 
  private static class Hotel implements Comparable<Hotel> {
    int price;
    int maxBeds;
 
    @Override
    public int compareTo(Hotel o2) {
      if (this.price == o2.price) {
        return Integer.compare(o2.maxBeds, this.maxBeds);
      } else {
        return Integer.compare(this.price, o2.price);
      }
    }
  }
}
 
