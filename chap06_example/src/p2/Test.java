package p2;
import p1.Acc;

public class Test extends Acc{

	public static void main(String[] args) {
		Acc obj = new Test();
		Test obj2 = new Test();
		obj.s = 10;
		obj2.r = 10;
		obj2.s = 10;
	}

}
