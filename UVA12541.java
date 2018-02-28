import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class UVA12541 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Person> minheap = new PriorityQueue<>();
		PriorityQueue<Person> maxheap = new PriorityQueue<>(Collections.reverseOrder());
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 0; t< T; t++){
			String [] strs = sc.nextLine().split(" ");
			minheap.add(new Person(strs[0], Integer.parseInt(strs[3]), Integer.parseInt(strs[2]), Integer.parseInt(strs[1])));
			maxheap.add(new Person(strs[0], Integer.parseInt(strs[3]), Integer.parseInt(strs[2]), Integer.parseInt(strs[1])));
		}
		System.out.println(maxheap.poll().name);
		System.out.println(minheap.poll().name);
		sc.close();
	}
	static class Person implements Comparable<Person> {
		String name;
		int year;
		int month;
		int date;
		
		Person(String name,int year,int month, int date) {
			this.name = name;
			this.year = year;
			this.month = month;
			this.date = date;
		}
		@Override
		public int compareTo(Person p) {
			if(this.year == p.year) {
				if(this.month == p.month) {
					return this.date - p.date;
				} else {
					return this.month - p.month;
				}
			} else {
				return this.year - p.year;
			}
		}
		
	}
}
