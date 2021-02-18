package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1520_내리막길 {
/**
 * 왼쪽위 -> 오른쪽아래 : 현재값보다 낮은값으로만 이동 가능
 * dp[i][j] : i -> j 갈수있는 경로 수의 합.
 * 항상 내리막길로만 이동가능한 경로 수  출력
 */
	static int[][] map;
	static int R,C;
	static int[] dy = {-1,1,0,0}; // 상 하 좌 우
	static int[] dx = {0,0,-1,1}; // 상 하 좌 우
	static int[][] dp;
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] init = br.readLine().split(" ");
		R = Integer.parseInt(init[0]);
		C = Integer.parseInt(init[1]);
		
		map = new int[R][C];
		dp = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1; //방문 여부 체크를 위해 -1 로 마스킹
			}
		}
		
		answer = solve(0,0);

		sb.append(answer).append("\n");
		System.out.print(sb);
		
	} // end of main
	/**
	 *solve(y,x) : 시작점(y,x) ~ 오른쪽아래 경로 합 
	 **/
	private static int solve(int y, int x) {
		if(y == map.length-1 && x == map[0].length-1) return 1; // 기저 조건
		if(dp[y][x] != -1) return dp[y][x]; //시작점부터 (y,x)까지의 경로수합 리턴
		
		dp[y][x] = 0;
		for (int k = 0; k < 4; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			if(ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
			if(map[y][x] > map[ny][nx]) {
				dp[y][x] += solve(ny,nx);
			}
		}
		return dp[y][x];
	}

} // end of class
