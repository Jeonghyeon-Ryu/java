package array;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainApp {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 배열 선언
		int[] scores; 
		// 배열 생성
		scores = new int[10];
		// 배열 초기화
		for(int i=0; i<scores.length; i++) {
			scores[i] = i*10;
		}
		// 배열 조회
		for(int i=0; i<scores.length; i++) {
			System.out.println(scores[i]);
		}
		
		// 두번째 학생의 성적을 출력
		System.out.println("두번째 학생의 점수는 : " + scores[1]);
		
		
		///////////////////////////////////////
		System.out.println("");
		Stream<int[]> st = Stream.of(scores);
		st.forEach(s->System.out.println(s));
		System.out.println("");
		
		IntStream st1 = Arrays.stream(scores);
		st1.forEach(s->System.out.print(s));
		System.out.println("");
		
		Stream<int[]> st2 = Arrays.asList(scores).stream(); 
		st2.forEach(s->System.out.print(s));
		scan.close();
	}
}
