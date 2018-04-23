import java.util.Scanner;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class HugeNumbers {
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		DoublePredicate range = d -> d >= 3.00 && d < 6.0;		
		DoubleStream.of(4.5,5.0,6.0,7.0).filter(range).forEach(d->System.out.print(d+" "));
		IntStream.rangeClosed(10, 12).map(d -> d * d).forEach(d -> System.out.println(d));
		
	}
}
