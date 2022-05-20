package text;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class p1301 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("JAVA");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2,"Database");
		list.add("iBATIS");
		
		int size = list.size();
		System.out.println("총 객체 수 : " + size);
		System.out.println();
		
		String skill = list.get(2);
		System.out.println("2 : " + skill);
		System.out.println();
		
		Stream<String> st = list.stream();
		
		st.forEach(s->System.out.println("value : " + s));
		
		list.remove(2);
		System.out.println("");
		st = list.stream();
		st.forEach(s->System.out.println("value : " + s));
		list.remove(2);
		System.out.println("");
		st = list.stream();
		st.forEach(s->System.out.println("value : " + s));
	}
}
