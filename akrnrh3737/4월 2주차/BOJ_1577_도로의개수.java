package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1577_도로의개수 {
	static int R,C;
	static int K; // 공사중인 도로의 개수
	static int map[][][]; //map[i][j][k] : (i,j)에서 k방향으로 갈수있는지 판단
	static long[][] dp;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		C = Integer.parseInt(st.nextToken()); // 가로
		R = Integer.parseInt(st.nextToken()); // 세로

		K = Integer.parseInt(br.readLine());
		
		map = new int[2][101][101];
		dp = new long[101][101];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			if(y1 == y2) {
				if(x1 > x2) {
					int temp = x1;
					x1 = x2;
					x2 = temp;
				}
				map[0][x2][y1] = -1; //x2 -> x1 이 막혀있을때 : 왼쪽에서 오른쪽 이동 불가능
			}
			
			if(x1 == x2) {
				if(y1 > y2) {
					int temp = y1;
					y1 = y2;
					y2 = temp;
				}
				map[1][x1][y2] = -1; //y2 -> y1 이 막혀있을때 : 위에서 아래로 이동 불가능
			}
			
		}
		dp[0][0] = 1;
		
		for (int i = 0; i <= C; i++) {
			for (int j = 0; j <= R; j++) {
				if(map[0][i][j] != -1 && i-1 >= 0) {
					dp[i][j] += dp[i-1][j];
				}
				if(map[1][i][j] != -1 && j-1 >= 0) {
					dp[i][j] += dp[i][j-1];
				}
				
			}
		}
		
		System.out.println(dp[C][R]);
		
	}


}
