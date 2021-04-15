package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16918_봄버맨 {
	static int R,C,N;
	static char[][] map;
	static int dy[] = {1,-1,0,0};
	static int dx[] = {0,0,1,-1};
	static Queue<Pos> q;
	
	static class Pos{
		int y,x;

		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken()); // 세로
		C = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // N초
		
		map = new char[R][C];
		q = new LinkedList<Pos>();
		
		for (int i = 0; i < R; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp[j];
			}
		}
		solve();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
		
	}
	private static void bomb() {
		List<Pos> bombList = new ArrayList<>();
		while(!q.isEmpty()) {
			int size = q.size();
			while(size-- > 0){
				Pos now = q.poll();
				bombList.add(new Pos(now.y,now.x));
				for (int d = 0; d < 4; d++) {
					int ny = now.y + dy[d];
					int nx = now.x + dx[d];
					if(ny >= R || ny < 0 || nx >= C || nx < 0) continue;
					if(map[ny][nx] == 'O') {
						map[ny][nx] = '.';
					}
				}
			}
		}
		
		for (Pos pos : bombList) {
			map[pos.y][pos.x] = '.';
		}
		
	}
	
	private static void solve() {
		int time = 1;
		while(time < N) {
			//초기 설치된 폭탄 마크
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] == 'O') {
						q.add(new Pos(i,j)); // 3초후에 터뜨릴 폭탄 마크
					}
				}
			}
			//빈곳에 폭탄 채워넣기
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] == '.') {
						map[i][j] = 'O';
					}
				}
			}
			time++;
			if(time == N) return;
			
			//폭탄 터뜨리기
			bomb();
			
			time++;
		}
		
	}

}
