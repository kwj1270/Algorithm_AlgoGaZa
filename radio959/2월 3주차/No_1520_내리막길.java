package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1520_내리막길 {

	static int M, N, cnt;
	static int[][] map;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];

		for (int r = 0; r < M; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		cnt=0;
		DFS(0, 0);
		
		System.out.println(cnt);
	}

	public static void DFS(int startx, int starty) {
		if (startx == M - 1 && starty == N - 1) {
			cnt++;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = startx + dx[i];
			int ny = starty + dy[i];
			if (nx < 0 || nx >= M || ny < 0 || ny >= N)
				continue;

			if (map[startx][starty] <= map[nx][ny])
				continue;
			else {
				DFS(nx, ny);
			}
		}

	}

}
