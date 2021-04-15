package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17143_낚시왕 {
	static int R,C,M;
	static Shark[][] map;
	static int[] dy = {-1,1,0,0};//위 아래 오른 왼
	static int[] dx = {0,0,1,-1};//위 아래 오른 왼
	
	static class Shark{
		int y,x,s,d,z;
		
		public Shark(int y, int x, int s, int d, int z) {
			super();
			this.y = y;
			this.x = x;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			return "Shark [y=" + y + ", x=" + x + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new Shark[100][100];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			Shark shark = new Shark(y, x, s, d, z);
			map[y][x] = shark;
			
		}

		int cnt = 0;
		Shark backup[][] = new Shark[100][100];
		for (int t = 0; t < C; t++) {
			for (int i = 0; i < R; i++) {
				if(map[i][t] != null) {
					cnt += map[i][t].z;
					map[i][t] = null;
					break;
				}
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					backup[i][j] = map[i][j];
					map[i][j] = null;
				}
			}
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					Shark now = backup[i][j];
					if(now != null) {
						int ny = now.y + dy[now.d]*now.s;
						int nx = now.x + dx[now.d]*now.s;
						
						//위로 벗어날때 일단 양수로 바꾸고 범위벗어나면 밑에 if에서 한번더처리
						if(ny < 0) {
							ny = -ny;
							now.d = 1; //아래 방향
						}					
						if(ny > R-1) { //아래방향일때 
							int a = ny / (R-1); //몇번 반복했는지 -> 몫이 짝수면 아래 방향 유지, 홀수면 반대로
							int b = ny % (R-1); // 상대 위치
							if(a % 2 == 0) { // 방향 유지
								ny = b;
							}else {
								ny = (R-1) - b;
								now.d = 0; //위로
							}
						}

						if(nx < 0) {
							nx = -nx;
							now.d = 2;
						}				
						if(nx > C-1) { // 오른쪽 방향일때
							int a = nx / (C-1);
							int b = nx % (C-1);
							if(a % 2 == 0) {
								nx = b;
							}else {
								nx = (C-1) - b;
								now.d = 3; //왼쪽으로
							}
						}
						if(map[ny][nx] == null || (map[ny][nx] != null && map[ny][nx].z < now.z)) {
							map[ny][nx] = now;
						}
					}
				}
			}
		}
		
		System.out.println(cnt);
		
	}


}
