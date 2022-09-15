package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	private int x;
	private int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
public class Test1 {
	public static int N, M;
	public static int[][] graph;
	public static int[] positionX = {0, 0, -1, 1};
	public static int[] positionY = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		for(int i=0; i<graph.length; i++) {
			String[] temp = br.readLine().split("");
			for(int j=0; j<graph[i].length; j++) {
				graph[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		// 넓이탐색 시작
		dfs(0,0);
	}
	public static void dfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		while(!q.isEmpty()) {
			Node node;
			node = q.poll();
			x = node.getX();
			y = node.getY();
			
			for(int i=0; i<positionX.length; i++) {
				int dx = x + positionX[i];
				int dy = y + positionY[i];
				if(dx<0 || dy<0 || dx>=N || dy>=M) continue;
				if(graph[dx][dy] == 0) continue;
				if(graph[dx][dy] == 1) {
					graph[dx][dy] = graph[x][y] + 1;
					q.offer(new Node(dx,dy));
				}
			}
		}
		System.out.println(graph[N-1][M-1]);
	}
}
