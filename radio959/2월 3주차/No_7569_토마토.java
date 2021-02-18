package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class No_7569_토마토 {

	static class Tomato {
		int x, y, z;

		public Tomato(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

	}

	static int[][][] box;
	static int M, N, H;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		box = new int[H][N][M];
		boolean all1 = true;

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					box[k][i][j] = Integer.parseInt(st.nextToken());
					if (box[k][i][j] == 0)
						all1 = false;
				}
			}
		}

		if (all1) {
			System.out.println(0);
			return;
		} else {
			System.out.println(bfs(0));
		}

	}

	static int bfs(int cnt) {

		// bfs를 쓰는데 필요한 자료형 큐
		Queue<Dot> q = new LinkedList<>();

		// 6방 탐색. 아래 앞(북) 뒤(남) 왼(서) 오(동) 위 순
		int[] dz = { -1, 0, 0, 0, 0, 1 };
		int[] dx = { 0, -1, 1, 0, 0, 0 };
		int[] dy = { 0, 0, 0, -1, 1, 0 };

		
		return 0;
	}

}
