package prac1;

public class q57 {

	public static void main(String[] args) {
//		try(DataConverter dc = new DataConverter()){
//			dc.copy();
//		}
	}
}

class DataConverter {
	public void copy() {}
	public void close() throws Exception {
		throw new RuntimeException();
	}
}