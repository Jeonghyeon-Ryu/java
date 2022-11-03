package arrayTest;

public class ArrayTest {
	public static void main(String[] args) {
		String salt = "캠핑갈래ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ";
		String source = "테스트 소스가나다라마바사 아자차카타파하";
		String result = "";
		
		byte[] a = source.getBytes();
		byte[] b = salt.getBytes();
		byte[] bytes = new byte[a.length + b.length];
		
		long start = System.currentTimeMillis();
		
		for(int i=0; i<a.length; i++) {
			bytes[i] = a[i];
		}
		for(int i=a.length; i<(a.length+b.length); i++) {
			bytes[i] = b[i-a.length];
		}
		
		System.out.println(a);
		
		long end = System.currentTimeMillis();
		System.out.println("소요시간 : " + (end-start));
		
	}
}
