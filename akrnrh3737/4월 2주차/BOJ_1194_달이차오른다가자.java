package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194_달이차오른다가자 {
	static int R,C;
	static char[][] map;
	static int[][][] dist; //dist[y][x][k] : y좌표, x좌표, 가지고있는열쇠상태 -> 가지고있는열쇠상태에 따라  111111 -> 63
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,1,-1};
	static class Pos{
		int y;
		int x;
		int k;
		public Pos(int y, int x, int k) {
			super();
			this.y = y;
			this.x = x;
			this.k = k;
		}
		@Override
		public String toString() {
			return "Pos [y=" + y + ", x=" + x + ", k=" + k + "]";
		}
		
	}
	static Queue<Pos> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		dist = new int[R][C][64];
		
		q = new LinkedList<Pos>();
		
		for (int i = 0; i < R; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp[j];
				if(map[i][j] == '0') {
					q.add(new Pos(i,j,0));
				}
			}
		}
		
		System.out.println(byBFS());
		
	} // end of main
	
	
	private static int byBFS() {
		
		while(!q.isEmpty()) {
			Pos now = q.poll();
			if(map[now.y][now.x] == '1') {
				return dist[now.y][now.x][now.k];
			}
			for (int d = 0; d < 4; d++) {
				int ny = now.y + dy[d];
				int nx = now.x + dx[d];
				int nk = now.k;
				if(ny >= R || ny < 0 || nx >= C || nx < 0) continue;
				
				char next = map[ny][nx];
				
				if('a' <= next && next <= 'f') { // 열쇠일때
					nk |= (1 << (next-'a')); //or 연산으로 열쇠 얻기
				}else if('A' <= next && next <= 'F') { // 문일때
					//열쇠없으면 못감
					if((nk & (1<<(next-'A'))) == 0) continue;
				}
				if(dist[ny][nx][nk] > 0 || next == '#') continue;
				
				q.add(new Pos(ny,nx,nk));
				dist[ny][nx][nk] = dist[now.y][now.x][now.k] + 1;
				
			}
		}
		return -1;
	}

}
