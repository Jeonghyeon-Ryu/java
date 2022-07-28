package prac1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class q05 {

	public static void main(String[] args) throws IOException {
//		Map<Integer, String> books = new TreeMap<>();
//		books.put(1007, "A");
//		books.put(1002, "C");
//		books.put(1001, "B");
//		books.put(1003, "B");
//		System.out.println(books);
		Stream<Path> files = Files.list(Paths.get(System.getProperty("user.home")));
		files.forEach(fName -> { // line n1
			try {
				Path aPath = fName.toAbsolutePath(); // line n2
				System.out.println(fName + ":" + Files.readAttributes(aPath, BasicFileAttributes.class).creationTime());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		});
	}

}
