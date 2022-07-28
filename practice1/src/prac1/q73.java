package prac1;

public class q73 {
	public static void main(String[] args) {
		MyClass obj = null;
		try(MyClass obj1 = new MyClass()){
			obj1.test = 100;
			obj = obj1.copyObject();
		}
		System.out.println(obj.test);
	}
	
}

class MyClass implements AutoCloseable {
	int test;
	public void close() { System.out.println("close");}
	public MyClass copyObject() { return this; }
}