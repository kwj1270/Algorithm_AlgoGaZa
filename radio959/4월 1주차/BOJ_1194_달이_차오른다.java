package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194_달이_차오른다 {

	static char[][] maze;
	static int M, N;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static class pos{
		int x;
		int y;
		public pos(int x, int y) {
			this.x =x;
			this.y =y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		maze = new char[M][N];
		pos t;
		for(int i=0; i<M; i++) {
			String temp = br.readLine().trim();
			for(int j=0; j<N; j++) {
				maze[i][j] = temp.charAt(j);
				if(maze[i][j]=='0') {
					t = new pos(i,j);
				}
			}
		}
		
		explore();
		
	}
	public static void explore() {
		Queue<pos> q = new LinkedList<pos>();
		
		
	}

}
