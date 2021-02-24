package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Chess{
	int y;
	int x;
	public Chess(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Baekjoon_1018_체스판다시칠하기 {
/**
 * N*M 보드에서 8*8크기를 선택했을때 최소로 다시 색칠하는 최소값 구하기
 * 8*8을 어디서부터 시작해야될까? 브루트포스
 * 인접해있는 얘들이 달라야하는건 BFS로 체크 , visited도 체크.
 * @throws IOException 
 * 
 * */
	static int R,C;
	static char[][] map;
	
	static boolean[][] visited;
	static char color[] = {'W','B'};
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int ans;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] init = br.readLine().split(" ");
		R = Integer.parseInt(init[0]);
		C = Integer.parseInt(init[1]);
		map = new char[R][C];
		
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = c[j];
			}
		}
		ans = Integer.MAX_VALUE;
		
		if(R==8 && C==8) {
			solve(0,0);
			System.out.println(ans);
			return;
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				solve(i,j);
			}
		}
		System.out.println(ans);
	}
	
	private static void solve(int i, int j) {
		
		//divide
		int sizeR = i+8;
		int sizeC = j+8;
		if(sizeR > 8 || sizeC > 8) return;
		//solve
		for (boolean[] row : visited) {
			Arrays.fill(row, false);
		}	
		
		int idx=0;
		for (int k = 0; k < color.length; k++) {
			if (color[k] == map[i][j]) {
				idx = k;
			}
		}
		
		int cnt = 0;
		Queue<Chess> q = new LinkedList<Chess>();
		visited[i][j] = true;
		q.add(new Chess(i, j));
		
		while(!q.isEmpty()) {
			int depthSize = q.size();//같은 depth끼리는 색이 모두 동일
			idx = (idx+1) % 2; //depth 색깔 인덱스
			for (int k = 0; k < depthSize; k++) {
				Chess now = q.poll();
//				if(color[idx] != map[now.y][now.x]) {
//					cnt++;
//				}
				for (int d = 0; d < 4; d++) {
					int ny = now.y + dy[d];
					int nx = now.x + dx[d];
					if(ny < i || ny >= sizeR || nx < j || nx >= sizeC) {
						continue;
					}
					if(!visited[ny][nx]) {
						if(color[idx] != map[ny][nx]) {
							cnt++;
						}
						visited[ny][nx] = true;
						q.add(new Chess(ny, nx));
					}
				}
			}
		}
		ans = ans < cnt ? ans : cnt;
	}

}
