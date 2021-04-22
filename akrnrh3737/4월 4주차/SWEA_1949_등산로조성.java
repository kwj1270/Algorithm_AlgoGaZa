package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1949_등산로조성 {
	static int N,K;
	static Queue<int[]> start;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,1,-1};
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			
			
			start = new LinkedList<int[]>();
			
			int maxHeight = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxHeight = Math.max(maxHeight, map[i][j]);
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(maxHeight == map[i][j]) {
						start.add(new int[] {i,j});
					}
				}
			}
			
			ans = 0;
			while(!start.isEmpty()) {
				int[] now = start.poll();
				visited = new boolean[N][N];
				visited[now[0]][now[1]] = true;
				solve(now[0], now[1], 0, 1);
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
			
		}
		System.out.print(sb);
	}
	
	private static void solve(int y, int x, int k, int length) {
		if(ans < length) {
			
			ans = length;
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(visited[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if(ny >= N || ny < 0 || nx >= N || nx < 0 || visited[ny][nx]) continue;
			//1. 다음위치가 지금보다 낮으면, k사용하지 않고 다음단계로 들어간다.
			//2. 다음위치가 지금보다 크거나 똑같고, 한번도 안깎아봤으면 깎아본다. -> 최소로 깎아야 최장길이가 나올 확률 상승
			if(map[ny][nx] < map[y][x]) {
				visited[ny][nx] = true;
				solve(ny, nx, k, length+1);
				visited[ny][nx] = false;
			}
			else{
				if(k == 0) {
					if(map[ny][nx]-K < map[y][x]) {
						int prev = map[ny][nx];
						map[ny][nx] = map[y][x]-1; // 1만 깎아주고
						visited[ny][nx] = true;
						
						solve(ny, nx, k+1, length+1);
						map[ny][nx] = prev;//다시 원복
						visited[ny][nx] = false;
						
					}

				}
			}

			

		}
	}

}
