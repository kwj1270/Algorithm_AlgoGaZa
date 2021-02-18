package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_7562_나이트의_이동 {

	// 우측 상단부터 시계방향으로 8방탐색
	static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[][] chessmap;
	static int ans= Integer.MAX_VALUE;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int startx, starty, endx, endy;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			ans = 0;
			N = Integer.parseInt(br.readLine()); // 체스판 크기 받아서 설정
			chessmap = new int[N][N];

			st = new StringTokenizer(br.readLine(), " "); // 시작 지점이랑
			startx = Integer.parseInt(st.nextToken());
			starty = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " "); // 종료지점 받아옴.
			endx = Integer.parseInt(st.nextToken());
			endy = Integer.parseInt(st.nextToken());

			move(startx, starty, endx, endy, 0);

			System.out.println(ans);

		}

	}

	public static void move(int startx, int starty, int endx, int endy, int cnt) {
		if (startx < 0 || startx >= N || starty < 0 || starty >= N) {
			return;
		} else if (startx == endx && starty == endy) {
			if(ans>cnt) {
				ans = cnt;
				return;
			}
			else return;
		}
		
		for(int i=0; i<8; i++) {
			move(startx+dx[i],starty+dy[i],endx,endy,cnt+1);
		}
		
	}

}
