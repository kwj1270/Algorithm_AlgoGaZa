package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import static java.lang.Integer.valueOf;

class Node {
	int x;
	int y;
	int k;

	public Node(int x, int y, int k) {
		this.x = x;
		this.y = y;
		this.k = k;
	}

}

class Main {

	private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder STRING_BUILDER = new StringBuilder();
	private static StringTokenizer stringTokenizer;
	private static final int DX[] = { 0, 0, 1, -1 };
	private static final int DY[] = { 1, -1, 0, 0 };

	private static int dp[][][];
	private static char map[][];
	private static int n;
	private static int m;

	private static int start_x;
	private static int start_y;
	private static int answer = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
		n = valueOf(stringTokenizer.nextToken());
		m = valueOf(stringTokenizer.nextToken());

		map = new char[n][m];
		dp = new int[n][m][(1 << 6)+1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < 1 << 6; k++) {
					dp[i][j][k] = -1;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine());
			String sentence = stringTokenizer.nextToken();
			for (int j = 0; j < m; j++) {
				map[i][j] = (sentence).charAt(j);
				if (map[i][j] == '0') {
					start_x = i;
					start_y = j;
				}
			}
		}

		dp[start_x][start_y][0] = 1;
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(start_x, start_y, 0));
		boolean flag = false;
		while (!q.isEmpty()) {
			Node now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + DX[i];
				int ny = now.y + DY[i];
				int nk = now.k;
				if (nx < 0 || nx >= n || ny < 0 || ny >= m)continue;
				if (map[nx][ny] == '#')continue;
				if (map[nx][ny] == '1') {
					answer = dp[now.x][now.y][now.k];
					flag = true;
					break;
				}
				if ('a' <= map[nx][ny] && map[nx][ny] <= 'f') {
					nk  = nk | (1 << (map[nx][ny] - 'a'));
				}
				if ('A' <= map[nx][ny] && map[nx][ny] <= 'F') {
					if((nk & (1 << (map[nx][ny]-'A'))) == 0) continue;
				}
				if (dp[nx][ny][nk] == -1 || dp[nx][ny][nk] > dp[now.x][now.y][now.k] + 1) {
					dp[nx][ny][nk] = dp[now.x][now.y][now.k] + 1;
					q.offer(new Node(nx, ny, nk));
				}
			}
			if(flag) break;
		}
		System.out.println(answer);
	}
	
}
