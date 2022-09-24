package kakao;

public class Solution3 {
	static int[][] users = {{40,10000},{25,10000}};
	static int[] emoticons = {7000,9000,5000};
	static int[][] result = {};
	
	public static void main(String[] args) {
		int[] answer = {};
		int[][] price = new int[emoticons.length][4];
		
		// 2차원 배열로 1~40 까지 할인된 가격 저장
		for(int i=0; i<emoticons.length; i++) {
			for(int j=0; j<4; j++) {
				price[i][j] = emoticons[i] * (100-(j+1)*10) / 100;
				System.out.print(price[i][j] + " ");
			}
			System.out.println("");
		}

		// 각 이모티콘의 할인율에 따라 구매 총액을 구해야됨.
		// 할인율 4개, 이모티콘 개수 n개 -> 4의 n승의 연산이 일어나야됨..
		// 최종 노드에 도착할때까지 더한 값을 유저의 금액과 비교해서 가입 수 늘리기

		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
	public static int dfs(int depth) {
		if(depth>=emoticons.length) {
			return 1;
		}
		for(int i=0; i<4; i++) {
			return dfs(depth+1);
		}
	}

}
