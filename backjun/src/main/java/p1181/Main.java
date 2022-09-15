package p1181;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashSet<String> set = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			String word = sc.next();
			set.add(word);
		}
		
		int length = set.size();
		String[] sortedWords = new String[length];
		
		set.toArray(sortedWords);
		
		// 1. 알파벳순 정렬
		Arrays.sort(sortedWords);
		// 2. 문자 길이별 
		Arrays.sort(sortedWords, new Comparator<String>() {
			public int compare(String o1, String o2) {
				
				return Integer.compare(o1.length(), o2.length());
			};
		});
		
		for (String sortedWord : sortedWords) {
			System.out.println(sortedWord);
		}
		sc.close();
	}
}