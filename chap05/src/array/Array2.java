package array;

public class Array2 {
	public static void main(String[] args) {
		int[] intAry = new int[2];
		for(int i=0; i<intAry.length; i++) {
			System.out.println("intAry["+i+"] : " + intAry[i]);
		}
		
		// int[2] 인 총 3개 존재하는 2차원배열.
		int[][] intAry2 = new int[3][2];
		for(int i=0; i<intAry2.length; i++) {
			for(int j=0; j<intAry2[i].length; j++) {
				System.out.println("intAry["+i+"]["+j+"] : " + intAry2[i][j]);
			}
		}
		
		System.out.println();
		// int[2] 인 총 3개 존재하는 서로다른 크기의 2차원배열.
		int[][] intAry3 = new int[2][];
		intAry3[0] = new int[3];			// ☆☆☆☆☆☆☆☆☆☆
		intAry3[1] = new int[5];			// ☆☆☆☆☆☆☆☆☆☆
		for(int i=0; i<intAry3.length; i++) {
			for(int j=0; j<intAry3[i].length; j++) {
				System.out.println("intAry3["+i+"]["+j+"] : " + intAry3[i][j]);
			}
		}
		
		System.out.println();
		int[][] javaScores = { {95,80}, {92, 96, 80} };
		for(int i=0; i<javaScores.length; i++)
			for(int j=0; j<javaScores[i].length; j++)
				System.out.println("JavaScores["+i+"]["+j+"] : " + javaScores[i][j]);
		
		// 향상된 for문
		for(int[] tempAry : javaScores) {
			for(int tempAry2 : tempAry)
				System.out.println(tempAry2);
		}
	}
}
