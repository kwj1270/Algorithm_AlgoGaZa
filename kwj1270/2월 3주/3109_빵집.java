import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder STRING_BUILDER = new StringBuilder();
	private static StringTokenizer stringTokenizer;
	
	private static int[] dx = {-1,0,1};
	private static int[] dy = {1,1,1};
	
	private static char[][] map;
	private static boolean[][] dp;
	
	private static int n;
	private static int m;
	
	private static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
		n = Integer.parseInt(stringTokenizer.nextToken());
		m = Integer.parseInt(stringTokenizer.nextToken());
		
		map = new char[n][m];
		dp = new boolean[n][m];
		
		for(int i=0; i < n; i++) {
			map[i] = BUFFERED_READER.readLine().trim().toCharArray(); 
		}
	
		for(int i=0; i < n; i++) {
			answer += dfs(i, 0);
		}
		
		System.out.println(answer);	
	}
	
	
	private static int dfs(int x, int y) {
		dp[x][y] = true;
		if(y == m-1) {
			return 1;
		}
		
		for(int i=0; i < 3; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

			if(dp[nx][ny] == false && map[nx][ny] == '.') {
				dp[nx][ny] = true;
				if(dfs(nx, ny) == 1) return 1;
			} 
		}
		return 0;
	}
}

/*
5 5
.xx..
..x..
.....
...x.
...x.
*/
