package prac1;

public class q61 {
	public static void main(String[] args) {
		Resource res = new Resource();
		try {
			res.open();
			res.close();
		} catch (Exception e) {
			System.out.println("Exception - 1");
		}
//		try( res= new Resource()){
//			res.open();
//		} catch( Exception e) {
//			System.out.println("Exception - 2");
//		}
	}
}

class Resource implements AutoCloseable {
	public void close() throws Exception {
		System.out.print("Close-");
	}
	public void open() {
		System.out.print("Open-");
	}
}