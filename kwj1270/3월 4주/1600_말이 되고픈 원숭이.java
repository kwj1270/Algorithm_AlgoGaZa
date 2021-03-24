import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int changed;
	int x;
	int y;

	public Node(int changed, int x, int y) {
		this.changed = changed;
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Node [changed=" + changed + ", x=" + x + ", y=" + y + "]";
	}

}

public class Main {

	private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder STRING_BUILDER = new StringBuilder();
	private static StringTokenizer stringTokenizer;

	private static int map[][];
	private static int dp[][][];

	private static int dx[] = { 0, 0, 1, -1 };
	private static int dy[] = { 1, -1, 0, 0 };

	private static int hdx[] = {1, -1, 2, 2, -2, -2, 1, -1};
	private static int hdy[] = {2, 2, 1, -1, 1, -1, -2, -2};

	private static int k;
	private static int w;
	private static int h;

	public static void main(String[] args) throws NumberFormatException, IOException {
		k = Integer.parseInt(BUFFERED_READER.readLine());

		stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
		w = Integer.parseInt(stringTokenizer.nextToken());
		h = Integer.parseInt(stringTokenizer.nextToken());

		map = new int[h][w];
		dp = new int[k+1][h][w];

		for (int i = 0; i < h; i++) {
			stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
				for(int kk=0; kk <= k; kk++) {
					dp[kk][i][j] = -1;
				}
			}
		}

		dp[0][0][0] = 0;
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(0, 0, 0));

		while (!q.isEmpty()) {
			Node now = q.poll();

			for (int i = 0; i < 4; i++) {
				int next_x = now.x + dx[i];
				int next_y = now.y + dy[i];

				if (next_x < 0 || next_x >= h)
					continue;
				if (next_y < 0 || next_y >= w)
					continue;
				if (map[next_x][next_y] == 1)
					continue;
				if (dp[now.changed][next_x][next_y] == -1
						|| dp[now.changed][next_x][next_y] > dp[now.changed][now.x][now.y] + 1) {
					dp[now.changed][next_x][next_y] = dp[now.changed][now.x][now.y] + 1;
					q.offer(new Node(now.changed, next_x, next_y));
				}
			}

			if (now.changed < k) {
				for(int i=0; i < 8; i++) {
					int next_x = now.x + hdx[i];
					int next_y = now.y + hdy[i];
					
					if (next_x < 0 || next_x >= h)
						continue;
					if (next_y < 0 || next_y >= w)
						continue;
					if (map[next_x][next_y] == 1)
						continue;
					
					if (dp[now.changed+1][next_x][next_y] == -1 || dp[now.changed+1][next_x][next_y] > dp[now.changed][now.x][now.y] + 1) {
						dp[now.changed+1][next_x][next_y] = dp[now.changed][now.x][now.y] + 1;
						q.offer(new Node(now.changed+1, next_x, next_y));
					}
				}
			}

		}
		int answer = Integer.MAX_VALUE;
		for(int i=0; i <= k; i++) {
			if(dp[i][h-1][w-1] == -1) continue;
			answer = Math.min(answer, dp[i][h-1][w-1]);
		}
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
		
	}

}
