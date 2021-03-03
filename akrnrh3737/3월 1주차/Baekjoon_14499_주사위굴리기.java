package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_14499_주사위굴리기 {
	/**
	 * (r,c) r:북쪽으로 떨어진 칸의 개수, c : 서쪽으로 떨어진 칸의 개수
	 * 지도 각 칸에 숫자가 써져있고 0이면 주사위바닥면 숫자가 지도에 복사됨.
	 * 0이 아니면 칸에있는숫자가 주사위의 바닥면에 복사되고 칸이 0이됨.
	 * 주사위가 이동했을때마다 주사위 상단 값 출력
	 * 바깥 이동하면 명령어 점프
	 * */
	static int[] dy = {0,0,0,-1,1};
	static int[] dx = {0,1,-1,0,0};
	static int[] dice;
	// 주사위 : 위, 뒤, 왼, 오, 앞, 바닥
	static int[][] direct = {
			{2,1,5,0,4,3}, // 동
			{3,1,0,5,4,2}, // 서
			{4,0,2,3,5,1}, // 북
			{1,5,2,3,0,4}, // 남
	}; 
	static int[][] map;
	static int N,M;
	static int sy,sx;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); //세로
		M = Integer.parseInt(st.nextToken()); //가로
		
		sy = Integer.parseInt(st.nextToken()); //주사위 y 좌표
		sx = Integer.parseInt(st.nextToken()); //주사위 x 좌표
		int order = Integer.parseInt(st.nextToken()); //주사위 x 좌표
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dice = new int[6]; //처음에 모든 면 0으로 셋팅
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < order; i++) {	
			int o = Integer.parseInt(st.nextToken());
			move(sy,sx,o);
		}
		
	}
	private static void move(int y, int x, int o) {

		int ny = y + dy[o];
		int nx = x + dx[o];
		
		//1. 주사위 위치 이동
		if( ny < 0 || ny >= N || nx < 0 || nx >= M) return;
		sy = ny;
		sx = nx;
		
		//2. 주사위 상태 변경
		int[] temp = new int[6];
		for (int i = 0; i < 6; i++) {
			temp[i] = dice[i];
		}
		for (int i = 0; i < 6; i++) {
			dice[i] = temp[direct[o-1][i]];
		}
		if(map[sy][sx] > 0) {
			//칸에있는숫자가 주사위 바닥에 복사
			//바닥 0
			dice[5] = map[sy][sx];
			map[sy][sx] = 0;
		}else {
			//0이면 주사위숫자가 바닥에 찍힌다.
			map[sy][sx] = dice[5];
		}
		System.out.println(dice[0]);
		
	}

}
