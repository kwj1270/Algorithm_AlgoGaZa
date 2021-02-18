package com.study20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//BFS를 이용한 사방 탐색을 사용하여 해결
class position{
	int x,y;

	public position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}	
}

public class backjoon_7576_토마토 {
	static int M,N;
	static int[][] map;
	static int max=0;
	static Queue<position> que = new LinkedList<>();
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void bfs() {
		while(!que.isEmpty()) {
			position p = que.poll();
			int x = p.x;
			int y = p.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0 || ny<0 || nx>=N || ny>=M) continue; //배열의 범위를 벗어나는경우
				if(map[nx][ny]>0||map[nx][ny]==-1) continue;
				que.offer(new position(nx,ny));
				map[nx][ny]=map[x][y]+1;
			}
			
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map= new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]== 1)
					que.offer(new position(i,j));
			}
		}
		
		bfs();
		
	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==0) {
					System.out.println(-1);
					return;
				}
				if(max<map[i][j]) {
					max=map[i][j];
				}
			}
		}
		System.out.println(max-1);
	}
}
