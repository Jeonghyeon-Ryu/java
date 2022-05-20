package text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class p1304 {

	public static void main(String[] args) throws FileNotFoundException {
		Set<String> set = new HashSet<>();
		Scanner sc = new Scanner(new File("stringsss.txt"));
		
		while(sc.hasNext()) {
			set.add(sc.nextLine());
		}
		int size = set.size();
		System.out.println("총 객체 수 : " + size);
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(" " + iter.next());
		}
		
	}
}
