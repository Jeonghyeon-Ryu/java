package array;

public class MainArgsTest {

	public static void main(String[] args) {
		if(args != null){
			int sum=0;
			for(String s : args) {
				sum += Integer.parseInt(s);
				System.out.println(s);
			}
			System.out.println(sum);
		}
	}

}
