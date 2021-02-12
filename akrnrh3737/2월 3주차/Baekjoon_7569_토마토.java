package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato{
	int h;
	int y;
	int x;
	public Tomato(int h, int y, int x) {
		this.h = h;
		this.y = y;
		this.x = x;
	}
}
public class Baekjoon_7569_토마토 {
/**
 * 토마토익은곳 위 아래 평면기준 네 방향 익어버림 (3차원)
 * 며칠이 지나면 토마토가 다익는지 최소 일수 구하기
 * 1. map[h][y][x] :
 * */
	static int[][][] map;
	static int H,N,M;
	static int answer;
	
	static int[] dh = {-1,1,0,0,0,0}; //3차원 위 3차원 아래 2차원 위,아래,왼쪽,오른쪽
	static int[] dy = {0,0,-1,1,0,0}; //3차원 위 3차원 아래 2차원 위,아래,왼쪽,오른쪽
	static int[] dx = {0,0,0,0,-1,1}; //3차원 위 3차원 아래 2차원 위,아래,왼쪽,오른쪽
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] info = br.readLine().split(" ");
		M = Integer.parseInt(info[0]); //가로(x좌표)
		N = Integer.parseInt(info[1]); //세로(y좌표)
		H = Integer.parseInt(info[2]); //높이(h좌표)
		
		map = new int[H][N][M]; // 상자 정보 초기화
		answer = Integer.MAX_VALUE;
		boolean flag = true; // 처음부터 토마토가 다 익었으면 true
		
		Queue<Tomato> q = new LinkedList<Tomato>();
		
		for (int i = 0; i < H; i++) {
			for (int y = 0; y < N; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int x = 0; x < M; x++) {
					map[i][y][x] =  Integer.parseInt(st.nextToken());
					if(map[i][y][x] == 1) {
						q.add(new Tomato(i,y,x));
					}
					//안 익은 토마토가 하나라도 있으면 false
					if(map[i][y][x] == 0) {
						flag = false;
					}
				}
			}
		}
		answer = solve(q, map);
		answer = flag ? 0 : answer;
		sb.append(answer).append("\n");
		System.out.print(sb);
		
	}
	/**
	 * 익은 토마토의 위치부터 시작하여 3차원 너비 우선 탐색하는 함수
	 * 모두 익을때 (모든 원소의 값이 1이 되었을때) 몇일이 걸렸는지 카운트
	 * */
	private static int solve(Queue<Tomato> q, int[][][] map) {
		int[][][] copyMap = new int[H][N][M];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				for (int k = 0; k < map[0][0].length; k++) {
					copyMap[i][j][k] = map[i][j][k];
				}
			}
		}
		
		int day = 0;
		//Queue<Tomato> q = new LinkedList<Tomato>();
		//q.add(new Tomato(h, y, x));
		while(!q.isEmpty()) {
			Tomato now = q.poll();
			for (int i = 0; i < 6; i++) {
				int nh = now.h + dh[i];
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];
				//if 두번 중첩되는것보다 이렇게 하는게 더 가독성이 좋다.
				if(nh < 0 || nh >= H || ny < 0 || ny >= N || nx < 0 || nx >= M) {
					continue;
				}
				if(copyMap[nh][ny][nx] == 0) {
					copyMap[nh][ny][nx] = copyMap[now.h][now.y][now.x] + 1;
					q.add(new Tomato(nh, ny, nx));
				}
			}
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					if(copyMap[i][j][j2] == 0) {
						day = -1;
						return day;
					}
					if(copyMap[i][j][j2] >= 1) {
						day = Math.max(day, copyMap[i][j][j2]);
					}
				}
			}
		}
		
		return day-1;
	}

}
