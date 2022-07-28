package prac1;

public class q46 {

	public static void main(String[] args) {
		int rate = 0;
		String account ="LOAN";
		
		switch(account) {
		case "RD":
			rate = 5;
			break;
		case "FD":
			rate = 10;
			break;
		default:
			assert false: "No interest for this account";
		}
		
		System.out.println(rate);
	}

}
