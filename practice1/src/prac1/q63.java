package prac1;

import java.util.function.UnaryOperator;

public class q63 {
	public static void main(String[] args) {
		final String str1 = "Java";
//		StringBuffer strbuf = new StringBuffer("Course");
		String strbuf = "Course";
		UnaryOperator<String> u = (str2) -> str1.concat(str2);
		UnaryOperator<String> c = (str3) -> str3.toLowerCase();
		System.out.println(u.apply(c.apply(strbuf)));;
	}
}
